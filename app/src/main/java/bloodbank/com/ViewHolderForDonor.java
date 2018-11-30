package bloodbank.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolderForDonor extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView title,tv_desc;
    ItemClickListener itemClickListener ;
    public ViewHolderForDonor(@NonNull View itemView) {
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
