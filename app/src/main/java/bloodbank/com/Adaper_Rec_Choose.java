package bloodbank.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adaper_Rec_Choose extends RecyclerView.Adapter<ViewHolderChoose> {
    Context mcontext;
    ArrayList<choose> choose;

    public Adaper_Rec_Choose(Context mcontext, ArrayList<bloodbank.com.choose> choose) {
        this.mcontext = mcontext;
        this.choose = choose;
    }

    @NonNull
    @Override
    public ViewHolderChoose onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_choose,null);
        return new ViewHolderChoose(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChoose viewHolderChoose, int i) {
        viewHolderChoose.tv_to.setText(choose.get(i).getTo());
        viewHolderChoose.tv_from.setText(choose.get(i).getFrom());
        viewHolderChoose.imageView.setImageResource(choose.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return choose.size();
    }
}
