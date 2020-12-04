package com.francosoft.medrex.ui.leftovermed;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francosoft.medrex.R;

public class LeftoverMedFragment extends Fragment {

    private LeftoverMedViewModel mViewModel;

    public static LeftoverMedFragment newInstance() {
        return new LeftoverMedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.left_over_med_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LeftoverMedViewModel.class);
        // TODO: Use the ViewModel
    }

}