package com.facebook.orca.app;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.MessagesUiReorderer;
import com.facebook.orca.threadview.PendingSendsDeduper;
import com.facebook.orca.threadview.ThreadViewLoader;

class MessagesModule$ThreadViewLoaderProvider extends AbstractProvider<ThreadViewLoader>
{
  private MessagesModule$ThreadViewLoaderProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadViewLoader a()
  {
    return new ThreadViewLoader((DataCache)b(DataCache.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), (MessagesUiReorderer)b(MessagesUiReorderer.class), (SendMessageManager)b(SendMessageManager.class), (PendingSendsDeduper)b(PendingSendsDeduper.class), (MessagesCollectionMerger)b(MessagesCollectionMerger.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadViewLoaderProvider
 * JD-Core Version:    0.6.0
 */