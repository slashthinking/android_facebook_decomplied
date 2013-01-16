package com.facebook.orca.app;

import com.facebook.location.LocationCache;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.AppConfigCache;
import com.facebook.orca.cache.ChatVisibilityCache;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$DataCacheProvider extends AbstractProvider<DataCache>
{
  private MessagesModule$DataCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public DataCache a()
  {
    return new DataCache((MeUserAuthDataStore)b(MeUserAuthDataStore.class), (ThreadsCache)b(ThreadsCache.class), (LocationCache)b(LocationCache.class), (AppConfigCache)b(AppConfigCache.class), (ChatVisibilityCache)b(ChatVisibilityCache.class), (ThreadsCacheUpdateRateLimiter)b(ThreadsCacheUpdateRateLimiter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DataCacheProvider
 * JD-Core Version:    0.6.0
 */