package com.example.employeeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewAllEmployee extends AppCompatActivity {

    RecyclerView rv_employee;

    SQLite.ViewAllEmployee offlineDB = new SQLite.ViewAllEmployee(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_employee);


        VariableCasting();
        SetUpRecyclerView();


    }

    private void SetUpRecyclerView() {
        LinearLayoutManager layoutManagerDelivery = new LinearLayoutManager(this);
        rv_employee.setLayoutManager(layoutManagerDelivery);
        rv_employee.setAdapter(offlineDB.ViewEmployee());
    }

    private void VariableCasting() {
        rv_employee = findViewById(R.id.rv_employee);
    }
}