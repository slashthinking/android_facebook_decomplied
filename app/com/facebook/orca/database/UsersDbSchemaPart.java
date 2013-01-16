package com.facebook.orca.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;
import com.facebook.orca.debug.BLog;

public class UsersDbSchemaPart extends SharedSQLiteSchemaPart
{
  private static final Class<?> a = UsersDbSchemaPart.class;

  public UsersDbSchemaPart()
  {
    super("users", 8);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE user_db_properties (key TEXT PRIMARY KEY, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE facebook_users (fbid INTEGER PRIMARY KEY, first_name TEXT, last_name TEXT, name TEXT, email_addresses TEXT, phone_numbers TEXT, pic_big TEXT, pic_square TEXT, pic_crop TEXT, rank REAL, is_pushable INTEGER, birthday_month INTEGER, birthday_day INTEGER, birthday_year INTEGER, last_active TEXT, mobile_app_data TEXT)");
    paramSQLiteDatabase.execSQL("CREATE INDEX facebook_users_rank_index on facebook_users (rank DESC)");
    paramSQLiteDatabase.execSQL("CREATE TABLE facebook_users_name_lookup (fbid INTEGER, normalized_name TEXT, name_type INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE INDEX facebook_users_name_lookup_name_index ON facebook_users_name_lookup (normalized_name, name_type, fbid)");
    paramSQLiteDatabase.execSQL("CREATE TABLE identifiers (identifier TEXT, type TEXT, user_key TEXT )");
    paramSQLiteDatabase.execSQL("CREATE INDEX identifiers_identifier_index ON identifiers ( identifier )");
    paramSQLiteDatabase.execSQL("CREATE TABLE favorite_contacts (fbid INTEGER PRIMARY KEY, display_order INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE INDEX favorite_contacts_order_index on favorite_contacts (display_order ASC)");
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.d(a, "Upgrading part from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_db_properties");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS facebook_users_fbid_rank_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS facebook_users_rank_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS facebook_users");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS facebook_users_name_lookup_name_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS facebook_users_name_lookup");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS clusters");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS clusters_cluster_id_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS clusters_user_key_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifiers");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS identifiers_identifier_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorite_contacts");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS favorite_contacts_order_index");
    a(paramSQLiteDatabase);
  }

  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("user_db_properties", null, null);
    paramSQLiteDatabase.delete("facebook_users", null, null);
    paramSQLiteDatabase.delete("favorite_contacts", null, null);
    paramSQLiteDatabase.delete("identifiers", null, null);
    paramSQLiteDatabase.delete("facebook_users_name_lookup", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbSchemaPart
 * JD-Core Version:    0.6.0
 */