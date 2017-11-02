package com.example.taruc.lab21loancalulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_STATUS = "loan";
    public static final String MONTHLY_PAYMENT = "payment";

    private EditText b_vp;
    private EditText b_dp;
    private EditText b_ir;
    private EditText b_rp;
    private EditText b_salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_vp = (EditText) findViewById(R.id.vehicle_price);
        b_dp = (EditText) findViewById(R.id.downpayment);
        b_ir = (EditText) findViewById(R.id.interest);
        b_rp = (EditText) findViewById(R.id.repayment);
        b_salary = (EditText)findViewById(R.id.salary);
    }

    public void calculateLoan(View view) {
        //TODO: calculate monthly payment and determine the loan status
        double monthlyPayment = 0;
        String status = "Approved";

        double vp = Double.parseDouble(this.b_vp.getText().toString());
        double dp = Double.parseDouble(this.b_dp.getText().toString());
        double ir = Double.parseDouble(this.b_ir.getText().toString());
        double rp = Double.parseDouble(this.b_rp.getText().toString());
        double salary = Double.parseDouble(this.b_salary.getText().toString());

        monthlyPayment = calculatePayment(vp,dp,rp,ir);
        status = calculateSalary(monthlyPayment,salary);

        //Create an Explicit Inetent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO: passing date using putExtra method
        //format: putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);

    }

    public double calculatePayment(double price, double down, double repay, double interest) {
        double total_interest = (price-down)*(interest/100)*(repay/12);
        double total_loan = (price-down)+ total_interest;
        double month_pay = total_loan/repay;
        return month_pay;
    }

    public String calculateSalary(double monthly_pay, double salary){
        double r_salary = salary * 0.3;
        String r_status = "";
        if(monthly_pay > r_salary){
            r_status += "Rejected";
        }
        else
            r_status += "Accept";

        return r_status;
    }
    public void resetEvent(View view){
        b_vp.setText("");
        b_dp.setText("");
        b_ir.setText("");
        b_rp.setText("");
        b_salary.setText("");

    }
}