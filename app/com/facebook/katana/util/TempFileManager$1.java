package com.facebook.katana.util;

import android.os.AsyncTask;
import com.facebook.common.util.Log;
import java.io.File;

final class TempFileManager$1 extends AsyncTask<File, Integer, Object>
{
  protected Object a(File[] paramArrayOfFile)
  {
    long l = System.currentTimeMillis();
    int i = paramArrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile = paramArrayOfFile[j];
      if (!localFile.isDirectory())
        Log.a(TempFileManager.b(), "Attempted to clean a non-directory " + localFile.toString());
      while (true)
      {
        j++;
        break;
        File[] arrayOfFile = localFile.listFiles();
        for (int k = 0; k < arrayOfFile.length; k++)
        {
          if (l - arrayOfFile[k].lastModified() <= 60000L)
            continue;
          arrayOfFile[k].delete();
        }
      }
    }
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.TempFileManager.1
 * JD-Core Version:    0.6.0
 */