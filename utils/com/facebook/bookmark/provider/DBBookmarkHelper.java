package com.facebook.bookmark.provider;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.bookmark.ipc.BookmarkTable;
import com.facebook.bookmark.ipc.BookmarkTable.Columns;
import com.facebook.bookmark.ipc.GroupOrderTable;
import com.facebook.bookmark.ipc.GroupOrderTable.Columns;
import com.facebook.bookmark.ipc.SyncStatusTable.Columns;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.db.Table.Column;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DBBookmarkHelper
{
  private final ContentResolver a;

  public DBBookmarkHelper(ContentResolver paramContentResolver)
  {
    this.a = ((ContentResolver)Preconditions.checkNotNull(paramContentResolver));
  }

  private static ContentValues a(Bookmark paramBookmark, BookmarksGroup paramBookmarksGroup, boolean paramBoolean, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(BookmarkTable.Columns.b.a, Long.valueOf(paramBookmark.id));
    localContentValues.put(BookmarkTable.Columns.c.a, paramBookmark.name);
    localContentValues.put(BookmarkTable.Columns.e.a, paramBookmark.icon);
    localContentValues.put(BookmarkTable.Columns.f.a, paramBookmark.pic);
    localContentValues.put(BookmarkTable.Columns.g.a, paramBookmark.type);
    localContentValues.put(BookmarkTable.Columns.d.a, paramBookmark.url);
    localContentValues.put(BookmarkTable.Columns.h.a, Integer.valueOf(paramBookmark.a()));
    localContentValues.put(BookmarkTable.Columns.i.a, paramBookmarksGroup.id);
    localContentValues.put(BookmarkTable.Columns.j.a, paramBookmarksGroup.name);
    localContentValues.put(BookmarkTable.Columns.k.a, Integer.valueOf(paramInt));
    String str = BookmarkTable.Columns.l.a;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put(str, Integer.valueOf(i));
      return localContentValues;
    }
  }

  private static void a(ArrayList<ContentProviderOperation> paramArrayList, BookmarksGroup paramBookmarksGroup, List<Bookmark> paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Bookmark localBookmark = (Bookmark)localIterator.next();
      ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(BookmarkIpcConstants.b);
      if (i < paramInt);
      for (boolean bool = true; ; bool = false)
      {
        paramArrayList.add(localBuilder.withValues(a(localBookmark, paramBookmarksGroup, bool, i)).build());
        i++;
        break;
      }
    }
  }

  private void a(List<BookmarksGroup> paramList)
  {
    try
    {
      Cursor localCursor2 = this.a.query(BookmarkIpcConstants.e, GroupOrderTable.b, null, null, null);
      localCursor1 = localCursor2;
      if (localCursor1 == null)
      {
        try
        {
          throw new SQLException("Can not query " + BookmarkIpcConstants.e);
        }
        finally
        {
        }
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject1;
      }
      HashMap localHashMap = Maps.a();
      int i = localCursor1.getColumnIndexOrThrow(GroupOrderTable.Columns.a.a);
      int j = localCursor1.getColumnIndexOrThrow(GroupOrderTable.Columns.b.a);
      while (localCursor1.moveToNext())
        localHashMap.put(localCursor1.getString(i), Integer.valueOf(localCursor1.getInt(j)));
      Collections.sort(paramList, new DBBookmarkHelper.1(this, localHashMap));
      if (localCursor1 != null)
        localCursor1.close();
      return;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  private List<BookmarksGroup> e()
  {
    ArrayList localArrayList1 = Lists.a();
    HashMap localHashMap = Maps.a();
    try
    {
      Cursor localCursor2 = this.a.query(BookmarkIpcConstants.b, BookmarkTable.b, null, null, BookmarkTable.Columns.j + ", " + BookmarkTable.Columns.k);
      if (localCursor2 == null)
      {
        try
        {
          throw new SQLException("Can not query " + BookmarkIpcConstants.b);
        }
        finally
        {
          localCursor1 = localCursor2;
        }
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject1;
      }
      int i = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.b.a);
      int j = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.c.a);
      int k = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.d.a);
      int m = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.e.a);
      int n = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.f.a);
      int i1 = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.g.a);
      int i2 = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.h.a);
      int i3 = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.i.a);
      int i4 = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.j.a);
      int i5 = localCursor2.getColumnIndexOrThrow(BookmarkTable.Columns.l.a);
      ArrayList localArrayList2 = Lists.a();
      localObject3 = Lists.a();
      localObject4 = localArrayList2;
      localObject5 = null;
      localObject6 = null;
      if (localCursor2.moveToNext())
      {
        long l = localCursor2.getLong(i);
        Bookmark localBookmark = (Bookmark)localHashMap.get(Long.valueOf(l));
        if (localBookmark == null)
        {
          localBookmark = new Bookmark(l, localCursor2.getString(j), localCursor2.getString(k), localCursor2.getInt(i2), localCursor2.getString(m), localCursor2.getString(n), localCursor2.getString(i1));
          localHashMap.put(Long.valueOf(l), localBookmark);
        }
        localObject7 = localCursor2.getString(i3);
        localObject8 = localCursor2.getString(i4);
        int i6 = localCursor2.getInt(i5);
        if (!((String)localObject8).equals(localObject5))
        {
          if (localObject5 != null)
            localArrayList1.add(new BookmarksGroup((String)localObject6, localObject5, (List)localObject4, (List)localObject3));
          localObject10 = Lists.a();
          localObject9 = Lists.a();
          if (i6 > 0)
          {
            ((List)localObject10).add(localBookmark);
            break label574;
          }
          ((List)localObject9).add(localBookmark);
          break label574;
        }
      }
      else
      {
        if (localObject5 != null)
          localArrayList1.add(new BookmarksGroup((String)localObject6, localObject5, (List)localObject4, (List)localObject3));
        if (localCursor2 != null)
          localCursor2.close();
        return localArrayList1;
      }
    }
    finally
    {
      while (true)
      {
        Cursor localCursor1 = null;
        continue;
        Object localObject9 = localObject3;
        Object localObject10 = localObject4;
        Object localObject8 = localObject5;
        Object localObject7 = localObject6;
        continue;
        label574: Object localObject3 = localObject9;
        Object localObject4 = localObject10;
        Object localObject5 = localObject8;
        Object localObject6 = localObject7;
      }
    }
  }

  public long a()
  {
    try
    {
      ContentResolver localContentResolver = this.a;
      Uri localUri = BookmarkIpcConstants.d;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = SyncStatusTable.Columns.b.a;
      localCursor2 = localContentResolver.query(localUri, arrayOfString, null, null, null);
      if (localCursor2 == null);
    }
    finally
    {
      try
      {
        long l1;
        if (localCursor2.moveToFirst())
        {
          long l2 = localCursor2.getLong(0);
          l1 = l2;
          if (localCursor2 != null)
            localCursor2.close();
        }
        while (true)
        {
          return l1;
          if (localCursor2 != null)
            localCursor2.close();
          l1 = 0L;
        }
        localObject1 = finally;
        localCursor1 = null;
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject1;
      }
      finally
      {
        Cursor localCursor2;
        Cursor localCursor1 = localCursor2;
      }
    }
  }

  public void a(BookmarksGroup paramBookmarksGroup)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(ContentProviderOperation.newDelete(BookmarkIpcConstants.b).withSelection(BookmarkTable.Columns.i + "=?", new String[] { "pinned" }).build());
    Iterator localIterator = paramBookmarksGroup.a().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Bookmark localBookmark = (Bookmark)localIterator.next();
      ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(BookmarkIpcConstants.b);
      j = i + 1;
      localArrayList.add(localBuilder.withValues(a(localBookmark, paramBookmarksGroup, true, i)).build());
    }
    localArrayList.add(ContentProviderOperation.newUpdate(BookmarkIpcConstants.d).withValue(SyncStatusTable.Columns.b.a, Long.valueOf(System.currentTimeMillis())).build());
    this.a.applyBatch(BookmarkIpcConstants.a, localArrayList);
  }

  public void a(List<BookmarksGroup> paramList, long paramLong)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(ContentProviderOperation.newDelete(BookmarkIpcConstants.b).build());
    localArrayList.add(ContentProviderOperation.newDelete(BookmarkIpcConstants.e).build());
    localArrayList.add(ContentProviderOperation.newUpdate(BookmarkIpcConstants.d).withValue(SyncStatusTable.Columns.a.a, Long.valueOf(paramLong)).withValue(SyncStatusTable.Columns.b.a, Integer.valueOf(0)).build());
    Iterator localIterator = paramList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      BookmarksGroup localBookmarksGroup = (BookmarksGroup)localIterator.next();
      ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(BookmarkIpcConstants.e).withValue(GroupOrderTable.Columns.a.a, localBookmarksGroup.id);
      String str = GroupOrderTable.Columns.b.a;
      j = i + 1;
      localArrayList.add(localBuilder.withValue(str, Integer.valueOf(i)).build());
      a(localArrayList, localBookmarksGroup, localBookmarksGroup.c(), localBookmarksGroup.b());
    }
    this.a.applyBatch(BookmarkIpcConstants.a, localArrayList);
  }

  public boolean a(long paramLong)
  {
    try
    {
      ContentResolver localContentResolver = this.a;
      Uri localUri = BookmarkIpcConstants.b;
      String[] arrayOfString1 = BookmarkTable.b;
      String str = BookmarkTable.Columns.b + "=?";
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = String.valueOf(paramLong);
      Cursor localCursor2 = localContentResolver.query(localUri, arrayOfString1, str, arrayOfString2, null);
      localCursor1 = localCursor2;
      if (localCursor1 == null);
    }
    finally
    {
      try
      {
        int i = localCursor1.getCount();
        if (i > 0)
          if (localCursor1 != null)
            localCursor1.close();
        for (boolean bool = true; ; bool = false)
        {
          return bool;
          if (localCursor1 != null)
            localCursor1.close();
        }
        localObject1 = finally;
        Cursor localCursor1 = null;
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject1;
      }
      finally
      {
      }
    }
  }

  public boolean a(long paramLong, int paramInt)
  {
    int i = 1;
    boolean bool1 = a(paramLong);
    boolean bool2 = false;
    if (!bool1)
      return bool2;
    ArrayList localArrayList = Lists.a();
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newUpdate(BookmarkIpcConstants.c).withValue(BookmarkTable.Columns.h.a, Integer.valueOf(paramInt));
    String str = BookmarkTable.Columns.b.a + "=?";
    String[] arrayOfString = new String[i];
    arrayOfString[0] = String.valueOf(paramLong);
    localArrayList.add(localBuilder.withSelection(str, arrayOfString).build());
    localArrayList.add(ContentProviderOperation.newUpdate(BookmarkIpcConstants.d).withValue(SyncStatusTable.Columns.b.a, Long.valueOf(System.currentTimeMillis() / 1000L)).withExpectedCount(i).build());
    if (this.a.applyBatch(BookmarkIpcConstants.a, localArrayList)[0].count.intValue() > 0);
    while (true)
    {
      bool2 = i;
      break;
      i = 0;
    }
  }

  public long b()
  {
    try
    {
      ContentResolver localContentResolver = this.a;
      Uri localUri = BookmarkIpcConstants.d;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = SyncStatusTable.Columns.a.a;
      Cursor localCursor2 = localContentResolver.query(localUri, arrayOfString, null, null, null);
      localCursor1 = localCursor2;
      if (localCursor1 != null);
      try
      {
        if (localCursor1.moveToFirst())
          break label97;
        throw new SQLException("Can not query " + BookmarkIpcConstants.d);
      }
      finally
      {
      }
      if (localCursor1 != null)
        localCursor1.close();
      throw localObject1;
      label97: long l = localCursor1.getLong(0);
      if (localCursor1 != null)
        localCursor1.close();
      return l;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  public List<BookmarksGroup> c()
  {
    List localList = e();
    a(localList);
    return localList;
  }

  public void d()
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(ContentProviderOperation.newDelete(BookmarkIpcConstants.b).build());
    localArrayList.add(ContentProviderOperation.newDelete(BookmarkIpcConstants.e).build());
    localArrayList.add(ContentProviderOperation.newUpdate(BookmarkIpcConstants.d).withValue(SyncStatusTable.Columns.a.a, Integer.valueOf(0)).withValue(SyncStatusTable.Columns.b.a, Integer.valueOf(0)).build());
    this.a.applyBatch(BookmarkIpcConstants.a, localArrayList);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.provider.DBBookmarkHelper
 * JD-Core Version:    0.6.2
 */