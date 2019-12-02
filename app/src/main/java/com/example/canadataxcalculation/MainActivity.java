package com.example.canadataxcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText etdate;
    private TextView tvdate;


    EditText fname;
    EditText Lname;
    Button btnshow;
    EditText GrossIncome;
    EditText rrsp;
    EditText sinNumber;
    String gender;

    RadioButton radioButton;
    RadioGroup rg;
    Integer newyear;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etdate = findViewById(R.id.et_date);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        btnshow= findViewById(R.id.btnShow);
        tvdate= findViewById(R.id.tv_date);
        fname = findViewById(R.id.firstName);
        Lname = findViewById(R.id.lastName);
        GrossIncome = findViewById(R.id.etGrossIncome);
        rrsp = findViewById(R.id.etRrsp);
        sinNumber= findViewById(R.id.etSinNumber);


//        male = findViewById(R.id.male);
//        final RadioGroup rg =  findViewById(R.id.radioGroup);
////        final String value = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int selectedId = rg.getCheckedRadioButtonId();
//                radioButton = findViewById(selectedId);
////                Toast.makeText(getBaseContext(), radioButton, Toast.LENGTH_SHORT).show();
//            }
//        });
//        int selectedId = rg.getCheckedRadioButtonId();
//        radioButton = findViewById(selectedId);
//        final CRACustomer craCustomer = new CRACustomer();

//        craCustomer.fNAme = fname.getText().toString();
//        craCustomer.lName = Lname.getText().toString();
//        craCustomer.dob = etdate.getText().toString();
//       craCustomer.fullName();
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    final CRACustomer craCustomer = new CRACustomer(fname.getText().toString(), Lname.getText().toString(), String.valueOf(newyear),
                            Integer.valueOf(String.valueOf(sinNumber.getText())), Double.valueOf(String.valueOf(GrossIncome.getText())), Double.valueOf(String.valueOf(rrsp.getText())),gender);


                    Intent myintent = new Intent(MainActivity.this, ShowData.class);
                    myintent.putExtra("custobject", craCustomer);
                    startActivity(myintent);
//                if (sinNumber.toString().length() > 9)
//                {
//                    AlertDialog alertDialog;
//                    alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                    alertDialog.setTitle("Alert Dialog");
//                    alertDialog.setMessage("Please Enter Valid Sin Number.");
//                    alertDialog.setIcon(R.drawable.ic_launcher_background);
//
//                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
////                        }
//                    });
//
//                    alertDialog.show();
//                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                    alertDialog.setTitle("Alert");
//                    alertDialog.setMessage("Add Valid Sin Number");
//                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    alertDialog.show();
                }


//                    AlertDialog alertDialog;
//                    alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                    alertDialog.setTitle("Alert Dialog");
//                    alertDialog.setMessage("Age must be more and equal to 18");
//                    alertDialog.setIcon(R.drawable.ic_launcher_background);
//
//                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    alertDialog.show();

            });


        spinner = (Spinner) findViewById(R.id.gender_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderarray, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);




//        gender.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                spinner.performClick();
//
//            }
//        });



        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month +1;
                        String date = day+ "/"+month+"/"+year;
                        etdate.setText(date);
                        newyear = year;

                    }
                },year,month,day);
                datePickerDialog.show();
                if(2019 - year <=18)
                {
//                    btnshow.setBackgroundColor(Color.RED);
//                    btnshow.setEnabled(false);
                }


            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(view.getContext(),"new ",Toast.LENGTH_SHORT).show();

        gender = parent.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
