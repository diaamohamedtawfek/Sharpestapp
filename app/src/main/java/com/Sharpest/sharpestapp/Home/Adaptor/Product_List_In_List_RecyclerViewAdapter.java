package com.Sharpest.sharpestapp.Home.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.Home.model.DataHome_InsideList;
import com.Sharpest.sharpestapp.Home.model.DataHome_MultyList;
import com.Sharpest.sharpestapp.Home.model.home.ItemList;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.Produect_Categry;

import java.util.ArrayList;
import java.util.List;

public class Product_List_In_List_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    List<DataHome_MultyList> List_Item;
    private Context context;
    String deirection;
    Activity activity;


    //>>>>
//    RecyclerView recycal_deliverys;
    private Product_insideList_RecyclerViewAdapter recyclerView_dAdapter;
    public List<DataHome_InsideList> listItems = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public Product_List_In_List_RecyclerViewAdapter(List<DataHome_MultyList> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_home_list_in_list, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<DataHome_MultyList> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        menuItemHolder.name_categroy.setText(List_Item.get(position).getItemCategoryNameAr());

        menuItemHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Produect_Categry.class);
                intent.putExtra("id_product",List_Item.get(position).getId());
                intent.putExtra("test", deirection);
                intent.putExtra("name_categry", List_Item.get(position).getItemCategoryNameAr());
                context.startActivity(intent);
            }
        });

        listItems.clear();
        if (List_Item.get(position).getItemList().isEmpty() || List_Item.get(position).getItemList().size()<=0||
                List_Item.get(position).getItemList().equals(null)||
                List_Item.get(position).getItemList()!=null){
//                menuItemHolder.recyclerView.setVisibility(View.GONE);
        }

        if (!List_Item.get(position).getItemList().isEmpty() ||
                List_Item.get(position).getItemList().size()>0||
                !List_Item.get(position).getItemList().equals(null)||
                List_Item.get(position).getItemList()!=null
        ){
            Log.e("itemList><><",""+List_Item.get(position).getItemList().size());
            menuItemHolder.recyclerView.setVisibility(View.VISIBLE);

//            gridLayoutManager = new GridLayoutManager(activity, 1);
            listItems.add(new DataHome_InsideList(
                    List_Item.get(position).getItemList()
            ));

            if (List_Item.get(position).getItemList().size() > 0){

            }else{
                menuItemHolder.allProduct.setVisibility(View.GONE);
                menuItemHolder.name_categroy.setVisibility(View.GONE);
                menuItemHolder.viewlist.setVisibility(View.GONE);
                menuItemHolder.recyclerView.setVisibility(View.GONE);
            }

            List<ItemList> arrayList=List_Item.get(position).getItemList();
            menuItemHolder.recyclerView.setLayoutManager(gridLayoutManager);

            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

            menuItemHolder.recyclerView.setLayoutManager(horizontalLayoutManagaer);

            recyclerView_dAdapter = new Product_insideList_RecyclerViewAdapter(arrayList,activity, context,deirection);

            menuItemHolder.recyclerView.setAdapter(recyclerView_dAdapter);

            recyclerView_dAdapter.notifyDataSetChanged();

            recyclerView_dAdapter.notifyDataSetChanged();


//            Log.e("?????????itemList><><",""+List_Item.get(position).getItemList().get(0).getItemNameEn());
//                for (int i=0 ;i>List_Item.get(position).getItemList().size();i++) {
//                    Log.e("?????????itemList><><",i+"  "+List_Item.get(position).getItemList().get(i).getItemNameEn());
//                    listItems.add(new DataHome_InsideList(
//                            List_Item.get(position).getItemList().get(i).getId(),
//                            "" + List_Item.get(position).getItemList().get(i).getItemNameAr(),
//                            "" + List_Item.get(position).getItemList().get(i).getItemNameEn(),
//                             List_Item.get(position).getItemList().get(i).getBannarImagePath()
//                    ));
//                    recyclerView_dAdapter.notifyDataSetChanged();
//                }
//            recyclerView_dAdapter.notifyDataSetChanged();
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
        TextView name_categroy, allProduct;
        RecyclerView recyclerView;
        View viewlist;
        RelativeLayout relativeLayout;

        public MenuItemViewHolder(View view) {
            super(view);
//            cardView = (LinearLayout) view.findViewById(R.id.card_listdelvery);

            name_categroy = (TextView) view.findViewById(R.id.text_name_partlist_Home);
            allProduct=(TextView) view.findViewById(R.id.text_all_Prodect_partlist_Home);
            viewlist=(View) view.findViewById(R.id.view_designlistilist);

            recyclerView=(RecyclerView) view.findViewById(R.id.recycal_allcatigry);
            relativeLayout=(RelativeLayout) view.findViewById(R.id.relative);


        }
    }
}
