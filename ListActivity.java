package com.example.naythway.holidayplans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.google.android.gms.common.util.ArrayUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;

public class ListActivity extends Activity  {

    MainActivity main = new MainActivity();
    //public static int currPlace;
    public static String currPlace = "";
    public static ListView list;
    Integer[] p1 = {3, 4, 5, 6};
    Integer[] p2 = {9, 10};
    Integer[] p3 = {3, 4, 5};
    Integer[] p4 = {3, 4, 5};

    String[] t, p;
    Integer[] img;

    String[] title = {
            "Shanghi",
            "The Great Wall",
            "Tokyo",
            "Osaka"
    } ;
    String[] para = {"Shanghai, on China's central coast, is the country's biggest city and a global financial hub.",
    "The Great Wall is broken into sections with the most popular being the Juyongguan Pass due to its proximity to Beijing and its completeness.",
    "Tokyo, Japan's busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples.",
    "Osaka is a large port city and commercial center on the Japanese island of Honshu. It's known for its modern architecture, nightlife and hearty street food."};
    Integer[] images = {
            R.drawable.shanghi1,
            R.drawable.greatwall1,
            R.drawable.tokyo1,
            R.drawable.osaka1
    };

    TextView txtAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final List<String> tempTitle = new ArrayList<String>();
        List<String> tempPara = new ArrayList<String>();
        List<Integer> tempImages = new ArrayList<Integer>();

        txtAbout = (TextView) findViewById(R.id.txtAbout);

        Date date1, date2 ;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        int d1, d2;
        try
        {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();

            date1 = formatter.parse(MainActivity.date1.getText().toString());
            date2 = formatter.parse(MainActivity.date2.getText().toString());

            cal1.setTime(date1);
            cal2.setTime(date2);

            d1 = cal1.get(Calendar.MONTH) + 1;
            d2 = cal2.get(Calendar.MONTH) + 1;

            String sp1Text = MainActivity.sp1.getSelectedItem().toString();
            String sp2Text = MainActivity.sp2.getSelectedItem().toString();


            if((sp1Text == "Anywhere" || sp1Text == "China") && (sp2Text == "Anything" || sp2Text == "Backpacking"))
            {
                boolean match = false;
                for(int i = d1; i <= d2; i++)
                {
                    if(ArrayUtils.contains(p1,i))
                    {
                        match = true;
                        break;
                    }
                }

                if(match)
                {
                    tempTitle.add(title[0]);
                    tempImages.add(images[0]);
                    tempPara.add(para[0]);
                }
            }
            if((sp1Text == "Anywhere" || sp1Text == "China") && (sp2Text == "Anything" || sp2Text == "Backpacking"))
            {
                boolean match = false;
                for(int i = d1; i <= d2; i++)
                {
                    if(ArrayUtils.contains(p2,i))
                    {
                        match = true;
                        break;
                    }
                }
                if(match)
                {
                    tempTitle.add(title[1]);
                    tempImages.add(images[1]);
                    tempPara.add(para[1]);
                }
            }
            if((sp1Text == "Anywhere" || sp1Text == "Japan") && (sp2Text == "Anything" || sp2Text == "Backpacking"))
            {
                boolean match = false;
                for(int i = d1; i <= d2; i++)
                {
                    if(ArrayUtils.contains(p3,i))
                    {
                        match = true;
                        break;
                    }
                }

                if(match)
                {
                    tempTitle.add(title[2]);
                    tempImages.add(images[2]);
                    tempPara.add(para[2]);

                    tempTitle.add(title[3]);
                    tempImages.add(images[3]);
                    tempPara.add(para[3]);
                }
            }

            t = (String[]) tempTitle.toArray(new String[0]);
            p = (String[]) tempPara.toArray(new String[0]);
            img = (Integer[]) tempImages.toArray(new Integer[0]);

            CustomList adapter = new
                    CustomList(ListActivity.this, t, p, img);
            list = (ListView)findViewById(R.id.list);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    //Toast.makeText(ListActivity.this, "You Clicked at " +title[+ position], Toast.LENGTH_SHORT).show();
                    //currPlace = position;
                    if(tempTitle.size() > 0)
                    {
                        currPlace = t[position];
                        Intent launchactivity = new Intent(ListActivity.this, DetailActivity.class);
                        startActivity(launchactivity);
                    }
                }
            });
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchactivity = new Intent(ListActivity.this, AboutActivity.class);
                startActivity(launchactivity);
            }
        });
    }
}
