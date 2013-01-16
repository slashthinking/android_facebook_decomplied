package com.facebook.orca.app;

import com.facebook.orca.cache.ChatVisibilityCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ChatVisiblityCacheProvider extends AbstractProvider<ChatVisibilityCache>
{
  private MessagesModule$ChatVisiblityCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public ChatVisibilityCache a()
  {
    return new ChatVisibilityCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ChatVisiblityCacheProvider
 * JD-Core Version:    0.6.0
 */