package com.example.mytrivia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mytrivia.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    // Agregamos Binding
    FragmentSecondBinding binding;
    //Declaramos variables
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    // Declaramos contenedores de los valores pulsados de los Radio Buttons
    private static final int Option_1 = 0;
    private static final int Option_2 = 1;
    private static final int Option_3 = 2;
    private static final int Option_4 = 3;
    private static final int Option_5 = 4;
    // Declaramos la variable numérica que recibirá nuestra opción pulsada.
    private int optionChoice = 6;


    // Creamos nuestro Constructor Vacío
    public SecondFragment() {
        // Required empty public constructor
    }
    // Instanciamos el fragmento SecondFragment
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    // Método onCreate
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }
    // onCreateView para inflar nuestra vista.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inglamos el fragmento SecondFragment
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        //Buscamos en el string la variable en que guardamos el valor del parámetro.
        String writting = getString(R.string.hellow_player,mParam1);
        binding.recivedName.setText(writting);
        // Contenedor Radio Buttons

        binding.rbAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                View radioButton = binding.rbAnswers.findViewById(checkedId);
                int index = binding.rbAnswers.indexOfChild(radioButton);
                switch(index){
                    case Option_1:
                        optionChoice = Option_1;
                        break;
                    case Option_2:
                        optionChoice = Option_2;
                        break;
                    case Option_3:
                        optionChoice = Option_3;
                        break;
                    case Option_4:
                        optionChoice = Option_4;
                        break;
                    case Option_5:
                        optionChoice = Option_5;
                        break;
                    default:
                        optionChoice = 6;
                        break;
                }
            }
        });

        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoice == Option_4) {
                    goWin(mParam1);
                } else if(optionChoice == Option_1 || optionChoice == Option_2 || optionChoice == Option_3 || optionChoice == Option_5 ){
                    goTryAgain(mParam1);
                } else if(optionChoice == 6) {
                    Toast.makeText(getContext(), "Debes Seleccionar una Opción Para Jugar...", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return view;
    }
    private void goWin(String Name){
        WinnerFragment winnerFragment = WinnerFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment,winnerFragment,WinnerFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    private void goTryAgain(String Name){
        Loser_Fragment loser_fragment = Loser_Fragment.newInstance(Name,"");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment,loser_fragment,Loser_Fragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

}