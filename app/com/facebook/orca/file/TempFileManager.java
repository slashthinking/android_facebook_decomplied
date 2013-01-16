package com.facebook.orca.file;

import android.content.Context;
import android.os.Environment;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;

public class TempFileManager
{
  private static File b;
  private static File c;
  private long a = 86400000L;

  public TempFileManager(Context paramContext)
  {
    b = new File(paramContext.getCacheDir(), "/orcatemp");
    c = new File(Environment.getExternalStorageDirectory(), "/orcatemp");
  }

  private File a(String paramString1, String paramString2, File paramFile)
  {
    boolean bool1 = a(paramFile);
    Object localObject = null;
    if (!bool1);
    while (true)
    {
      return localObject;
      if ((paramString1 == null) || (paramString1.trim().length() == 0))
        paramString1 = "";
      if ((paramString2 == null) || (paramString2.trim().length() == 0))
        paramString2 = ".tmp";
      String str = "";
      try
      {
        File localFile;
        boolean bool2;
        do
        {
          str = paramString1 + SystemClock.b().a() + "_tmp" + paramString2;
          localFile = new File(paramFile, str);
          bool2 = localFile.createNewFile();
        }
        while (!bool2);
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramFile.getName();
        BLog.d("Orca:TempFileManager", StringLocaleUtil.a("Error occurred when creating the temporary file %s in directory %s.", arrayOfObject), localIOException);
        localObject = null;
      }
    }
  }

  private boolean a(File paramFile)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramFile != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (!paramFile.exists())
        break label52;
      if ((!paramFile.isDirectory()) || (!paramFile.canRead()) || (!paramFile.canWrite()))
        break label47;
    }
    while (true)
    {
      return bool1;
      bool2 = false;
      break;
      label47: bool1 = false;
      continue;
      label52: bool1 = paramFile.mkdirs();
    }
  }

  private void b(File paramFile)
  {
    long l = SystemClock.b().a();
    File[] arrayOfFile = paramFile.listFiles(new TempFileManager.TempFileFilter());
    if (arrayOfFile == null);
    while (true)
    {
      return;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        if (l - localFile.lastModified() <= this.a)
          continue;
        localFile.delete();
      }
    }
  }

  static boolean b()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public File a(String paramString1, String paramString2, Boolean paramBoolean)
  {
    if ((paramBoolean.booleanValue()) || (!b()));
    for (File localFile = a(paramString1, paramString2, b); ; localFile = a(paramString1, paramString2, c))
      return localFile;
  }

  public void a()
  {
    b(c);
    b(b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.file.TempFileManager
 * JD-Core Version:    0.6.0
 */