package bloodbank.com;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.rimoto.intlphoneinput.IntlPhoneInput;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class SignUp extends AppCompatActivity {
    DatabaseReference myreference ;
    String name;
    String number;
    ArrayList<String> numbers;
    String phoneNumber;
    String nameOfCountry;
    String nameOfCities;
    String nameOfBloodType;
    EditText et_nameDonor ;
    IntlPhoneInput inputphoneNumber;
    Button btn_sinUp, btn_24h;
    TextView tv_24h, tv_time_to,tv_time_to2, tv_time_from,tv_time_from2;
    TextView sat, mon, tue, wed, thu,fri,sun;
    int availableTime = 2 ,Hour, Minute, index_btn = 1,index_time = 1;
    int index_colorTV1 = 1,index_colorTV2 = 1,index_colorTV3 = 1,index_colorTV4 = 1,index_colorTV5 = 1,index_colorTV6 = 1,index_colorTV7 = 1;
    String AmPm = "Am";
    LinearLayout linear_time ;
    Spinner spinner_country , spinner_cities , spinner_bloodType;
    ArrayAdapter adapter_country,adapter_cities,adapter_bloodType;
    String [] country,cities,bloodType;
    String selectsat="", selectmon="", selecttue="", selectwed="", selectthu="",selectfri="",selectsun="";
    boolean connected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        numbers = new ArrayList<>();
        findViewById();
        btn_24();
        getTime();
        changeColorTV();
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        /*et_nameDonor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getNumbers();
                return false;
            }
        });
        et_nameDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
            }
        });
        inputphoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
            }
        });*/
        btn_sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinUpDonor();
            }
        });



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




    public void findViewById(){
        try {
            //SimUp
            btn_sinUp = findViewById(R.id.btn_sinUp);
            et_nameDonor = findViewById(R.id.et_nameDonor);
            inputphoneNumber = findViewById(R.id.inputphoneNumber);
            //click for get Time
            btn_24h = findViewById(R.id.btn_24h);
            tv_24h = findViewById(R.id.tv__24h);
            //get Time
            tv_time_to = findViewById(R.id.time_to);
            tv_time_to2 = findViewById(R.id.time_to2);
            tv_time_from = findViewById(R.id.time_from);
            tv_time_from2 = findViewById(R.id.time_from2);
            linear_time = findViewById(R.id.linear_time);

            //for Days
            sat = findViewById(R.id.sat);
            mon = findViewById(R.id.mon);
            tue = findViewById(R.id.tue);
            wed = findViewById(R.id.wed);
            thu = findViewById(R.id.thu);
            fri = findViewById(R.id.fri);
            sun = findViewById(R.id.sun);

            //Spinner
            spinner_country = findViewById(R.id.country);
            cities = getResources().getStringArray(R.array.Egypt);
            spinner_cities = findViewById(R.id.city);
            spinner_bloodType = findViewById(R.id.bloodType);
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error11", Toast.LENGTH_SHORT).show();
        }

    }
    public void getTimePicker() {
        try {
            final android.app.AlertDialog builder = new android.app.AlertDialog.Builder(SignUp.this).create();
            final View dialogShow = getLayoutInflater().inflate(R.layout.time_picker, null);
            builder.setView(dialogShow);

            builder.show();

            TimePicker timePicker = dialogShow.findViewById(R.id.timePicker);
            Button btn_ok = dialogShow.findViewById(R.id.btn_ok);
            Button btn_cancel = dialogShow.findViewById(R.id.btn_cancel);
            Hour = 0;
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    if (hourOfDay >= 12) {
                        AmPm = "Pm";
                    } else if (hourOfDay < 12) {
                        AmPm = "Am";
                    }
                    Hour = hourOfDay;
                    Minute = minute;
                }
            });
            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Hour!=0) {
                        if (index_time == 1){
                            if (AmPm == "Pm"){
                                if (Hour != 12) {
                                    Hour -= 12;
                                    tv_time_from.setText(Hour + ":" + Minute + "" + AmPm);
                                }
                                tv_time_from.setText(Hour + ":" + Minute + "" + AmPm);
                            }
                            else {
                                tv_time_from.setText(Hour + ":" + Minute + "" + AmPm);
                            }

                        }else  if (index_time == 2) {
                            if (AmPm == "Pm"){
                                if (Hour !=12){
                                    Hour -=12;
                                    tv_time_to.setText(Hour + ":" + Minute + "" + AmPm);
                                }
                                tv_time_to.setText(Hour + ":" + Minute + "" + AmPm);
                            }
                            else {
                                tv_time_to.setText(Hour + ":" + Minute + "" + AmPm);
                            }
                        }
                        builder.dismiss();
                    }else {
                        Toast.makeText(SignUp.this, "please choose time", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.dismiss();
                }
            });
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error10", Toast.LENGTH_SHORT).show();
        }
    }
    public void changeColorTV() {
        try {
            final int color = getResources().getColor(R.color.colorText);
            final int color1 = getResources().getColor(R.color.colorText1);
            sat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV1 == 1) {
                        selectsat="sat ";
                        sat.setTextColor(color);
                        index_colorTV1++;
                    } else if (index_colorTV1 == 2) {
                        selectsat="";
                        sat.setTextColor(color1);
                        index_colorTV1--;
                    }
                }
            });
            mon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV2 == 1) {
                        selectmon="mon ";
                        mon.setTextColor(color);
                        index_colorTV2++;
                    } else if (index_colorTV2 == 2) {
                        selectmon="";
                        mon.setTextColor(color1);
                        index_colorTV2--;
                    }
                }
            });
            tue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV3 == 1) {
                        selecttue="tue ";
                        tue.setTextColor(color);
                        index_colorTV3++;
                    } else if (index_colorTV3 == 2) {
                        selecttue="";
                        tue.setTextColor(color1);
                        index_colorTV3--;
                    }
                }
            });
            wed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV4 == 1) {
                        selectwed="wed ";
                        wed.setTextColor(color);
                        index_colorTV4++;
                    } else if (index_colorTV4 == 2) {
                        selectwed= "";
                        wed.setTextColor(color1);
                        index_colorTV4--;
                    }
                }
            });
            thu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV5 == 1) {
                        selectthu="thu ";
                        thu.setTextColor(color);
                        index_colorTV5++;
                    } else if (index_colorTV5 == 2) {
                        selectthu="";
                        thu.setTextColor(color1);
                        index_colorTV5--;
                    }
                }
            });
            fri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV6 == 1) {
                        selectfri = "fri ";
                        fri.setTextColor(color);
                        index_colorTV6++;
                    } else if (index_colorTV6 == 2) {
                        selectfri = "";
                        fri.setTextColor(color1);
                        index_colorTV6--;
                    }
                }
            });
            sun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_colorTV7 == 1) {
                        selectsun = "sun ";
                        sun.setTextColor(color);
                        index_colorTV7++;
                    } else if (index_colorTV7 == 2) {
                        selectsun = "";
                        sun.setTextColor(color1);
                        index_colorTV7--;
                    }
                }
            });
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error9", Toast.LENGTH_SHORT).show();
        }
    }
    public void btn_24() {
        try {
            final Drawable getbtn1 = getResources().getDrawable(R.drawable.btn_24h_1);
            final Drawable getbtn2 = getResources().getDrawable(R.drawable.btn_24h_2);
            tv_24h.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_btn == 1) {
                        availableTime = 1;
                        btn_24h.setBackground(getbtn2);
                        linear_time.setVisibility(View.VISIBLE);
                        index_btn++;
                        getNumbers();
                    } else if (index_btn == 2) {
                        availableTime = 2;
                        btn_24h.setBackground(getbtn1);
                        linear_time.setVisibility(View.GONE);
                        index_btn--;
                        getNumbers();
                    }
                }
            });
            btn_24h.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index_btn == 1) {
                        availableTime = 1;
                        btn_24h.setBackground(getbtn2);
                        linear_time.setVisibility(View.VISIBLE);
                        index_btn++;
                        getNumbers();
                    } else if (index_btn == 2) {
                        availableTime = 2;
                        btn_24h.setBackground(getbtn1);
                        linear_time.setVisibility(View.GONE);
                        index_btn--;
                        getNumbers();
                    }
                }
            });
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error8", Toast.LENGTH_SHORT).show();
        }
    }
    public void getTime(){

        try {
            tv_time_from.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTimePicker();
                    index_time = 1;
                }
            });
            tv_time_from2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTimePicker();
                    index_time = 1;
                }
            });
            tv_time_to.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTimePicker();
                    index_time = 2;
                }
            });
            tv_time_to2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTimePicker();
                    index_time = 2;
                }
            });
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error7", Toast.LENGTH_SHORT).show();
        }
    }
    public void setSpinnerCountry(){
        try {
            country = getResources().getStringArray(R.array.country);
            adapter_country = new ArrayAdapter(SignUp.this,R.layout.spinner,country);
            spinner_country.setAdapter(adapter_country);
            spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfCountry = country[position];
                    if (nameOfCountry == country[0]){
                        cities = getResources().getStringArray(R.array.defaultCity);
                        setSpinnerCities();
                        getNumbersForSpinner(nameOfCountry,"Cairo","A+");
                    }else if (nameOfCountry == country[1]){
                        cities = getResources().getStringArray(R.array.Egypt);
                        setSpinnerCities();
                        getNumbersForSpinner(nameOfCountry,"Cairo","A+");
                    }else if (nameOfCountry == country[2]){
                        cities = getResources().getStringArray(R.array.Jordan);
                        setSpinnerCities();
                        getNumbersForSpinner(nameOfCountry,"Amman","A+");
                    }else if (nameOfCountry == country[3]){
                        cities = getResources().getStringArray(R.array.Emirates);
                        setSpinnerCities();
                        getNumbersForSpinner(nameOfCountry,"Dubai","A+");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){

            Toast.makeText(SignUp.this, "Error6", Toast.LENGTH_SHORT).show();
        }
    }
    public void setSpinnerCities(){
        try {
            adapter_cities = new ArrayAdapter(SignUp.this,R.layout.spinner,cities);
            spinner_cities.setAdapter(adapter_cities);
            spinner_cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position!=0) {
                        nameOfCities = cities[position];
                        getNumbersForSpinner(nameOfCountry,nameOfCities,"A+");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        catch (Exception e){

            Toast.makeText(SignUp.this, "Error5", Toast.LENGTH_SHORT).show();
        }
    }
    public void setSpinnerBloodType(){
        try {
            bloodType = getResources().getStringArray(R.array.bloodType);
            adapter_bloodType = new ArrayAdapter(SignUp.this,R.layout.spinner,bloodType);
            spinner_bloodType.setAdapter(adapter_bloodType);
            spinner_bloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position!=0) {
                        nameOfBloodType = bloodType[position];
                        getNumbersForSpinner(nameOfCountry,nameOfCities,nameOfBloodType);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (Exception e){
            Toast.makeText(SignUp.this, "Error4", Toast.LENGTH_SHORT).show();

        }
    }
    public void sinUpDonor(){
        try {
            final android.app.AlertDialog alertDialog = new AlertDialog.Builder(SignUp.this).create();
            name = et_nameDonor.getText().toString();
            if (connected()) {
                if (!name.equals("")) {
                    if (spinner_country.getSelectedItemPosition()!=0) {
                        if (spinner_cities.getSelectedItemPosition()!=0) {
                            if (spinner_bloodType.getSelectedItemPosition()!=0) {
                                if (inputphoneNumber.isValid()) {
                                    phoneNumber = inputphoneNumber.getNumber();
                                        if (chickNumberPhone()) {
                                            if (availableTime == 2) {
                                            myreference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
                                            Donor donor = new Donor(name, phoneNumber, "anytime");
                                            myreference.push().setValue(donor);

                                            Toast.makeText(SignUp.this, "the registration is done", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(SignUp.this, MainActivity.class));
                                        } else if (availableTime == 1) {
                                            myreference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
                                            String fromTime = tv_time_from.getText().toString();
                                            String toTime = tv_time_to.getText().toString();
                                            if (selectsat == "sat" || selectmon == "mon" || selecttue == "tue" || selectwed == "wed" ||
                                                    selectthu == "thu" || selectfri == "fri" || selectsun == "sun") {

                                                if (fromTime.length() > 5 && toTime.length() > 5) {

                                                    Donor donor = new Donor("1", name, phoneNumber, fromTime, toTime, selectsat, selectmon,
                                                            selecttue, selectwed, selectthu, selectfri, selectsun);
                                                    myreference.push().setValue(donor);


                                                    Toast.makeText(SignUp.this, "the registration is done", Toast.LENGTH_LONG).show();
                                                    startActivity(new Intent(SignUp.this, MainActivity.class));
                                                } else {
                                                    alertDialog.setMessage("pleas choose time");
                                                    alertDialog.show();
                                                }
                                            } else {
                                                alertDialog.setMessage("pleas choose days");
                                                alertDialog.show();
                                            }
                                        }
                                    } else {
                                        alertDialog.setMessage("This number already exists");
                                        alertDialog.show();
                                    }
                                }else {
                                    alertDialog.setMessage("Please check the phone number");
                                    alertDialog.show();
                                }
                        } else {
                            Toast.makeText(SignUp.this, "please choose the blood type", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUp.this, "please choose the city", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "please choose the country", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    alertDialog.setMessage("Enter Your Name");
                    alertDialog.show();
                    }
            } else {
                Toast.makeText(SignUp.this, "check your internet connection", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.w(TAG, "sinUpDonor: ",e );
            Toast.makeText(SignUp.this, "Error2", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean chickNumberPhone(){
        try {
            getNumbers();

            for (String number : numbers) {
                long num1 = Long.parseLong(number);
                long num2 = Long.parseLong(phoneNumber);
                if (num1 == num2) {
                    return false;
                }

            }
        }catch (Exception e){
            Toast.makeText(SignUp.this, "Error1", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void  getNumbers(){
        try {
            if (spinner_country.getSelectedItemPosition()!=0) {
                if (spinner_cities.getSelectedItemPosition()!=0) {
                    if (spinner_bloodType.getSelectedItemPosition()!=0) {
                        myreference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
                        myreference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                numbers.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    number = snapshot.child("phoneNumber").getValue(String.class);
                                    numbers.add(number);

                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }else {
                        Toast.makeText(SignUp.this, "please choose the blood type", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUp.this, "please choose the city", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(SignUp.this, "please choose the country", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(SignUp.this, "Error3", Toast.LENGTH_SHORT).show();
        }
    }
    private void  getNumbersForSpinner(String nameOfCountry ,String nameOfCities,String nameOfBloodType){
        try {
            myreference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
            myreference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    numbers.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        number = snapshot.child("phoneNumber").getValue(String.class);
                        numbers.add(number);

                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch (Exception e){
            Toast.makeText(SignUp.this, "Error4", Toast.LENGTH_SHORT).show();
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

}

