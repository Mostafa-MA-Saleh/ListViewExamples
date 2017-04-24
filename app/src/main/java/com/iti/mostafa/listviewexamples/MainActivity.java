package com.iti.mostafa.listviewexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSimpleList = (Button) findViewById(R.id.SimpleListButton);
        Button btnSimpleListImage = (Button) findViewById(R.id.SimpleListImageButton);
        Button btnComplexList = (Button) findViewById(R.id.ComplexListButton);
        Button btnBetterComplexList = (Button) findViewById(R.id.BetterComplexListButton);
        Button btnEvenBetterComplexList = (Button) findViewById(R.id.EvenBetterComplexListButton);
        Button btnRecyclerView = (Button) findViewById(R.id.RecyclerViewButton);

        btnSimpleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SimpleList.class));
            }
        });

        btnSimpleListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SimpleListImage.class));
            }
        });

        btnComplexList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ComplexList.class));
            }
        });

        btnBetterComplexList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BetterComplexList.class));
            }
        });

        btnEvenBetterComplexList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EvenBetterComplexList.class));
            }
        });

        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
            }
        });
    }
}
