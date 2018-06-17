package com.example.naythway.holidayplans;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //DatePickerFragment dpF = new DatePickerFragment();
    public static EditText date1, date2;

    private Button btn;
    public static Spinner sp1, sp2;
    public static int mButtonClicked;

    public static String pickedDate = "";
    public static int spIdx1, spIdx2;

    //declaration of spinners
    String[] countryAll = {"Anywhere", "Belgium","China", "Germany","Japan"};
    String[] types = {"Anything", "Backpacking", "Luxury travel", "Adventure holidays"};

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    TextView txtAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date1 = (EditText) findViewById(R.id.datePicker1);
        date1.setInputType(InputType.TYPE_NULL);
        date1.setText("");

        date2 = (EditText) findViewById(R.id.datePicker2);
        date2.setInputType(InputType.TYPE_NULL);
        date2.setText("");

        btn = (Button) findViewById(R.id.btnSearch);

        sp1 = (Spinner) findViewById(R.id.spCountry);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countryAll);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adapter1);

        sp2 = (Spinner) findViewById(R.id.spType);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, types);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adapter2);

        txtAbout = (TextView) findViewById(R.id.txtAbout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                Date actDate1, actDate2;

                try
                {
                    if(date1.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this,"Please choose From Date!", Toast.LENGTH_SHORT).show();
                    }
                    else if(date2.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this,"Please choose To Date!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        actDate1 = formatter.parse(date1.getText().toString());
                        actDate2 = formatter.parse(date2.getText().toString());
                        if(actDate1.after(actDate2))
                        {
                            Toast.makeText(MainActivity.this,"From date should not be earlier", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), "selected date is " + date, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent launchactivity = new Intent(MainActivity.this, ListActivity.class);
                            startActivity(launchactivity);
                        }
                    }

                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }

            }
            });

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "date picker");
                mButtonClicked = 0;
            }
        });

        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "date picker");
                mButtonClicked = 1;
            }
        });

        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchactivity = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(launchactivity);
            }
        });
        }
}

