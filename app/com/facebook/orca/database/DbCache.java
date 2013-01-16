package com.facebook.orca.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.threads.FolderName;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DbCache
{
  private static final String[] d = { "thread_id", "action_id", "last_visible_action_id" };
  private final ThreadsDatabaseSupplier a;
  private final DbThreadsPropertyUtil b;
  private volatile boolean c;

  DbCache(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbThreadsPropertyUtil paramDbThreadsPropertyUtil)
  {
    this.a = paramThreadsDatabaseSupplier;
    this.b = paramDbThreadsPropertyUtil;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean a(FolderName paramFolderName)
  {
    boolean bool = true;
    if (paramFolderName == FolderName.e)
      if ((!a(FolderName.b)) || (!a(FolderName.d)));
    while (true)
    {
      return bool;
      bool = false;
      continue;
      if (!this.b.a(DbProperties.c(paramFolderName), bool))
        continue;
      bool = false;
    }
  }

  public List<String> b(FolderName paramFolderName)
  {
    HashMap localHashMap = Maps.a();
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    String[] arrayOfString1 = d;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramFolderName.b();
    Cursor localCursor1 = localSQLiteDatabase.query("threads", arrayOfString1, "folder=?", arrayOfString2, null, null, "timestamp_ms DESC", Integer.toString(25));
    try
    {
      while (localCursor1.moveToNext())
      {
        String str = localCursor1.getString(0);
        if ("0".equals(str))
          continue;
        localHashMap.put(str, new DbCache.OutOfDateThread(str, localCursor1.getLong(1), localCursor1.getLong(2)));
      }
    }
    finally
    {
      localCursor1.close();
    }
    Cursor localCursor2 = localSQLiteDatabase.query("messages", new String[] { "thread_id" }, "action_id IN " + SqlUtil.a(Iterables.a(localHashMap.values(), new DbCache.1(this))), null, null, null, null);
    try
    {
      if (localCursor2.moveToNext())
        localHashMap.remove(localCursor2.getString(0));
    }
    finally
    {
      localCursor2.close();
    }
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (this.b.a(DbProperties.a((String)localEntry.getKey()), -1L) != ((DbCache.OutOfDateThread)localEntry.getValue()).a())
        continue;
      localIterator.remove();
    }
    return Lists.a(localHashMap.keySet());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbCache
 * JD-Core Version:    0.6.0
 */