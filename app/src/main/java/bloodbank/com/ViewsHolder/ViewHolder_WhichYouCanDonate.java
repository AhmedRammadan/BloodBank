package bloodbank.com.ViewsHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bloodbank.com.R;

public class ViewHolder_WhichYouCanDonate extends RecyclerView.ViewHolder {
    public TextView tv_to;
    public TextView tv_from;
    public ImageView imageView;
    public ViewHolder_WhichYouCanDonate(@NonNull View itemView) {
        super(itemView);
        tv_from = itemView.findViewById(R.id.tv_from);
        tv_to = itemView.findViewById(R.id.tv_to);
        imageView = itemView.findViewById(R.id.img_bloodType);
    }
}
