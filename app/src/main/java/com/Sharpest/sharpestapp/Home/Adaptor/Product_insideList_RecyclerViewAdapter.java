package com.Sharpest.sharpestapp.Home.Adaptor;

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

import com.bumptech.glide.Glide;
import com.Sharpest.sharpestapp.Home.model.home.ItemList;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.Details_Ofers_ProductActivity;

import java.util.ArrayList;
import java.util.List;

public class Product_insideList_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<ItemList> List_Item;
    private Context context;
    String deirection;
    Activity activity;

    public Product_insideList_RecyclerViewAdapter(List<ItemList> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_home_inside_list, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<ItemList> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        try {
            if (List_Item.get(position).getItemPrice() != null || !List_Item.get(position).getItemPrice().equals(null)) {
                menuItemHolder.name_categroy.setText( List_Item.get(position).getItemNameAr());
            }else{
                menuItemHolder.name_categroy.setText( List_Item.get(position).getItemNameAr());
            }
        }catch (Exception e){
            menuItemHolder.name_categroy.setText( List_Item.get(position).getItemNameAr());
        }

        try {
            if (List_Item.get(position).getItemPrice() != null || !List_Item.get(position).getItemPrice().equals(null)) {
                menuItemHolder.allProduct.setText(""+List_Item.get(position).getItemPrice());
            }else{
                menuItemHolder.allProduct.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            menuItemHolder.allProduct.setVisibility(View.VISIBLE);
        }
        menuItemHolder.idpr.setText(""+List_Item.get(position).getId());

        try {
            if (
                    List_Item.get(position).getBannarImagePath()==null
                            ||List_Item.get(position).getBannarImagePath().equals(null)
                            || List_Item.get(position).getBannarImagePath().isEmpty()
                            || List_Item.get(position).getBannarImagePath()=="")
            {
                menuItemHolder.imageProduct.setImageResource(R.mipmap.sharpest_logo);
            }else {
//                menuItemHolder.imageProduct.setImageResource(R.mipmap.sharpest_logo);
                Glide.with(context)
                        .load(List_Item.get(position).getBannarImagePath())
//                        .load(List_Item.get(position).getBannarImagePath())
                        .error(R.mipmap.sharpest_logo)
                        .into(menuItemHolder.imageProduct);
//                Picasso.with(context)
//                        .load(List_Item.get(position).getBannarImagePath())
//                        .into(menuItemHolder.imageProduct);
            }
        } catch (Exception e){
                menuItemHolder.imageProduct.setImageResource(R.mipmap.sharpest_logo);
        }


        menuItemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Details_Ofers_ProductActivity.class);
//                Intent intent=new Intent(context, Details_ProductActivity.class);
                intent.putExtra("id_product",menuItemHolder.idpr.getText());
                intent.putExtra("test", deirection);
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
        TextView name_categroy, allProduct,idpr;

        CardView cardView;
        ImageView imageProduct;
        public MenuItemViewHolder(View view) {
            super(view);


            name_categroy = (TextView) view.findViewById(R.id.text_name_partlist_Home);
            allProduct=(TextView) view.findViewById(R.id.text_all_Prodect_partlist_Home);
            idpr=(TextView) view.findViewById(R.id.text_id_Home);

            imageProduct=(ImageView) view.findViewById(R.id.image_insidelistHome);
            cardView=(CardView) view.findViewById(R.id.card_inside_listhome);
        }
    }
}
