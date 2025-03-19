package android.example.demobasiclistview.dao.implement;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.example.demobasiclistview.dao.DAOInterface;
import android.example.demobasiclistview.model.CanBo;
import android.example.demobasiclistview.model.DonVi;
import android.example.demobasiclistview.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CanBoDao implements DAOInterface<CanBo> {
    private SQLiteDatabase db;

    public CanBoDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public long insert(CanBo canBo) {
        ContentValues values = new ContentValues();
        values.put("name", canBo.getName());
        values.put("role", canBo.getRole());
        values.put("phoneNumber", canBo.getPhoneNumber());
        values.put("email", canBo.getEmail());
        values.put("donViId", canBo.getDonvi());

        return db.insert("CanBo", null, values);
    }

    @Override
    public CanBo getById(int id) {
        Cursor cursor = db.query("CanBo", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            @SuppressLint("Range") CanBo canBo = new CanBo(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("role")),
                    cursor.getString(cursor.getColumnIndex("phoneNumber")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("donViId"))
            );
            cursor.close();
            return canBo;
        }
        return null;
    }

    @Override
    public List<CanBo> getAll() {
        List<CanBo> canBoList = new ArrayList<>();
        Cursor cursor = db.query("CanBo", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") CanBo canBo = new CanBo(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("role")),
                        cursor.getString(cursor.getColumnIndex("phoneNumber")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("donViId"))
                );
                canBoList.add(canBo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return canBoList;
    }
}
