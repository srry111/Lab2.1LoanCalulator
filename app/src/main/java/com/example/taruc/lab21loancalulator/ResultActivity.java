package com.example.taruc.lab21loancalulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    private TextView month_pay;
    private TextView a_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        month_pay = (TextView)findViewById(R.id.textViewMonthlyPayment);
        a_status = (TextView) findViewById(R.id.textViewStatus);

        //To receive data from another Activity
        Intent intent = getIntent();//Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT,0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        //TODO: Display the outputs

        month_pay.setText(""+Double.toString(payment));
        a_status.setText(""+ status);

    }

    public void closeActivity(View view){
        finish();

    }
}
