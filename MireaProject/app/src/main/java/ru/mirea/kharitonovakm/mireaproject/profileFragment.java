package ru.mirea.kharitonovakm.mireaproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        SharedPreferences preferences = getActivity().getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        EditText Name = view.findViewById(R.id.name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText favouriteColor = view.findViewById(R.id.FavouriteColor);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText Age = view.findViewById(R.id.age);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText hobbi = view.findViewById(R.id.Hobbi);

        Name.setText(preferences.getString("name", ""));
        favouriteColor.setText(preferences.getString("FavouriteColor", ""));
        Age.setText(preferences.getString("age", ""));
        hobbi.setText(preferences.getString("Hobbi", ""));

        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getActivity().getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
                SharedPreferences.Editor editor	= sharedPref.edit();

                EditText Name = view.findViewById(R.id.name);
                String name = Name.getText().toString();
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText favouriteColor = view.findViewById(R.id.FavouriteColor);
                String FavouriteColor = favouriteColor.getText().toString();
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText Age = view.findViewById(R.id.age);
                String age = Age.getText().toString();
                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText hobbi = view.findViewById(R.id.Hobbi);
                String Hobbi = hobbi.getText().toString();

                editor.putString("name", name);
                editor.putString("FavouriteColor", FavouriteColor);
                editor.putString("age", age);
                editor.putString("Hobbi", Hobbi);

                Toast.makeText(getContext(), "успешно", Toast.LENGTH_SHORT).show();

                editor.apply();
            }
        });

        return view;
    }

}