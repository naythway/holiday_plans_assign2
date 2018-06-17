package com.example.naythway.holidayplans;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment {

    //public String pickVal = "";
    public static String defDate = "";
    MainActivity main = new MainActivity();
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }

    public DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    /*Toast.makeText(getActivity(), "selected date is " + view.getYear() +
                            " / " + (view.getMonth()+1) +
                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();*/
                    String date = view.getYear() +
                            "/" + (view.getMonth()+1) +
                            "/" + view.getDayOfMonth();

                    if(MainActivity.mButtonClicked == 0)
                    {
                        //Toast.makeText(getActivity(), "selected date is " + date, Toast.LENGTH_SHORT).show();
                        main.date1.setText(date);

                    }
                    else if(MainActivity.mButtonClicked == 1)
                    {
                        main.date2.setText(date);
                    }
                }
            };

}