package com.facebook.orca.fbwebrtc;

import com.facebook.orca.auth.UserTokenCredentials;
import com.facebook.orca.inject.AbstractProvider;

class WebrtcModule$WebrtcConfigProvider extends AbstractProvider<WebrtcConfig>
{
  private WebrtcModule$WebrtcConfigProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcConfig a()
  {
    UserTokenCredentials localUserTokenCredentials = (UserTokenCredentials)b(UserTokenCredentials.class);
    if (localUserTokenCredentials == null);
    String str1;
    String str2;
    for (WebrtcConfig localWebrtcConfig = null; ; localWebrtcConfig = new WebrtcConfig("stun.fbsbx.com:3478", "api.facebook.com:443:" + str1 + ":" + str2 + ":0"))
    {
      return localWebrtcConfig;
      str1 = localUserTokenCredentials.a();
      str2 = localUserTokenCredentials.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcConfigProvider
 * JD-Core Version:    0.6.0
 */