package org.acra;

import java.io.File;
import java.io.FilenameFilter;

class ErrorReporter$2
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".stacktrace");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ErrorReporter.2
 * JD-Core Version:    0.6.0
 */