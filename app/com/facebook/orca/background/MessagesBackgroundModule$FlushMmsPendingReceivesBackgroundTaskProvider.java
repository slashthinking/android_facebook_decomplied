package com.facebook.orca.background;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.sms.MmsSmsContentResolverHandler;

class MessagesBackgroundModule$FlushMmsPendingReceivesBackgroundTaskProvider extends AbstractProvider<FlushMmsPendingReceivesBackgroundTask>
{
  private MessagesBackgroundModule$FlushMmsPendingReceivesBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public FlushMmsPendingReceivesBackgroundTask a()
  {
    return new FlushMmsPendingReceivesBackgroundTask((Context)b(Context.class, FromApplication.class), (MmsSmsContentResolverHandler)b(MmsSmsContentResolverHandler.class), (ReadThreadManager)b(ReadThreadManager.class), a(Boolean.class, IsClientSmsEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.FlushMmsPendingReceivesBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */