package com.francosoft.medrex.ui.medicinerefill;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francosoft.medrex.R;

public class MedicineRefillFragment extends Fragment {

    private MedicineRefillViewModel mViewModel;

    public static MedicineRefillFragment newInstance() {
        return new MedicineRefillFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.medicine_refill_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MedicineRefillViewModel.class);
        // TODO: Use the ViewModel
    }

}