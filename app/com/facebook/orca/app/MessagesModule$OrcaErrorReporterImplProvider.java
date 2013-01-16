package com.facebook.orca.app;

import com.facebook.orca.debug.OrcaErrorReporterImpl;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$OrcaErrorReporterImplProvider extends AbstractProvider<OrcaErrorReporterImpl>
{
  private MessagesModule$OrcaErrorReporterImplProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaErrorReporterImpl a()
  {
    return new OrcaErrorReporterImpl();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaErrorReporterImplProvider
 * JD-Core Version:    0.6.0
 */