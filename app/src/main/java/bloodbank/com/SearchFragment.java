package bloodbank.com;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SearchFragment extends Fragment {
    String nameOfCountry, nameOfCities , nameOfBloodType;
    DatabaseReference reference;
    RecyclerView rec_search;
    Adaper_Recy  adaper_recy;
    ArrayList<Donor> al_recSearch ;
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        nameOfCountry  = MainActivity.nameOfCountry;
        nameOfCities   = MainActivity.nameOfCities;
        nameOfBloodType= MainActivity.nameOfBloodType;
        rec_search = view.findViewById(R.id.re_Search);
        reference = FirebaseDatabase.getInstance().getReference("blood-bank").child(nameOfCountry).child(nameOfCities).child(nameOfBloodType);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.GONE);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Donor donor = snapshot.getValue(Donor.class);
                    al_recSearch.add(donor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        rec_search.setLayoutManager(new LinearLayoutManager(getActivity()));
        al_recSearch = new ArrayList<>();

        adaper_recy = new Adaper_Recy(getActivity(),al_recSearch);
        rec_search.setAdapter(adaper_recy);
        return view;
    }

}
