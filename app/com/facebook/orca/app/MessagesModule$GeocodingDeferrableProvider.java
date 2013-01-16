package com.facebook.orca.app;

import android.location.Geocoder;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.GeocodingCache;
import com.facebook.orca.location.GeocodingExecutor;

class MessagesModule$GeocodingDeferrableProvider extends AbstractProvider<GeocodingExecutor>
{
  private MessagesModule$GeocodingDeferrableProvider(MessagesModule paramMessagesModule)
  {
  }

  public GeocodingExecutor a()
  {
    return new GeocodingExecutor((Geocoder)b(Geocoder.class), (GeocodingCache)b(GeocodingCache.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GeocodingDeferrableProvider
 * JD-Core Version:    0.6.0
 */