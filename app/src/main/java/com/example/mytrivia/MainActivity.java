package com.example.mytrivia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import com.example.mytrivia.databinding.ActivityMainBinding;
import com.example.mytrivia.databinding.FragmentFirstBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addFirstFragment();

    }
    private void addFirstFragment(){
        FirstFragment firstFragment = FirstFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(binding.contentFragment.getId(),firstFragment,FirstFragment.class.getSimpleName());
        fragmentTransaction.commit();

    }
}