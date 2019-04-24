package com.test0.pwing.prac_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import Listview.MyBlock;
import Listview.abs_Myadapter;
import javaSQL.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqliteHelper myDB = new SqliteHelper(this, "MRT_TABLE");

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<MyBlock> blockList = new ArrayList<>();


        try {
            myDB.createDB();
        } catch (IOException e) {
            throw new Error("Cannot Create Database");
        }
        try {
            myDB.openDB();

        } catch (SQLiteException e) {
            throw e;
        }

        Cursor data = myDB.getTable();
        data.moveToFirst();
        while (data.moveToNext()) {
            final MyBlock myBlock = new MyBlock(data.getString(2), data.getString(3));
            blockList.add(myBlock);
        }

//        for (int i = 0; i < 10; i++) {
//            blockList.add(new MyBlock("insert title text here", "insert text here"));
//        }

        class Myadapter extends abs_Myadapter {
            Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList){
                super(context, layout, myBlockArrayList);
            }
            @Override
            public void openWeb() {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getUrl()));
                startActivity(intent);
            }
        };

        final Myadapter myadapter = new Myadapter(getBaseContext(), R.layout.mylistview_layout, blockList);

        listView.setAdapter(myadapter);

    }
}