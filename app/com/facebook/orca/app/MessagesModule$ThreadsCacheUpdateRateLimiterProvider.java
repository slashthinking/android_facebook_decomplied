package com.facebook.orca.app;

import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.push.mqtt.MqttConnectionManager;

class MessagesModule$ThreadsCacheUpdateRateLimiterProvider extends AbstractProvider<ThreadsCacheUpdateRateLimiter>
{
  private MessagesModule$ThreadsCacheUpdateRateLimiterProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadsCacheUpdateRateLimiter a()
  {
    return new ThreadsCacheUpdateRateLimiter((ThreadsCache)b(ThreadsCache.class), (MqttConnectionManager)b(MqttConnectionManager.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadsCacheUpdateRateLimiterProvider
 * JD-Core Version:    0.6.0
 */