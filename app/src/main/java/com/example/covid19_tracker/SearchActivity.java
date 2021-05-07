package com.example.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActivity extends AppCompatActivity {


        AutoCompleteTextView autoCountryName ;
        String countryName = "";

        TextView deathNum ;
        TextView recoverdNum ;
        TextView casesNum ;
        //TextView hintTxt;

        String state;
        String deathes ;
        String recoverd ;
        String cases ;




        public void getContent(View view){


        DownloadTask task = new DownloadTask();
        String result;
        try {
            result = task.execute("https://api.covid19api.com/summary").get();
            countryName = autoCountryName.getText().toString();
            Log.i("on create", "onCreate: " + countryName);




        }catch (Exception e){
            e.printStackTrace();
        }




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        deathNum = findViewById(R.id.deathNum);
        recoverdNum = findViewById(R.id.recoverdNum);
        casesNum= findViewById(R.id.casesNum);

        Toast.makeText(this, " Stay Safe , Stay Home !", Toast.LENGTH_SHORT).show();

        autoCountryName = (AutoCompleteTextView) findViewById(R.id.autoCountryName);

        String[] countryNames = {"Afghanistan",
                "Albania",
                "Algeria",
                "American Samoa",
                "Andorra",
                "Angola",
                "Argentina",
                "Armenia",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Bahrain",
                "Bangladesh",
                "Belgium",
                "Bolivia (Plurinational State of)",
                "Bosnia and Herzegovina",
                "Botswana",
                "Brazil",
                "Bulgaria",
                "Cambodia",
                "Cameroon",
                "Canada",
                "Central African Republic (the)",
                "Chad",
                "Chile",
                "China",
                "Cocos (Keeling) Islands (the)",
                "Colombia",
                "Congo (the Democratic Republic of the)",
                "Costa Rica",
                "Croatia",
                "Cuba",
                "Cyprus",
                "Czechia",
                "Côte d'Ivoire",
                "Denmark",
                "Djibouti",
                "Dominica",
                "Dominican Republic (the)",
                "Ecuador",
                "Egypt",
                "El Salvador",
                "Eritrea",
                "Estonia",
                "Eswatini",
                "Ethiopia",
                "Finland",
                "France",
                "French Guiana",
                "French Polynesia",
                "French Southern Territories (the)",
                "Gabon",
                "Gambia (the)",
                "Georgia",
                "Germany",
                "Ghana",
                "Gibraltar",
                "Greece",
                "Greenland",
                "Honduras",
                "Hong Kong",
                "Hungary",
                "Iceland",
                "India",
                "Indonesia",
                "Iran (Islamic Republic of)",
                "Iraq",
                "Ireland",

                "Israel",
                "Italy",
                "Jamaica",
                "Japan",
                "Jersey",
                "Jordan",
                "Kazakhstan",
                "Kenya",
                "Korea (the Democratic People's Republic of)",
                "Korea (the Republic of)",
                "Kuwait",
                "Kyrgyzstan",
                "Lao People's Democratic Republic (the)",
                "Latvia",
                "Lebanon",
                "Liberia",
                "Libya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Mexico",
                "Monaco",
                "Mongolia",
                "Montenegro",
                "Montserrat",
                "Morocco",
                "Mozambique",
                "Myanmar",
                "Namibia",
                "Nepal",
                "Netherlands (the)",

                "New Zealand",
                "Nicaragua",
                "Niger (the)",
                "Nigeria",
                "Niue",
                "Norfolk Island",
                "Northern Mariana Islands (the)",
                "Norway",
                "Oman",
                "Pakistan",
                "Palau",
                "Palestine, State of",
                "Panama",
                "Papua New Guinea",
                "Paraguay",
                "Peru",
                "Philippines (the)",
                "Pitcairn",
                "Poland",
                "Portugal",
                "Puerto Rico",
                "Qatar",
                "Republic of North Macedonia",
                "Romania",
                "Russian Federation (the)",
                "Rwanda",
                "Réunion",
                "Saint Barthélemy",
                "Saint Helena, Ascension and Tristan da Cunha",
                "Saint Kitts and Nevis",
                "Saint Lucia",
                "Saint Martin (French part)",
                "Saint Pierre and Miquelon",
                "Saint Vincent and the Grenadines",
                "Samoa",
                "San Marino",
                "Sao Tome and Principe",
                "Saudi Arabia",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra Leone",
                "Singapore",
                "Sint Maarten (Dutch part)",
                "Slovakia",
                "Slovenia",
                "Solomon Islands",
                "Somalia",
                "South Africa",
                "South Georgia and the South Sandwich Islands",
                "South Sudan",
                "Spain",
                "Sri Lanka",
                "Sudan (the)",
                "Suriname",
                "Svalbard and Jan Mayen",
                "Sweden",
                "Switzerland",
                "Syrian Arab Republic",
                "Taiwan",
                "Tajikistan",
                "Tanzania, United Republic of",
                "Thailand",
                "Timor-Leste",
                "Togo",
                "Tokelau",
                "Tonga",
                "Trinidad and Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Turks and Caicos Islands (the)",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United Arab Emirates (the)",
                "United Kingdom of Great Britain and Northern Ireland (the)",
                "United States Minor Outlying Islands (the)",
                "United States of America (the)",
                "Uruguay",
                "Uzbekistan",
                "Vanuatu",
                "Venezuela (Bolivarian Republic of)",
                "Viet Nam",
                "Virgin Islands (British)",
                "Virgin Islands (U.S.)",
                "Wallis and Futuna",
                "Western Sahara",
                "Yemen",
                "Zambia",
                "Zimbabwe",
                "Åland Islands"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countryNames);

        autoCountryName.setAdapter(arrayAdapter);
        autoCountryName.setThreshold(1);


    }



    //Downloading JSON contnt
    public class DownloadTask extends AsyncTask<String , Void , String> {


        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int pointer = reader.read();
                while (pointer != -1) {
                    char currentChar = (char) pointer;
                    result += currentChar;
                    pointer = reader.read();

                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return "faild to load content";
        }


        //Customizing JSON content
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            Log.i("ttt", "onPostExecute: " + s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                String content = jsonObject.getString("Countries");

                Pattern p = Pattern.compile("\"" + countryName + "(.*?)\"Date\"");
                Matcher m = p.matcher(content);
                while (m.find()) {
                    state = (m.group(1));

                }

                // assign Total Deathes

                Pattern p2 = Pattern.compile("\"NewDeaths\":(.*?),");
                Matcher m2 = p2.matcher(state);
                while (m2.find()) {
                    deathes = (m2.group(1));

                }
                deathNum.setText(deathes);


                // assign Total Recoverd

                Pattern p3 = Pattern.compile("\"NewRecovered\":(.*?),");
                Matcher m3 = p3.matcher(state);
                while (m3.find()) {
                    recoverd = (m3.group(1));

                }
                recoverdNum.setText(recoverd);


                // assign total cases

                Pattern p4 = Pattern.compile("\"NewConfirmed\":(.*?),");
                Matcher m4 = p4.matcher(state);
                while (m4.find()) {
                    cases = (m4.group(1));

                }
                casesNum.setText(cases);


                Log.i("Country State", "onPostExecute: " + state);
                Log.i("Country deathes", "onPostExecute: " + deathes);
                Log.i("Country recoverd", "onPostExecute: " + recoverd);
                Log.i("Country cases", "onPostExecute: " + cases);

            } catch (JSONException e) {
                Toast.makeText(SearchActivity.this, " something went wrong", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        }

    }
}