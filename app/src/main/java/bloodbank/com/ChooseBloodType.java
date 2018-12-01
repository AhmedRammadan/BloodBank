package bloodbank.com;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class ChooseBloodType extends AppCompatActivity {
    RecyclerView rec_ForChoose;
    Adaper_Rec_Choose adapter;
    ArrayList<choose> chooses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_blood_type);
        rec_ForChoose = findViewById(R.id.re_chooseBloodType);
        rec_ForChoose.setLayoutManager(new LinearLayoutManager(ChooseBloodType.this));
        chooses = new ArrayList<>();
        chooses.add(new choose(" AB+ , B+ "," O+ , O- , B+ , B- ",R.drawable.ic_b));
        chooses.add(new choose(" B+ , B- , AB+ , AB- "," O- , B- ",R.drawable.ic_b_));
        chooses.add(new choose(" A+ , AB+ , O+ , B+ "," O+ , O- ",R.drawable.ic_o));
        chooses.add(new choose("All of them"," O- ",R.drawable.ic_o_));
        chooses.add(new choose(" A+ , AB+ "," A+ , A- , O+ , O- ",R.drawable.ic_a));
        chooses.add(new choose(" A+ , A- , AB+ , AB- "," O- , A- ",R.drawable.ic_a_));
        chooses.add(new choose(" AB+ ","All of them",R.drawable.ic_ab));
        chooses.add(new choose(" AB+ , AB- "," O- , AB- , B- , A- ",R.drawable.ic_ab_));

        adapter = new Adaper_Rec_Choose(ChooseBloodType.this,chooses);
        rec_ForChoose.setAdapter(adapter);
        setupToolbar();
    }
    private void setupToolbar() {
        final android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.toolbarChooseBloodType);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbarChooseBloodType);
        collapsingToolbar.setTitle("");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            startActivity(new Intent(ChooseBloodType.this,MainActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChooseBloodType.this,MainActivity.class));
        finish();
    }
}