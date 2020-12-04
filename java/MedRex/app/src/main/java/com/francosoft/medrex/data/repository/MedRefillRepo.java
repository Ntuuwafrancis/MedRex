package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.MedicineRefillDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.MedicineRefill;

import java.util.List;

public class MedRefillRepo {

    private MedicineRefillDao mMedRefillDao;
    LiveData<List<MedicineRefill>> allMedRefills;

    public MedRefillRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mMedRefillDao = database.mMedRefillDao();
        allMedRefills = mMedRefillDao.getAllMedicineRefills();
    }

    public void insert(MedicineRefill medicineRefill) {
        new InsertAsyncTask(mMedRefillDao).execute(medicineRefill);
    }

    public void update(MedicineRefill medicineRefill) {
        new UpdateAsyncTask(mMedRefillDao).execute(medicineRefill);
    }

    public void delete(MedicineRefill medicineRefill) {
        new DeleteAsyncTask(mMedRefillDao).execute(medicineRefill);
    }

    public void deleteAllMedRefills() {
        new DeleteAllAsyncTask(mMedRefillDao).execute();
    }

    public LiveData<List<MedicineRefill>> getAllMedRefills() {
        return allMedRefills;
    }

    private static class InsertAsyncTask extends AsyncTask<MedicineRefill, Void, Void> {
        private MedicineRefillDao mMedRefillDao;

        public InsertAsyncTask(MedicineRefillDao refillDao) {
            this.mMedRefillDao = refillDao;
        }

        @Override
        protected Void doInBackground(MedicineRefill... medicineRefills) {

            mMedRefillDao.insert(medicineRefills[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<MedicineRefill, Void, Void> {
        private MedicineRefillDao mMedRefillDao;

        public UpdateAsyncTask(MedicineRefillDao refillDao) {
            this.mMedRefillDao = refillDao;
        }

        @Override
        protected Void doInBackground(MedicineRefill... medicineRefills) {

            mMedRefillDao.update(medicineRefills[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<MedicineRefill, Void, Void> {
        private MedicineRefillDao mMedRefillDao;

        public DeleteAsyncTask(MedicineRefillDao refillDao) {
            this.mMedRefillDao = refillDao;
        }

        @Override
        protected Void doInBackground(MedicineRefill... medicineRefills) {

            mMedRefillDao.delete(medicineRefills[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicineRefillDao mMedRefillDao;

        public DeleteAllAsyncTask(MedicineRefillDao refillDao) {
            this.mMedRefillDao = refillDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mMedRefillDao.deleteAllMedicineRefills();
            return null;
        }
    }
}
