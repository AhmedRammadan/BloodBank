package bloodbank.com;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear1,LinearLayout1;
    TextView textBloodBank;
    Spinner spinner,spinner1,spinner2;
    ArrayAdapter adapter,adapter1,adapter2;
    String [] names,names1,names2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            LinearLayout1.setGravity(0);
            LinearLayout1.setPadding(13,13,13,0);
            textBloodBank.setGravity(0);
            textBloodBank.setPadding(13,13,13,20);
            textBloodBank.setTextSize(30f);
            linear1.setVisibility(View.VISIBLE);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1 = findViewById(R.id.linear1);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        LinearLayout1 = findViewById(R.id.LinearLayout1);
        textBloodBank = findViewById(R.id.textBloodBank);
        handler.postDelayed(runnable,2000);
        setSpinner();

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
        names = getResources().getStringArray(R.array.names);
        adapter = new ArrayAdapter(MainActivity.this,R.layout.spinner,names);
        spinner.setAdapter(adapter);

        names1 = getResources().getStringArray(R.array.names1);
        adapter1 = new ArrayAdapter(MainActivity.this,R.layout.spinner,names1);
        spinner1.setAdapter(adapter1);

        names2 = getResources().getStringArray(R.array.names2);
        adapter2 = new ArrayAdapter(MainActivity.this,R.layout.spinner,names2);
        spinner2.setAdapter(adapter2);
    }

}
