package sg.edu.rp.c346.id21025446.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textView);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "time displayed", Toast.LENGTH_SHORT).show();
                int showHour = tp.getCurrentHour().intValue();
                int showMin = tp.getCurrentMinute().intValue();
                String timeShown = "Time is " + showHour + ":" + showMin;

                tvDisplay.setText(timeShown);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "date displayed", Toast.LENGTH_SHORT).show();
                int showDay = dp.getDayOfMonth();
                int showMonth = dp.getMonth() + 1;
                int showYear = dp.getYear();
                String dateShown = "Date is " + showDay + "/" + showMonth + "/" + showYear;

                tvDisplay.setText(dateShown);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "time and date has been reset", Toast.LENGTH_SHORT).show();
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0, 1);
                }
        });

    }
}