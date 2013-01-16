package com.facebook.katana.binding;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import com.facebook.katana.provider.PhotosProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StreamPhotosCache
{
  private final Map<String, StreamPhoto> a = new HashMap();
  private final StreamPhotosCache.PhotosContainerListener b;
  private final List<StreamPhoto> c = new ArrayList();
  private final Map<String, String> d = new HashMap();
  private long e;
  private WorkerThread f;

  protected StreamPhotosCache(StreamPhotosCache.PhotosContainerListener paramPhotosContainerListener)
  {
    this.b = paramPhotosContainerListener;
  }

  public static Map<String, StreamPhoto> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Cursor localCursor = paramContext.getContentResolver().query(PhotosProvider.i, StreamPhotosCache.StreamPhotoQuery.a, null, null, null);
    if (localCursor != null)
      if (!localCursor.moveToFirst());
    while (true)
    {
      Uri localUri = Uri.withAppendedPath(PhotosProvider.i, "" + localCursor.getInt(localCursor.getColumnIndex("_id")));
      String str1 = localCursor.getString(localCursor.getColumnIndex("filename"));
      File localFile = new File(str1);
      if (localFile.exists())
      {
        String str2 = localCursor.getString(localCursor.getColumnIndex("url"));
        localHashMap.put(str2, new StreamPhoto(localUri, str2, str1, localFile.length(), null));
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        return localHashMap;
        paramContext.getContentResolver().delete(localUri, null, null);
      }
    }
  }

  private void a(Context paramContext, long paramLong)
  {
    this.c.addAll(this.a.values());
    Collections.sort(this.c, new StreamPhotosCache.2(this));
    Iterator localIterator = this.c.iterator();
    monitorenter;
    try
    {
      do
      {
        if (!localIterator.hasNext())
          break;
        StreamPhoto localStreamPhoto = (StreamPhoto)localIterator.next();
        this.a.remove(localStreamPhoto.b());
        paramContext.getContentResolver().delete(localStreamPhoto.a(), null, null);
        this.e -= localStreamPhoto.d();
      }
      while ((this.e > paramLong) || (this.a.size() >= 100L));
      monitorexit;
      this.c.clear();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Bitmap a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 1);
  }

  public Bitmap a(Context paramContext, String paramString, int paramInt)
  {
    monitorenter;
    while (true)
    {
      Bitmap localBitmap2;
      try
      {
        StreamPhoto localStreamPhoto = (StreamPhoto)this.a.get(paramString);
        if (localStreamPhoto == null)
          continue;
        localStreamPhoto.f();
        localBitmap2 = localStreamPhoto.g();
        if (localBitmap2 == null)
        {
          a(localStreamPhoto, this.b);
          localBitmap1 = localBitmap2;
          return localBitmap1;
          if (this.d.containsKey(paramString))
            continue;
          this.b.a(paramContext, paramString, paramInt);
          this.d.put(paramString, paramString);
          localBitmap1 = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Bitmap localBitmap1 = localBitmap2;
    }
  }

  protected StreamPhoto a(Context paramContext, int paramInt, String paramString, StreamPhoto paramStreamPhoto)
  {
    long l;
    if (paramInt == 200)
    {
      l = paramStreamPhoto.d();
      if (l < 500000L)
      {
        if ((l + this.e > 500000L) || (this.a.size() >= 100L))
          a(paramContext, 500000L - l);
        monitorenter;
      }
    }
    try
    {
      this.a.put(paramStreamPhoto.b(), paramStreamPhoto);
      this.e = (l + this.e);
      monitorexit;
      this.d.remove(paramString);
      return paramStreamPhoto;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected void a()
  {
    this.a.clear();
    this.d.clear();
    this.f = null;
  }

  protected void a(Context paramContext, WorkerThread paramWorkerThread)
  {
    this.f = paramWorkerThread;
    new Thread(new StreamPhotosCache.1(this, paramContext)).start();
  }

  public void a(StreamPhoto paramStreamPhoto, StreamPhotosCache.PhotosContainerListener paramPhotosContainerListener)
  {
    this.f.a().post(new StreamPhotosCache.3(this, paramStreamPhoto, paramPhotosContainerListener));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.StreamPhotosCache
 * JD-Core Version:    0.6.0
 */