package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$23 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    FacebookDatabaseHelper.a(paramSQLiteDatabase, "mailbox_threads");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, "mailbox_messages");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, "mailbox_messages_display");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, "mailbox_profiles");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.23
 * JD-Core Version:    0.6.0
 */