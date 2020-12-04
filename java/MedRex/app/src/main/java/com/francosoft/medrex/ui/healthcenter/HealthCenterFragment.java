package com.francosoft.medrex.ui.healthcenter;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francosoft.medrex.R;

public class HealthCenterFragment extends Fragment {

    private HealthCenterViewModel mViewModel;

    public static HealthCenterFragment newInstance() {
        return new HealthCenterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.health_center_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HealthCenterViewModel.class);
        // TODO: Use the ViewModel
    }

}