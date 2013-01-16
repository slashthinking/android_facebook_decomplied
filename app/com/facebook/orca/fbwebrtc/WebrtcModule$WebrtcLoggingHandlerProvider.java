package com.facebook.orca.fbwebrtc;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.inject.AbstractProvider;

class WebrtcModule$WebrtcLoggingHandlerProvider extends AbstractProvider<WebrtcLoggingHandler>
{
  private WebrtcModule$WebrtcLoggingHandlerProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcLoggingHandler a()
  {
    return new WebrtcLoggingHandler((AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcLoggingHandlerProvider
 * JD-Core Version:    0.6.0
 */