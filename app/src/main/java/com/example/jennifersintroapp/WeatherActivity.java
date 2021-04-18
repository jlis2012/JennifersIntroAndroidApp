package com.example.jennifersintroapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        OnClickListener{

    //Declare Variables
    private RadioButton btnFah;
    private RadioButton btnCel;
    private RadioButton btnKel;
    private EditText txtInputTemp;
    private TextView lblOutputF;
    private TextView lblOutputC;
    private TextView lblOutputK;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //set listener
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //this method is used to get resources for radio buttons, text boxes, and labels
        btnFah = (RadioButton) findViewById(R.id.rdoDegF);
        btnCel = (RadioButton) findViewById(R.id.rdoDegC);
        btnKel = (RadioButton) findViewById(R.id.rdoDegK);
        txtInputTemp = (EditText) findViewById(R.id.txtInputTemp);
        lblOutputF = (TextView) findViewById(R.id.lblOutputF);
        lblOutputC = (TextView) findViewById(R.id.lblOutputC);
        lblOutputK = (TextView) findViewById(R.id.lblOutputK);
        //convert the user input temp to a double
        double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));
        double answer = 0;

        //If Fahrenheit is selected, convert to Celsius and Kelvin and display in respective text boxes
        if(btnFah.isChecked()) {
            if(btnFah.isChecked()) {
                lblOutputF.setText(temp+" degrees F");
                lblOutputC.setText((Math.round((temp-32)*5/9*100.0)/100.0)+" degrees C");
                lblOutputK.setText((Math.round((temp+459.67)*5/9*100.0)/100.0)+" degrees K");
            }
            answer = (temp-32)*5/9;
        }

        //If Celsius is selected, convert to Fahrenheit and Kelvin and display in respective text boxes
        if(btnCel.isChecked()) {
            lblOutputF.setText(((Math.round((temp*9)/5+32)*100.0)/100.0) +" degrees F");
            lblOutputC.setText(temp+" degrees C");
            lblOutputK.setText((Math.round((temp+273.15)*100.0)/100.0)+ " degrees K");
            answer = temp;
        }

        //If Kelvin is selected, convert to Fahrenheit and Celsius and display in respective text boxes
        if(btnKel.isChecked()){
            lblOutputF.setText((Math.round((temp*9/5-459.67)*100.0)/100.0)+ " degrees F");
            lblOutputC.setText((Math.round((temp-273.15)*100.0)/100.0)+ " degrees C");
            lblOutputK.setText(temp+ " degrees K");
            answer = temp-273.15;
        }
        displayToast(answer);
    }

    private void displayToast( double temperature) {
        if(temperature>50)
            Toast.makeText(this, "It's a HOT day today!", Toast.LENGTH_LONG).show();
        else if(temperature>20)
            Toast.makeText(this, "This is a really nice temperature", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Bundle up... it's cold outside!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        TextView myOutput = (TextView) findViewById(R.id.lblOutput);
        switch (i) {
            case R.id.rdoDegF:
                myOutput.setText("You chose Fahrenheit");
                break;
            case R.id.rdoDegC:
                myOutput.setText("You chose Celsius");
                break;
            case R.id.rdoDegK:
                myOutput.setText("You chose Kelvin");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.mnuMain:
                startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                return true;
            case R.id.mnuExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
