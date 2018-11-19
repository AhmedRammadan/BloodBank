package bloodbank.com;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import static android.content.ContentValues.TAG;


public class SinUpFragment extends Fragment {
    DatabaseReference myreference ;
    String name;
    String phoneNumber;
    String nameOfCountry;
    String nameOfCities;
    String nameOfBloodType;
    EditText et_nameDonor , et_phoneNumber;
    View view;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sinup, container, false);

        findViewById();
        btn_24();
        getTime();
        changeColorTV();
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        btn_sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinUpDonor();
            }
        });
        return view;
    }
    public void findViewById(){
        //SimUp
        btn_sinUp = view.findViewById(R.id.btn_sinUp);
        et_nameDonor = view.findViewById(R.id.et_nameDonor);
        et_phoneNumber = view.findViewById(R.id.et_phoneNumber);
        //click for get Time
        btn_24h = view.findViewById(R.id.btn_24h);
        tv_24h = view.findViewById(R.id.tv__24h);
        //get Time
        tv_time_to = view.findViewById(R.id.time_to);
        tv_time_to2 = view.findViewById(R.id.time_to2);
        tv_time_from = view.findViewById(R.id.time_from);
        tv_time_from2 = view.findViewById(R.id.time_from2);
        linear_time = view.findViewById(R.id.linear_time);

        //for Days
        sat = view.findViewById(R.id.sat);
        mon = view.findViewById(R.id.mon);
        tue = view.findViewById(R.id.tue);
        wed = view.findViewById(R.id.wed);
        thu = view.findViewById(R.id.thu);
        fri = view.findViewById(R.id.fri);
        sun = view.findViewById(R.id.sun);

        //Spinner
        spinner_country = view.findViewById(R.id.country);
        cities = getResources().getStringArray(R.array.Egypt);
        spinner_cities = view.findViewById(R.id.city);
        spinner_bloodType = view.findViewById(R.id.bloodType);


    }
    public void getTimePicker() {
        final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
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
                    Toast.makeText(getActivity(), "pleas choose time", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }
    public void changeColorTV() {
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
    }
    public void btn_24() {
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
                } else if (index_btn == 2) {
                    availableTime = 2;
                    btn_24h.setBackground(getbtn1);
                    linear_time.setVisibility(View.GONE);
                    index_btn--;
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
                } else if (index_btn == 2) {
                    availableTime = 2;
                    btn_24h.setBackground(getbtn1);
                    linear_time.setVisibility(View.GONE);
                    index_btn--;
                }
            }
        });
    }
    public void getTime(){
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

    }
    public void setSpinnerCountry(){
        country = getResources().getStringArray(R.array.country);
        adapter_country = new ArrayAdapter(getActivity(),R.layout.spinner,country);
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
    }
    public void setSpinnerCities(){

        adapter_cities = new ArrayAdapter(getActivity(),R.layout.spinner,cities);
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
    public void setSpinnerBloodType(){

        bloodType = getResources().getStringArray(R.array.bloodType);
        adapter_bloodType = new ArrayAdapter(getActivity(),R.layout.spinner,bloodType);
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
    }
    public void sinUpDonor(){
        myreference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);
        final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        name        = et_nameDonor.getText().toString();
        phoneNumber = et_phoneNumber.getText().toString();
        if (!name.equals("") && !phoneNumber.equals("")){
            if (availableTime == 2){
                    //here available all time
                    alertDialog.setMessage(name +"\n"+ phoneNumber +"\n"+ nameOfCountry +"\n"+ nameOfCities +"\n"+nameOfBloodType + "\n"+ "all Time");
                    Donor donor = new Donor(name,phoneNumber,"all time");
                    myreference.push().setValue(donor);
                    alertDialog.setMessage(donor.getName() +"\n"+ donor.getPhoneNumber()+ "\n"+ donor.getAvailableTime());
            }else if (availableTime == 1) {

                String fromTime = tv_time_from.getText().toString();
                String toTime = tv_time_to.getText().toString();
                if (selectsat=="sat "|| selectmon=="mon "|| selecttue=="tue "|| selectwed=="wed "||
                        selectthu=="thu "||selectfri=="fri "||selectsun =="sun ") {

                    if (fromTime.length() > 5 && toTime.length() > 5) {

                        Donor donor = new Donor(name, phoneNumber, fromTime, toTime, selectsat, selectmon,
                                selecttue, selectwed, selectthu, selectfri, selectsun);
                        myreference.push().setValue(donor);
                        alertDialog.setMessage(donor.getName() + "\n" + donor.getPhoneNumber()+ "\n" + donor.getFromTime() + "\n" + donor.getToTime() + "\n" +
                                donor.getSat() + donor.getMon() + donor.getTue() + donor.getWed() + donor.getThu() + donor.getFri() + donor.getSun());
                    } else {

                        alertDialog.setMessage("pleas choose time");
                    }
                }else {
                    alertDialog.setMessage("pleas choose days");
                }
            }
        }else {
            alertDialog.setMessage("Enter Your Name and phoneNumber");
        }

       alertDialog.show();
    }


}


