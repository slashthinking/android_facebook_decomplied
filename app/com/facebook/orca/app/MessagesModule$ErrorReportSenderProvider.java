package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.debug.ErrorReportSender;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ErrorReportSenderProvider extends AbstractProvider<ErrorReportSender>
{
  private MessagesModule$ErrorReportSenderProvider(MessagesModule paramMessagesModule)
  {
  }

  public ErrorReportSender a()
  {
    return new ErrorReportSender((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ErrorReportSenderProvider
 * JD-Core Version:    0.6.0
 */