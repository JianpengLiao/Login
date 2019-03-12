package mg.studio.myapplication;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "test_db";//Database name
    public static String TABLE_NAME = "stu_table";// table name
    public static String FIELD_UserName = "username";// Column name
    public static String FIELD_Email = "email";// Column name
    public static String  FIELD_PassWord= "password";// Column name
    private static final int DB_VERSION = 1;   // Database version

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //creat a table
        String  sql = "CREATE TABLE " + TABLE_NAME + "(" + FIELD_UserName + ", " + FIELD_Email +", "+ FIELD_PassWord + " text not null);";
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "onCreate " + TABLE_NAME + "Error" + e.toString());
            return;
        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "update Database------------->");
    }

}

