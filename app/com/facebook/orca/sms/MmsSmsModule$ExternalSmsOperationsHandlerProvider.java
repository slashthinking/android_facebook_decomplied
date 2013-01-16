package com.facebook.orca.sms;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.sms.observe.ExternalSmsOperationsHandler;

class MmsSmsModule$ExternalSmsOperationsHandlerProvider extends AbstractProvider<ExternalSmsOperationsHandler>
{
  private MmsSmsModule$ExternalSmsOperationsHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public ExternalSmsOperationsHandler a()
  {
    return new ExternalSmsOperationsHandler((MmsSmsLogger)b(MmsSmsLogger.class), (OrcaServiceOperation)b(OrcaServiceOperation.class, FromApplication.class), (OrcaDataManager)b(OrcaDataManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.ExternalSmsOperationsHandlerProvider
 * JD-Core Version:    0.6.0
 */