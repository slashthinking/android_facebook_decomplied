package com.facebook.common.util;

import java.io.File;
import java.io.InputStream;

public class FileUtil
{
  public File a(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }

  public File a(String paramString)
  {
    return new File(paramString);
  }

  public void a(InputStream paramInputStream, File paramFile)
  {
    FileUtils.a(paramInputStream, paramFile);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FileUtil
 * JD-Core Version:    0.6.0
 */