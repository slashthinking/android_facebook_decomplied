package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.Factory;
import com.facebook.katana.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhotoSyncModel
{
  private static boolean a = false;

  public static Cursor a(Context paramContext, String paramString)
  {
    Uri localUri = Uri.withAppendedPath(PhotosProvider.c, paramString);
    return paramContext.getContentResolver().query(localUri, PhotoSyncModel.PhotoQuery.a, null, null, null);
  }

  public static Cursor a(Context paramContext, Collection<FacebookPhoto> paramCollection)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("pid").append(" IN(");
    Iterator localIterator = paramCollection.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      FacebookPhoto localFacebookPhoto = (FacebookPhoto)localIterator.next();
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuilder.append('\'');
        localStringBuilder.append(localFacebookPhoto.a());
        localStringBuilder.append('\'');
        break;
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    return localContentResolver.query(PhotosProvider.a, PhotoSyncModel.PhotoQuery.a, localStringBuilder.toString(), null, null);
  }

  private static String a(Collection<String> paramCollection)
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("pid").append(" IN(");
    Iterator localIterator = paramCollection.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuffer.append('\'').append(str).append('\'');
        break;
        localStringBuffer.append(',');
      }
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public static void a(Context paramContext, Collection<FacebookPhoto> paramCollection, Factory<Cursor> paramFactory, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    monitorenter;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    boolean bool2;
    HashMap localHashMap;
    while (true)
    {
      try
      {
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        if (paramString != null)
        {
          bool1 = true;
          bool2 = paramBoolean3 & bool1;
          a("merging " + paramCollection.size() + " photos");
          localHashMap = new HashMap();
          Iterator localIterator1 = paramCollection.iterator();
          if (!localIterator1.hasNext())
            break;
          FacebookPhoto localFacebookPhoto4 = (FacebookPhoto)localIterator1.next();
          localHashMap.put(localFacebookPhoto4.a(), localFacebookPhoto4);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      boolean bool1 = false;
    }
    Cursor localCursor = (Cursor)paramFactory.b();
    String str;
    FacebookPhoto localFacebookPhoto3;
    if (localCursor.moveToFirst())
    {
      int m = localCursor.getColumnIndex("pid");
      str = localCursor.getString(m);
      localFacebookPhoto3 = (FacebookPhoto)localHashMap.get(str);
      if (localFacebookPhoto3 != null)
        break label301;
      if (bool2)
        localArrayList3.add(str);
    }
    while (true)
    {
      localHashMap.remove(str);
      if (localCursor.moveToNext())
        break;
      localCursor.close();
      if (!paramBoolean1)
        break label329;
      Iterator localIterator4 = localHashMap.values().iterator();
      while (localIterator4.hasNext())
        localArrayList1.add((FacebookPhoto)localIterator4.next());
      label301: if ((a(localFacebookPhoto3, localCursor)) || (!paramBoolean2))
        continue;
      localArrayList2.add(localFacebookPhoto3);
    }
    label329: if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0) || (localArrayList3.size() > 0))
      a("adding " + localArrayList1.size() + " photos, updating " + localArrayList2.size() + ", and deleting " + localArrayList3.size());
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int k;
    if (localArrayList1.size() > 0)
    {
      ContentValues[] arrayOfContentValues = new ContentValues[localArrayList1.size()];
      Iterator localIterator3 = localArrayList1.iterator();
      int j = 0;
      while (localIterator3.hasNext())
      {
        FacebookPhoto localFacebookPhoto2 = (FacebookPhoto)localIterator3.next();
        ContentValues localContentValues2 = new ContentValues();
        arrayOfContentValues[j] = localContentValues2;
        j++;
        localContentValues2.put("pid", localFacebookPhoto2.a());
        localContentValues2.put("aid", localFacebookPhoto2.b());
        localContentValues2.put("owner", Long.valueOf(localFacebookPhoto2.c()));
        localContentValues2.put("src", localFacebookPhoto2.f());
        localContentValues2.put("src_big", localFacebookPhoto2.g());
        localContentValues2.put("src_small", localFacebookPhoto2.h());
        localContentValues2.put("caption", localFacebookPhoto2.d());
        localContentValues2.put("created", Long.valueOf(localFacebookPhoto2.e()));
        localContentValues2.put("position", Long.valueOf(localFacebookPhoto2.m()));
        localContentValues2.put("object_id", Long.valueOf(localFacebookPhoto2.j()));
        if (!localFacebookPhoto2.l())
          break label939;
        k = 1;
        localContentValues2.put("can_tag", Integer.valueOf(k));
      }
      localContentResolver.bulkInsert(PhotosProvider.a, arrayOfContentValues);
    }
    ContentValues localContentValues1;
    label695: FacebookPhoto localFacebookPhoto1;
    if (localArrayList2.size() > 0)
    {
      localContentValues1 = new ContentValues();
      Iterator localIterator2 = localArrayList2.iterator();
      if (localIterator2.hasNext())
      {
        localFacebookPhoto1 = (FacebookPhoto)localIterator2.next();
        localContentValues1.clear();
        localContentValues1.put("aid", localFacebookPhoto1.b());
        localContentValues1.put("owner", Long.valueOf(localFacebookPhoto1.c()));
        localContentValues1.put("src", localFacebookPhoto1.f());
        localContentValues1.put("src_big", localFacebookPhoto1.g());
        localContentValues1.put("src_small", localFacebookPhoto1.h());
        localContentValues1.put("caption", localFacebookPhoto1.d());
        localContentValues1.put("created", Long.valueOf(localFacebookPhoto1.e()));
        localContentValues1.put("position", Long.valueOf(localFacebookPhoto1.m()));
        if (!localFacebookPhoto1.l())
          break label945;
      }
    }
    label939: label945: for (int i = 1; ; i = 0)
    {
      localContentValues1.put("can_tag", Integer.valueOf(i));
      localContentResolver.update(Uri.withAppendedPath(PhotosProvider.b, localFacebookPhoto1.a()), localContentValues1, null, null);
      break label695;
      if (localArrayList3.size() > 0)
      {
        Assert.a(paramString);
        localContentResolver.delete(Uri.withAppendedPath(PhotosProvider.c, paramString), a(localArrayList3), null);
      }
      if ((paramBoolean1) && (paramBoolean2) && (bool2))
        Utils.a(paramContext, paramString, paramCollection.size());
      monitorexit;
      return;
      k = 0;
      break;
    }
  }

  private static void a(String paramString)
  {
    if (a)
      Log.e("PhotoSyncModel", paramString);
  }

  private static boolean a(FacebookPhoto paramFacebookPhoto, Cursor paramCursor)
  {
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("caption"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("aid"));
    long l = paramCursor.getLong(paramCursor.getColumnIndex("position"));
    if ((StringUtils.a(paramFacebookPhoto.d(), str1)) && (StringUtils.a(paramFacebookPhoto.b(), str2)) && (paramFacebookPhoto.m() == l));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static Factory<Cursor> b(Context paramContext, String paramString)
  {
    return new PhotoSyncModel.1(paramContext, paramString);
  }

  public static Factory<Cursor> b(Context paramContext, Collection<FacebookPhoto> paramCollection)
  {
    return new PhotoSyncModel.2(paramContext, paramCollection);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotoSyncModel
 * JD-Core Version:    0.6.0
 */