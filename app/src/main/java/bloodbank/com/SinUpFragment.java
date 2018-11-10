package bloodbank.com;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import net.rimoto.intlphoneinput.IntlPhoneInput;

public class SinUpFragment extends Fragment {
    View view;
    Button btn_sinUp, btn_24h;
    TextView tv_24h, tv_time_to,tv_time_to2, tv_time_from,tv_time_from2;
    TextView sat, mon, tue, wed, thu,fri,sun;
    int Hour, Minute, index_btn = 1,index_time = 1;
    int index_colorTV1 = 1,index_colorTV2 = 1,index_colorTV3 = 1,index_colorTV4 = 1,index_colorTV5 = 1,index_colorTV6 = 1,index_colorTV7 = 1;
    String AmPm = "Am";
    LinearLayout linear_time ;
    String myInternationalNumber;
    IntlPhoneInput phoneInputView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sinup, container, false);
        //get Phone Number
        phoneInputView =view.findViewById(R.id.my_phone_input);
        myInternationalNumber = phoneInputView.getText();
        findViewById();
        btn_24();
        getTime();
        changeColorTV();

        return view;
    }
    public void findViewById(){
        //SimUp
        btn_sinUp = view.findViewById(R.id.btn_sinUp);
        //click for get Time
        btn_24h = view.findViewById(R.id.btn_24h);
        tv_24h = view.findViewById(R.id.tv__24h);
        //get Time
        tv_time_to = view.findViewById(R.id.time_to);
        tv_time_to2 = view.findViewById(R.id.time_to2);
        tv_time_from = view.findViewById(R.id.time_from);
        tv_time_from2 = view.findViewById(R.id.time_from2);
        linear_time = view.findViewById(R.id.linear_time);

        //for Days
        sat = view.findViewById(R.id.sat);
        mon = view.findViewById(R.id.mon);
        tue = view.findViewById(R.id.tue);
        wed = view.findViewById(R.id.wed);
        thu = view.findViewById(R.id.thu);
        fri = view.findViewById(R.id.fri);
        sun = view.findViewById(R.id.sun);

    }
    public void getTimePicker() {
        final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
        final View dialogShow = getLayoutInflater().inflate(R.layout.time_picker, null);
        builder.setView(dialogShow);

        builder.show();

        TimePicker timePicker = dialogShow.findViewById(R.id.timePicker);
         Button btn_ok = dialogShow.findViewById(R.id.btn_ok);
        Button btn_cancel = dialogShow.findViewById(R.id.btn_cancel);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay >= 12) {
                    AmPm = "Pm";
                } else if (hourOfDay < 12) {
                    AmPm = "Am";
                }
                Hour = hourOfDay;
                Minute = minute;
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_time ==1){
                    tv_time_to.setText(Hour + ":" + Minute + "" + AmPm);
                }else {
                    tv_time_from.setText(Hour + ":" + Minute + "" + AmPm);
                }
                builder.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }
    public void changeColorTV() {
        final int color = getResources().getColor(R.color.colorText);
        final int color1 = getResources().getColor(R.color.colorText1);
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV1 == 1) {
                    sat.setTextColor(color);
                    index_colorTV1++;
                } else if (index_colorTV1 == 2) {
                    sat.setTextColor(color1);
                    index_colorTV1--;
                }
            }
        });
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV2 == 1) {
                    mon.setTextColor(color);
                    index_colorTV2++;
                } else if (index_colorTV2 == 2) {
                    mon.setTextColor(color1);
                    index_colorTV2--;
                }
            }
        });
        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV3 == 1) {
                    tue.setTextColor(color);
                    index_colorTV3++;
                } else if (index_colorTV3 == 2) {
                    tue.setTextColor(color1);
                    index_colorTV3--;
                }
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV4 == 1) {
                    wed.setTextColor(color);
                    index_colorTV4++;
                } else if (index_colorTV4 == 2) {
                    wed.setTextColor(color1);
                    index_colorTV4--;
                }
            }
        });
        thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV5 == 1) {
                    thu.setTextColor(color);
                    index_colorTV5++;
                } else if (index_colorTV5 == 2) {
                    thu.setTextColor(color1);
                    index_colorTV5--;
                }
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV6 == 1) {
                    fri.setTextColor(color);
                    index_colorTV6++;
                } else if (index_colorTV6 == 2) {
                    fri.setTextColor(color1);
                    index_colorTV6--;
                }
            }
        });
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_colorTV7 == 1) {
                    sun.setTextColor(color);
                    index_colorTV7++;
                } else if (index_colorTV7 == 2) {
                    sun.setTextColor(color1);
                    index_colorTV7--;
                }
            }
        });
    }
    public void btn_24() {
        final Drawable getbtn1 = getResources().getDrawable(R.drawable.btn_24h_1);
        final Drawable getbtn2 = getResources().getDrawable(R.drawable.btn_24h_2);
        tv_24h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_btn == 1) {
                    btn_24h.setBackground(getbtn2);
                    linear_time.setVisibility(View.VISIBLE);
                    index_btn++;
                } else if (index_btn == 2) {
                    btn_24h.setBackground(getbtn1);
                    linear_time.setVisibility(View.GONE);
                    index_btn--;
                }
            }
        });
        btn_24h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index_btn == 1) {
                    btn_24h.setBackground(getbtn2);
                    linear_time.setVisibility(View.VISIBLE);
                    index_btn++;
                } else if (index_btn == 2) {
                    btn_24h.setBackground(getbtn1);
                    linear_time.setVisibility(View.GONE);
                    index_btn--;
                }
            }
        });
    }
    public void getTime(){
        tv_time_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimePicker();
                index_time = 1;
            }
        });
        tv_time_to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimePicker();
                index_time = 1;
            }
        });
        tv_time_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimePicker();
                index_time = 2;
            }
        });
        tv_time_from2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimePicker();
                index_time = 2;
            }
        });
    }

}

   /* public void getTime(String title){
        // TODO Auto-generated method stub
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                if (selectedHour >= 12){
                    AmPm = "Pm";
                }else if (selectedHour < 12){
                    AmPm = "Am";
                }else {
                    AmPm = "dsd";
                }
                Hour = selectedHour ;
                Minute = selectedMinute ;
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle(title);
        mTimePicker.show();
    }*/

