package bloodbank.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView name , data , number;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        data = itemView.findViewById(R.id.data);
        number = itemView.findViewById(R.id.number);
    }
}
