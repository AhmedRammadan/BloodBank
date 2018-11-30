package bloodbank.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name  , days, time;
    ImageView call;
    ItemClickListener itemClickListener;
    public ViewHolder(@NonNull View itemView) {
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