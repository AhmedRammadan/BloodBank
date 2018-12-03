package bloodbank.com;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Adaper_Recy extends RecyclerView.Adapter<ViewHolder> {

    Context mcontext;
    ArrayList<Donor> items ;
    String  timeDonorFrom , timeDonorTo, phoneNumber;
    String timeNowString ,tfrom , tto;
    int timeNow,nowh , nowm ,Tfrom,Tto;
    boolean callIs;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
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
                callIs = false;
                SearchPage.checkPermission(mcontext);
                if (ContextCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    String nowH = new SimpleDateFormat("H").format(Calendar.getInstance().getTime());
                    String nowM = new SimpleDateFormat("m").format(Calendar.getInstance().getTime());
                    String AMPM = new SimpleDateFormat("a").format(Calendar.getInstance().getTime());
                    try {
                        nowh = Integer.parseInt(nowH);
                        nowm = Integer.parseInt(nowM);
                        Tfrom = Integer.parseInt(items.get(i).getFrom());
                        Tto = Integer.parseInt(items.get(i).getTo());
                        tfrom =items.get(i).getFromTime();
                        tto =items.get(i).getToTime();
                    }catch (Exception e){
                    }
                    if (nowh==00){
                        nowh = 12;
                        timeNowString = nowh+""+nowm;
                    }else {
                        timeNowString = nowh+""+nowm;
                    }
                    try {
                        timeNow =Integer.parseInt(timeNowString);
                    }catch (Exception e){
                    }
                    if (Tfrom<Tto) {
                        for (int timeCall = Tfrom; timeCall <= Tto; timeCall++) {
                            if (timeCall == timeNow) {
                                callIs = true;
                                break;
                            }
                        }
                    }else if (Tfrom>Tto){
                        for (int timeCall = Tto; timeCall >= Tfrom; timeCall++) {
                            if (timeCall == timeNow) {
                                callIs = true;
                                break;
                            }
                        }
                    }
                    Log.i( "onItemClick##: ",Tfrom+""+ Tto);
                    Log.i( "onItemClick##: ",""+timeNow);
                    call(phoneNumber,callIs);
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
    public void call(String PhoneNumber , boolean callIs) {
        if (callIs) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + PhoneNumber));
            mcontext.startActivity(callIntent);
        }else {
            AlertDilog();
        }
    }
    public void AlertDilog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mcontext);
        alertDialog.setMessage("Sorry donor is not available now\nYou can communicate with him from "+tfrom+" hour to "+tto+" hour");
        alertDialog.show();


    }
}
