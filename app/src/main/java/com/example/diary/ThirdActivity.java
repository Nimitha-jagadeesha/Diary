package com.example.diary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

public class ThirdActivity extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener
{

    TextView DateTextView;
    EditText dataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setIcon(R.mipmap.diaryicon);
        actionBar.setTitle("Diary");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        bindViews();
        updateViews();
    }

    public void bindViews()
    {
        DateTextView=findViewById(R.id.thirdActivity_TextView_date);
        dataEditText=findViewById(R.id.third_EditText_Data);
    }

    public void updateViews()
    {
        DateTextView.setText(getCurrentDate());
    }

    public String getCurrentDate() {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int dayOfMonth=c.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth + "/" + month + "/" + year;
    }

    public void onClickDatePicker(View v)
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        String date = dayOfMonth + "/" + month + "/" + year;
        DateTextView.setText(date);
    }

    public  void onClickShow(View v)
    {
         loadData(DateTextView.getText().toString());
    }

    public void loadData(String date)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        String Data=sharedPreferences.getString(date,"");
        dataEditText.setText(Data);
    }
}
