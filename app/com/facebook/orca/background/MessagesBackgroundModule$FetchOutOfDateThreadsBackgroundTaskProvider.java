package com.facebook.orca.background;

import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class MessagesBackgroundModule$FetchOutOfDateThreadsBackgroundTaskProvider extends AbstractProvider<FetchOutOfDateThreadsBackgroundTask>
{
  private MessagesBackgroundModule$FetchOutOfDateThreadsBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public FetchOutOfDateThreadsBackgroundTask a()
  {
    return new FetchOutOfDateThreadsBackgroundTask((MeUserAuthDataStore)b(MeUserAuthDataStore.class), (DbCache)b(DbCache.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (LocalBroadcastManager)b(LocalBroadcastManager.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.FetchOutOfDateThreadsBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */