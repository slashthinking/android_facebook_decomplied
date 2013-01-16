package com.facebook.camera.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.facebook.common.util.FileUtil;
import com.facebook.common.util.FileUtils;
import com.facebook.common.util.Log;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Storage
{
  private static final Class<?> a = Storage.class;
  private static final File b = new File(Environment.getExternalStorageDirectory(), "DCIM/Facebook");
  private final FileUtil c;

  public Storage(FileUtil paramFileUtil)
  {
    this.c = ((FileUtil)Preconditions.checkNotNull(paramFileUtil));
  }

  private Uri a(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      if (!b.exists())
        b.mkdirs();
      String str1 = System.currentTimeMillis() + "" + new Random().nextInt(9999);
      File localFile;
      do
      {
        String str2 = a(paramString1, str1, paramString2);
        localFile = this.c.a(b, str2);
      }
      while (localFile.exists());
      Log.e(a, "Next file to use for media: " + Uri.fromFile(localFile).getPath());
      Uri localUri = Uri.fromFile(localFile);
      monitorexit;
      return localUri;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private String a(String paramString1, String paramString2, String paramString3)
  {
    return paramString1 + "_" + paramString2 + paramString3;
  }

  public Uri a(byte[] paramArrayOfByte)
  {
    Uri localUri = c();
    File localFile = new File(localUri.getPath());
    try
    {
      FileUtils.a(paramArrayOfByte, localFile);
      return localUri;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.a(a, "Unable to write to file ", localIOException);
    }
  }

  public String a(Uri paramUri, ContentResolver paramContentResolver)
  {
    Object localObject;
    if ("file".equals(paramUri.getScheme()))
      localObject = paramUri.getPath();
    while (true)
    {
      return localObject;
      try
      {
        Cursor localCursor = paramContentResolver.query(paramUri, new String[] { "_data" }, null, null, null);
        int i = localCursor.getColumnIndexOrThrow("_data");
        localCursor.moveToFirst();
        String str = localCursor.getString(i);
        localObject = str;
      }
      catch (Exception localException)
      {
        Log.c(a, "Error getting photo path", localException);
        localObject = null;
      }
    }
  }

  public boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }

  public Uri b()
  {
    return a("FB_VID", ".3gp");
  }

  public String b(Uri paramUri, ContentResolver paramContentResolver)
  {
    Object localObject;
    if ("file".equals(paramUri.getScheme()))
      localObject = paramUri.getPath();
    while (true)
    {
      return localObject;
      try
      {
        Cursor localCursor = paramContentResolver.query(paramUri, new String[] { "_data" }, null, null, null);
        if (localCursor == null)
        {
          localObject = null;
          continue;
        }
        int i = localCursor.getColumnIndexOrThrow("_data");
        localCursor.moveToFirst();
        String str = localCursor.getString(i);
        localObject = str;
      }
      catch (Exception localException)
      {
        Log.c(a, "Error getting video path", localException);
        localObject = null;
      }
    }
  }

  public Uri c()
  {
    return a("FB_IMG", ".jpg");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.utils.Storage
 * JD-Core Version:    0.6.0
 */