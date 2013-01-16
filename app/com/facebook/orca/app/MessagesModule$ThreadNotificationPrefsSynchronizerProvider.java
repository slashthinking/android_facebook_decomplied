package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.ThreadNotificationPrefsSynchronizer;

class MessagesModule$ThreadNotificationPrefsSynchronizerProvider extends AbstractProvider<ThreadNotificationPrefsSynchronizer>
{
  private MessagesModule$ThreadNotificationPrefsSynchronizerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadNotificationPrefsSynchronizer a()
  {
    return new ThreadNotificationPrefsSynchronizer((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperation)b(OrcaServiceOperation.class, FromApplication.class), (DataCache)b(DataCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadNotificationPrefsSynchronizerProvider
 * JD-Core Version:    0.6.0
 */