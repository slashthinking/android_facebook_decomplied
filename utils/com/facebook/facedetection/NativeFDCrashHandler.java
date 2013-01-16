package com.facebook.facedetection;

import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NativeFDCrashHandler
  implements INeedInit
{
  private Context a;
  private FbErrorReporter b;
  private OrcaSharedPreferences c;

  public NativeFDCrashHandler(Context paramContext, FbErrorReporter paramFbErrorReporter, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramContext;
    this.b = paramFbErrorReporter;
    this.c = paramOrcaSharedPreferences;
  }

  public void i_()
  {
    try
    {
      localFile = new File(this.a.getDir("fd-crash-reports", 0), "fd-crash-report.txt");
      boolean bool = localFile.exists();
      if (!bool);
    }
    catch (Exception localException)
    {
      try
      {
        File localFile;
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        byte[] arrayOfByte = new byte[4];
        localFileInputStream.read(arrayOfByte);
        localFileInputStream.close();
        String str = new String(arrayOfByte).trim();
        Log.d("NativeFDCrashHandler", "Native face detection crashed with error code = " + str);
        this.b.a("Native FD crash", str);
        if (!localFile.delete())
          this.b.a("NativeFDCrashHandler failure", "Could not delete file");
        this.c.a(new NativeFDCrashHandler.1(this));
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        while (true)
        {
          this.b.a("NativeFDCrashHandler failure", "FileNotFoundException");
          continue;
          localException = localException;
          Log.a("NativeFDCrashHandler", "NativeFDCrashHandler failed");
          this.b.a("NativeFDCrashHandler crash", localException.getMessage());
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          Log.a("NativeFDCrashHandler", "Could not read native crash report");
          this.b.a("NativeFDCrashHandler failure", "IOException");
        }
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.NativeFDCrashHandler
 * JD-Core Version:    0.6.2
 */