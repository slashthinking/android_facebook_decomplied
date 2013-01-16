package com.facebook.orca.file;

import java.io.File;
import java.io.FilenameFilter;

class TempFileManager$TempFileFilter
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf("."));
    int i = 0;
    if (str != null)
    {
      boolean bool = str.endsWith("_tmp");
      i = 0;
      if (bool)
        i = 1;
    }
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.file.TempFileManager.TempFileFilter
 * JD-Core Version:    0.6.0
 */