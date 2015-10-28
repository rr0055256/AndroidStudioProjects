package com.helloworld.raman.customizablelistview;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by raman on 28/10/15.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        int firstImage = intent.getExtras().getInt("FirstImage");


        String firstImageText = intent.getStringExtra("FirstImageText");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(firstImage);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(firstImageText);
    }
}
