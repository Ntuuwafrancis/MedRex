package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;

import com.francosoft.medrex.data.dao.MedicationDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.Medication;

import java.util.List;

public class MedicationRepo {

    public MedicationDao mMedicationDao;
    LiveData<List<Medication>> allMedications;

    public MedicationRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mMedicationDao = database.mMedicationDao();
        allMedications = mMedicationDao.getAllMedications();
    }

    public void insert(Medication medication) {
        new InsertAsyncTask(mMedicationDao).execute(medication);
    }

    public void update(Medication medication) {
        new UpdateAsyncTask(mMedicationDao).execute(medication);
    }

    public void delete(Medication medication) {
        new DeleteAsyncTask(mMedicationDao).execute(medication);
    }

    public void deleteAllMedications() {
        new DeleteAllAsyncTask(mMedicationDao).execute();
    }

    public LiveData<List<Medication>> getAllMedications() {
        return allMedications;
    }

    private static class InsertAsyncTask extends AsyncTask<Medication, Void, Void> {
        private MedicationDao mMedicationDao;

        public InsertAsyncTask(MedicationDao medicationDao) {
            this.mMedicationDao = medicationDao;
        }

        @Override
        protected Void doInBackground(Medication... medications) {

            mMedicationDao.insert(medications[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Medication, Void, Void> {
        private MedicationDao mMedicationDao;

        public UpdateAsyncTask(MedicationDao medicationDao) {
            this.mMedicationDao = medicationDao;
        }
        @Override
        protected Void doInBackground(Medication... medications) {

            mMedicationDao.update(medications[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Medication, Void, Void> {
        private MedicationDao mMedicationDao;

        public DeleteAsyncTask(MedicationDao medicationDao) {
            this.mMedicationDao = medicationDao;
        }
        @Override
        protected Void doInBackground(Medication... medications) {

            mMedicationDao.delete(medications[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private MedicationDao mMedicationDao;

        public DeleteAllAsyncTask(MedicationDao medicationDao) {
            this.mMedicationDao = medicationDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {

            mMedicationDao.deleteAllMedications();
            return null;
        }
    }
}
