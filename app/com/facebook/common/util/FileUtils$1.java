package com.facebook.common.util;

import java.io.File;

final class FileUtils$1 extends Thread
{
  public void run()
  {
    String str1 = "";
    File localFile1 = new File(this.a);
    int j;
    int i;
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        int m = arrayOfFile.length;
        int n = 0;
        int i1 = 0;
        while (true)
          if (n < m)
          {
            File localFile2 = arrayOfFile[n];
            try
            {
              if (localFile2.lastModified() <= this.b)
                localFile2.delete();
              n++;
            }
            catch (Exception localException)
            {
              while (true)
              {
                str1 = localException.getMessage();
                i1++;
              }
            }
          }
        j = i1;
        i = k;
      }
    }
    while (true)
    {
      String str2;
      boolean bool;
      if (this.c != null)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(i - j);
        arrayOfObject[1] = Integer.valueOf(i);
        arrayOfObject[2] = this.a;
        str2 = String.format("deleted %d/%d from %s", arrayOfObject);
        bool = false;
        if (j == 0)
          bool = true;
        if (bool)
          break label219;
      }
      label219: for (String str3 = str2 + "(lastError=" + str1 + ")"; ; str3 = str2)
      {
        this.c.a(bool, str3);
        return;
      }
      i = 0;
      j = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FileUtils.1
 * JD-Core Version:    0.6.0
 */