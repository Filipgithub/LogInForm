package com.example.uino.activityexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView personName = (TextView) findViewById(R.id.hello);
       // SharedPreferences storage = getSharedPreferences("storage",MODE_PRIVATE);
        String user = personName.getText().toString()+" "+getIntent().getStringExtra("extra");
        personName.setText(user);
    }
}
