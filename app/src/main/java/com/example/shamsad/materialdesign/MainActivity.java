package com.example.shamsad.materialdesign;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(android.support.v7.widget.Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);  //Rather than using system's toolbar, newly created toolbar is gonna use.

    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.action_settings){
            Toast.makeText(this,"hit"+item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }

        else if(id==R.id.navigate){
            startActivity(new Intent(this,SubActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
