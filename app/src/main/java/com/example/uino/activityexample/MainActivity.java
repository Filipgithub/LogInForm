package com.example.uino.activityexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String extras = "";
    EditText firstName;
    EditText lastName;
   // SharedPreferences storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.editText);
        lastName = (EditText) findViewById(R.id.editText2);
        extras = firstName.getText().toString() + " " + lastName.getText().toString();
        //storage = getSharedPreferences("storage", MODE_PRIVATE);


    }


    public void goToAnother(View view) {
        if (firstName.getText().toString().equals("Filip")
                && lastName.getText().toString().equals("Klindic")) {
            extras = firstName.getText().toString() + " " + lastName.getText().toString();
            final Intent intent = new Intent(this, SecondActivity.class);
            /*SharedPreferences.Editor edit = storage.edit();
            edit.putString("extra", extras);
            edit.apply();*/
            intent.putExtra("extra",extras);
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage("Loading...");
            pd.show();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                        pd.dismiss();
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        } else if (firstName.getText().toString().equals(""))
            firstName.setError("Please enter correct User name!");
        else if (lastName.getText().toString().equals(""))
            lastName.setError("Please enter correct Password!");
        else
            Toast.makeText(this, "Wrong User name or Password", Toast.LENGTH_SHORT).show();
    }

}

