package com.facebook.contacts.data;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class ContactsDbSchemaPart extends SharedSQLiteSchemaPart
{
  public static final ImmutableList<String> a;
  private static final Class<?> b = ContactsDbSchemaPart.class;

  static
  {
    a = ImmutableList.e().b("phone_e164").b("phone_national").b("phone_local").b();
  }

  public ContactsDbSchemaPart()
  {
    super("contacts", 25);
  }

  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE contacts_db_properties (key TEXT PRIMARY KEY, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE contact_summaries (contact_id TEXT PRIMARY KEY, data TEXT )");
    paramSQLiteDatabase.execSQL("CREATE TABLE contact_details (contact_id TEXT PRIMARY KEY, data TEXT )");
    paramSQLiteDatabase.execSQL("CREATE TABLE contacts_indexed_data (type TEXT, contact_id TEXT, indexed_data TEXT )");
    paramSQLiteDatabase.execSQL("CREATE INDEX contacts_type_index ON contacts_indexed_data ( type, contact_id );");
    paramSQLiteDatabase.execSQL("CREATE INDEX contacts_data_index ON contacts_indexed_data ( type, indexed_data );");
    paramSQLiteDatabase.execSQL("CREATE TABLE favorite_contacts (fbid TEXT PRIMARY KEY, display_order INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE INDEX favorite_contacts_order_index on favorite_contacts (display_order ASC)");
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.d(b, "Upgrading part from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts_db_properties");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_summaries");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_details");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts_indexed_data");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS contacts_type_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS contacts_data_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorite_contacts");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS favorite_contacts_order_index");
    a(paramSQLiteDatabase);
  }

  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("contacts_db_properties", null, null);
    paramSQLiteDatabase.delete("contact_summaries", null, null);
    paramSQLiteDatabase.delete("contact_details", null, null);
    paramSQLiteDatabase.delete("contacts_indexed_data", null, null);
    paramSQLiteDatabase.delete("favorite_contacts", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsDbSchemaPart
 * JD-Core Version:    0.6.0
 */