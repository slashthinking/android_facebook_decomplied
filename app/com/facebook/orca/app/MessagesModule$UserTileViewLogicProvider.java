package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.orca.photos.tiles.UserTileViewLogic;

class MessagesModule$UserTileViewLogicProvider extends AbstractProvider<UserTileViewLogic>
{
  private MessagesModule$UserTileViewLogicProvider(MessagesModule paramMessagesModule)
  {
  }

  public UserTileViewLogic a()
  {
    return new UserTileViewLogic((DataCache)b(DataCache.class), (GraphicSizerFactory)b(GraphicSizerFactory.class), a(PlatformAppHttpConfig.class), MessagesModule.a(this.a).getContentResolver());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UserTileViewLogicProvider
 * JD-Core Version:    0.6.0
 */