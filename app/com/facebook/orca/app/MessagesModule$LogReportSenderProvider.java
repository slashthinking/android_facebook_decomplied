package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.common.diagnostics.FbSdcardLogger;
import com.facebook.orca.debug.LogReportSender;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$LogReportSenderProvider extends AbstractProvider<LogReportSender>
{
  private MessagesModule$LogReportSenderProvider(MessagesModule paramMessagesModule)
  {
  }

  public LogReportSender a()
  {
    return new LogReportSender((Context)b(Context.class), (FbSdcardLogger)b(FbSdcardLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.LogReportSenderProvider
 * JD-Core Version:    0.6.0
 */