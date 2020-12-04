package com.francosoft.medrex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.francosoft.medrex.data.dao.DoctorDao;
import com.francosoft.medrex.data.database.MedRexDatabase;
import com.francosoft.medrex.entities.Doctor;

import java.util.List;

public class DoctorRepo {

    private DoctorDao mDoctorDao;
    LiveData<List<Doctor>> allDoctors;

    public DoctorRepo(Application application) {
        MedRexDatabase database = MedRexDatabase.getMedRexDatabase(application);

        mDoctorDao = database.mDoctorDao();
        allDoctors = mDoctorDao.getAllDoctors();
    }

    public void insert(Doctor doctor) {
        new InsertAsyncTask(mDoctorDao).execute(doctor);
    }

    public void update(Doctor doctor) {
        new UpdateAsyncTask(mDoctorDao).execute(doctor);
    }

    public void delete(Doctor doctor) {
        new DeleteAsyncTask(mDoctorDao).execute(doctor);
    }

    public void deleteAllDoctors() {
        new DeleteAllAsyncTask(mDoctorDao).execute();
    }

    public LiveData<List<Doctor>> getAllDoctors() {
        return allDoctors;
    }

    private static class InsertAsyncTask extends AsyncTask<Doctor, Void, Void> {
        private DoctorDao mDoctorDao;

        public InsertAsyncTask(DoctorDao doctorDao) {
            this.mDoctorDao = doctorDao;
        }

        @Override
        protected Void doInBackground(Doctor... doctors) {

            mDoctorDao.insert(doctors[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Doctor, Void, Void> {
        private DoctorDao mDoctorDao;

        public UpdateAsyncTask(DoctorDao doctorDao) {
            this.mDoctorDao = doctorDao;
        }

        @Override
        protected Void doInBackground(Doctor... doctors) {

            mDoctorDao.update(doctors[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Doctor, Void, Void> {
        private DoctorDao mDoctorDao;

        public DeleteAsyncTask(DoctorDao doctorDao) {
            this.mDoctorDao = doctorDao;
        }

        @Override
        protected Void doInBackground(Doctor... doctors) {

            mDoctorDao.delete(doctors[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private DoctorDao mDoctorDao;

        public DeleteAllAsyncTask(DoctorDao doctorDao) {
            this.mDoctorDao = doctorDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mDoctorDao.deleteAllDoctors();
            return null;
        }
    }
}
