package com.facebook.orca.database;

import com.facebook.orca.threads.FolderName;

public class DbProperties
{
  public static final DbThreadPropertyKey a = new DbThreadPropertyKey("/sync/");
  public static final DbThreadPropertyKey b = new DbThreadPropertyKey("/sync/last_thread_fetch_action_id/");
  public static final DbUserPropertyKey c = new DbUserPropertyKey("/sync/last_sync_client_time_ms");
  public static final DbUserPropertyKey d = new DbUserPropertyKey("/sync/last_get_friends_client_time_ms");
  public static final DbUserPropertyKey e = new DbUserPropertyKey("/sync/friend_count");
  public static final DbUserPropertyKey f = new DbUserPropertyKey("/sync/favorite_count");
  public static final DbUserPropertyKey g = new DbUserPropertyKey("/sync/last_favorite_contacts_sync_client_time_ms");
  public static final DbUserPropertyKey h = new DbUserPropertyKey("/sync/last_top_contacts_sync_client_time_ms");
  public static final DbUserPropertyKey i = new DbUserPropertyKey("/sync/last_friends_mobile_app_data_sync_client_time_ms");

  public static final DbThreadPropertyKey a(FolderName paramFolderName)
  {
    return (DbThreadPropertyKey)((DbThreadPropertyKey)a.c(paramFolderName.b())).c("/last_get_threads_client_time_ms");
  }

  public static final DbThreadPropertyKey a(String paramString)
  {
    return (DbThreadPropertyKey)b.c(paramString);
  }

  public static final DbThreadPropertyKey b(FolderName paramFolderName)
  {
    return (DbThreadPropertyKey)((DbThreadPropertyKey)a.c(paramFolderName.b())).c("/last_get_threads_action_id");
  }

  public static final DbThreadPropertyKey c(FolderName paramFolderName)
  {
    return (DbThreadPropertyKey)((DbThreadPropertyKey)a.c(paramFolderName.b())).c("/threads_table_out_of_date");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbProperties
 * JD-Core Version:    0.6.0
 */