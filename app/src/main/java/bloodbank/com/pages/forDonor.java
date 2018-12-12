package bloodbank.com.pages;

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

import bloodbank.com.Adapters.Adapter_Rec_ForDonor;
import bloodbank.com.R;
import bloodbank.com.items.card__forDonor;

public class forDonor extends AppCompatActivity {
    String title1 = "The Benefits of Donating Blood",
            desc1="There’s no end to the benefits of donating blood for those who need it. According to the American Red Cross, one donation can save as many as three lives, and someone in the world needs blood every two seconds.\n" +
                    "\n" +
                    "It turns out that donating blood doesn’t just benefit recipients. There are health benefits for donors, too, on top of the benefits that come from helping others. Read on to learn the health benefits of donating blood and the reasons behind them.",
            title2 = "Benefits",
            desc2="Donating blood has benefits for your emotional and physical health. According to a report by the Mental Health Foundation, helping others can:\n" +
                    "\n" +
                    "-reduce stress\n" +
                    "-improve your emotional well-being\n" +
                    "-benefit your physical health\n" +
                    "-help get rid of negative feelings\n" +
                    "-provide a sense of belonging and reduce isolation\n" +
                    "Research has found further evidence of the health benefits that come specifically from donating blood.",
            title3 = "Lower risk of heart disease",
            desc3 ="Blood donation may lower the risk of heart disease and heart attack. This is because it reduces the blood’s viscosity.\n" +
                    "\n" +
                    "A 2013 study found that regular blood donation significantly lowered the mean total cholesterol and low-density lipoprotein cholesterol, protecting against cardiovascular disease. Researchers note this is consistent with findings in other studies which found that blood donors had a lower risk of heart disease and heart attack.\n" +
                    "\n" +
                    "Donating blood regularly may also lower iron stores. This may reduce the risk of heart attack. High body iron stores are believed to increase the risk of heart attack.",
            title4 = "Lower risk of cancer",
            desc4 ="A 2008 study found a small decrease in the risk of certain cancers in people who regularly donated blood. These included cancers that are linked to high iron levels, including cancer of the:\n" +
                    "   -liver\n" +
                    "   -colon\n" +
                    "   -lung\n" +
                    "   -esophagus\n" +
                    "   -stomach\n" +
                    "\n" +
                    "A 2016 study also found that donating blood can lower inflammatory markers and increase antioxidant capacity.",
            title5 = "Free health checkup",
            desc5 ="In order to give blood, you’re required to undergo a health screening. A trained staff member performs this checkup. They’ll check your:\n" +
                    "   -pulse\n" +
                    "   -blood pressure\n" +
                    "   -body temperature\n" +
                    "   -hemoglobin levels\n" +
                    "\nThis free mini-physical can offer excellent insight into your health. It can effectively detect problems that could indicate an underlying medical condition or risk factors for certain diseases.\n" +
                    "\n" +
                    "Your blood is also tested for several diseases. \n These include:" +
                    "\n" +
                    "   -hepatitis B\n" +
                    "   -hepatitis C\n" +
                    "   -HIV\n" +
                    "   -West Nile virus\n" +
                    "   -syphilis\n" +
                    "   -Trypanosoma cruzi",
            title6 = "Side effects of donating blood",
            desc6 ="Blood donation is safe for healthy adults. There’s no risk of contracting disease. New, sterile equipment is used for each donor.\n" +
                    "\n" +
                    "Some people may feel nauseous, lightheaded, or dizzy after donating blood. If this happens, it should only last a few minutes. You can lie down with your feet up at the until you feel better.\n" +
                    "\n" +
                    "You may also experience some bleeding at the site of the needle. Applying pressure and raising your arm for a couple of minutes will usually stop this. You may develop a bruise at the site.\n" +
                    "Call the blood donation center if:\n" +
                    "-You still feel lightheaded, dizzy, or nauseous after drinking, eating, and resting.\n" +
                    "-You develop a raised bump or continue bleeding at the needle site.\n" +
                    "-You have arm pain, numbness, or tingling.",
            title7 = "During the donation",
            desc7 ="You must register to donate blood. This includes providing identification, your medical history, and undergoing a quick physical examination. You’ll also be given some information about blood donation to read.\n" +
                    "Once you’re ready, your blood donation procedure will begin. Whole blood donation is the most common type of donation. This is because it offers the most flexibility. It can be transfused as whole blood or separated into red cells, platelets, and plasma for different recipients.\n" +
                    "For a whole blood donation procedure:\n" +
                    "1-You’ll be seated in a reclining chair. You can donate blood either sitting or lying down.\n" +
                    "2-A small area of your arm will be cleaned. A sterile needle will then be inserted.\n" +
                    "3-You’ll remain seated or lying down while a pint of your blood is drawn. This takes 8 to 10 minutes.\n" +
                    "4-When a pint of blood has been collected, a staff member will remove the needle and bandage your arm.\n" +
                    "Other types of donation include:\n" +
                    "-platelet donation (plateletpheresis)\n" +
                    "-plasma donation (plasmapheresis)\n" +
                    "-double red cell donation\n" +
                    "These types of donations are performed using a process called apheresis. An apheresis machine is connected to both of your arms. It collects a small amount of blood and separates the components before returning the unused components back to you. This cycle is repeated several times over approximately two hours.\n" +
                    "Once your donation is complete, you’ll be given a snack and a drink and be able to sit and rest for 10 or 15 minutes before you leave. If you feel faint or nauseous, you’ll be able to lie down until you feel better.",
            title8 ="What to know before you donate",
            desc8 ="Here are some important things to know before you donate:\n" +
                    "-You need to be 17 or older to donate whole blood. Some states allow you to donate at 16 with parental consent.\n" +
                    "-You have to weigh at least 110 pounds and be in good health to donate.\n" +
                    "-You need to provide information about medical conditions and any medications you’re taking. These may affect your eligibility to donate blood.\n" +
                    "-You must wait at least eight weeks between whole blood donations and 16 weeks between double red cell donations.\n" +
                    "-Platelet donations can be made every seven days, up to 24 times per year.\n" +
                    "The following are some suggestions to help you prepare for donating blood:\n" +
                    "-Drink an extra 16 ounces of water before your appointment.\n" +
                    "-Eat a healthy meal that’s low in fat.\n" +
                    "-Wear a short-sleeved shirt or a shirt with sleeves that are easy to roll up.\n" +
                    "Let the staff know if you have a preferred arm or vein and if you prefer to sit up or lie down. Listening to music, reading, or talking to someone else can help you relax during the donation process.";
    RecyclerView rec_ForDonor;
    Adapter_Rec_ForDonor adapter;
    ArrayList<card__forDonor> items;
    FloatingActionButton btn_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        btn_fab = findViewById(R.id.btn_fab);
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = title1 +"\n"+ desc1+"\n\n"+title2+"\n"+desc2+"\n\n"+title3+"\n"+desc3+"\n\n"+title4+"\n"+desc4+"\n\n"+ title5+"\n"+ desc5+"\n\n"+title6+"\n"+desc6+"\n\n"+ title7+"\n"+desc7+"\n\n"+title8+"\n"+desc8;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareBody);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "The Benefits of Donating Blood"));

            }
        });
        rec_ForDonor = findViewById(R.id.re_forDonor);
        items = new ArrayList<>();
        items.add(new card__forDonor(title1, desc1));
        items.add(new card__forDonor(title2, desc2));
        items.add(new card__forDonor(title3, desc3));
        items.add(new card__forDonor(title4, desc4));
        items.add(new card__forDonor(title5, desc5));
        items.add(new card__forDonor(title6, desc6));
        items.add(new card__forDonor(title7, desc7));
        items.add(new card__forDonor(title8, desc8));
        adapter = new Adapter_Rec_ForDonor(forDonor.this,items);
        rec_ForDonor.setLayoutManager(new LinearLayoutManager(forDonor.this));
        rec_ForDonor.setAdapter(adapter);
        setupToolbar();
    }
    private void setupToolbar() {
        final android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            startActivity(new Intent(forDonor.this, ShowFragment.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(forDonor.this, ShowFragment.class));
        finish();

    }
}
