package com.iti.mostafa.listviewexamples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mostafa on 02/08/2017.
 */

public class ComplexList extends Activity {

    private final String[] values = {"Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jellybean", "Kitkat",
            "Lollipop", "Marshmallow", "Nougat"};

    private final String[] versions = {"1.5", "1.6", "2.0", "2.2",
            "2.3", "3.0", "4.0", "4.2", "4.4",
            "5.0", "6.0", "7.0"};

    private final int[] images = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo,
                                R.drawable.gingerbread, R.drawable.honeycomb, R.drawable.ice_cream_sandwich,
                                R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop,
                                R.drawable.marshmallow, R.drawable.nougat};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ListView listView = (ListView) findViewById(R.id.listView);
        final ComplexArrayAdapter listAdapter = new ComplexArrayAdapter(getApplicationContext(), values, versions, images);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ComplexArrayAdapter extends ArrayAdapter<String>{

        Context context;
        String[] values;
        int[] images;
        String[] desc;

        public ComplexArrayAdapter(Context context, String[] values, String[] desc, int[] images) {
            super(context, R.layout.complex_list_row, R.id.textView, values);
            this.context = context;
            this.values = values;
            this.images = images;
            this.desc = desc;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.complex_list_row, parent, false);
            TextView lblHeader = (TextView) view.findViewById(R.id.textView);
            TextView lblDesc = (TextView) view.findViewById(R.id.lblDesc);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            lblHeader.setText(values[position]);
            lblDesc.setText(desc[position]);
            image.setImageResource(images[position]);
            return view;
        }
    }
}
