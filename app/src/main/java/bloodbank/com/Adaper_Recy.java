package bloodbank.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adaper_Recy extends RecyclerView.Adapter<ViewHolder> {

    Context mcontext;
    ArrayList<Item_Recy> items ;

    public Adaper_Recy(Context mcontext, ArrayList<Item_Recy> items) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.name.setText(items.get(i).getName());
        holder.data.setText(items.get(i).getDate());
        holder.number.setText(items.get(i).getNumber());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
