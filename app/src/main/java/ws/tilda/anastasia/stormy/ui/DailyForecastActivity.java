package ws.tilda.anastasia.stormy.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import ws.tilda.anastasia.stormy.R;

public class DailyForecastActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday",
                "Wednesday", "Thursday", "Friday", "Saturday" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                daysOfTheWeek);
        setListAdapter(adapter);
    }
}
