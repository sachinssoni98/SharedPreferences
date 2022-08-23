package com.example.datastorageusingsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, mob1, mob2, city;
    Button btnsave, btnkill;
    Boolean nameEnabler = false, emailEnabler = false, mob1Enabler = false, mob2Enabler = false, cityEnabler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mob1 = findViewById(R.id.mobile1);
        mob2 = findViewById(R.id.mobile2);
        city = findViewById(R.id.city);
        btnsave = findViewById(R.id.btnsave);
        btnkill = findViewById(R.id.btnkill);
        btnsave.setEnabled(false);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(name.getText())) {
                    btnsave.setEnabled(false);
                    Log.d("Under if", "Name");
                } else {
                    nameEnabler = true;
                    Log.d("Under else", nameEnabler.toString());
                    if (nameEnabler && emailEnabler && mob1Enabler && mob2Enabler || cityEnabler) {
                        btnsave.setEnabled(true);
                    }
                }
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(email.getText())) {
                    btnsave.setEnabled(false);
                    Log.d("Under if", "Email");

                } else {
                    emailEnabler = true;
                    Log.d("Under else", emailEnabler.toString());
                    if (nameEnabler && emailEnabler && mob1Enabler && mob2Enabler || cityEnabler) {
                        btnsave.setEnabled(true);
                    }
                }
            }
        });

        mob1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(mob1.getText())) {
                    btnsave.setEnabled(false);
                    Log.d("Under if", "mob1");
                } else {
                    mob1Enabler = true;
                    Log.d("Under else", "mob1");
                    if (nameEnabler && emailEnabler && mob1Enabler && mob2Enabler || cityEnabler) {
                        btnsave.setEnabled(true);
                    }

                }
            }
        });

        mob2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(mob2.getText())) {
                    btnsave.setEnabled(false);
                    Log.d("Under if", "mob2");
                } else {
                    mob2Enabler = true;
                    Log.d("Under else", "mob2");
                    if (nameEnabler && emailEnabler && mob1Enabler && mob2Enabler || cityEnabler) {
                        btnsave.setEnabled(true);
                    }
                }
            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(city.getText())) {
                    btnsave.setEnabled(false);
                    Log.d("Under if", "city");
                } else {
                    cityEnabler = true;
                    Log.d("Under else", "city");
                    if (nameEnabler && emailEnabler && mob1Enabler && mob2Enabler || cityEnabler) {
                        btnsave.setEnabled(true);
                    }
                }
            }
        });

        btnsave.setOnClickListener(this::saveData);
        btnkill.setOnClickListener(this::killActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("dataContainer", MODE_PRIVATE);
        String n = sharedPreferences.getString("name", "");
        String e = sharedPreferences.getString("email", "");
        String m1 = sharedPreferences.getString("mobile1", "");
        String m2 = sharedPreferences.getString("mobile2", "");
        String c = sharedPreferences.getString("city", "");

        name.setText(n);
        email.setText(e);
        mob1.setText(m1);
        mob2.setText(m2);
        city.setText(c);
    }

    private void killActivity(View view) {
        finish();
    }

    private void saveData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("dataContainer", MODE_PRIVATE);
        SharedPreferences.Editor myeditor = sharedPreferences.edit();
        myeditor.putString("name", name.getText().toString());
        myeditor.putString("email", email.getText().toString());
        myeditor.putString("mobile1", mob1.getText().toString());
        myeditor.putString("mobile2", mob2.getText().toString());
        myeditor.putString("city", city.getText().toString());
        myeditor.apply();
        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}