package com.iti.mostafa.listviewexamples;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mostafa on 02/08/2017.
 */

public class RecyclerViewActivity extends Activity {

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
        setContentView(R.layout.recycler_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter recyclerAdapter = new ComplexAdapter(values, versions, images);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(divider);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public class ComplexAdapter extends RecyclerView.Adapter<ComplexAdapter.ViewHolder> {

        private String[] values;
        private int[] images;
        private String[] desc;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView lblHeader;
            public TextView lblDesc;
            public ImageView image;

            public ViewHolder(View v) {
                super(v);
                lblHeader = (TextView) v.findViewById(R.id.textView);
                lblDesc = (TextView) v.findViewById(R.id.lblDesc);
                image = (ImageView) v.findViewById(R.id.imageView);
            }
        }

        public ComplexAdapter(String[] values, String[] desc, int[] images) {
            this.values = values;
            this.images = images;
            this.desc = desc;
        }

        @Override
        public ComplexAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.complex_recycler_row, parent, false);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView text = (TextView) v.findViewById(R.id.textView);
                    Toast.makeText(parent.getContext(), text.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            ComplexAdapter.ViewHolder vh = new ComplexAdapter.ViewHolder(v);
            return vh;
        }


        @Override
        public void onBindViewHolder(ComplexAdapter.ViewHolder holder, int position) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            options.inJustDecodeBounds = false;
            Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), images[position], options);
            holder.lblHeader.setText(values[position]);
            holder.lblDesc.setText(desc[position]);
            holder.image.setImageBitmap(scaledImage);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }
}

