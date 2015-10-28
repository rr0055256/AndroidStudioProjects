package com.helloworld.raman.jawapictures;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] jawaBikes = {"Jawa1","Jawa2","Jawa3"};
    Integer [] jawaDrawables = {R.drawable.jawa,R.drawable.jawa_stock_1,R.drawable.jawa_stock_2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //ListView object
        ListView listView = (ListView) findViewById(R.id.listView);

        CustomList list = new CustomList(MainActivity.this,0);

        listView.setAdapter(list);
    }

    class CustomList extends ArrayAdapter<String>{

        public CustomList(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return jawaBikes.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
                LayoutInflater inflater = getLayoutInflater();

                convertView = inflater.inflate(R.layout.jawa_layout, null, true);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

            TextView textView = (TextView) convertView.findViewById(R.id.textView);

            textView.setText(jawaBikes[position]);

            imageView.setImageResource(jawaDrawables[position]);

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
