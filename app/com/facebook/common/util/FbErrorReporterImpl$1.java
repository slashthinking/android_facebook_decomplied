package com.facebook.common.util;

import org.acra.ErrorReporter;

class FbErrorReporterImpl$1
  implements Runnable
{
  public void run()
  {
    try
    {
      monitorenter;
      try
      {
        ErrorReporter localErrorReporter = ErrorReporter.getInstance();
        localErrorReporter.putCustomData("soft_error_category", this.a.replace("\n", "\\n"));
        localErrorReporter.putCustomData("soft_error_message", this.b.replace("\n", "\\n"));
        localErrorReporter.handleException(this.c);
        localErrorReporter.removeCustomData("soft_error_category");
        localErrorReporter.removeCustomData("soft_error_message");
        monitorexit;
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbErrorReporterImpl.1
 * JD-Core Version:    0.6.0
 */