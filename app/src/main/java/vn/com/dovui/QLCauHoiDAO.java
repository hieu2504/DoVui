package vn.com.dovui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class QLCauHoiDAO {

    private DoVuiSqlite doVuiSqlite;

    public QLCauHoiDAO(Context context){
        this.doVuiSqlite=new DoVuiSqlite(context);
    }

    private String USER_TABLE="qlcauhoi";
    public String MACAUHOI="macauhoi";
    public String CAUHOI="cauhoi";
    public String COL_A="dap_an_a";
    public String COL_B="dap_an_b";
    public String COL_C="dap_an_c";
    public String COL_D="dap_an_d";
    public String DAPAN="cautraloi";

    public List<QLCauhoi> getAll(){
        List<QLCauhoi> qlCauhoiList=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=doVuiSqlite.getReadableDatabase();

        String SQL="SELECT * FROM "+ USER_TABLE;

        Cursor cursor=sqLiteDatabase.rawQuery(SQL, null);

        if(cursor !=null){
            if(cursor.getCount()>0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    QLCauhoi qlCauhoi=new QLCauhoi();

                    qlCauhoi.setMacauhoi(Integer.parseInt(cursor.getString(cursor.getColumnIndex(MACAUHOI))));
                    qlCauhoi.setCauhoi(cursor.getString(cursor.getColumnIndex(CAUHOI)));
                    qlCauhoi.setAn_A(cursor.getString(cursor.getColumnIndex(COL_A)));
                    qlCauhoi.setAn_B(cursor.getString(cursor.getColumnIndex(COL_B)));
                    qlCauhoi.setAn_C(cursor.getString(cursor.getColumnIndex(COL_C)));
                    qlCauhoi.setAn_D(cursor.getString(cursor.getColumnIndex(COL_D)));
                    qlCauhoi.setDap_an(cursor.getString(cursor.getColumnIndex(DAPAN)));

                    qlCauhoiList.add(qlCauhoi);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return qlCauhoiList;
    }





}
