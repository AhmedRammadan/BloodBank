package bloodbank.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name , data , days;
    ImageView call;
    ItemClickListener itemClickListener;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        data = itemView.findViewById(R.id.data);
        days = itemView.findViewById(R.id.days);
        call = itemView.findViewById(R.id.call);
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