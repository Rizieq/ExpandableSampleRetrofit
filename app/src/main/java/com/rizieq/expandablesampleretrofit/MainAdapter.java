//package com.rizieq.expandablesampleretrofit;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//
//import com.rizieq.expandablesampleretrofit.modelsecond.ChildLinkItem;
//import com.rizieq.expandablesampleretrofit.modelsecond.ServeItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    ArrayList<Object> dataList = null;
//    private Context context;
//    List<ChildLinkItem> childLinkItems;
//    List<ServeItem> serveItems;
//
//
//    public MainAdapter(ArrayList<Object> dataList, Context context) {
//        this.dataList = dataList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // inisialisasi layout parent dan child
//
//        if (viewType == 1){
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false);
//            return new ParentViewHolder(v);
//
//        } else {
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_layout,parent,false);
//            return new ChildViewHolder(v);
//
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
//        final View parent = holder.itemView;
//
//        // UNTUK GET DATA DARI MODEL DAN DI SET DI PARENT DAN CHILD RECYCLERVIEW
//
//        if (holder instanceof  ParentViewHolder){
//            ((TextView) parent.findViewById(R.id.tvMovieCategory)).setText(((ServeItem)dataList.get(position)).getTitle());
//
//            parent.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    List<Object> movies = ((ServeItem) dataList.get(position)).getChildLink();
//                    if (parent.isActivated()){
//                        ((ImageView)parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.ic_arrow_down_navigate);
//                        removeFrom(position,movies.size());
//
//                    } else {
//                        ((ImageView) parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.ic_arrow_drop_up_navigate);
//                        addInFrontOf(position, childLinkItems);
//
//                    }
//                    parent.setActivated(!parent.isActivated());
//                    notifyDataSetChanged();
//                }
//            });
//        } else {
//            ((TextView) parent.findViewById(R.id.tvMovieName)).setText(((ChildLinkItem)dataList.get(position)).getTitle());
//
//        }
//    }
//
//    private void addInFrontOf(int position, List<ChildLinkItem> movies) {
//        for (int i = 0; i < movies.size(); i++)
//            dataList.add(position+i+1,movies.get(i));
//    }
//
//    private void removeFrom(int position, int size) {
//        for (int i = 0; i < size; i++)
//            dataList.remove(position+1);
//    }
//
//    @Override
//    public int getItemCount() {
//        if (dataList != null)
//            return dataList.size();
//        else return 0;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (dataList.get(position) instanceof ServeItem)return 1;
//        else return 0;
//    }
//}