package com.example.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class Diary extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener
{
    TextView DateTextView;
    EditText dataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setTitle("Diary");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        bindViews();
        updateViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.refresh:
                dataEditText.setText("");
                break;
            case R.id.share:
                Intent intent =new Intent(this,ThirdActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindViews()
    {
        DateTextView=findViewById(R.id.mainActivity_TextView_date);
        dataEditText=findViewById(R.id.diary_EditText_Data);
    }

    private void updateViews()
    {
        DateTextView.setText(getCurrentDate());
    }

    public static String getCurrentDate()
    {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int dayOfMonth=c.get(Calendar.DAY_OF_MONTH);
        String date = dayOfMonth + "/" + month + "/" + year;
        return date;
    }

    public void onClickDatePicker(View v)
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));datePickerDialog.show();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        String date = dayOfMonth + "/" + month + "/" + year;
        DateTextView.setText(date);
    }

    public void onClickSave(View v)
    {
        saveData();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
    }

    public void saveData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(DateTextView.getText().toString(),dataEditText.getText().toString());
        editor.apply();
    }

    public void onClickNext(View v)
    {
        Intent intent =new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

}
