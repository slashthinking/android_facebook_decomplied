package com.facebook.orca.fbwebrtc;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class WebrtcModule$WebrtcUiHandlerProvider extends AbstractProvider<WebrtcUiHandler>
{
  private WebrtcModule$WebrtcUiHandlerProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcUiHandler a()
  {
    return new WebrtcUiHandler((Context)b(Context.class, FromApplication.class), (LocalBroadcastManager)b(LocalBroadcastManager.class), (SecureContextHelper)b(SecureContextHelper.class), (WebrtcNotificationManager)b(WebrtcNotificationManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcUiHandlerProvider
 * JD-Core Version:    0.6.0
 */