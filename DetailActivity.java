package com.example.naythway.holidayplans;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private TextView title, city, country;
    private TextView abtTitle,abtText,ttdTitle,ttdText,wtgTitle,wtgText;
    private ImageView image1,image2,image3, mapView;

    TextView txtAbout;

    String[] names = {
            "Shanghi",
            "The Great Wall",
            "Tokyo",
            "Osaka"
    } ;
    String[] para1 = {"Shanghai, on China's central coast, is the country's biggest city and a global financial hub.",
            "The Great Wall is broken into sections with the most popular being the Juyongguan Pass due to its proximity to Beijing and its completeness.",
            "Tokyo, Japan's busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples.",
            "Osaka is a large port city and commercial center on the Japanese island of Honshu. It's known for its modern architecture, nightlife and hearty street food."};
    Integer[] images1 = {
            R.drawable.shanghi1,
            R.drawable.greatwall1,
            R.drawable.tokyo1,
            R.drawable.osaka1
    };

    String[] para2 = {"Yu Garden was first built in 1559 during the Ming Dynasty by Pan Yunduan as a comfort for his father, the minister Pan En, in his old age.",
            "Thrill seekers visiting the Great Wall won't want to miss paragliding at Simatai. Wing China (wingchina.com) offers tourists the chance to leap off the edge of the Simatai wall section and glide almost 1,000 feet into the valley below.",
            "Tokyo Skytree  is a broadcasting, restaurant and observation tower in Sumida, Tokyo, Japan.",
            "Osaka Castle is a Japanese castle in Chuo-ku, Osaka, Japan. The castle is one of Japan's most famous landmarks and it played a major role in the unification of Japan during the sixteenth century of the Azuchi-Momoyama period."};
    Integer[] images2 = {
            R.drawable.shanghi2,
            R.drawable.greatwall2,
            R.drawable.tokyo2,
            R.drawable.osaka2
    };

    String[] para3 = {"",
            "",
            "Odaiba is a large artificial island in Tokyo Bay, Japan, across the Rainbow Bridge from central Tokyo.",
            "Universal Studios Japan, located in Osaka, is one of four Universal Studios theme parks, owned and operated by USJ Co., Ltd., which is wholly owned by NBCUniversal."};
    Integer[] images3 = {
            0,
            0,
            R.drawable.tokyo3,
            R.drawable.osaka3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtAbout = (TextView) findViewById(R.id.txtAbout);

        title = (TextView) findViewById(R.id.txtTitle);
        city = (TextView) findViewById(R.id.txtCity);
        country = (TextView) findViewById(R.id.txtCountry);
        mapView = (ImageView) findViewById(R.id.mapView);

        abtTitle = (TextView) findViewById(R.id.txtAboutOfTitle);
        image1 = (ImageView) findViewById(R.id.img1);
        abtText = (TextView) findViewById(R.id.txtAboutOfText);

        ttdTitle = (TextView) findViewById(R.id.txtThingToDoTitle);
        image2 = (ImageView) findViewById(R.id.img2);
        ttdText = (TextView) findViewById(R.id.txtThingToDoText);

        wtgTitle = (TextView) findViewById(R.id.txtWhereToGoTitle);
        image3 = (ImageView) findViewById(R.id.img3);
        wtgText = (TextView) findViewById(R.id.txtWhereToGoText);


        String cPlace = ListActivity.currPlace;
        int currPosition = 0;
        //Toast.makeText(DetailActivity.this, "Current Place ID : " +ListActivity.currPlace, Toast.LENGTH_SHORT).show();
        if(cPlace == "Shanghi")
        {
            currPosition = 0;
        }
        else if(cPlace == "The Great Wall")
        {
            currPosition = 1;
        }
        else if(cPlace == "Tokyo")
        {
            currPosition = 2;
        }
        else if(cPlace == "Osaka")
        {
            currPosition = 3;
        }

        getPlace(currPosition);
        if(currPosition == 0)
        {
            city.setText("Shanghai");
            country.setText("China");
            mapView.setImageResource(R.drawable.small_map_shanghi);
        }
        else if(currPosition == 1)
        {
            city.setText("Beijing");
            country.setText("China");
            mapView.setImageResource(R.drawable.small_map_greatwall);
        }
        else if(currPosition == 2)
        {
            city.setText("Tokyo");
            country.setText("Japan");
            mapView.setImageResource(R.drawable.small_map_tyoko);
        }
        else if(currPosition == 3)
        {
            city.setText("Osaka");
            country.setText("Japan");
            mapView.setImageResource(R.drawable.small_map_osaka);
        }

        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchactivity = new Intent(DetailActivity.this, AboutActivity.class);
                startActivity(launchactivity);
            }
        });

    }

    private void getPlace(int pIndex)
    {
        title.setText(names[pIndex]);

        if(para1[pIndex] != "")
        {
            abtTitle.setText("About of " + names[pIndex]);
            image1.setImageResource(images1[pIndex]);
            abtText.setText(para1[pIndex]);
        }
        else {
            abtTitle.setVisibility(View.VISIBLE);
            image1.setVisibility(View.INVISIBLE);
            abtTitle.setVisibility(View.INVISIBLE);
        }
        if(para2[pIndex] != "")
        {
            ttdTitle.setText("Thing to Do");
            image2.setImageResource(images2[pIndex]);
            ttdText.setText(para2[pIndex]);
        }
        else
        {
            ttdTitle.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);
            ttdText.setVisibility(View.INVISIBLE);
        }
        if(para3[pIndex] != "")
        {
            wtgTitle.setText("Where to Go");
            image3.setImageResource(images3[pIndex]);
            wtgText.setText(para3[pIndex]);
        }
        else
        {
            wtgTitle.setVisibility(View.VISIBLE);
            image3.setVisibility(View.INVISIBLE);
            wtgText.setVisibility(View.INVISIBLE);
        }
    }
}
