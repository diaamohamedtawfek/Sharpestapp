package com.Sharpest.sharpestapp.adaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.CourseOutline;

import java.util.ArrayList;
import java.util.List;

public class Learn_Course_DetlesCours_viewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;


    List<CourseOutline> List_Item;
    private Context context;
    String deirection;
    Activity activity;

    public Learn_Course_DetlesCours_viewHolder(List<CourseOutline> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_content_cource, viewGroup, false);
        return new Learn_Course_DetlesCours_viewHolder.MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<CourseOutline> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final Learn_Course_DetlesCours_viewHolder.MenuItemViewHolder menuItemHolder = (Learn_Course_DetlesCours_viewHolder.MenuItemViewHolder) holder;


        menuItemHolder.name1.setText(""+List_Item.get(position).getCourseOutlineAr());
        menuItemHolder.imageView.setImageResource(R.mipmap.verified);

//        try {
//            if (
//                    List_Item.get(position).getBannarImagePath()==null
//                            ||List_Item.get(position).getBannarImagePath().equals(null)
//                            || List_Item.get(position).getBannarImagePath().isEmpty()
//                            || List_Item.get(position).getBannarImagePath()=="")
//            {
//                menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo);
//            }else {
//                Picasso.with(context)
//                        .load(List_Item.get(position).getBannarImagePath())
//                        .into(menuItemHolder.imageView);
//            }
//        }catch (Exception e){
//            menuItemHolder.imageView.setImageResource(R.mipmap.sharpest_logo;
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
        TextView name1;
        ImageView imageView;

        public MenuItemViewHolder(View view) {
            super(view);

            name1 = (TextView) view.findViewById(R.id.text_conentCource);
            imageView=(ImageView) view.findViewById(R.id.image_conentCource);


        }
    }
}

