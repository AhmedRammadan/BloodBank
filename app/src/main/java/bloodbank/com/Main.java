package bloodbank.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment {
    View view ;
    static String nameOfCountry, nameOfCities , nameOfBloodType;
    Spinner spinner_country,spinner_cities,spinner_bloodType;
    ArrayAdapter adapter_country,adapter_cities,adapter_bloodType;
    String [] country,cities,bloodType;
    Button btn_search;
    TextView tv_signUpp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        findViewById();
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerBloodType();
        Search();
        tv_signUpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment();
            }
        });
        return view;
    }
    public void findViewById(){
        try {
           spinner_country = view.findViewById(R.id.spinner_country);
            tv_signUpp = view.findViewById(R.id.tv_signUpp);
            cities = getResources().getStringArray(R.array.Egypt);
            spinner_cities = view.findViewById(R.id.spinner_cities);
            spinner_bloodType = view.findViewById(R.id.spinner_bloodType);
            btn_search = view.findViewById(R.id.btn_search);

        }catch (Exception e){

        }

    }
    public void Search() {
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner_country.getSelectedItemPosition()!=0) {
                    if (spinner_cities.getSelectedItemPosition() != 0) {
                        if (spinner_bloodType.getSelectedItemPosition() != 0) {
                            startActivity( new Intent(getActivity(), SearchPage.class));
                        }else {
                            Toast.makeText(getActivity(), "please choose blood type", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getActivity(), "please choose city", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "please choose the country", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void setSpinnerCountry(){
        try {
            country = getResources().getStringArray(R.array.country);
            adapter_country = new ArrayAdapter(getActivity(),R.layout.spinner,country);
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
                    }else if (nameOfCountry == country[4]){
                        cities = getResources().getStringArray(R.array.Bahrain);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[5]){
                        cities = getResources().getStringArray(R.array.Algeria);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[6]){
                        cities = getResources().getStringArray(R.array.SaudiArabia);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[7]){
                        cities = getResources().getStringArray(R.array.Sudan);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[8]){
                        cities = getResources().getStringArray(R.array.Somalia);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[9]){
                        cities = getResources().getStringArray(R.array.Iraq);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[10]){
                        cities = getResources().getStringArray(R.array.Kuwait);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[11]){
                        cities = getResources().getStringArray(R.array.Morocco);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[12]){
                        cities = getResources().getStringArray(R.array.Yemen);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[13]){
                        cities = getResources().getStringArray(R.array.Turkey);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[14]){
                        cities = getResources().getStringArray(R.array.Tunisia);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[15]){
                        cities = getResources().getStringArray(R.array.islands_of_the_moon);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[16]){
                        cities = getResources().getStringArray(R.array.Comoros);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[17]){
                        cities = getResources().getStringArray(R.array.Djibouti);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[18]){
                        cities = getResources().getStringArray(R.array.Syria);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[19]){
                        cities = getResources().getStringArray(R.array.Oman);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[20]){
                        cities = getResources().getStringArray(R.array.Palestine);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[21]){
                        cities = getResources().getStringArray(R.array.Qatar);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[22]){
                        cities = getResources().getStringArray(R.array.Lebanon);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[23]){
                        cities = getResources().getStringArray(R.array.Libya);
                        setSpinnerCities();
                    }else if (nameOfCountry == country[24]) {
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
            adapter_cities = new ArrayAdapter(getActivity(),R.layout.spinner,cities);
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
            adapter_bloodType = new ArrayAdapter(getActivity(),R.layout.spinner,bloodType);
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

    private void setFragment(){
        MainActivity.BackPressed = 2;
        Fragment fragment = new SignDonor();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }

}
