package com.example.mytrivia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytrivia.databinding.FragmentLoserBinding;
import com.example.mytrivia.databinding.FragmentWinnerBinding;


public class Loser_Fragment extends Fragment {

    FragmentLoserBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public Loser_Fragment() {

    }

    public static Loser_Fragment newInstance(String param1, String param2) {
        Loser_Fragment fragment = new Loser_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoserBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        String writting = getString(R.string.loserMessage, mParam1);
        binding.textView2.setText(writting);

        binding.againButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

}