package bloodbank.com;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    RecyclerView rec_search;
    Adaper_Recy  adaper_recy;
    ArrayList<Item_Recy> al_recSearch ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        rec_search = view.findViewById(R.id.re_Search);
        rec_search.setLayoutManager(new LinearLayoutManager(getActivity()));
        al_recSearch = new ArrayList<>();
        al_recSearch.add(new Item_Recy("احمد رمضان" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed " , "8 Am : 4Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        al_recSearch.add(new Item_Recy("Ahmed Ramadan" , "8 Am : 4 Pm","01066727482"));
        adaper_recy = new Adaper_Recy(getActivity(),al_recSearch);
        rec_search.setAdapter(adaper_recy);
        return view;
    }
}
