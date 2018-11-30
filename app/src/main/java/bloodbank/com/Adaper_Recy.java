package bloodbank.com;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Adaper_Recy extends RecyclerView.Adapter<ViewHolder> {

    Context mcontext;
    ArrayList<Donor> items ;
    String timeNow , timeDonorFrom , timeDonorTo;
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
        int chickDay = items.get(i).getCheckDay();
        int chickTime = items.get(i).getCheckTime();

        if (chickDay == 1 && chickTime == 1){
            String days = items.get(i).getFri()+"-";
            days+=items.get(i).getMon()+"-";
            days+=items.get(i).getSat()+"-";
            days+=items.get(i).getSun()+"-";
            days+=items.get(i).getThu()+"-";
            days+=items.get(i).getWed()+"-";
            days+=items.get(i).getTue()+"-";
            holder.days.setText(days);
            timeDonorFrom = items.get(i).getFromTime();
            timeDonorTo   = items.get(i).getToTime();
            holder.time.setText("From   "+items.get(i).getFromTime()+"  To  "+items.get(i).getToTime());

        }else if (chickDay == 0 && chickTime == 0){
            holder.days.setText(items.get(i).getAvailableDay());
            holder.time.setText(items.get(i).getAvailableTime());
        }else if (chickDay == 0 && chickTime == 1){
            holder.days.setText(items.get(i).getAvailableDay());
            timeDonorFrom = items.get(i).getFromTime();
            timeDonorTo   = items.get(i).getToTime();
            holder.time.setText("From   "+items.get(i).getFromTime()+"  To  "+items.get(i).getToTime());
        }else if (chickDay == 1 && chickTime == 0){
            holder.time.setText(items.get(i).getAvailableTime());
            String days = items.get(i).getFri()+"-";
            days+=items.get(i).getMon()+"-";
            days+=items.get(i).getSat()+"-";
            days+=items.get(i).getSun()+"-";
            days+=items.get(i).getThu()+"-";
            days+=items.get(i).getWed()+"-";
            days+=items.get(i).getTue()+"-";
            holder.days.setText(days);
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                SearchPage.checkPermission(mcontext);
                Calendar now = Calendar.getInstance();
                if(now.get(Calendar.AM_PM) == Calendar.AM){
                    // AM
                    timeNow = ""+now.get(Calendar.HOUR)+":"+now.get(Calendar.MINUTE)+"Am";
                }else{
                    // PM
                    timeNow = ""+now.get(Calendar.HOUR)+":"+now.get(Calendar.MINUTE)+"Pm";
                }
                Toast.makeText(mcontext, timeNow +" "+timeDonorFrom, Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    if (timeNow==timeDonorFrom) {
                        call(items.get(i).getPhoneNumber());
                    }
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
