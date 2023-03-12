package com.Sharpest.sharpestapp.adaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.CourseRoundDetail;

import java.util.ArrayList;
import java.util.List;

public class DetilesCource_Course_DetlesCours_viewHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;


    List<CourseRoundDetail> List_Item;
    private Context context;
    String deirection;
    Activity activity;

    public DetilesCource_Course_DetlesCours_viewHolder(List<CourseRoundDetail> list_Item, Activity activity, Context context, String deirection) {
        List_Item = list_Item;
        this.context = context;
        this.deirection=deirection;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_detiels_cource, viewGroup, false);
        return new DetilesCource_Course_DetlesCours_viewHolder.MenuItemViewHolder(menu1);

    }

    public void filterList(ArrayList<CourseRoundDetail> filteredList) {
        List_Item = filteredList;
        //recyclerView_dAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final DetilesCource_Course_DetlesCours_viewHolder.MenuItemViewHolder menuItemHolder = (DetilesCource_Course_DetlesCours_viewHolder.MenuItemViewHolder) holder;


        if (List_Item.size() == 1){
            menuItemHolder.line.setVisibility(View.GONE);
        }
        String dates=List_Item.get(position).getStartDate();
        String result = dates.substring(0,10);

//        Calendar calendar = Calendar.getInstance();
//        DateFormat df = DateFormat.getDateInstance();
//        Date date;
//        try {
//            date = df.parse(result);
//            calendar.setTime(date);
//
//            String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
//
//            String day = days[calendar.get(Calendar.DAY_OF_WEEK)];
//
//            menuItemHolder.place.setText(day+" >>>  "+result);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        menuItemHolder.place.setText(List_Item.get(position).getCourseDays()+" يبدأ  "+result);
        menuItemHolder.timeCource.setText(""+List_Item.get(position).getTimePeriod());
        menuItemHolder.place_corse.setText("الاماكن المتاحة للحجز  "+ List_Item.get(position).getAvailableSetsNumber()+"  أفراد");

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
        TextView place,timeCource,place_corse;
        View line;

        public MenuItemViewHolder(View view) {
            super(view);

            place = (TextView) view.findViewById(R.id.text_place_found);
            timeCource = (TextView) view.findViewById(R.id.text_timedateCourse);

            place_corse = (TextView) view.findViewById(R.id.text_location_detielseCource);
            line = (View) view.findViewById(R.id.line);


        }
    }
}

