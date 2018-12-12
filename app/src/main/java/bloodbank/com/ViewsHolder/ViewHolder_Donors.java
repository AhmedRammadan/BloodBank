package bloodbank.com.ViewsHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bloodbank.com.R;

public class ViewHolder_Donors extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name;
    public TextView days;
    public TextView time;
    ImageView call;
    ItemClickListener itemClickListener;
    public ViewHolder_Donors(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        call = itemView.findViewById(R.id.call);
        days = itemView.findViewById(R.id.days);
        time = itemView.findViewById(R.id.time);
        call.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
}