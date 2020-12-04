package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.HealthConditionDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.HealthCondition;

import java.util.List;

public class HealthConditionRepo {

    private HealthConditionDao mHealthConditionDao;
    LiveData<List<HealthCondition>> allHConditions;

    public HealthConditionRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mHealthConditionDao = database.mHealthConditionDao();
        allHConditions = mHealthConditionDao.getAllHealthConditions();
    }


    public void insert(HealthCondition healthCondition) {
        new InsertAsyncTask(mHealthConditionDao).execute(healthCondition);
    }

    public void update(HealthCondition healthCondition) {
        new UpdateAsyncTask(mHealthConditionDao).execute(healthCondition);
    }

    public void delete(HealthCondition healthCondition) {
        new DeleteAsyncTask(mHealthConditionDao).execute(healthCondition);
    }

    public void deleteAllHConditions() {
        new DeleteAllAsyncTask(mHealthConditionDao).execute();

    }

    public LiveData<List<HealthCondition>> getAllHConditions() {
        return allHConditions;
    }

    private static class InsertAsyncTask extends AsyncTask<HealthCondition, Void, Void> {
        private HealthConditionDao mHealthConditionDao;

        public InsertAsyncTask(HealthConditionDao healthConditionDao) {
            this.mHealthConditionDao = healthConditionDao;
        }

        @Override
        protected Void doInBackground(HealthCondition... healthConditions) {

            mHealthConditionDao.insert(healthConditions[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<HealthCondition, Void, Void> {
        private HealthConditionDao mHealthConditionDao;

        public UpdateAsyncTask(HealthConditionDao healthConditionDao) {
            this.mHealthConditionDao = healthConditionDao;
        }

        @Override
        protected Void doInBackground(HealthCondition... healthConditions) {

            mHealthConditionDao.update(healthConditions[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<HealthCondition, Void, Void> {
        private HealthConditionDao mHealthConditionDao;

        public DeleteAsyncTask(HealthConditionDao healthConditionDao) {
            this.mHealthConditionDao = healthConditionDao;
        }

        @Override
        protected Void doInBackground(HealthCondition... healthConditions) {

            mHealthConditionDao.delete(healthConditions[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private HealthConditionDao mHealthConditionDao;

        public DeleteAllAsyncTask(HealthConditionDao healthConditionDao) {
            this.mHealthConditionDao = healthConditionDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mHealthConditionDao.deleteAllHealthConditions();
            return null;
        }
    }
}
