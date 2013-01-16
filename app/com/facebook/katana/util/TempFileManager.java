package com.facebook.katana.util;

import android.net.Uri;
import android.os.Environment;
import com.facebook.common.util.FileUtils;
import com.facebook.common.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TempFileManager
{
  private static final Class<?> a = TempFileManager.class;

  public static Uri a(String paramString)
  {
    boolean bool = c();
    Object localObject = null;
    if (!bool);
    while (true)
    {
      return localObject;
      try
      {
        File localFile = File.createTempFile(".facebook_", ".jpg", d());
        FileUtils.a(new FileInputStream(paramString), localFile);
        Uri localUri = Uri.fromFile(localFile);
        localObject = localUri;
      }
      catch (IOException localIOException)
      {
        Log.c(a, "Cannot add image file: " + paramString, localIOException);
        localObject = null;
      }
    }
  }

  public static void a()
  {
    if (!c());
    while (true)
    {
      return;
      TempFileManager.1 local1 = new TempFileManager.1();
      File[] arrayOfFile = new File[1];
      arrayOfFile[0] = d();
      local1.execute(arrayOfFile);
    }
  }

  private static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  private static File d()
  {
    File localFile2;
    if (!c())
      localFile2 = null;
    while (true)
    {
      return localFile2;
      File localFile1 = Environment.getExternalStorageDirectory();
      localFile2 = new File(localFile1.toString() + "/Android/data/com.facebook.katana/cache/");
      localFile2.mkdirs();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.TempFileManager
 * JD-Core Version:    0.6.0
 */