package com.Sharpest.sharpestapp.Home.uiFragment.adaptor_fragment_myprder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.Home.uiFragment.model.serviceMyorder.DataServiceMyorderfrgmentRequestFinal;
import com.Sharpest.sharpestapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyService_MyOrder_viewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<DataServiceMyorderfrgmentRequestFinal> List_Item;
    private Context context;
    String deirection;
    Activity activity;



    public MyService_MyOrder_viewHolder(List<DataServiceMyorderfrgmentRequestFinal> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_listmoderfragment, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<DataServiceMyorderfrgmentRequestFinal> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        if (deirection.equals("hor")){
            menuItemHolder.linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        }else{
            menuItemHolder.linearLayout.setOrientation(LinearLayout.VERTICAL);
        }
        menuItemHolder.name_categroy.setText(List_Item.get(position).getServiceRequestTypeNameAr());

        menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);


        menuItemHolder.getid.setText(""+List_Item.get(position).getId());

        menuItemHolder.details.setText(""+List_Item.get(position).getRequestHeaderStatusNameAr());

        try {
            String dateNum=List_Item.get(position).getRequestDate().substring(0,10);
            menuItemHolder.date.setText("تاريخ الطلب :  "+dateNum);
        }catch (Exception e){

        }


        menuItemHolder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context, Details_ProductActivity.class);
//                intent.putExtra("id_product",menuItemHolder.getid.getText().toString().trim());
//                activity.startActivity(intent);
//                Toast.makeText(context, ""+List_Item.get(position).getId(), Toast.LENGTH_SHORT).show();
            }
        });

        menuItemHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context, Details_ProductActivity.class);
//                intent.putExtra("id_product",menuItemHolder.getid.getText().toString().trim());
//                activity.startActivity(intent);
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
        TextView name_categroy, details,getid , date,text_couponValue;

        LinearLayout linearLayout;

        public MenuItemViewHolder(View view) {
            super(view);
//            cardView = (LinearLayout) view.findViewById(R.id.card_listdelvery);

            name_categroy = (TextView) view.findViewById(R.id.text_name_product_category);
            details=(TextView) view.findViewById(R.id.text_detailes_product_category);

            date=(TextView) view.findViewById(R.id.text_date_product_category);
            text_couponValue=(TextView) view.findViewById(R.id.text_couponValue);
            text_couponValue.setVisibility(View.GONE);

            getid=(TextView) view.findViewById(R.id.text_id);

            imageView=(ImageView) view.findViewById(R.id.image_product_category);

            linearLayout=(LinearLayout) view.findViewById(R.id.linear_produect_category);

        }
    }
}

