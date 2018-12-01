package bloodbank.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolderChoose extends RecyclerView.ViewHolder {
    TextView tv_to , tv_from;
    ImageView imageView;
    public ViewHolderChoose(@NonNull View itemView) {
        super(itemView);
        tv_from = itemView.findViewById(R.id.tv_from);
        tv_to = itemView.findViewById(R.id.tv_to);
        imageView = itemView.findViewById(R.id.img_bloodType);
    }
}
