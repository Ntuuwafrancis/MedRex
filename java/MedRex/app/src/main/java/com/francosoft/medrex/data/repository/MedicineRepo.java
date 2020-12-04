package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.MedicineDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.Medicine;

import java.util.List;

public class MedicineRepo {

    private MedicineDao mMedicineDao;
    LiveData<List<Medicine>> allMedicine;

    public MedicineRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mMedicineDao = database.mMedicineDao();
        allMedicine = mMedicineDao.getAllMedicine();
    }

    public void insert(Medicine medicine) {
        new InsertAsyncTask(mMedicineDao).execute(medicine);
    }

    public void update(Medicine medicine) {
        new UpdateAsyncTask(mMedicineDao).execute(medicine);
    }

    public void delete(Medicine medicine) {
        new DeleteAsyncTask(mMedicineDao).execute(medicine);
    }

    public void deleteAllMedicine() {
        new DeleteAllAsyncTask(mMedicineDao).execute();
    }

    public LiveData<List<Medicine>> getAllMedicine() {
        return allMedicine;
    }

    private static class InsertAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao mMedicineDao;

        public InsertAsyncTask(MedicineDao medicineDao) {
            this.mMedicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {

            mMedicineDao.insert(medicines[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao mMedicineDao;

        public UpdateAsyncTask(MedicineDao medicineDao) {
            this.mMedicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {

            mMedicineDao.update(medicines[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao mMedicineDao;

        public DeleteAsyncTask(MedicineDao medicineDao) {
            this.mMedicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {

            mMedicineDao.delete(medicines[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicineDao mMedicineDao;

        public DeleteAllAsyncTask(MedicineDao medicineDao) {
            this.mMedicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mMedicineDao.deleteAllMedicine();
            return null;
        }
    }
}
