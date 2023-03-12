package com.Sharpest.sharpestapp.Home.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.Home.model.DataOfers.DataOfers_Fainal;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.Details_Ofers_ProductActivity;
import com.Sharpest.sharpestapp.UI.Details_ofers_CourssesActivity;
import com.Sharpest.sharpestapp.UI.service_Responce.DesginAndPrograming;
import com.Sharpest.sharpestapp.UI.service_Responce.Photo3d;
import com.Sharpest.sharpestapp.UI.service_Responce.Seana;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Offers_Recycal_ViewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<DataOfers_Fainal> List_Item;
    private Context context;
    String deirection;
    Activity activity;



    public Offers_Recycal_ViewHolder(List<DataOfers_Fainal> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_offers, viewGroup, false);
        return new MenuItemViewHolder(menu1);
    }

    public void filterList(ArrayList<DataOfers_Fainal> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        try {
            if (  List_Item.get(position).getOfferValue()!=null ) {
                menuItemHolder.oferDecound.setText("" + List_Item.get(position).getOfferValue());
            }else{
                menuItemHolder.oferDecound.setText(" ");
            }
        }catch (Exception e){}


        String s = List_Item.get(position).getOfferExpireDate().substring(0,10);
        menuItemHolder.dateexpire.setText(s+" ينتهي العرض في ");

        if (List_Item.get(position).getItem() != null){
            menuItemHolder.name_corsess.setText(""+List_Item.get(position).getItem().getItemNameAr());
        }
        if (List_Item.get(position).getCourse() != null){
            menuItemHolder.name_corsess.setText(""+List_Item.get(position).getCourse().getCourseNameAr());
        }
        if (List_Item.get(position).getServiceRequestType() != null){
            menuItemHolder.name_corsess.setText(""+List_Item.get(position).getServiceRequestType().getServiceRequestTypeNameAr());
        }


        if (List_Item.get(position).getOfferActiveFlag()== 0) {
            menuItemHolder.liner_finsh_offers.setVisibility(View.VISIBLE);
        }
        if (List_Item.get(position).getOfferActiveFlag()!= 0) {
            menuItemHolder.liner_finsh_offers.setVisibility(View.GONE);
        }

        try {
            if (
                    List_Item.get(position).getOfferImagePath()==null
                            ||List_Item.get(position).getOfferImagePath().equals(null)
                            || List_Item.get(position).getOfferImagePath().isEmpty()
                            || List_Item.get(position).getOfferImagePath()=="")
            {
                menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
            }else {
                Picasso.with(context)
                        .load(List_Item.get(position).getOfferImagePath())
                        .error(R.mipmap.sharpest_logo)
                        .into(menuItemHolder.imageView);
            }
        }catch (Exception e){
            menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
        }





        menuItemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (List_Item.get(position).getOfferActiveFlag()!=0) {
                    if (List_Item.get(position).getItem()!=null ){
                        Intent intent=new Intent(context, Details_Ofers_ProductActivity.class);
                        intent.putExtra("id_product",List_Item.get(position).getItem().getId().toString());
                        context.startActivity(intent);
                    }
                    else if (List_Item.get(position).getCourse()!=null ){
                        Intent intent=new Intent(context, Details_ofers_CourssesActivity.class);
                        intent.putExtra("id_product",List_Item.get(position).getCourse().getId().toString());
                        context.startActivity(intent);
                    }
                    else if (List_Item.get(position).getServiceRequestType()!=null ){
                        if ( List_Item.get(position).getServiceRequestType().getId() == 1 ){
                            Log.e("???ServiceRequestType>>", ""+List_Item.get(position).getServiceRequestType().getId());
                        Intent intent=new Intent(context, Seana.class);
                        intent.putExtra("id_product",List_Item.get(position).getServiceRequestType().getId()+"");
                        context.startActivity(intent);
                        }

                        if ( List_Item.get(position).getServiceRequestType().getId() == 2 ){
                            Log.e("???ServiceRequestType>>", ""+List_Item.get(position).getServiceRequestType().getId());
                            Intent intent=new Intent(context, DesginAndPrograming.class);
                            intent.putExtra("id_product",List_Item.get(position).getServiceRequestType().getId()+"");
                            context.startActivity(intent);
                        }

                        if ( List_Item.get(position).getServiceRequestType().getId() == 3 ){
                            Log.e("???ServiceRequestType>>", ""+List_Item.get(position).getServiceRequestType().getId());
                            Intent intent=new Intent(context, Photo3d.class);
                            intent.putExtra("id_product",List_Item.get(position).getServiceRequestType().getId()+"");
                            context.startActivity(intent);
                        }
                    }else{
                        Log.e("getOfferActiveFlag>>",List_Item.get(position).getOfferActiveFlag().toString());
//                        Log.e("ServiceRequestHeaderList>>",List_Item.get(position).getServiceRequestHeaderList().toString());
                        Log.e("getServiceRequestType>>",List_Item.get(position).getServiceRequestType().toString());
                        Toast.makeText(context, "cdsa", Toast.LENGTH_SHORT).show();
                    }
                }
                if (List_Item.get(position).getOfferActiveFlag()==0) {
                    Toast.makeText(context, "لقد انتهي العرض", Toast.LENGTH_LONG).show();
                }

            }
        });

        previousPosition = position;


    }
    @Override
    public int getItemCount() {
        return (null != List_Item ? List_Item.size() : 0);
    }

    protected class MenuItemViewHolder extends RecyclerView.ViewHolder {
        //        LinearLayout cardView;
        ImageView imageView;
        TextView name_corsess,onlineor, oferDecound, dateexpire;
        CardView cardView;
        LinearLayout liner_finsh_offers;

        public MenuItemViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_courzses);

            imageView=(ImageView) view.findViewById(R.id.image_coursses);
            name_corsess = (TextView) view.findViewById(R.id.text_name_coursses);
            dateexpire = (TextView) view.findViewById(R.id.text_date_coursses);
            onlineor = (TextView) view.findViewById(R.id.text_onlineor_coursses);
            oferDecound = (TextView) view.findViewById(R.id.oferDecound);
            liner_finsh_offers = (LinearLayout) view.findViewById(R.id.licenser);

        }
    }




}
