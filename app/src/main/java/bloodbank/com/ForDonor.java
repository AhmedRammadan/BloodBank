package bloodbank.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ForDonor extends AppCompatActivity {
    RecyclerView rec_ForDonor;
    Adapter_Rec_ForDonor adapter;
    ArrayList<item_forDonor> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_donor);
        rec_ForDonor = findViewById(R.id.re_forDonor);
        items = new ArrayList<>();
        item_forDonor item = new item_forDonor(R.drawable.blood1,"ما عليك فعله قبل وبعد التبرع", "is developer");
        items.add(item);
        adapter = new Adapter_Rec_ForDonor(ForDonor.this,items);
        rec_ForDonor.setLayoutManager(new LinearLayoutManager(this));
        rec_ForDonor.setAdapter(adapter);
    }
}
