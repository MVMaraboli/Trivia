package com.example.mytrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mytrivia.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    FragmentFirstBinding mBinding;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentFirstBinding.inflate(inflater,container,false);
        View view = mBinding.getRoot();
        mBinding.StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBinding.NamePlayer.getText().toString().isEmpty()){
                    addSecondFragment(mBinding.NamePlayer.getText().toString());
                } else {
                    Toast.makeText(getContext(),"Debes Escribir tu Nombre Para Jugar...",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void addSecondFragment(String Name){
        SecondFragment secondFragment = SecondFragment.newInstance(Name,"");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment,secondFragment,FirstFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}