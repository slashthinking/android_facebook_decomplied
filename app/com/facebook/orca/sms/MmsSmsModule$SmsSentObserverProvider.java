package com.facebook.orca.sms;

import android.content.Context;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaForegroundActivityListener;
import com.facebook.orca.sms.observe.ExternalSmsOperationsHandler;
import com.facebook.orca.sms.observe.ExternalSmsOperationsObserver;

class MmsSmsModule$SmsSentObserverProvider extends AbstractProvider<ExternalSmsOperationsObserver>
{
  private MmsSmsModule$SmsSentObserverProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public ExternalSmsOperationsObserver a()
  {
    return new ExternalSmsOperationsObserver(MmsSmsModule.a(this.a).getContentResolver(), (ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (OrcaForegroundActivityListener)b(OrcaForegroundActivityListener.class), a(Boolean.class, IsClientSmsEnabled.class), (ExternalSmsOperationsHandler)b(ExternalSmsOperationsHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.SmsSentObserverProvider
 * JD-Core Version:    0.6.0
 */