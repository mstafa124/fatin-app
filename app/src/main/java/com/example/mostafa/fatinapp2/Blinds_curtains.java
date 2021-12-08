package com.example.mostafa.fatinapp2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

public class Blinds_curtains extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
int[] blinds=new int[]{R.drawable.blinds2,R.drawable.blinds3,R.drawable.blinds4,R.drawable.blinds5,R.drawable.blinds6,R.drawable.blinds7,R.drawable.blinds8,R.drawable.blinds9,R.drawable.blinds10,R.drawable.blinds11,R.drawable.blinds12,R.drawable.blinds13,R.drawable.blinds14,R.drawable.blinds15,R.drawable.blinds16,R.drawable.blinds17,R.drawable.blinds19,R.drawable.blinds1};
int n=0;
    ImageView imgblinds;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinds_curtains);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgblinds=(ImageView)findViewById(R.id.imgblinds);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        setTitle("Internal Blinds");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Thread tblinds=new Thread(){
           @Override
           public void run() {

               for (n=0;n<18;n++){
                   int waited=0;
                   while (waited<3000){
                       try {
                           Thread.sleep(4000);
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   imgblinds.setImageResource(blinds[n]);
                                   if (n<18){
                                       n++;
                                   }
                                   if (n==18){
                                       n=0;
                                   }
                               }
                           });
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
               }


           }
       };
        tblinds.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.contact_us) {
            Intent is=new Intent(Blinds_curtains.this,Blinds_curtains.class);
            startActivity(is);
            // Handle the camera action
        }
        if (id == R.id.about_u) {
            Intent imn=new Intent(Blinds_curtains.this,AboutUs.class);
            startActivity(imn);
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
