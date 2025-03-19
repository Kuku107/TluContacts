package android.example.demobasiclistview.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tlucontact";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DONVI_TABLE = "CREATE TABLE DonVi (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "phoneNumber TEXT, " +
                "address TEXT)";

        String CREATE_CANBO_TABLE = "CREATE TABLE CanBo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "role TEXT, " +
                "phoneNumber TEXT, " +
                "email TEXT, " +
                "donViId INTEGER, " +
                "FOREIGN KEY (donViId) REFERENCES DonVi(id))";

        db.execSQL(CREATE_DONVI_TABLE);
        db.execSQL(CREATE_CANBO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CanBo");
        db.execSQL("DROP TABLE IF EXISTS DonVi");
        onCreate(db);
    }
}