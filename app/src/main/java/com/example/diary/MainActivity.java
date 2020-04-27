package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{

    TextInputEditText passwordTextInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    public void onClickSubmit(View v)
    {
        if (!passwordTextInputEditText.getText().toString().equals(getString(R.string.nimi)))
        {
            Toast.makeText(this, R.string.wrong_password,Toast.LENGTH_SHORT).show();
        }
        else
            {
            Intent intent=new Intent(this,Diary.class);
            startActivity(intent);
        }
    }

    private void bindViews()
    {
        passwordTextInputEditText=findViewById(R.id.mainActivity_TextInputEditText_password);
    }
}
