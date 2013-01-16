package com.facebook.orca.app;

import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSnippetUtil;

class MessagesModule$ThreadDisplayCacheProvider extends AbstractProvider<ThreadDisplayCache>
{
  private MessagesModule$ThreadDisplayCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadDisplayCache a()
  {
    return new ThreadDisplayCache((DataCache)b(DataCache.class), (AttachmentDataFactory)b(AttachmentDataFactory.class), (ThreadParticipantUtils)b(ThreadParticipantUtils.class), (ThreadSnippetUtil)b(ThreadSnippetUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadDisplayCacheProvider
 * JD-Core Version:    0.6.0
 */