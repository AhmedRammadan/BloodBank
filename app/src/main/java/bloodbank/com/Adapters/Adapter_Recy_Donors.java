package bloodbank.com.Adapters;

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

import bloodbank.com.ViewsHolder.ViewHolder_Donors;
import bloodbank.com.ViewsHolder.ItemClickListener;
import bloodbank.com.items.SignUpDonor;
import bloodbank.com.R;
import bloodbank.com.pages.SearchPage;

public class Adapter_Recy_Donors extends RecyclerView.Adapter<ViewHolder_Donors> {

    Context mcontext;
    ArrayList<SignUpDonor> items ;
    String  timeDonorFrom , timeDonorTo, phoneNumber;
    public Adapter_Recy_Donors(Context mcontext, ArrayList<SignUpDonor> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder_Donors onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.item_search,null);
        return new ViewHolder_Donors(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder_Donors holder, final int i) {
        holder.name.setText(items.get(i).getName());
        phoneNumber = items.get(i).getPhoneNumber();
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
                if (ContextCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    call(phoneNumber);
                }else {
                    SearchPage.checkPermission(mcontext);
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
        callIntent.setData(Uri.parse("tel:" + PhoneNumber));
        mcontext.startActivity(callIntent);

    }
}
