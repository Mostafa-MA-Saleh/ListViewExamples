package com.iti.mostafa.listviewexamples;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Mostafa on 02/08/2017.
 */

public class SimpleList extends Activity {

    private final String[] values = {"Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jellybean", "Kitkat",
            "Lollipop", "Marshmallow", "Nougat"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getApplicationContext(),
                                                                    R.layout.simple_list_row,
                                                                    R.id.textView, values);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
