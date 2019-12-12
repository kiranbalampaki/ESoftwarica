package com.example.atry.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.atry.R;
import com.example.atry.Students;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private EditText etName, etAge, etAddress;
    private RadioGroup radioGroup;
    private Button btnSave;
    private String gender;

    public static List<Students> studentArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        radioGroup = root.findViewById(R.id.radioGroup);
        btnSave = root.findViewById(R.id.btnSave);

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.rbMale) {
                            gender = "Male";
                        }
                        if (i == R.id.rbFemale) {
                            gender = "Female";
                        }
                        if (i == R.id.rbOther) {
                            gender = "Other";
                        }
                    }
                });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (String.valueOf((etName).getText()).isEmpty()){
                            etName.setError("Enter full name");
                            return;
                        }
                        else if (String.valueOf((etAge).getText()).isEmpty()){
                            etAge.setError("Enter age");
                            return;
                        }
                        else if (radioGroup.getCheckedRadioButtonId() == -1){
                            Toast.makeText(getContext(), "Enter Gender", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (String.valueOf((etAddress).getText()).isEmpty()){
                            etAge.setError("Enter address");
                            return;
                        }

                        studentArrayList.add(new Students(String.valueOf((etName).getText()), String.valueOf((etAge).getText()), String.valueOf((etAddress).getText()), gender));

                        Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

                        etName.setText(null);
                        etAge.setText(null);
                        etAddress.setText(null);
                    }
                });

            }

        });
        return root;
    }
}