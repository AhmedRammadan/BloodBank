package bloodbank.com;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class Adapter_Rec_ForDonor extends RecyclerView.Adapter<ViewHolderForDonor>  {
    Context mcontext;
    ArrayList<item_forDonor> items;

    public Adapter_Rec_ForDonor(Context mcontext, ArrayList<item_forDonor> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderForDonor onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_rec_for_donor,null);
        return new ViewHolderForDonor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForDonor viewHolderForDonor, final int i) {
        viewHolderForDonor.image_item.setImageResource(items.get(i).getImage());
        viewHolderForDonor.title.setText(items.get(i).getTitle());
        viewHolderForDonor.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mcontext,post.class);
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
