package com.example.moringaplantation3;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Queue;

public class DatabaseSQLite extends SQLiteOpenHelper {
    String Tab_Name = "PersonDetails";
    String col_0 = "Id";  //Int
    String col_1 = "plantno";  //Int//now change varchar
    String col_2 = "dtvisit";  //Varchar
    String col_3 = "chwname";  //Int
    String col_4 = "teamleadnme";  //Int
    String col_5 = "VillageMohalla";  //Varchar
    String col_6 = "uc";  //Varchar
    String col_7 = "sizeplant"; //Int
    String col_8 = "locplant";  //Int
    String col_9 = "other";  //Varchar
    String col_10 = "qtyplan";  //Int
    public DatabaseSQLite(Context context) {
        super(context, "MyDb.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + Tab_Name + " (" + col_0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col_1 + " VARCHAR NOT NULL," +
                col_2 + " VARCHAR NOT NULL," +
                col_3 + " INTEGER NOT NULL," +
                col_4 + " INTEGER NOT NULL," +
                col_5 + " VARCHAR NOT NULL," +
                col_6 + " VARCHAR NOT NULL," +
                col_7 + " INTEGER NOT NULL," +
                col_8 + " INTEGER NOT NULL," +
                col_9 + " VARCHAR Default NULL," +
                col_10 + " INTEGER NOT NULL );";
         db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public String addData(String plantno, String Dateofvisit, int CHWnameandcode, int Teamleadernameandcode, String VillageMohalla, String Unioncouncil, int SizeofPlant, int LocationOfPlant, String other, int QuantityOfPlants){
        try {
            ContentValues cv1 = new ContentValues();
            cv1.put(col_1, plantno);
            cv1.put(col_2, Dateofvisit);
            cv1.put(col_3, CHWnameandcode);
            cv1.put(col_4, Teamleadernameandcode);
            cv1.put(col_5, VillageMohalla);
            cv1.put(col_6, Unioncouncil);
            cv1.put(col_7, SizeofPlant);
            cv1.put(col_8, LocationOfPlant);
            cv1.put(col_9, other);
            cv1.put(col_10, QuantityOfPlants);
            SQLiteDatabase db = this.getWritableDatabase();
            if (db.insert(Tab_Name,null,cv1)>0){
                return "insert";
            }
            else{
                return "Please insert different ID or another error";
            }
        } catch (Exception e) {
            return "Please Input another ID";
        }


    }

    // Selecting Data
    public Cursor select() {
        String query = "select * from " + Tab_Name + " Order by id";
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(query, null);
    }
    //Fill Getter Setter
    public ArrayList<GetterSetter> select1() {
        ArrayList<GetterSetter> getsetList = new ArrayList<GetterSetter>();
        String query = "select * from " + Tab_Name + " Order by id";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                GetterSetter getset = new GetterSetter();
                getset.Setplantno(cursor.getString(0));
                getset.Setdtvisit(cursor.getString(1));
                getset.Setchwname(cursor.getString(2));
                getset.Setteamleadnme(cursor.getString(3));
                getset.SetVillageMohalla(cursor.getString(4));
                getset.Setuc(cursor.getString(5));
                getset.Setsizeplant(cursor.getString(6));
                getset.Setlocplant(cursor.getString(7));
               getset.Getother(cursor.getString(8));
                getset.Setqtyplan(cursor.getString(9));
                getsetList.add(getset);
            } while (cursor.moveToNext());
        }
        return getsetList;
    }





}
