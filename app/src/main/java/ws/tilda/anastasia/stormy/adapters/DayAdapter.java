package ws.tilda.anastasia.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import ws.tilda.anastasia.stormy.R;
import ws.tilda.anastasia.stormy.weather.Day;

import static ws.tilda.anastasia.stormy.weather.Forecast.getIconId;

public class DayAdapter extends BaseAdapter{
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; //we aren't gonna use it. Tag items for easy reference.
    }


    //Where mapping happens
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            //brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.circleImageView = (ImageView) convertView.findViewById(R.id.circleImageView);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        holder.circleImageView.setImageResource(R.drawable.bg_temperature);

        if(position == 0) {
            holder.dayLabel.setText("Today");
        } else {
            holder.dayLabel.setText(day.getDayOfTheWeek());

        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView; //public by default
        TextView temperatureLabel;
        TextView dayLabel;
        ImageView circleImageView;

    }
}
