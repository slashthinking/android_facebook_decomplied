package com.facebook.orca.app;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.debug.FbLogImpl;
import com.facebook.orca.debug.FbLogWriter;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$FbLogImplProvider extends AbstractProvider<FbLogImpl>
{
  private FbBaseModule$FbLogImplProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FbLogImpl a()
  {
    return new FbLogImpl(FbBaseModule.c(this.a), c(FbLogWriter.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.FbLogImplProvider
 * JD-Core Version:    0.6.0
 */