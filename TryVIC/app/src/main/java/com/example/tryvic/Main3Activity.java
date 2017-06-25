package com.example.tryvic;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity

    implements NavigationView.OnNavigationItemSelectedListener {

        public TextView tw;
        public  TextView b_t;
    private BrocastRec myReceiver= new BrocastRec();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            tw =(TextView)findViewById(R.id.search_t);
            b_t = (TextView)findViewById(R.id.b_t);

            Button search_b = (Button)findViewById(R.id.search_b);
            Button brocast_b = (Button)findViewById(R.id.brocast_b);

            search_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    search(tw.getText().toString());
                }
            });

            brocast_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    brocast_f();
                }
            });

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
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
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
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

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            int a=0;
            if (id == R.id.nav_camera) {
                //tw.setText("cam");
//                Intent it= new Intent(MainActivity.this, Main3Activity.class);
//                startActivity(it);
                // Handle the camera action
            } else if (id == R.id.nav_gallery) {
                Intent it= new Intent(Main3Activity.this, MainActivity.class);
                startActivity(it);
            } else if (id == R.id.nav_slideshow) {

            } else if (id == R.id.nav_manage) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }
            Log.e("whatis a","aaaaaaaa");
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        public void search(String what) {}

        public void brocast_f() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("com.example.tryvic.brocastrec");
            registerReceiver(myReceiver,filter);
            Intent intent= new Intent("com.example.tryvic.brocastrec");
            String str = b_t.getText().toString();
            //str_all= str;
            Bundle bundle= new Bundle();
            bundle.putString("message", str);
            intent.putExtras(bundle);
            sendBroadcast(intent);
        }



}
