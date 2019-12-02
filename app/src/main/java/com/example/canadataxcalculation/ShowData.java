package com.example.canadataxcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
        public  TextView getFullname;
        public  TextView getSinNumber;
        public TextView getFt;
        public TextView getDob;
        private TextView getCpp;
        private  TextView getPt;
        private TextView  getTotaltaxammount;
    private TextView  getGEnder;
    private TextView totalTax;
    private TextView rrsp;

//    CRACustomer craCustomer = getIntent().getParcelableExtra("custobject");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        CRACustomer craCustomer = getIntent().getParcelableExtra("custobject");

        getFullname = findViewById(R.id.getNAme);
        getFt = findViewById(R.id.getFedralTax);
        getCpp = findViewById(R.id.getCpp);
        getSinNumber = findViewById(R.id.getSinnumber);
        getDob = findViewById(R.id.getAge);
        getPt = findViewById(R.id.getPt);
        getTotaltaxammount = findViewById(R.id.totaltaxable);
        getGEnder = findViewById(R.id.getGender);
        totalTax = findViewById(R.id.taxammount);

        rrsp = findViewById(R.id.rrspget);


        getFullname.setText(craCustomer.fullName());
        getCpp.setText(String.valueOf(craCustomer.cppAmount()));
        getFt.setText(String.valueOf(craCustomer.federalTax()));
        getPt.setText(String.valueOf(craCustomer.provincTax()));
        getDob.setText(String.valueOf((craCustomer.calculateAge())));
        getSinNumber.setText(String.valueOf(craCustomer.sinNumber));
        getTotaltaxammount.setText(String.valueOf(craCustomer.total_taxable_amount));
        getGEnder.setText(craCustomer.gender);
        totalTax.setText(String.valueOf(craCustomer.totaltaxammount));
        rrsp.setText(String.valueOf(craCustomer.rrspAmount(craCustomer.grossIncome)));



    }


}
