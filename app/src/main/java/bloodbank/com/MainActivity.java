package bloodbank.com;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String nameOfCountry, nameOfCities , nameOfBloodType;
    boolean connected = false;
    LinearLayout linear1,LinearLayout1;
    TextView textBloodBank;
    Spinner spinner_country,spinner_cities,spinner_bloodType;
    ArrayAdapter adapter_country,adapter_cities,adapter_bloodType;
    String [] country,cities,bloodType;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            LinearLayout1.setGravity(0);
            LinearLayout1.setPadding(13,13,13,0);
            textBloodBank.setTextSize(30f);
            textBloodBank.setGravity(0);
            textBloodBank.setPadding(20,0,20,30);
            linear1.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        handler.postDelayed(runnable,2000);
    }


    public void findViewById(){
        try {
            spinner_country = findViewById(R.id.spinner_country);
            cities = getResources().getStringArray(R.array.Egypt);
            spinner_cities = findViewById(R.id.spinner_cities);
            spinner_bloodType = findViewById(R.id.spinner_bloodType);
            linear1 = findViewById(R.id.linear1);
            spinner_country = findViewById(R.id.spinner_country);
            spinner_cities = findViewById(R.id.spinner_cities);
            spinner_bloodType = findViewById(R.id.spinner_bloodType);
            LinearLayout1 = findViewById(R.id.LinearLayout1);
            textBloodBank = findViewById(R.id.textBloodBank);


        }catch (Exception e){

        }

    }
    public void Search(View view) {
        if (connected()) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("key", 0);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    public void sinUp(View view) {
        if (connected()) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("key", 1);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean connected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else{
            connected = false;
        }
        return connected;
    }

    public void setSpinnerCountry(){
        try {
            country = getResources().getStringArray(R.array.country);
            adapter_country = new ArrayAdapter(MainActivity.this,R.layout.spinner,country);
            spinner_country.setAdapter(adapter_country);
            spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfCountry = country[position];

                    if (nameOfCountry == country[0]){
                        cities = getResources().getStringArray(R.array.Egypt);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[1]){
                        cities = getResources().getStringArray(R.array.Jordan);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[2]){
                        cities = getResources().getStringArray(R.array.Emirates);
                        setSpinnerCities();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){

        }
    }
    public void setSpinnerCities(){
        try {
            adapter_cities = new ArrayAdapter(MainActivity.this,R.layout.spinner,cities);
            spinner_cities.setAdapter(adapter_cities);
            spinner_cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfCities = cities[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        catch (Exception e){

        }
    }
    public void setSpinnerBloodType(){
        try {
            bloodType = getResources().getStringArray(R.array.bloodType);
            adapter_bloodType = new ArrayAdapter(MainActivity.this,R.layout.spinner,bloodType);
            spinner_bloodType.setAdapter(adapter_bloodType);
            spinner_bloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfBloodType = bloodType[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){

        }
    }

}
