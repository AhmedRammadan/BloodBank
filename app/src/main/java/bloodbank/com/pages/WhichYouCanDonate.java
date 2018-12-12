package bloodbank.com.pages;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import bloodbank.com.Adapters.Adapter_Rec_WhichYouCanDonate;
import bloodbank.com.R;
import bloodbank.com.items.card_WhichYouCanDonate;

public class WhichYouCanDonate extends AppCompatActivity {
    RecyclerView rec_ForChoose;
    Adapter_Rec_WhichYouCanDonate adapter;
    ArrayList<card_WhichYouCanDonate> card_WhichYouCanDonates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_blood_type);
        rec_ForChoose = findViewById(R.id.re_chooseBloodType);
        rec_ForChoose.setLayoutManager(new LinearLayoutManager(WhichYouCanDonate.this));
        card_WhichYouCanDonates = new ArrayList<>();
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" A+ , AB+ "," A+ , A- , O+ , O- ",R.drawable.ic_a));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" A+ , A- , AB+ , AB- "," O- , A- ",R.drawable.ic_a_));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" AB+ , AB- "," O- , AB- , B- , A- ",R.drawable.ic_ab_));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" AB+ ","All of them",R.drawable.ic_ab));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" AB+ , B+ "," O+ , O- , B+ , B- ",R.drawable.ic_b));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" B+ , B- , AB+ , AB- "," O- , B- ",R.drawable.ic_b_));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate(" A+ , AB+ , O+ , B+ "," O+ , O- ",R.drawable.ic_o));
        card_WhichYouCanDonates.add(new card_WhichYouCanDonate("All of them"," O- ",R.drawable.ic_o_));

        adapter = new Adapter_Rec_WhichYouCanDonate(WhichYouCanDonate.this, card_WhichYouCanDonates);
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
            startActivity(new Intent(WhichYouCanDonate.this, ShowFragment.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(WhichYouCanDonate.this, ShowFragment.class));
        finish();
    }
}