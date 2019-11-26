package com.example.csc250_fall2019_employeemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeEntryActivity extends AppCompatActivity
{
    private EditText fnameET, lnameET, height_feetET, height_inchesET, weightET, ageET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_entry);

        this.fnameET = this.findViewById(R.id.fnameET);
        this.lnameET = this.findViewById(R.id.lnameET);
        this.weightET = this.findViewById(R.id.weightET);
        this.ageET = this.findViewById(R.id.ageET);
        this.height_feetET = this.findViewById(R.id.height_feetET);
        this.height_inchesET = this.findViewById(R.id.height_inchesET);
    }

    public void onCreateEmployeeButtonClicked(View v)
    {
        String fname = this.fnameET.getText().toString();
        String lname = this.lnameET.getText().toString();
        double weight = Double.parseDouble(this.weightET.getText().toString());
        int age = Integer.parseInt(this.ageET.getText().toString());
        int height_feet = Integer.parseInt(this.height_feetET.getText().toString());
        int height_inches = Integer.parseInt(this.height_inchesET.getText().toString());

        Core.theEmployee = new Employee(fname, lname, height_feet, height_inches, age, weight);
        Core.theEmployees.add(Core.theEmployee);
        //EmployeeListActivity.

        Intent returnBag = new Intent();
        String mostRecentName = Core.theEmployee.toString();
        returnBag.putExtra("employee_name", mostRecentName);
        Toast.makeText(this, "Employee Created: " + Core.theEmployee.toString(), Toast.LENGTH_LONG).show();
        this.setResult(Activity.RESULT_OK, returnBag); //notifies screen 1 that a result is included.

    }
}
