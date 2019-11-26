package com.example.csc250_fall2019_employeemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeeListActivity extends AppCompatActivity {

    private ListView employeeLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

       //capable of showing a collection of things on the screen
        this.employeeLV = this.findViewById(R.id.employeeLV);

        //created a collection of 1000 unique strings
        String[] theStrings = new String[1000]; //array
        for(int i = 0; i < theStrings.length; i++)
        {
            theStrings[i] = "String" + i;
        }

        ArrayList<String> theString2 = new ArrayList<String>(); //arraylist
        for(int i = 0; i < Core.theEmployees.size(); i++)
        {
            theString2.add((i+1) + ". " + Core.theEmployees.get(i).toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theStrings);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theString2);
        this.employeeLV.setAdapter(adapter2);


    }
}
