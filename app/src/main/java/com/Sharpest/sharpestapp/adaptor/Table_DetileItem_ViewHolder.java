package com.Sharpest.sharpestapp.adaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.model.DetalsProdect.ItemDetail;

import java.util.ArrayList;
import java.util.List;

public class Table_DetileItem_ViewHolder  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;


    List<ItemDetail> List_Item;
    private Context context;
    String deirection;
    Activity activity;

    public Table_DetileItem_ViewHolder(List<ItemDetail> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

//    public Table_DetileItem_ViewHolder(List<ItemDetail> arrayList, Activity activity, Context applicationContext, String deirection) {
//        List_Item = arrayList;
//        this.context = context;
//        this.deirection=deirection;
//        this.activity=activity;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_list_detiles_items, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<ItemDetail> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        menuItemHolder.name1.setText(""+List_Item.get(position).getSubLookupDomainValue());
        menuItemHolder.name2.setText(""+List_Item.get(position).getSubLookupDomain().getSubLookupDomainNameAr());
        menuItemHolder.name3.setText(""+List_Item.get(position).getSubLookupDomain().getLookupDomain().getLookupDomainNameAr());

//        try {
//            if (
//                    List_Item.get(position).getBannarImagePath()==null
//                            ||List_Item.get(position).getBannarImagePath().equals(null)
//                            || List_Item.get(position).getBannarImagePath().isEmpty()
//                            || List_Item.get(position).getBannarImagePath()=="")
//            {
//                menuItemHolder.imageProduct.setImageResource(R.drawable.background);
//            }else {
//                Picasso.with(context)
//                        .load(List_Item.get(position).getBannarImagePath())
//                        .into(menuItemHolder.imageProduct);
//            }
//        }catch (Exception e){
//            menuItemHolder.imageProduct.setImageResource(R.drawable.background);
//        }



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
        TextView name1, name2,name3;


        public MenuItemViewHolder(View view) {
            super(view);

            name1 = (TextView) view.findViewById(R.id.name1_detilesprodect);
            name2=(TextView) view.findViewById(R.id.name2_detilesprodect);
            name3=(TextView) view.findViewById(R.id.name3_detilesprodect);


        }
    }
}
