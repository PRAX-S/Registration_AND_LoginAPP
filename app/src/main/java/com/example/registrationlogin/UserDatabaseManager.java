package com.example.registrationlogin;
import static com.example.registrationlogin.DatabaseHelper.COLUMN_PASSWORD;
import static com.example.registrationlogin.DatabaseHelper.COLUMN_USERNAME;
import static com.example.registrationlogin.DatabaseHelper.COLUMN_EMAIL;
import static com.example.registrationlogin.DatabaseHelper.COLUMN_ID;
import static com.example.registrationlogin.DatabaseHelper.TABLE_NAME;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class UserDatabaseManager {
    private static String COLUMN_EMAIL ;
    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;
    public UserDatabaseManager(Context context)
    {
        this.dbhelper= new DatabaseHelper(context);
    }
    public void open()
    {
        this.db=dbhelper.getWritableDatabase();
    }
    public void close()
    {
        dbhelper.close();
    }
    public long insertUser(String username,String email,String password )
    {
        ContentValues content = new ContentValues();
        content.put("username",username);
        content.put("email",email);
        content.put("password",password);
        return db.insert("users",null,content);
    }
    public String getPassword(String username)
    {
        String password = null;
        Cursor cursor = null;
        try
        {
          String[] columns = {"password"};
          String selection = "username = ? ";
          String[] selectionArgs = {username};

        cursor = db.query("users",columns,selection,selectionArgs,null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
            password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(cursor!=null)
            {
                cursor.close();
            }
        }
        return password;
    }
}
