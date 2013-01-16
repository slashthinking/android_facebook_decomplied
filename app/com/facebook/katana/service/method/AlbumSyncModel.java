package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.Factory;
import com.facebook.katana.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AlbumSyncModel
{
  private static boolean a = false;

  public static Cursor a(ContentResolver paramContentResolver, long paramLong)
  {
    return paramContentResolver.query(Uri.withAppendedPath(PhotosProvider.g, "" + paramLong), AlbumSyncModel.AlbumsQuery.a, null, null, null);
  }

  public static Cursor a(ContentResolver paramContentResolver, Collection<FacebookAlbum> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("aid").append(" IN(");
    Iterator localIterator = paramCollection.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      FacebookAlbum localFacebookAlbum = (FacebookAlbum)localIterator.next();
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuilder.append('\'');
        localStringBuilder.append(localFacebookAlbum.a());
        localStringBuilder.append('\'');
        break;
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    return paramContentResolver.query(PhotosProvider.e, AlbumSyncModel.AlbumsQuery.a, localStringBuilder.toString(), null, null);
  }

  public static AlbumSyncModel.Result a(ContentResolver paramContentResolver, Collection<FacebookAlbum> paramCollection, Factory<Cursor> paramFactory, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong)
  {
    monitorenter;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    HashMap localHashMap;
    try
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      a("received " + paramCollection.size() + " albums");
      localHashMap = new HashMap();
      Iterator localIterator1 = paramCollection.iterator();
      while (localIterator1.hasNext())
      {
        FacebookAlbum localFacebookAlbum3 = (FacebookAlbum)localIterator1.next();
        localHashMap.put(localFacebookAlbum3.a(), localFacebookAlbum3);
      }
    }
    finally
    {
      monitorexit;
    }
    Cursor localCursor = (Cursor)paramFactory.b();
    int j;
    int k;
    String str3;
    FacebookAlbum localFacebookAlbum2;
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getColumnIndex("aid");
      j = localCursor.getColumnIndex("modified");
      k = localCursor.getColumnIndex("cover_url");
      str3 = localCursor.getString(i);
      localFacebookAlbum2 = (FacebookAlbum)localHashMap.get(str3);
      if (localFacebookAlbum2 != null)
        break label401;
      if (paramBoolean3)
        localArrayList3.add(str3);
    }
    label401: String str4;
    String str5;
    while (true)
    {
      localHashMap.remove(str3);
      if (localCursor.moveToNext())
        break;
      localCursor.close();
      if (paramBoolean1)
        localArrayList1.addAll(localHashMap.values());
      a("found " + localArrayList1.size() + " albums to add, " + localArrayList2.size() + " albums to update, and " + localArrayList3.size() + " albums to delete");
      if (!paramBoolean4)
        break label662;
      Iterator localIterator2 = localArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        String str2 = ((FacebookAlbum)localIterator2.next()).b();
        if (str2 == null)
          continue;
        localArrayList4.add(str2);
      }
      if (localFacebookAlbum2.f() == localCursor.getLong(j))
        continue;
      str4 = localFacebookAlbum2.k();
      str5 = localCursor.getString(k);
      if ((str4 != null) || (str5 != null))
        break label466;
      localFacebookAlbum2.a(false);
      localArrayList2.add(localFacebookAlbum2);
    }
    label466: if ((str4 != null) && (str5 != null))
      if (str4.equals(str5))
        break label687;
    label662: label687: for (boolean bool = true; ; bool = false)
    {
      localFacebookAlbum2.a(bool);
      break;
      localFacebookAlbum2.a(true);
      break;
      Iterator localIterator3 = localArrayList2.iterator();
      while (localIterator3.hasNext())
      {
        FacebookAlbum localFacebookAlbum1 = (FacebookAlbum)localIterator3.next();
        if (!localFacebookAlbum1.o())
          continue;
        String str1 = localFacebookAlbum1.b();
        if (str1 == null)
          continue;
        localArrayList4.add(str1);
      }
      AlbumSyncModel.Result localResult;
      if (localArrayList4.size() == 0)
      {
        a("no covers missing");
        a(paramContentResolver, localArrayList1, localArrayList2, localArrayList3, paramLong);
        localResult = new AlbumSyncModel.Result(true);
      }
      while (true)
      {
        monitorexit;
        return localResult;
        a("missing " + localArrayList4.size() + " covers");
        localResult = new AlbumSyncModel.Result(localArrayList4);
        continue;
        a(paramContentResolver, localArrayList1, localArrayList2, localArrayList3, paramLong);
        localResult = new AlbumSyncModel.Result(true);
      }
    }
  }

  private static void a(ContentResolver paramContentResolver, Collection<FacebookAlbum> paramCollection1, Collection<FacebookAlbum> paramCollection2, Collection<String> paramCollection, long paramLong)
  {
    Uri localUri1;
    if (-1L != paramLong)
      localUri1 = Uri.withAppendedPath(PhotosProvider.g, Long.toString(paramLong));
    while (paramCollection1.size() > 0)
    {
      ContentValues[] arrayOfContentValues = new ContentValues[paramCollection1.size()];
      Iterator localIterator4 = paramCollection1.iterator();
      int k = 0;
      while (true)
        if (localIterator4.hasNext())
        {
          FacebookAlbum localFacebookAlbum2 = (FacebookAlbum)localIterator4.next();
          ContentValues localContentValues2 = new ContentValues();
          arrayOfContentValues[k] = localContentValues2;
          int m = k + 1;
          String[] arrayOfString3 = localFacebookAlbum2.n();
          String str4 = null;
          if (arrayOfString3 != null)
            str4 = StringUtils.a(",", (Object[])localFacebookAlbum2.n());
          localContentValues2.put("aid", localFacebookAlbum2.a());
          localContentValues2.put("cover_pid", localFacebookAlbum2.b());
          localContentValues2.put("cover_url", localFacebookAlbum2.k());
          localContentValues2.put("owner", Long.valueOf(localFacebookAlbum2.c()));
          localContentValues2.put("name", localFacebookAlbum2.d());
          localContentValues2.put("created", Long.valueOf(localFacebookAlbum2.e()));
          localContentValues2.put("modified", Long.valueOf(localFacebookAlbum2.f()));
          localContentValues2.put("description", localFacebookAlbum2.g());
          localContentValues2.put("location", localFacebookAlbum2.h());
          localContentValues2.put("size", Integer.valueOf(localFacebookAlbum2.i()));
          localContentValues2.put("visibility", localFacebookAlbum2.j());
          localContentValues2.put("type", localFacebookAlbum2.l());
          localContentValues2.put("object_id", Long.valueOf(localFacebookAlbum2.m()));
          localContentValues2.put("pids", str4);
          k = m;
          continue;
          localUri1 = null;
          break;
        }
      paramContentResolver.bulkInsert(PhotosProvider.e, arrayOfContentValues);
    }
    ContentValues localContentValues1;
    FacebookAlbum localFacebookAlbum1;
    if (paramCollection2.size() > 0)
    {
      localContentValues1 = new ContentValues();
      Iterator localIterator1 = paramCollection2.iterator();
      if (localIterator1.hasNext())
      {
        localFacebookAlbum1 = (FacebookAlbum)localIterator1.next();
        localContentValues1.clear();
        String[] arrayOfString1 = localFacebookAlbum1.n();
        String str3 = null;
        if (arrayOfString1 != null)
          str3 = StringUtils.a(",", (Object[])localFacebookAlbum1.n());
        localContentValues1.put("cover_pid", localFacebookAlbum1.b());
        localContentValues1.put("cover_url", localFacebookAlbum1.k());
        localContentValues1.put("name", localFacebookAlbum1.d());
        localContentValues1.put("created", Long.valueOf(localFacebookAlbum1.e()));
        localContentValues1.put("modified", Long.valueOf(localFacebookAlbum1.f()));
        localContentValues1.put("description", localFacebookAlbum1.g());
        localContentValues1.put("location", localFacebookAlbum1.h());
        localContentValues1.put("size", Integer.valueOf(localFacebookAlbum1.i()));
        localContentValues1.put("visibility", localFacebookAlbum1.j());
        localContentValues1.put("type", localFacebookAlbum1.l());
        localContentValues1.put("pids", str3);
        if (localFacebookAlbum1.o())
          localContentValues1.put("thumbnail", (byte[])null);
        if (localUri1 != null)
          break label890;
      }
    }
    label890: for (Uri localUri2 = ContentUris.withAppendedId(PhotosProvider.g, localFacebookAlbum1.c()); ; localUri2 = localUri1)
    {
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = localFacebookAlbum1.a();
      paramContentResolver.update(localUri2, localContentValues1, "aid IN(?)", arrayOfString2);
      break;
      if (paramCollection.size() > 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        localStringBuilder1.append("aid").append(" IN(");
        Iterator localIterator2 = paramCollection.iterator();
        int i = 1;
        if (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          if (i != 0)
            i = 0;
          while (true)
          {
            localStringBuilder1.append('\'').append(str2).append('\'');
            break;
            localStringBuilder1.append(',');
          }
        }
        localStringBuilder1.append(')');
        Assert.a(localUri1);
        paramContentResolver.delete(localUri1, localStringBuilder1.toString(), null);
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        localStringBuilder2.append("aid").append(" IN(");
        Iterator localIterator3 = paramCollection.iterator();
        int j = 1;
        if (localIterator3.hasNext())
        {
          String str1 = (String)localIterator3.next();
          if (j != 0)
            j = 0;
          while (true)
          {
            localStringBuilder2.append('\'').append(str1).append('\'');
            break;
            localStringBuilder2.append(',');
          }
        }
        localStringBuilder2.append(')');
        paramContentResolver.delete(PhotosProvider.a, localStringBuilder2.toString(), null);
      }
      return;
    }
  }

  private static void a(String paramString)
  {
    if (a)
      Log.e("AlbumSyncModel", paramString);
  }

  public static void a(Collection<FacebookPhoto> paramCollection, Collection<FacebookAlbum> paramCollection1)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      FacebookPhoto localFacebookPhoto2 = (FacebookPhoto)localIterator1.next();
      localHashMap.put(localFacebookPhoto2.a(), localFacebookPhoto2);
    }
    Iterator localIterator2 = paramCollection1.iterator();
    while (localIterator2.hasNext())
    {
      FacebookAlbum localFacebookAlbum = (FacebookAlbum)localIterator2.next();
      FacebookPhoto localFacebookPhoto1 = (FacebookPhoto)localHashMap.get(localFacebookAlbum.b());
      if (localFacebookPhoto1 == null)
        continue;
      localFacebookAlbum.a(localFacebookPhoto1.h());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AlbumSyncModel
 * JD-Core Version:    0.6.0
 */