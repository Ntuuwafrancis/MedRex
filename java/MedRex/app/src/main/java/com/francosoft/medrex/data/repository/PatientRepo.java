package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.francosoft.medrex.data.dao.PatientDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.Patient;

public class PatientRepo {

    private PatientDao mPatientDao;

    public PatientRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mPatientDao = database.mPatientDao();
    }


    public void insert(Patient patient) {
        new InsertAsyncTask(mPatientDao).execute(patient);
    }

    public void update(Patient patient) {
        new UpdateAsyncTask(mPatientDao).execute(patient);
    }

    public void delete(Patient patient) {
        new DeleteAsyncTask(mPatientDao).execute(patient);
    }


    private static class InsertAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao mPatientDao;

        public InsertAsyncTask(PatientDao patientDao) {
            this.mPatientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {

            mPatientDao.insert(patients[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao mPatientDao;

        public UpdateAsyncTask(PatientDao patientDao) {
            this.mPatientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {

            mPatientDao.update(patients[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao mPatientDao;

        public DeleteAsyncTask(PatientDao patientDao) {
            this.mPatientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {

            mPatientDao.delete(patients[0]);
            return null;
        }
    }


}
