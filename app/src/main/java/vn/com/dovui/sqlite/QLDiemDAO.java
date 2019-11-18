package vn.com.dovui.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.com.dovui.model.QLDiem;
import vn.com.dovui.sqlite.DoVuiSqlite;

public class QLDiemDAO {
    private DoVuiSqlite doVuiSqlite;
    public QLDiemDAO (Context context){
        this.doVuiSqlite=new DoVuiSqlite(context);
    }
    private String DIEM_TABLE="diem";
    public String SOTHUTU="stt";
    public String COL_TEN="ten";
    public String COL_DIEM="diem";

    public List<QLDiem> getAll(){
        List<QLDiem> qlDiemList=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=doVuiSqlite.getReadableDatabase();

        String SQL="SELECT * FROM "+ DIEM_TABLE;

        Cursor cursor=sqLiteDatabase.rawQuery(SQL, null);

        if(cursor !=null){
            if(cursor.getCount()>0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    QLDiem qlDiem=new QLDiem();

                    qlDiem.setSothutu(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOTHUTU))));
                    qlDiem.setDiem(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_DIEM))));
                    qlDiem.setName(cursor.getString(cursor.getColumnIndex(COL_TEN)));

                    qlDiemList.add(qlDiem);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return qlDiemList;
    }

    public List<QLDiem> diemCao(){
        List<QLDiem> qlDiemList=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=doVuiSqlite.getReadableDatabase();

        String SQL="SELECT * FROM diem h ORDER by h.diem DESC ";

        Cursor cursor=sqLiteDatabase.rawQuery(SQL, null);

        if(cursor !=null){
            if(cursor.getCount()>0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    QLDiem qlDiem=new QLDiem();

                    qlDiem.setSothutu(cursor.getInt(0));
                    qlDiem.setDiem(cursor.getInt(2));
                    qlDiem.setName(cursor.getString(1));

                    qlDiemList.add(qlDiem);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return qlDiemList;
    }

    public long insertDiem(QLDiem qlDiem){
        SQLiteDatabase sqLiteDatabase=doVuiSqlite.getReadableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(SOTHUTU,qlDiem.getSothutu());
        contentValues.put(COL_DIEM,qlDiem.getDiem());
        contentValues.put(COL_TEN,qlDiem.getName());

        long result=sqLiteDatabase.insert(DIEM_TABLE,null,contentValues);
        sqLiteDatabase.close();
        return result;
    }
}
