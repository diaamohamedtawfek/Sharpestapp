package com.Sharpest.sharpestapp.adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.Details_ProductActivity;
import com.Sharpest.sharpestapp.model.Data_ProdectCategory_final;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Produect_Category_viewHolder   extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<Data_ProdectCategory_final> List_Item;
    private Context context;
    String deirection;
    Activity activity;



    public Produect_Category_viewHolder(List<Data_ProdectCategory_final> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_produect_fromsection_1, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<Data_ProdectCategory_final> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        if (deirection.equals("hor")){
            menuItemHolder.linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        }else{
            menuItemHolder.linearLayout.setOrientation(LinearLayout.VERTICAL);
        }
        menuItemHolder.name_categroy.setText(List_Item.get(position).getItemNameAr());

        try {
            if (
                    List_Item.get(position).getBannarImagePath()==null
                            ||List_Item.get(position).getBannarImagePath().equals(null)
                            || List_Item.get(position).getBannarImagePath().isEmpty()
                            || List_Item.get(position).getBannarImagePath()=="")
            {
                menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
            }else {
                Picasso.with(context)
                        .load(List_Item.get(position).getBannarImagePath())
                        .error(R.mipmap.sharpest_logo)
                        .into(menuItemHolder.imageView);
            }
        }catch (Exception e){
            menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
        }

        menuItemHolder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Details_ProductActivity.class);
                intent.putExtra("id_product",List_Item.get(position).getId());
                activity.startActivity(intent);
//                Toast.makeText(context, ""+List_Item.get(position).getId(), Toast.LENGTH_SHORT).show();
            }
        });


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
        TextView name_categroy, details;

        LinearLayout linearLayout;

        public MenuItemViewHolder(View view) {
            super(view);
//            cardView = (LinearLayout) view.findViewById(R.id.card_listdelvery);

            name_categroy = (TextView) view.findViewById(R.id.text_name_product_category);
            details=(TextView) view.findViewById(R.id.text_detailes_product_category);

            imageView=(ImageView) view.findViewById(R.id.image_product_category);

            linearLayout=(LinearLayout) view.findViewById(R.id.linear_produect_category);

        }
    }
}
