package database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName2.db";
    public static final String TABLE_NAME = "login";
    private static final int VERSAO_BANCO = 1;
    private HashMap hashMap;
    public static String databasePath = "";

    public DB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        databasePath = context.getDatabasePath(DATABASE_NAME).getPath();
        Log.v("minhaTAG", "executando o método construtor DBCORE\n" + databasePath);
        ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME + " " +
                        "(_id integer primary key, email text, password text)"
        );
        Log.v("minhaTAG", "executando: onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        Log.v("minhaTAG", "executando: onUpgrade");
    }

    public boolean insertLogin(String email, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", pwd);
        db.insert(TABLE_NAME, null, contentValues);
        Log.v("minhaTAG", "executando: insertLogin (" + email + ")");
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where _id=" + id + "", null);
        return res;
    }

//    public int numberOfRows() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
//        return numRows;
//    }

//    public boolean updatelogin(int id, String email, String pwd) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("email", email);
//        contentValues.put("password", pwd);
//        try {
//            db.update(TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(id)}
//            );
//        } catch (Exception erro) {
//            return true;
//        }
//        return false;
//    }

//    public Integer deleteContact(Integer id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME,
//                "_id = ? ",
//                new String[]{Integer.toString(id)});
//    }

    @SuppressLint("Range")
    public ArrayList<String> getAllLogins() {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("email")));
            res.moveToNext();
        }
        return array_list;
    }

//    public Cursor carregaDados(){
//        Log.v("minhaTAG","Passou método carregaDados");
//        Cursor cursor;
//        String[] campos =  {"_id","email","password"};
//        SQLiteDatabase db = this.getReadableDatabase();
//        cursor = db.query(TABLE_NAME, campos, null, null, null, null, null, null);
//        cursor.moveToNext();
//        // while (cursor.moveToNext()){
//        //   Log.v("minhaTAG",cursor.getString(1));}
//
////        String query = "SELECT * FROM "+TABLE_NAME;
////        SQLiteDatabase db = getWritableDatabase();
////        cursor = db.rawQuery(query,null);
//
//        // if(cursor!=null){
//        //   cursor.moveToFirst();
//        //lista
//            /*while (cursor.moveToNext()){
//                Log.v("minhaTAG",cursor.getString(1));
//            }*/
//        //}
//        db.close();
//        return cursor;
//    }

}