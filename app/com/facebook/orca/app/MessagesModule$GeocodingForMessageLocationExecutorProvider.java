package com.facebook.orca.app;

import com.facebook.location.LocationCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.GeocodingExecutor;
import com.facebook.orca.location.GeocodingForMessageLocationExecutor;

class MessagesModule$GeocodingForMessageLocationExecutorProvider extends AbstractProvider<GeocodingForMessageLocationExecutor>
{
  private MessagesModule$GeocodingForMessageLocationExecutorProvider(MessagesModule paramMessagesModule)
  {
  }

  public GeocodingForMessageLocationExecutor a()
  {
    return new GeocodingForMessageLocationExecutor((LocationCache)b(LocationCache.class), (GeocodingExecutor)b(GeocodingExecutor.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GeocodingForMessageLocationExecutorProvider
 * JD-Core Version:    0.6.0
 */