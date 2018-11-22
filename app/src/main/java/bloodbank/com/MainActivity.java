package bloodbank.com;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> numbers;
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
        linear1 = findViewById(R.id.linear1);
        spinner_country = findViewById(R.id.spinner_country);
        spinner_cities = findViewById(R.id.spinner_cities);
        spinner_bloodType = findViewById(R.id.spinner_bloodType);
        LinearLayout1 = findViewById(R.id.LinearLayout1);
        textBloodBank = findViewById(R.id.textBloodBank);
        handler.postDelayed(runnable,2000);
        setSpinner();

         numbers = new ArrayList();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // HideTheNavigationBar();
    }

    void HideTheNavigationBar(){
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void Search(View view) {
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("key",0);
        startActivity(intent);
    }
    public void sinUp(View view) {
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("key",1);
        startActivity(intent);
    }

    public void setSpinner(){
        country = getResources().getStringArray(R.array.country);
        adapter_country = new ArrayAdapter(MainActivity.this,R.layout.spinner,country);
        spinner_country.setAdapter(adapter_country);

        cities = getResources().getStringArray(R.array.Egypt);
        adapter_cities = new ArrayAdapter(MainActivity.this,R.layout.spinner,cities);
        spinner_cities.setAdapter(adapter_cities);

        bloodType = getResources().getStringArray(R.array.bloodType);
        adapter_bloodType = new ArrayAdapter(MainActivity.this,R.layout.spinner,bloodType);
        spinner_bloodType.setAdapter(adapter_bloodType);
    }

}
