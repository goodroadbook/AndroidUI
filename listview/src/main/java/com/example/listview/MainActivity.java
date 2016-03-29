package com.example.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity
{
        String[] values = new String[] { "Android",
        "iPhone",
        "WindowsMobile",
        "Blackberry",
        "WebOS",
        "Ubuntu",
        "Windows7",
        "Max OS X",
        "Linux",
        "OS/2" };

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_main,
                R.id.label,
                values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int aPosition, long id)
    {
        String item = (String)getListAdapter().getItem(aPosition);
        Toast.makeText(this, item + " selected", Toast.LENGTH_SHORT).show();
    }
}

