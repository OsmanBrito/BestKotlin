package com.unhee.bestkotlin.data.repository

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import com.unhee.bestkotlin.RepositoryActivity
import com.unhee.bestkotlin.api.RetrofitInitializer
import com.unhee.bestkotlin.data.ProjectDataBase
import com.unhee.bestkotlin.data.dao.RepositoryDAO
import com.unhee.bestkotlin.data.entity.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoRepository constructor(private val application: Application) {

    private val dao: RepositoryDAO
    private val allRepositories: LiveData<List<Repository>>

    init {
        val db = ProjectDataBase.getDatabase(application)
        dao = db!!.repositoryDAO()
        allRepositories = dao.repositories
    }

    suspend fun getRepositories(nextPage: Boolean): LiveData<List<Repository>> {
        if (dao.getAll().isNullOrEmpty() || nextPage) {
            refreshRepositories()
        }
        return dao.repositories
    }

    private suspend fun refreshRepositories(){
        try {
            val network = RetrofitInitializer.githubApi.repositories(
                "language:kotlin",
                "stars",
                if (dao.getAll().isNullOrEmpty()) 1 else (dao.getAll().size / 30) + 1
            )
            if (!network.items.isNullOrEmpty()) {
                dao.let { createAllAsyncTask(it).execute(network.items) }
            }
        } catch (e: Exception) {
            //TODO: RAPAZ, OLHA AQUI MEU!
            e.printStackTrace()
            RepositoryActivity.semaphore = 0
            withContext(Dispatchers.Main) {
                RepositoryActivity.progressBar.visibility = View.GONE
            }
        }
    }

    private class createAllAsyncTask internal constructor(private val mAsyncTaskDao: RepositoryDAO) :
        AsyncTask<List<Repository>, Void, Void>() {

        override fun doInBackground(vararg params: List<Repository>): Void? {
            mAsyncTaskDao.createAll(params[0])
            Log.e(TAG, "Add repositories.")
            return null
        }
    }

    companion object {
        private val TAG = "RepoRepository"
    }

}
