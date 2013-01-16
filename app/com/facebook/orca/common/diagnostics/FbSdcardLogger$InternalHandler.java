package com.facebook.orca.common.diagnostics;

import android.os.Environment;
import com.facebook.orca.debug.BLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

class FbSdcardLogger$InternalHandler
{
  private File b;
  private Writer c;
  private long d;
  private long e;

  private FbSdcardLogger$InternalHandler(FbSdcardLogger paramFbSdcardLogger)
  {
  }

  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "o";
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      return str;
      str = "v";
      continue;
      str = "d";
      continue;
      str = "i";
      continue;
      str = "w";
      continue;
      str = "e";
      continue;
      str = "a";
    }
  }

  private void a()
  {
    monitorenter;
    try
    {
      c();
      Writer localWriter = this.c;
      if (localWriter != null);
      while (true)
      {
        return;
        boolean bool = FbSdcardLogger.c(this.a);
        if (!bool)
          continue;
        try
        {
          long l = System.currentTimeMillis();
          if (l - this.d < 30000L)
            continue;
          this.d = System.currentTimeMillis();
          File localFile = b();
          if (!localFile.exists())
          {
            localFile.mkdirs();
            new File(localFile, ".nomedia").createNewFile();
          }
          this.b = LogFileUtils.a(localFile.getAbsoluteFile(), "debug.log", null, new Date());
          this.c = new BufferedWriter(new FileWriter(this.b), 2048);
          this.e = l;
          BLog.c(FbSdcardLogger.c(), "Opened log.");
        }
        catch (IOException localIOException)
        {
          this.b = null;
          this.c = null;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(int paramInt, String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      a();
      if (this.c != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FbSdcardLogger.b().format(new Date()));
        localStringBuilder.append(" ");
        localStringBuilder.append(a(paramInt));
        localStringBuilder.append("/");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("(").append(Long.toString(Thread.currentThread().getId())).append("): ");
        String str1 = localStringBuilder.toString();
        for (String str2 : paramString2.split("\n"))
        {
          this.c.write(str1);
          this.c.write(str2);
          this.c.write("\n");
        }
        this.c.flush();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        this.b = null;
        this.c = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private File b()
  {
    return new File(Environment.getExternalStorageDirectory(), "/Android/data/" + FbSdcardLogger.d(this.a) + "/files/log/");
  }

  private void c()
  {
    if (this.c == null);
    while (true)
    {
      return;
      if (System.currentTimeMillis() - this.e > 1200000L)
      {
        d();
        continue;
      }
    }
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:c	Ljava/io/Writer;
    //   4: invokevirtual 201	java/io/Writer:close	()V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 91	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:b	Ljava/io/File;
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 41	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:c	Ljava/io/Writer;
    //   17: return
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 91	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:b	Ljava/io/File;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 41	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:c	Ljava/io/Writer;
    //   29: goto -12 -> 17
    //   32: astore_1
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 91	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:b	Ljava/io/File;
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 41	com/facebook/orca/common/diagnostics/FbSdcardLogger$InternalHandler:c	Ljava/io/Writer;
    //   43: aload_1
    //   44: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	18	java/lang/Throwable
    //   0	7	32	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.diagnostics.FbSdcardLogger.InternalHandler
 * JD-Core Version:    0.6.0
 */