package com.example.gridview;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<GridItem> mAppItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppItem = new ArrayList<GridItem>();

        //Application 정보를수집한다.
        getApplicationInfoArrayList();

        GridView gridView = (GridView)findViewById(R.id.grid_main);
        GridAdapter adapter = new GridAdapter(this, R.layout.grid_item_layout, mAppItem);
        gridView.setAdapter(adapter);
    }

    private void getApplicationInfoArrayList()
    {
        String appName 		= null;
        Drawable appIcon 	= null;
        PackageManager packageMgr = getPackageManager();

        try
        {
        List<ApplicationInfo> appList = packageMgr.getInstalledApplications(
        PackageManager.GET_UNINSTALLED_PACKAGES);

            for(ApplicationInfo appInfo : appList)
            {
                appName = appInfo.loadLabel(packageMgr).toString();
                appIcon = appInfo.loadIcon(packageMgr);
                GridItem item = new GridItem(appName, appIcon);
                mAppItem.add(item);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

