package com.facebook.katana.orca;

import android.os.Handler;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaForegroundActivityListener;

class FbandroidMessengerAppModule$FbandroidPushHandlerProvider extends AbstractProvider<FbandroidPushHandler>
{
  private FbandroidMessengerAppModule$FbandroidPushHandlerProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public FbandroidPushHandler a()
  {
    return new FbandroidPushHandler((Handler)b(Handler.class), (OrcaForegroundActivityListener)b(OrcaForegroundActivityListener.class), FbandroidMessengerAppModule.a(this.a), (BookmarkManager)b(BookmarkManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.FbandroidPushHandlerProvider
 * JD-Core Version:    0.6.0
 */