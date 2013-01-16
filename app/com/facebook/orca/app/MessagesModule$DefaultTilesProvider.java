package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.photos.tiles.DefaultTiles;
import com.facebook.orca.photos.tiles.DefaultTilesCache;
import com.facebook.orca.threads.ThreadParticipantUtils;

class MessagesModule$DefaultTilesProvider extends AbstractProvider<DefaultTiles>
{
  private MessagesModule$DefaultTilesProvider(MessagesModule paramMessagesModule)
  {
  }

  public DefaultTiles a()
  {
    return new DefaultTiles((Resources)b(Resources.class), (DefaultTilesCache)b(DefaultTilesCache.class), (ThreadParticipantUtils)b(ThreadParticipantUtils.class), (ThreadDisplayCache)b(ThreadDisplayCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DefaultTilesProvider
 * JD-Core Version:    0.6.0
 */