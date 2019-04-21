package javaSQL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "appDB";
    private static final int VERSION = 1;
    private static String tableName;

    public SqliteHelper(Context context,String tableName) {
        super(context, DATABASE, null, VERSION);
        this.tableName = tableName;
//        String dbPath = "/data/data/"+ context.getPackageName()+"/"+"database/";
//        Log.e("Path 1",dbPath);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createCmd = "CREATE TABLE IF NOT EXISTS " + this.tableName + "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "id_station INTEGER, " +
                "station TEXT, " +
                "location TEXT)";
        sqLiteDatabase.execSQL(createCmd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public Cursor queryWithSQL(String sql, String[] bindArgs) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, bindArgs);
    }

    public Cursor getList() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + this.tableName, null);
    }
}
