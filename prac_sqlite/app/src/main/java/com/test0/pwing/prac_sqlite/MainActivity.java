package com.test0.pwing.prac_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] namesLocation = {"place A", "placeB", "placeC"};
        String[] descript = {"aaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbb", "ccccccccccc"};

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<MyBlock> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            arrayList.add(new MyBlock(namesLocation[i], descript[i]));
        }

        final Myadapter myadapter = new Myadapter(getBaseContext(), R.layout.mylistview_layout, arrayList);
        listView.setAdapter(myadapter);
    }

}
