package bloodbank.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class posts extends Fragment {
     View view;
    RecyclerView rec_ForDonor;
    Adapter_Rec_ForDonor adapter;
    ArrayList<item_forDonor> items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_posts, container, false);
       /* rec_ForDonor = view.findViewById(R.id.re_forDonor);
        items = new ArrayList<>();
        item_forDonor item = new item_forDonor(R.drawable.blood1,"The Benefits of Donating Blood", "is developer");
         items.add(item);
        adapter = new Adapter_Rec_ForDonor(getContext(),items);
        rec_ForDonor.setLayoutManager(new LinearLayoutManager(getContext()));
        rec_ForDonor.setAdapter(adapter);*/
        return view;
    }

}
