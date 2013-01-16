package com.facebook.bugreporter;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.Log;
import com.facebook.orca.debug.BLog;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;

public class BugReporterFileUtil
{
  private static final Class<?> a = BugReporterFileUtil.class;
  private final Context b;
  private final Executor c;

  public BugReporterFileUtil(Context paramContext, Executor paramExecutor)
  {
    this.b = paramContext;
    this.c = paramExecutor;
  }

  public File a()
  {
    File localFile = new File(this.b.getExternalCacheDir(), "bugreports");
    Object localObject1 = null;
    while (true)
      try
      {
        localObject2 = new File(localFile, String.valueOf(System.nanoTime()));
      }
      catch (NullPointerException localNullPointerException3)
      {
        try
        {
          if (((File)localObject2).exists())
            continue;
          boolean bool = ((File)localObject2).mkdirs();
          if (bool)
            continue;
          localObject2 = null;
          return localObject2;
          localNullPointerException3 = localNullPointerException3;
          NullPointerException localNullPointerException1 = localNullPointerException3;
          localObject2 = localObject1;
          BLog.e(a, "Exception caught in createReportDirectory: " + localNullPointerException1);
          continue;
        }
        catch (NullPointerException localNullPointerException2)
        {
          Object localObject2;
          continue;
          localObject1 = localObject2;
        }
      }
  }

  public void a(Uri paramUri)
  {
    this.c.execute(new BugReporterFileUtil.1(this, paramUri));
  }

  public void b(Uri paramUri)
  {
    try
    {
      File localFile1 = new File(new URI(paramUri.toString()));
      File[] arrayOfFile = localFile1.listFiles();
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        j = 0;
        if (j < i)
        {
          File localFile2 = arrayOfFile[j];
          if (!localFile2.exists())
            break label104;
          localFile2.delete();
          break label104;
        }
      }
      localFile1.delete();
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      while (true)
      {
        int j;
        Log.a(a, "Cannot parse Bug Report Directory URI: " + localURISyntaxException);
        continue;
        label104: j++;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterFileUtil
 * JD-Core Version:    0.6.0
 */