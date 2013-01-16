package org.acra.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public class Installation
{
  private static final String INSTALLATION = "ACRA-INSTALLATION";
  private static String sID = null;

  public static String id(Context paramContext)
  {
    monitorenter;
    try
    {
      File localFile;
      if (sID == null)
        localFile = new File(paramContext.getFilesDir(), "ACRA-INSTALLATION");
      try
      {
        if (!localFile.exists())
          writeInstallationFile(localFile);
        sID = readInstallationFile(localFile);
        String str = sID;
        monitorexit;
        return str;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String readInstallationFile(File paramFile)
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)localRandomAccessFile.length()];
    try
    {
      localRandomAccessFile.readFully(arrayOfByte);
      return new String(arrayOfByte);
    }
    finally
    {
      localRandomAccessFile.close();
    }
    throw localObject;
  }

  private static void writeInstallationFile(File paramFile)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      localFileOutputStream.write(UUID.randomUUID().toString().getBytes());
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.Installation
 * JD-Core Version:    0.6.0
 */