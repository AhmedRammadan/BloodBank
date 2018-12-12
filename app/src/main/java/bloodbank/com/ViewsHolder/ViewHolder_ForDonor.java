package bloodbank.com.ViewsHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bloodbank.com.R;

public class ViewHolder_ForDonor extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView title,tv_desc;
    public ItemClickListener itemClickListener ;
    public ViewHolder_ForDonor(@NonNull View itemView) {
        super(itemView);
        tv_desc = itemView.findViewById(R.id.tv_desc);
        title = itemView.findViewById(R.id.tv_title);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }
}
