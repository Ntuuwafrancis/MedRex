package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.PrescriptionDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.Prescription;

import java.util.List;

public class PrescriptionRepo {

    private PrescriptionDao mPrescriptionDao;
    LiveData<List<Prescription>> allPrescriptions;

    public PrescriptionRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mPrescriptionDao = database.mPrescriptionDao();
        allPrescriptions = mPrescriptionDao.getAllPrescriptions();
    }


    public void insert(Prescription prescription) {
        new InsertAsyncTask(mPrescriptionDao).execute(prescription);
    }

    public void update(Prescription prescription) {
        new UpdateAsyncTask(mPrescriptionDao).execute(prescription);
    }

    public void delete(Prescription prescription) {
        new DeleteAsyncTask(mPrescriptionDao).execute(prescription);
    }

    public void deleteAllPrescriptions() {
        new DeleteAllAsyncTask(mPrescriptionDao).execute();
    }

    public LiveData<List<Prescription>> getAllPrescriptions() {
        return allPrescriptions;
    }

    private static class InsertAsyncTask extends AsyncTask<Prescription, Void, Void> {
        private PrescriptionDao mPrescriptionDao;

        public InsertAsyncTask(PrescriptionDao prescriptionDao) {
            this.mPrescriptionDao = prescriptionDao;
        }

        @Override
        protected Void doInBackground(Prescription... prescriptions) {

            mPrescriptionDao.insert(prescriptions[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Prescription, Void, Void> {
        private PrescriptionDao mPrescriptionDao;

        public UpdateAsyncTask(PrescriptionDao prescriptionDao) {
            this.mPrescriptionDao = prescriptionDao;
        }

        @Override
        protected Void doInBackground(Prescription... prescriptions) {

            mPrescriptionDao.update(prescriptions[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Prescription, Void, Void> {
        private PrescriptionDao mPrescriptionDao;

        public DeleteAsyncTask(PrescriptionDao prescriptionDao) {
            this.mPrescriptionDao = prescriptionDao;
        }

        @Override
        protected Void doInBackground(Prescription... prescriptions) {

            mPrescriptionDao.delete(prescriptions[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private PrescriptionDao mPrescriptionDao;

        public DeleteAllAsyncTask(PrescriptionDao prescriptionDao) {
            this.mPrescriptionDao = prescriptionDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mPrescriptionDao.deleteAllPrescriptions();
            return null;
        }
    }
}
