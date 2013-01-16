package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.photos.tiles.DefaultTilesCache;

class MessagesModule$DefaultTilesCacheProvider extends AbstractProvider<DefaultTilesCache>
{
  private MessagesModule$DefaultTilesCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public DefaultTilesCache a()
  {
    return new DefaultTilesCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DefaultTilesCacheProvider
 * JD-Core Version:    0.6.0
 */