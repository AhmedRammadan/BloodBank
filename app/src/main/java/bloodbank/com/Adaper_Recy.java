package bloodbank.com;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaper_Recy extends RecyclerView.Adapter<ViewHolder> {

    Context mcontext;
    ArrayList<Donor> items ;
    int chick;

    public Adaper_Recy(Context mcontext, ArrayList<Donor> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.item_search,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        holder.name.setText(items.get(i).getName());
        holder.data.setText(items.get(i).getPhoneNumber());
        String AvailableTime = items.get(i).getAvailableTime();
        try {
            chick = Integer.parseInt(AvailableTime);
        }catch (Exception e){
        }

        if (chick == 1){
            String days = items.get(i).getFri()+" ";
            days+=items.get(i).getMon()+" ";
            days+=items.get(i).getSat()+" ";
            days+=items.get(i).getSun()+" ";
            days+=items.get(i).getThu()+" ";
            days+=items.get(i).getWed()+" ";
            days+=items.get(i).getTue()+" ";
            holder.days.setText(days);
        }else {
            holder.days.setText(items.get(i).getAvailableTime());
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                SearchPage.checkPermission(mcontext);
                if (ContextCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    call(items.get(i).getPhoneNumber());
                }else {
                    Toast.makeText(mcontext, "please do permission for call", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void call(String PhoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+PhoneNumber));
        mcontext.startActivity(callIntent);

    }
}
