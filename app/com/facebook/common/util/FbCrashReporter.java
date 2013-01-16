package com.facebook.common.util;

import android.app.Application;
import org.acra.reporter.BaseCrashReporter;

public class FbCrashReporter extends BaseCrashReporter
{
  public FbCrashReporter(Application paramApplication)
  {
    super(paramApplication);
  }

  public boolean checkSSLCertsOnCrashReport()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbCrashReporter
 * JD-Core Version:    0.6.0
 */