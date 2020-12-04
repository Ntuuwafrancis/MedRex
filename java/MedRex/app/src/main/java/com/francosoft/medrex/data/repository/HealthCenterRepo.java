package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.HealthCenterDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.HealthCenter;

import java.util.List;

public class HealthCenterRepo {

    private HealthCenterDao mHealthCenterDao;
    LiveData<List<HealthCenter>> allHCenters;

    public HealthCenterRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mHealthCenterDao = database.mHealthCenterDao();
        allHCenters = mHealthCenterDao.getAllHealthCenters();
    }

    public void insert(HealthCenter healthCenter) {
        new InsertAsyncTask(mHealthCenterDao).execute(healthCenter);
    }

    public void update(HealthCenter healthCenter) {
        new UpdateAsyncTask(mHealthCenterDao).execute(healthCenter);
    }

    public void delete(HealthCenter healthCenter) {
        new DeleteAsyncTask(mHealthCenterDao).execute(healthCenter);
    }

    public void deleteAllHCenters() {
        new DeleteAllAsyncTask(mHealthCenterDao).execute();

    }

    public LiveData<List<HealthCenter>> getAllHCenters() {
        return allHCenters;
    }

    private static class InsertAsyncTask extends AsyncTask<HealthCenter, Void, Void> {
        private HealthCenterDao mHealthCenterDao;

        public InsertAsyncTask(HealthCenterDao healthCenterDao) {
            this.mHealthCenterDao = healthCenterDao;
        }

        @Override
        protected Void doInBackground(HealthCenter... healthCenters) {

            mHealthCenterDao.insert(healthCenters[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<HealthCenter, Void, Void> {
        private HealthCenterDao mHealthCenterDao;

        public UpdateAsyncTask(HealthCenterDao healthCenterDao) {
            this.mHealthCenterDao = healthCenterDao;
        }

        @Override
        protected Void doInBackground(HealthCenter... healthCenters) {

            mHealthCenterDao.update(healthCenters[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<HealthCenter, Void, Void> {
        private HealthCenterDao mHealthCenterDao;

        public DeleteAsyncTask(HealthCenterDao healthCenterDao) {
            this.mHealthCenterDao = healthCenterDao;
        }

        @Override
        protected Void doInBackground(HealthCenter... healthCenters) {

            mHealthCenterDao.delete(healthCenters[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private HealthCenterDao mHealthCenterDao;

        public DeleteAllAsyncTask(HealthCenterDao healthCenterDao) {
            this.mHealthCenterDao = healthCenterDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mHealthCenterDao.deleteAllHealthCenters();
            return null;
        }
    }
}
