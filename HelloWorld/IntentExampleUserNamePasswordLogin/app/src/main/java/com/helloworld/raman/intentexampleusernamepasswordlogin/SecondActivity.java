package com.helloworld.raman.intentexampleusernamepasswordlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView setUserName;
    private TextView setPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //object to display username
        setUserName = (TextView) findViewById(R.id.enteredUserName);

        //object to display password
        setPassword = (TextView) findViewById(R.id.enteredPassword);

        //obect of button
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                //get username
                String displayUsername = intent.getStringExtra("username");

                //get password
                String displayPassword = intent.getStringExtra("password");

                setUserName.setText(displayUsername);

                setPassword.setText(displayPassword);

                if(displayPassword.equalsIgnoreCase("Android")){
                    Toast.makeText(SecondActivity.this,"The password is valid",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this,"The password entered is :"+displayPassword+" and is invalid. Please enter password as 'Android'",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
