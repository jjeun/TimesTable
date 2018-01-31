package com.jjeun.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);


        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressNum = 1;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myListView(progressNum);
                Toast.makeText(getApplicationContext(), progressNum + " Times Table", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void myListView(int num) {
        ArrayList<Integer> timesTable = new ArrayList<Integer>();

        for (int i = 1; i <= 20; i++) {
            timesTable.add(num * i);
        }

        ListView myListView = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, timesTable);
        myListView.setAdapter(myArrayAdapter);
    }
}
