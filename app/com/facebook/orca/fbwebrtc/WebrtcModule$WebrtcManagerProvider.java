package com.facebook.orca.fbwebrtc;

import com.facebook.orca.annotations.IsVoipEnabledForUser;
import com.facebook.orca.inject.AbstractProvider;

class WebrtcModule$WebrtcManagerProvider extends AbstractProvider<WebrtcManager>
{
  private WebrtcModule$WebrtcManagerProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcManager a()
  {
    return new WebrtcManager(a(Boolean.class, IsVoipEnabledForUser.class), (WebrtcSignalingHandler)b(WebrtcSignalingHandler.class), (WebrtcUiHandler)b(WebrtcUiHandler.class), (WebrtcLoggingHandler)b(WebrtcLoggingHandler.class), a(WebrtcConfig.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcManagerProvider
 * JD-Core Version:    0.6.0
 */