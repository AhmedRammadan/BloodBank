package bloodbank.com.pages;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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

import bloodbank.com.Adapters.Adapter_Recy_Donors;
import bloodbank.com.items.SignUpDonor;
import bloodbank.com.fragments.Search;
import bloodbank.com.R;

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
    String nameOfCountryAlertDialog, nameOfCitiesAlertDialog , nameOfBloodTypeAlertDialog;
    DatabaseReference reference;
    RecyclerView rec_search;
    Adapter_Recy_Donors _recyDonors;
    ArrayList<SignUpDonor> al_recSearch ;
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
        _recyDonors = new Adapter_Recy_Donors(SearchPage.this,al_recSearch);
        rec_search.setAdapter(_recyDonors);
        handler.postDelayed(runnable,4000);
    }
    public void findViewById(){
        try {
            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            nameOfCountry  = Search.nameOfCountry;
            nameOfCities   = Search.nameOfCities;
            nameOfBloodType= Search.nameOfBloodType;
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
                    nameOfCountryAlertDialog=country[position];
                    if (nameOfCountryAlertDialog == country[0]){
                        cities = getResources().getStringArray(R.array.defaultCity);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog  ==country[1]){
                        cities = getResources().getStringArray(R.array.Egypt);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[2]){
                        cities = getResources().getStringArray(R.array.Jordan);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[3]){
                        cities = getResources().getStringArray(R.array.Emirates);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[4]){
                        cities = getResources().getStringArray(R.array.Bahrain);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[5]){
                        cities = getResources().getStringArray(R.array.Algeria);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[6]){
                        cities = getResources().getStringArray(R.array.SaudiArabia);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[7]){
                        cities = getResources().getStringArray(R.array.Sudan);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[8]){
                        cities = getResources().getStringArray(R.array.Somalia);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[9]){
                        cities = getResources().getStringArray(R.array.Iraq);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[10]){
                        cities = getResources().getStringArray(R.array.Kuwait);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[11]){
                        cities = getResources().getStringArray(R.array.Morocco);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[12]){
                        cities = getResources().getStringArray(R.array.Yemen);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[13]){
                        cities = getResources().getStringArray(R.array.Turkey);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[14]){
                        cities = getResources().getStringArray(R.array.Tunisia);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[15]){
                        cities = getResources().getStringArray(R.array.islands_of_the_moon);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[16]){
                        cities = getResources().getStringArray(R.array.Comoros);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[17]){
                        cities = getResources().getStringArray(R.array.Djibouti);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[18]){
                        cities = getResources().getStringArray(R.array.Syria);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[19]){
                        cities = getResources().getStringArray(R.array.Oman);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[20]){
                        cities = getResources().getStringArray(R.array.Palestine);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[21]){
                        cities = getResources().getStringArray(R.array.Qatar);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[22]){
                        cities = getResources().getStringArray(R.array.Lebanon);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[23]){
                        cities = getResources().getStringArray(R.array.Libya);
                        setSpinnerCities();
                    }else if (nameOfCountryAlertDialog == country[24]) {
                        cities = getResources().getStringArray(R.array.Mauritania);
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
                        nameOfCitiesAlertDialog=cities[position];
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
                        nameOfBloodTypeAlertDialog = bloodType[position];

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
        final AlertDialog alertDialog = new AlertDialog.Builder(SearchPage.this,R.style.CustomDialog).create();
        View alertShow = getLayoutInflater().inflate(R.layout.alert_dialog,null);
        alertDialog.setView(alertShow);
        alertDialog.show();
        spinner_country = alertShow.findViewById(R.id.spinner_searchCountry);
        spinner_cities = alertShow.findViewById(R.id.spinner_searchCity);
        spinner_bloodType = alertShow.findViewById(R.id.spinner_searchBloodType);
        TextView btn_alertSearch = alertShow.findViewById(R.id.btn_alertSearch);
        TextView btn_alertCancel = alertShow.findViewById(R.id.btn_alertCancel);
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        btn_alertSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (connected()) {
                   if (spinner_country.getSelectedItemPosition() != 0) {
                       if (spinner_cities.getSelectedItemPosition() != 0) {
                           if (spinner_bloodType.getSelectedItemPosition() != 0) {
                               progressBar.setVisibility(View.VISIBLE);
                               getDataBaseAlertDialog();
                               _recyDonors = new Adapter_Recy_Donors(SearchPage.this, al_recSearch);
                               rec_search.setAdapter(_recyDonors);
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
                        SignUpDonor signUpDonor = snapshot.getValue(SignUpDonor.class);
                        al_recSearch.add(0, signUpDonor);
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
    private void getDataBaseAlertDialog(){
        if (connected()){
            tv_noDonors.setVisibility(View.GONE);
            tv_tryAgain.setVisibility(View.GONE);
            reference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountryAlertDialog).child(nameOfCitiesAlertDialog).child(nameOfBloodTypeAlertDialog);
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    al_recSearch.clear();
                    rec_search.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        SignUpDonor signUpDonor = snapshot.getValue(SignUpDonor.class);
                        al_recSearch.add(0, signUpDonor);
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
        _recyDonors = new Adapter_Recy_Donors(SearchPage.this,al_recSearch);
        rec_search.setAdapter(_recyDonors);
    }
    public static void requestStoragePermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                Manifest.permission.CALL_PHONE)) {

            new AlertDialog.Builder(context)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity)context,
                                    new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions((Activity)context,
                    new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}