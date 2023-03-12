package com.Sharpest.sharpestapp.Home.uiFragment.adaptor_fragment_myprder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.Home.uiFragment.model.corceMyorder.DataCuorceFrgmentRequestFinal;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.Details_CourssesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Coursses_Myorder_ViewHolder
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<DataCuorceFrgmentRequestFinal> List_Item;
    private Context context;
    String deirection;
    Activity activity;



    public Coursses_Myorder_ViewHolder(List<DataCuorceFrgmentRequestFinal> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_coursess_myorder, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<DataCuorceFrgmentRequestFinal> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        menuItemHolder.name_corsess.setText(List_Item.get(position).getCourseNameAr());
        menuItemHolder.getid.setText(""+List_Item.get(position).getId());

        if (List_Item.get(position).getCourseAvailableOnline().equals("1")) {
            menuItemHolder.date.setText("online");
        }
        if (!List_Item.get(position).getCourseAvailableOnline().equals("1")) {
            menuItemHolder.date.setText("offline");
        }
        menuItemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Details_CourssesActivity.class);
                intent.putExtra("id_product", menuItemHolder.getid.getText().toString().trim());
                intent.putExtra("test", "cource_myorder");
                context.startActivity(intent);
            }
        });

        try {
            if (
                    List_Item.get(position).getImageBanarPath()==null
                            ||List_Item.get(position).getImageBanarPath().equals(null)
//                            || List_Item.get(position).getImageBanarPath().isEmpty()
                            || List_Item.get(position).getImageBanarPath()=="")
            {
                menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
            }else {
                Picasso.with(context)
                        .load(String.valueOf(List_Item.get(position).getImageBanarPath()))
                        .error(R.mipmap.sharpest_logo)
                        .into(menuItemHolder.imageView);
            }
        }catch (Exception e){
            menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
        }


        if (position > previousPosition) { //scrolling DOWN
            //AnimationUtil.animate(menuItemHolder, true);

        } else { // scrolling UP

            // AnimationUtil.animate(menuItemHolder, false);
        }
        previousPosition = position;


    }
    @Override
    public int getItemCount() {
        return (null != List_Item ? List_Item.size() : 0);
    }

    protected class MenuItemViewHolder extends RecyclerView.ViewHolder {
        //        LinearLayout cardView;
        ImageView imageView;
        TextView name_corsess,date,getid;
        CardView cardView;

        public MenuItemViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_courzses);

            imageView=(ImageView) view.findViewById(R.id.image_coursses);
            name_corsess = (TextView) view.findViewById(R.id.text_name_coursses);
            date = (TextView) view.findViewById(R.id.text_date_coursses);

            getid = (TextView) view.findViewById(R.id.text_getid_coursses);

        }
    }
}
