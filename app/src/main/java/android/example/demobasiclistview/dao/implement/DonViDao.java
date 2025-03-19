package android.example.demobasiclistview.dao.implement;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.example.demobasiclistview.dao.DAOInterface;
import android.example.demobasiclistview.model.DonVi;
import android.example.demobasiclistview.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DonViDao implements DAOInterface<DonVi> {
    private SQLiteDatabase db;

    public DonViDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public long insert(DonVi donVi) {
        ContentValues values = new ContentValues();
        values.put("name", donVi.getName());
        values.put("phoneNumber", donVi.getPhoneNumber());
        values.put("address", donVi.getAddress());

        return db.insert("DonVi", null, values);
    }

    @Override
    public DonVi getById(int id) {
        Cursor cursor = db.query("DonVi", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            @SuppressLint("Range") DonVi donVi = new DonVi(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("phoneNumber")),
                    cursor.getString(cursor.getColumnIndex("address"))
            );
            cursor.close();
            return donVi;
        }
        return null;
    }

    @Override
    public List<DonVi> getAll() {
        List<DonVi> donViList = new ArrayList<>();
        Cursor cursor = db.query("DonVi", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") DonVi donVi = new DonVi(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("phoneNumber")),
                        cursor.getString(cursor.getColumnIndex("address"))
                );
                donViList.add(donVi);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return donViList;
    }
}
