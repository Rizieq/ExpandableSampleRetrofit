package com.rizieq.expandablesampleretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizieq.expandablesampleretrofit.modelsecond.ChildLinkItem;
import com.rizieq.expandablesampleretrofit.modelsecond.ServeItem;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {

    private Context context;
    private List<ChildLinkItem> childLinkItems;

    public ChildAdapter(Context context, List<ChildLinkItem> childLinkItems) {
        this.context = context;
        this.childLinkItems = childLinkItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.child_layout,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tvTitle.setText(childLinkItems.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return childLinkItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvMovieName);

        }
    }
}
