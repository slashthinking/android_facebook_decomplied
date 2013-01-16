package com.facebook.katana.util;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.app.INeedInit;

public class FbandroidErrorReportingInitializer
  implements INeedInit
{
  private final FbErrorReporter a;

  public FbandroidErrorReportingInitializer(FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramFbErrorReporter;
  }

  public void i_()
  {
    ErrorReporting.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FbandroidErrorReportingInitializer
 * JD-Core Version:    0.6.0
 */