package com.rizieq.expandablesampleretrofit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rizieq.expandablesampleretrofit.modelsecond.AllData;
import com.rizieq.expandablesampleretrofit.modelsecond.ChildLinkItem;
import com.rizieq.expandablesampleretrofit.modelsecond.ServeItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterSecond extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Object> dataList = null;


    public AdapterSecond(Context context, ArrayList<Object> dataList) {
        this.context = context;
        this.dataList = dataList;
        /*this.childLinkItems = childLinkItems;*/
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == 1) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout, viewGroup, false);

            View view1 = v;
            Log.d("View_1", String.valueOf(view1));

            return new ParentViewHolder(v);

        } else {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_layout, viewGroup, false);

            View view2 = v;
            Log.d("View_2", String.valueOf(view2));
            return new ChildViewHolder(v);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        final View parent = viewHolder.itemView;
        Log.d("FINAL_VIEW_PARENT ", String.valueOf(parent));

        String tampungHolder = String.valueOf(viewHolder instanceof ParentViewHolder);
        Log.d("TAMPUNG_VIEW_HOLDER ",tampungHolder);

        if (viewHolder instanceof ParentViewHolder) {

            ((TextView) parent.findViewById(R.id.tvMovieCategory)).setText(((ServeItem) dataList.get(i)).getTitle().toString());

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<ChildLinkItem> childLinkItems = ((ServeItem) dataList.get(i)).getChildLink();

                    String dataTitle = String.valueOf(childLinkItems.size());
                    Log.d("DATA_CHILD ",dataTitle);

                    String active = String.valueOf(parent.isActivated());
                    String position = String.valueOf(i);
                    Log.d("LOG_PARENT ",active + " POSITION_ONBIND "+position);



                    if (parent.isActivated()) {
                        ((ImageView) parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.ic_arrow_down_navigate);
                        removeFrom(i, childLinkItems.size());


                        String remove = "Remove From";

                        Log.d("REMOVE_FROM ",remove);
                    } else {
                        ((ImageView) parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.ic_arrow_drop_up_navigate);
                        addInfrontOf(i, childLinkItems);
                    }
                    parent.setActivated(!parent.isActivated());

                    String setActived = String.valueOf(parent.isActivated());

                    Log.d("SET_ACTIVED ",setActived + " ACTIVE " + active + " POSTITION " + position);

                    notifyDataSetChanged();

                }
            });
        } else {
            ((TextView) parent.findViewById(R.id.tvMovieName)).setText(((ChildLinkItem) dataList.get(i)).getTitle());
            Glide.with(context)
                    .load(((ChildLinkItem)dataList.get(i)).getAvatar())
                    .into((ImageView)parent.findViewById(R.id.child_image));


            parent.findViewById(R.id.tvMovieName).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,DetailActivity.class));
                }
            });

        }

    }

    private void addInfrontOf(int position, List<ChildLinkItem> childLinkItems) {
        for (int i = 0; i < childLinkItems.size(); i++) {

            String title = childLinkItems.get(i).getTitle();
            Log.d("LOG_TITLE ", title);

            /*dataList.add(position+i+1,new ChildLinkItem(childLinkItems.get(i).getAvatar(),childLinkItems.get(i).getTitle(),childLinkItems.get(i).getLinkId(),childLinkItems.get(i).getAccountId(),childLinkItems.get(i).getGroupLinkId(),childLinkItems.get(i).getStatus()));*/
            dataList.add(position+i+1,childLinkItems.get(i));
            /*dataList.add(position + i + 1, "");*/
        }

        String hasil = "HASIL DEBUG";
        Log.d("DEBUG_RESPONSE ", hasil);

        Log.d("SIZE_ADDINFRONTOF ", String.valueOf(childLinkItems.size()));

        /*dataList.add(position+i+1,childLinkItems.get(i));*/
        /*dataList.add(position+i+1,new ChildLinkItem(childLinkItems.get(i).getAvatar(),childLinkItems.get(i).getTitle(),childLinkItems.get(i).getLinkId(),childLinkItems.get(i).getAccountId(),childLinkItems.get(i).getGroupLinkId(),childLinkItems.get(i).getStatus()));*/


        String pposisi = String.valueOf(position);
        Log.d("POSITION ", pposisi);
    }

    private void removeFrom(int position, int size) {
        for (int i = 0; i < size; i++)
            dataList.remove(position + 1);
    }

    @Override
    public int getItemCount() {
        if (dataList != null)
            return dataList.size();
        else return 0;

    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position)instanceof ServeItem)return 1;
        else return 0;
    }
}
