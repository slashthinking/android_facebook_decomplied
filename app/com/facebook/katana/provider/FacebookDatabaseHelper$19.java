package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;

final class FacebookDatabaseHelper$19 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE search_results");
    paramSQLiteDatabase.execSQL("DROP TABLE info_contacts");
    paramSQLiteDatabase.execSQL("DROP TABLE default_user_images");
    a("drop tables");
    paramSQLiteDatabase.execSQL("ALTER TABLE friends RENAME TO connections");
    paramSQLiteDatabase.execSQL("ALTER TABLE connections ADD COLUMN connection_type INT NOT NULL DEFAULT " + ConnectionsContract.ConnectionType.USER.ordinal());
    a("alter table friends");
    paramSQLiteDatabase.execSQL("CREATE TABLE friends_data (_id INTEGER PRIMARY KEY,user_id INT UNIQUE,first_name TEXT,last_name TEXT,cell TEXT,other TEXT,email TEXT,birthday_month INT,birthday_day INT,birthday_year INT,search_token TEXT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE search_results (_id INTEGER PRIMARY KEY,user_id INT,display_name TEXT,user_image_url TEXT);");
    paramSQLiteDatabase.execSQL(ConnectionsProvider.a);
    a("create new tables");
    paramSQLiteDatabase.execSQL("INSERT INTO friends_data(user_id) SELECT user_id  FROM connections  WHERE connection_type=" + ConnectionsContract.ConnectionType.USER.ordinal());
    a("insert new recs to friends_data table");
    FacebookDatabaseHelper.b().b(paramSQLiteDatabase);
    a("forceFriendsSync");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.19
 * JD-Core Version:    0.6.0
 */