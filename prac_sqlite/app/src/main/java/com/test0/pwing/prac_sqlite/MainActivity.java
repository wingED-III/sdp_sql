package com.test0.pwing.prac_sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import javaSQL.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] namesLocation = {"place A", "placeB", "placeC"};
        String[] descript = {"aaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbb", "ccccccccccc"};

        SqliteHelper myDB = new SqliteHelper(this, "mrt");

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<MyBlock> arrayList = new ArrayList<>();

        Cursor data = myDB.getList();
//        while (data.moveToNext()) {
//            arrayList.add(new MyBlock(data.getString(2), data.getString(3)));
//        }

//        for (int i = 0; i < 3; i++) {
//            arrayList.add(new MyBlock(namesLocation[i], descript[i]));
//        }

        for (int i = 0; i < 10; i++) {
            arrayList.add(new MyBlock("insert title text here","insert text here"));
        }


        final Myadapter myadapter = new Myadapter(getBaseContext(), R.layout.mylistview_layout, arrayList);
        listView.setAdapter(myadapter);
    }

}
