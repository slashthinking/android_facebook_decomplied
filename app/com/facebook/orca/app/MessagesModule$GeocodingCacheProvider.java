package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.GeocodingCache;

class MessagesModule$GeocodingCacheProvider extends AbstractProvider<GeocodingCache>
{
  private MessagesModule$GeocodingCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public GeocodingCache a()
  {
    return new GeocodingCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GeocodingCacheProvider
 * JD-Core Version:    0.6.0
 */