package com.francosoft.medrex.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.francosoft.medrex.data.dao.DoctorDao;
import com.francosoft.medrex.data.dao.HealthCenterDao;
import com.francosoft.medrex.data.dao.HealthConditionDao;
import com.francosoft.medrex.data.dao.LeftoverMedicationDao;
import com.francosoft.medrex.data.dao.MedicationDao;
import com.francosoft.medrex.data.dao.MedicineDao;
import com.francosoft.medrex.data.dao.MedicineRefillDao;
import com.francosoft.medrex.data.dao.PatientDao;
import com.francosoft.medrex.data.dao.PrescriptionDao;
import com.francosoft.medrex.entities.Doctor;
import com.francosoft.medrex.entities.HealthCenter;
import com.francosoft.medrex.entities.HealthCondition;
import com.francosoft.medrex.entities.LeftoverMedication;
import com.francosoft.medrex.entities.Medication;
import com.francosoft.medrex.entities.Medicine;
import com.francosoft.medrex.entities.MedicineRefill;
import com.francosoft.medrex.entities.Patient;
import com.francosoft.medrex.entities.Prescription;

@Database(entities = {Doctor.class, HealthCenter.class, HealthCondition.class, Medication.class,
        LeftoverMedication.class, Medicine.class, Patient.class, Prescription.class, MedicineRefill.class}, version = 1, exportSchema = false)
public abstract class MedRexDatabase extends RoomDatabase {

    public abstract DoctorDao mDoctorDao();
    public abstract HealthCenterDao mHealthCenterDao();
    public abstract HealthConditionDao mHealthConditionDao();
    public abstract LeftoverMedicationDao mLeftoverMedDao();
    public abstract MedicationDao mMedicationDao();
    public abstract MedicineDao mMedicineDao();
    public abstract MedicineRefillDao mMedRefillDao();
    public abstract PatientDao mPatientDao();
    public abstract PrescriptionDao mPrescriptionDao();

    private static MedRexDatabase medRexDatabase;

    public static synchronized MedRexDatabase getMedRexDatabase(Context context){
        if (medRexDatabase == null) {
            medRexDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    MedRexDatabase.class, "MedRex_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return medRexDatabase;
    }

}
