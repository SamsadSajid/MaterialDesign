package com.example.shamsad.materialdesign;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        toolbar =(android.support.v7.widget.Toolbar)findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);  //Rather than using system's toolbar, newly created toolbar is gonna use.

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.action_settings){
            Toast.makeText(this,"hit bokachoda "+item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }

       // else if(id==R.id.action_home){
         //   NavUtils.navigateUpFromSameTask(this);
        //}

        return super.onOptionsItemSelected(item);
    }
}
