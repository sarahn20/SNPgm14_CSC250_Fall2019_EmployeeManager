package com.example.csc250_fall2019_employeemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) //when the home screen is first pulled up
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAddEmployeeClick(View v) //when the create button is clicked
    {
        Intent i = new Intent(this, EmployeeEntryActivity.class);
        this.startActivity(i);
    }
    @Override
    protected void onResume() //when you go back to the home screen
    {
        super.onResume();
        if(Core.theEmployee != null)
        {
            Toast.makeText(this, "Received result: " + Core.theEmployee.toString() + " | Number of Employees: " + Core.theEmployees.size() + "", Toast.LENGTH_LONG).show();

        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) //this gets called automatically when a result was provided by the another screen
    {
        String employeeName = data.getStringExtra("employee_name");
        Toast.makeText(this, "Received result: " + employeeName + " Number of Employees: " + Core.theEmployees.size() + "", Toast.LENGTH_LONG).show();
    }
    public void onEmployeeListClick(View v)
    {
        Intent i = new Intent(this, EmployeeListActivity.class);
        this.startActivity(i);
    }
}
