package bloodbank.com;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity {
    Handler handler =new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (connected()) {
                getDataBase();
            }else {
                tv_tryAgain.setVisibility(View.VISIBLE);
                rec_search.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                tv_noDonors.setVisibility(View.VISIBLE);
                tv_noDonors.setText("check your internet connection");
            }
        }
    };
    private static final int   MY_PERMISSIONS_REQUEST = 1;
    String nameOfCountry, nameOfCities , nameOfBloodType;
    DatabaseReference reference;
    RecyclerView rec_search;
    Adaper_Recy  adaper_recy;
    ArrayList<Donor> al_recSearch ;
    ProgressBar progressBar;
    TextView tv_noDonors,tv_tryAgain;
    Spinner spinner_country,spinner_cities,spinner_bloodType;
    ArrayAdapter adapter_country,adapter_cities,adapter_bloodType;
    String [] country,cities,bloodType;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog();
            }
        });
        getDataBase();
        rec_search.setLayoutManager(new LinearLayoutManager(SearchPage.this));
        al_recSearch = new ArrayList<>();
        adaper_recy = new Adaper_Recy(SearchPage.this,al_recSearch);

        rec_search.setAdapter(adaper_recy);
        handler.postDelayed(runnable,4000);
    }
    public void findViewById(){
        try {
            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            nameOfCountry  = Main.nameOfCountry;
            nameOfCities   = Main.nameOfCities;
            nameOfBloodType= Main.nameOfBloodType;
            rec_search = findViewById(R.id.re_Search);
            tv_noDonors = findViewById(R.id.tv_noDonors);
            tv_tryAgain = findViewById(R.id.tv_tryAgain);
            spinner_country = findViewById(R.id.spinner_searchCountry);
            cities = getResources().getStringArray(R.array.defaultCity);
            spinner_cities = findViewById(R.id.spinner_searchCity);
            spinner_bloodType = findViewById(R.id.spinner_searchBloodType);
            fab = findViewById(R.id.fab);

        }catch (Exception e){

        }

    }
    public void setSpinnerCountry(){
        try {
            country = getResources().getStringArray(R.array.country);
            adapter_country = new ArrayAdapter(SearchPage.this,R.layout.spinner,country);
            spinner_country.setAdapter(adapter_country);
            spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfCountry=country[position];
                    if (nameOfCountry == country[0]){
                        cities = getResources().getStringArray(R.array.defaultCity);
                        setSpinnerCities();
                    }else if (nameOfCountry  ==country[1]){
                        cities = getResources().getStringArray(R.array.Egypt);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[2]){
                        cities = getResources().getStringArray(R.array.Jordan);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[3]){
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
            adapter_cities = new ArrayAdapter(SearchPage.this,R.layout.spinner,cities);
            spinner_cities.setAdapter(adapter_cities);
            spinner_cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position!=0) {
                        nameOfCities=cities[position];
                    }
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
            adapter_bloodType = new ArrayAdapter(SearchPage.this,R.layout.spinner,bloodType);
            spinner_bloodType.setAdapter(adapter_bloodType);
            spinner_bloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position!=0) {
                        nameOfBloodType = bloodType[position];

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){

        }
    }
    private void AlertDialog(){
        final AlertDialog alertDialog = new AlertDialog.Builder(SearchPage.this).create();
        View alertShow = getLayoutInflater().inflate(R.layout.alert_dialog,null);
        alertDialog.setView(alertShow);
        alertDialog.show();
        spinner_country = alertShow.findViewById(R.id.spinner_searchCountry);
        spinner_cities = alertShow.findViewById(R.id.spinner_searchCity);
        spinner_bloodType = alertShow.findViewById(R.id.spinner_searchBloodType);
        Button btn_alertSearch = alertShow.findViewById(R.id.btn_alertSearch);
        Button btn_alertCancel = alertShow.findViewById(R.id.btn_alertCancel);
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        alertDialog.setCancelable(false);
        btn_alertSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (connected()) {
                   if (spinner_country.getSelectedItemPosition() != 0) {
                       if (spinner_cities.getSelectedItemPosition() != 0) {
                           if (spinner_bloodType.getSelectedItemPosition() != 0) {
                               progressBar.setVisibility(View.VISIBLE);
                               getDataBase();
                               adaper_recy = new Adaper_Recy(SearchPage.this, al_recSearch);
                               rec_search.setAdapter(adaper_recy);
                               alertDialog.dismiss();
                           } else {
                               Toast.makeText(SearchPage.this, "please choose the blood type", Toast.LENGTH_SHORT).show();
                           }
                       } else {
                           Toast.makeText(SearchPage.this, "please choose the city", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(SearchPage.this, "please choose the country", Toast.LENGTH_SHORT).show();
                   }
               }else {
                   Toast.makeText(SearchPage.this, "check your internet connection", Toast.LENGTH_SHORT).show();
               }
            }
        });
        btn_alertCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
    private void getDataBase(){
        if (connected()){
            tv_noDonors.setVisibility(View.GONE);
            tv_tryAgain.setVisibility(View.GONE);
            reference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    al_recSearch.clear();
                    rec_search.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Donor donor = snapshot.getValue(Donor.class);
                        al_recSearch.add(donor);
                    }
                    if (al_recSearch.size() == 0) {
                        tv_noDonors.setText("Sorry there are no donors");
                        tv_noDonors.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else {
            tv_tryAgain.setVisibility(View.VISIBLE);
            rec_search.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            tv_noDonors.setVisibility(View.VISIBLE);
            tv_noDonors.setText("check your internet connection");
        }
    }
    private boolean connected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else{
            return false;
        }
    }
    public void tryAgain(View view) {
        progressBar.setVisibility(View.VISIBLE);
        getDataBase();
        adaper_recy = new Adaper_Recy(SearchPage.this,al_recSearch);
        rec_search.setAdapter(adaper_recy);
    }
    public static void  checkPermission(Context context){
        // Here, thisActivity is the current activity

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                // ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            return;
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    return;
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    checkPermission(SearchPage.this);
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
