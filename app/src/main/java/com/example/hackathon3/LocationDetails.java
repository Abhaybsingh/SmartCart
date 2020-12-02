package com.example.hackathon3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import android.view.View.OnClickListener;
import android.widget.Button;

public class LocationDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2, spinner3;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

//        Spinner spinner = findViewById(R.id.stateSpinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(this);
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner2() {

        spinner1 = (Spinner) findViewById(R.id.stateSpinner);
        List<String> list1 = new ArrayList<String>();
        list1.add("Andhra Pradesh");
        list1.add("Arunachal");
        list1.add("Assam");
        list1.add("Bihar");
        list1.add("Chhattisgarh");
        list1.add("Goa");
        list1.add("Gujarat");
        list1.add("Haryana");
        list1.add("Himachal");
        list1.add("Jharkhand");
        list1.add("Karnataka");
        list1.add("Kerala");
        list1.add("Madhya Pradesh");
        list1.add("Manipur");
        list1.add("Meghalaya");
        list1.add("Mizoram");
        list1.add("Nagaland");
        list1.add("Odisha");
        list1.add("Punjab");
        list1.add("Rajasthan");
        list1.add("Sikkim");
        list1.add("Tamil Nadu");
        list1.add("Telangana");
        list1.add("Tripura");
        list1.add("Uttar Pradesh");
        list1.add("Uttarakhand");
        list1.add("West Bengal");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter2);

        spinner2 = (Spinner) findViewById(R.id.citySpinner);
        List<String> list2 = new ArrayList<String>();
        list2.add("Ahmedabad");
        list2.add("Surat");
        list2.add("Vapi");
        list2.add("Vadodara");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        spinner3 = (Spinner) findViewById(R.id.storeSpinner);
        List<String> list3 = new ArrayList<String>();
        list3.add("Vishal Mega Mart");
        list3.add("Indian Mall");
        list3.add("Ms Mart");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter3);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.stateSpinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner2 = (Spinner) findViewById(R.id.citySpinner);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener2());

        spinner3 = (Spinner) findViewById(R.id.storeSpinner);
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener3());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.stateSpinner);
        spinner2 = (Spinner) findViewById(R.id.citySpinner);
        spinner3 = (Spinner) findViewById(R.id.storeSpinner);

        btnSubmit = (Button) findViewById(R.id.scanQrCodeBtn);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

//                Toast.makeText(LocationDetails.this, String.valueOf(spinner1.getSelectedItem()) +
//                                "\n"+ String.valueOf(spinner2.getSelectedItem()) +
//                                "\n"+ String.valueOf(spinner3.getSelectedItem()) ,
//                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LocationDetails.this, addOrRemoveProduct.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String text= adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//        Toast.makeText(adapterView.getContext(), "Select a state", Toast.LENGTH_SHORT).show();
//    }


}