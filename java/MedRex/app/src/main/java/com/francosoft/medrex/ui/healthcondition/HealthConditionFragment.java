package com.francosoft.medrex.ui.healthcondition;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francosoft.medrex.R;

public class HealthConditionFragment extends Fragment {

    private HealthConditionViewModel mViewModel;

    public static HealthConditionFragment newInstance() {
        return new HealthConditionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.health_condition_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HealthConditionViewModel.class);
        // TODO: Use the ViewModel
    }

}