package com.example.employeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_firstname;
    EditText et_lastname;
    Button btn_addEmployee;

    SQLite.MainActivity offlineDB = new SQLite.MainActivity(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VariableCasting();


    }

    private void VariableCasting() {
        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
        btn_addEmployee = findViewById(R.id.btn_addEmployee);
    }

    public void AddEmployeeToDB(View view) {
        String firstname = et_firstname.getText().toString();
        String lastname = et_lastname.getText().toString();
        offlineDB.InsertEmployee(firstname,lastname);
    }

    public void GoToUpdateEmployee(View view) {

        Intent intent = new Intent(MainActivity.this, UpdateEmployee.class);
        startActivity(intent);
    }


}