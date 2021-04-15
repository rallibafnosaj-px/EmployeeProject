package com.example.employeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEmployee extends AppCompatActivity {

    EditText et_id;
    EditText et_firstname;
    EditText et_lastname;

    SQLite.UpdateEmployee offlineDB = new SQLite.UpdateEmployee(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);


        VariableCasting();

    }

    private void VariableCasting() {

        et_id = findViewById(R.id.et_id);
        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
    }

    public void UpdateEmployee(View view) {

        String id = et_id.getText().toString();
        String firstname = et_firstname.getText().toString();
        String lastname = et_lastname.getText().toString();

        Toast.makeText(this, "" + offlineDB.UpdateEmployee(id,firstname,lastname), Toast.LENGTH_SHORT).show();

    }
    public void GoToDeleteEmployee(View view) {
        String id = et_id.getText().toString();
        String firstname = et_firstname.getText().toString();
        String lastname = et_lastname.getText().toString();
        Toast.makeText(this, "" +  offlineDB.DeleteEmployee(id,firstname,lastname), Toast.LENGTH_SHORT).show();
    }

    public void GoToViewEmployee(View view) {
        Intent intent = new Intent(UpdateEmployee.this, ViewAllEmployee.class);
        startActivity(intent);
    }
}