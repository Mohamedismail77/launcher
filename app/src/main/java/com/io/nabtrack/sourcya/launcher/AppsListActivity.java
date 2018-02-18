package com.io.nabtrack.sourcya.launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by m-ismail on 01/02/18.
 */

public class AppsListActivity extends Activity implements View.OnClickListener{

    private PackageManager manager;
    private List<AppDetail> apps;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_list);
        TextView time = findViewById(R.id.time);
        //loadApps();
        //loadListView();
        //addClickListener();
        ImageButton lan = findViewById(R.id.lan);
        ImageButton wifi = findViewById(R.id.wifi);
        ImageButton chrome = findViewById(R.id.chrome);
        ImageButton showBox = findViewById(R.id.showBox);
        ImageButton oneTv = findViewById(R.id.oneTv);
        ImageButton youTube = findViewById(R.id.youtube);
        lan.setOnClickListener(this);
        wifi.setOnClickListener(this);
        chrome.setOnClickListener(this);
        showBox.setOnClickListener(this);
        oneTv.setOnClickListener(this);
        youTube.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.lan:
                intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.wifi:
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;

            case R.id.chrome:
                manager = getPackageManager();
                intent = manager.getLaunchIntentForPackage("com.android.chrome");
                AppsListActivity.this.startActivity(intent);
                break;
            case R.id.showBox:
                manager = getPackageManager();
                intent = manager.getLaunchIntentForPackage("app.movie.shows.latestmovies.xfrj");
                AppsListActivity.this.startActivity(intent);
                break;
            case R.id.youtube:
                manager = getPackageManager();
                intent = manager.getLaunchIntentForPackage("com.google.android.youtube.tv");
                AppsListActivity.this.startActivity(intent);
                break;
            case R.id.oneTv:
                manager = getPackageManager();
                intent = manager.getLaunchIntentForPackage("com.sourcya.mware.io.androidApp");
                AppsListActivity.this.startActivity(intent);
                break;
        }


    }



    //    private void loadApps(){
//        manager = getPackageManager();
//        apps = new ArrayList<AppDetail>();
//
//        Intent i = new Intent(Intent.ACTION_MAIN, null);
//        i.addCategory(Intent.CATEGORY_LAUNCHER);
//
//        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
//        for(ResolveInfo ri:availableActivities){
//            AppDetail app = new AppDetail();
//            app.label = ri.loadLabel(manager);
//            app.name = ri.activityInfo.packageName;
//            app.icon = ri.activityInfo.loadIcon(manager);
//            apps.add(app);
//        }
//    }
//
//    private void loadListView(){
//        list = (ListView)findViewById(R.id.apps_list);
//
//        ArrayAdapter<AppDetail> adapter = new ArrayAdapter<AppDetail>(this,
//                R.layout.list_item,
//                apps) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                if(convertView == null){
//                    convertView = getLayoutInflater().inflate(R.layout.list_item, null);
//                }
//
//                ImageView appIcon = (ImageView)convertView.findViewById(R.id.item_app_icon);
//                appIcon.setImageDrawable(apps.get(position).icon);
//
//                TextView appLabel = (TextView)convertView.findViewById(R.id.item_app_label);
//                appLabel.setText(apps.get(position).label);
//
//                TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);
//                appName.setText(apps.get(position).name);
//
//                return convertView;
//            }
//        };
//
//        list.setAdapter(adapter);
//    }
//
//    private void addClickListener(){
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> av, View v, int pos,
//                                    long id) {
//                Intent i = manager.getLaunchIntentForPackage(apps.get(pos).name.toString());
//                AppsListActivity.this.startActivity(i);
//            }
//        });
//    }

}
