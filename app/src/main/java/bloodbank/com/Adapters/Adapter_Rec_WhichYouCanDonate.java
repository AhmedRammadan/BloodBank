package bloodbank.com.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bloodbank.com.R;
import bloodbank.com.ViewsHolder.ViewHolder_WhichYouCanDonate;
import bloodbank.com.items.card_WhichYouCanDonate;

public class Adapter_Rec_WhichYouCanDonate extends RecyclerView.Adapter<ViewHolder_WhichYouCanDonate> {
    Context mcontext;
    ArrayList<card_WhichYouCanDonate> card_WhichYouCanDonate;

    public Adapter_Rec_WhichYouCanDonate(Context mcontext, ArrayList<card_WhichYouCanDonate> card_WhichYouCanDonate) {
        this.mcontext = mcontext;
        this.card_WhichYouCanDonate = card_WhichYouCanDonate;
    }

    @NonNull
    @Override
    public ViewHolder_WhichYouCanDonate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_which_you_can_donate,null);
        return new ViewHolder_WhichYouCanDonate(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_WhichYouCanDonate viewHolderWhichYouCanDonate, int i) {
        viewHolderWhichYouCanDonate.tv_to.setText(card_WhichYouCanDonate.get(i).getTo());
        viewHolderWhichYouCanDonate.tv_from.setText(card_WhichYouCanDonate.get(i).getFrom());
        viewHolderWhichYouCanDonate.imageView.setImageResource(card_WhichYouCanDonate.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return card_WhichYouCanDonate.size();
    }
}
