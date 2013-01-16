package com.facebook.orca.app;

import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$FbErrorReporterProvider extends AbstractProvider<FbErrorReporter>
{
  private FbBaseModule$FbErrorReporterProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FbErrorReporter a()
  {
    return new FbErrorReporterImpl(a(TriState.class, IsMeUserAnEmployee.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.FbErrorReporterProvider
 * JD-Core Version:    0.6.0
 */