package bloodbank.com.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import bloodbank.com.R;
import bloodbank.com.ViewsHolder.ItemClickListener;
import bloodbank.com.ViewsHolder.ViewHolder_ForDonor;
import bloodbank.com.items.card__forDonor;
import bloodbank.com.pages.forDonor;

public class Adapter_Rec_ForDonor extends RecyclerView.Adapter<ViewHolder_ForDonor>  {
    Context mcontext;
    ArrayList<card__forDonor> items;

    public Adapter_Rec_ForDonor(Context mcontext, ArrayList<card__forDonor> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder_ForDonor onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_rec_for_donor,null);
        return new ViewHolder_ForDonor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_ForDonor viewHolderForDonor, final int i) {
        viewHolderForDonor.tv_desc.setText(items.get(i).getDescription());
        viewHolderForDonor.title.setText(items.get(i).getTitle());
        viewHolderForDonor.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mcontext, forDonor.class);
                intent.putExtra("title",items.get(i).getTitle());
                intent.putExtra("description",items.get(i).getDescription());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
