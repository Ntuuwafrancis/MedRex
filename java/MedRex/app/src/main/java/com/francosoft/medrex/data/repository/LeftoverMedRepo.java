package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.LeftoverMedicationDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.LeftoverMedication;

import java.util.List;

public class LeftoverMedRepo {

    private LeftoverMedicationDao mLeftoverMedDao;
    LiveData<List<LeftoverMedication>> allLeftoverMedications;

    public LeftoverMedRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mLeftoverMedDao = database.mLeftoverMedDao();
        allLeftoverMedications = mLeftoverMedDao.getAllLeftoverMedications();
    }

    public void insert(LeftoverMedication leftoverMedication) {
        new InsertAsyncTask(mLeftoverMedDao).execute(leftoverMedication);
    }

    public void update(LeftoverMedication leftoverMedication) {
        new UpdateAsyncTask(mLeftoverMedDao).execute(leftoverMedication);
    }

    public void delete(LeftoverMedication leftoverMedication) {
        new DeleteAsyncTask(mLeftoverMedDao).execute(leftoverMedication);
    }

    public void deleteAllLeftoverMeds() {
        new DeleteAllAsyncTask(mLeftoverMedDao).execute();
    }

    public LiveData<List<LeftoverMedication>> getAllLeftoverMedications() {
        return allLeftoverMedications;
    }

    private static class InsertAsyncTask extends AsyncTask<LeftoverMedication, Void, Void> {
        private LeftoverMedicationDao mLeftoverMedDao;

        public InsertAsyncTask(LeftoverMedicationDao mLeftoverMedDao) {
            this.mLeftoverMedDao = mLeftoverMedDao;
        }

        @Override
        protected Void doInBackground(LeftoverMedication... leftoverMedications) {

            mLeftoverMedDao.insert(leftoverMedications[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<LeftoverMedication, Void, Void> {
        private LeftoverMedicationDao mLeftoverMedDao;

        public UpdateAsyncTask(LeftoverMedicationDao mLeftoverMedDao) {
            this.mLeftoverMedDao = mLeftoverMedDao;
        }

        @Override
        protected Void doInBackground(LeftoverMedication... leftoverMedications) {

            mLeftoverMedDao.update(leftoverMedications[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<LeftoverMedication, Void, Void> {
        private LeftoverMedicationDao mLeftoverMedDao;

        public DeleteAsyncTask(LeftoverMedicationDao mLeftoverMedDao) {
            this.mLeftoverMedDao = mLeftoverMedDao;
        }

        @Override
        protected Void doInBackground(LeftoverMedication... leftoverMedications) {

            mLeftoverMedDao.delete(leftoverMedications[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private LeftoverMedicationDao mLeftoverMedDao;

        public DeleteAllAsyncTask(LeftoverMedicationDao mLeftoverMedDao) {
            this.mLeftoverMedDao = mLeftoverMedDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mLeftoverMedDao.deleteAllLeftoverMedications();
            return null;
        }
    }
}
