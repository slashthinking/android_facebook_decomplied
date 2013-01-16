package com.facebook.orca.app;

import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.ThreadSummaryStitching;

class MessagesModule$ThreadsCacheProvider extends AbstractProvider<ThreadsCache>
{
  private MessagesModule$ThreadsCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadsCache a()
  {
    return new ThreadsCache((MeUserAuthDataStore)b(MeUserAuthDataStore.class), (MessagesCollectionMerger)b(MessagesCollectionMerger.class), (ThreadSummaryStitching)b(ThreadSummaryStitching.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadsCacheProvider
 * JD-Core Version:    0.6.0
 */