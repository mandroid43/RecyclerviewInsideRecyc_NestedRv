package com.manapps.mandroid.recyclerviewinsiderecyc_nestedrv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChildRvItemAdapter extends RecyclerView.Adapter<ChildRvItemAdapter.ChildItemViewHolder> {

    class ChildItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemLabel;

        public ChildItemViewHolder(View itemView) {
            super(itemView);
            itemLabel = (TextView) itemView.findViewById(R.id.item_label);
        }
    }

    private Context context;
    private List<ChildItemModel> childItemList;

    public ChildRvItemAdapter(Context context, List<ChildItemModel> childItemList) {
        this.context = context;
        this.childItemList = childItemList;
    }

    @Override
    public ChildItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_layout, parent, false);
        return new ChildItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildItemViewHolder holder, int position) {
        holder.itemLabel.setText(childItemList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, childItemList.get(position).getTitle()+ ": Clicked!!" , Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return childItemList.size();
    }


}

