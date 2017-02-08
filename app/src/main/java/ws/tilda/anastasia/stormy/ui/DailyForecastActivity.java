package ws.tilda.anastasia.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

import ws.tilda.anastasia.stormy.R;
import ws.tilda.anastasia.stormy.adapters.DayAdapter;
import ws.tilda.anastasia.stormy.weather.Day;

import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);


        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


       String daysofTheWeek = mDays[position].getDayOfTheWeek();
       String conditions = mDays[position].getSummary();
       String highTemp = mDays[position].getTemperatureMax() + "";
       String message = String.format("On %s the high will be %s and it will be %s",
               daysofTheWeek,
               highTemp,
               conditions);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
