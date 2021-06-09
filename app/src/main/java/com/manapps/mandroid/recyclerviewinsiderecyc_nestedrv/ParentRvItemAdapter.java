package com.manapps.mandroid.recyclerviewinsiderecyc_nestedrv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentRvItemAdapter extends RecyclerView.Adapter<ParentRvItemAdapter.ParentItemViewHolder> {

    RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

    class ParentItemViewHolder extends RecyclerView.ViewHolder {
        private TextView sectionLabel, showAllButton;
        private RecyclerView itemRecyclerView;

        public ParentItemViewHolder(View itemView) {
            super(itemView);
            sectionLabel = (TextView) itemView.findViewById(R.id.section_label);
            showAllButton = (TextView) itemView.findViewById(R.id.showAllBtn);
            itemRecyclerView = (RecyclerView) itemView.findViewById(R.id.item_recycler_view);
        }
    }

    private Context context;
    private List<ParentItemModel> parentItemList;

    public ParentRvItemAdapter(Context context, List<ParentItemModel> parentItemList) {
        this.context = context;
        this.parentItemList = parentItemList;
    }

    @Override
    public ParentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item_layout, parent, false);
        return new ParentItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParentItemViewHolder holder, int position) {
        final ParentItemModel parentItemModel = parentItemList.get(position);
        holder.sectionLabel.setText(parentItemModel.getSection());

        //setting child recyclerview attributes
        holder.itemRecyclerView.setHasFixedSize(true);
        holder.itemRecyclerView.setNestedScrollingEnabled(false);

        /* you can make this child Recyclerview horizontal,vertical,grid acc to your needs by seetting appropriate layoutManager */

        // use this for setting vertical recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        // use this for setting horizontal recyclerview
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        // use this for setting grid recyclerview
       // GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);


        holder.itemRecyclerView.setLayoutManager(linearLayoutManager);
        //setting recycledViewPool to optimize the performance of Nested Recyclerview
        holder.itemRecyclerView.setRecycledViewPool(recycledViewPool);

        ChildRvItemAdapter adapter = new ChildRvItemAdapter(context, parentItemModel.getChildItemsList());
        holder.itemRecyclerView.setAdapter(adapter);

        //showAllButton clicked
        holder.showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, parentItemModel.getSection() + ": Show All clicked!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }


}

