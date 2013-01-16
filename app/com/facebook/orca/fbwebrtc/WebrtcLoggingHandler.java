package com.facebook.orca.fbwebrtc;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.debug.WtfToken;
import com.facebook.webrtc.IWebrtcLoggingInterface;

public class WebrtcLoggingHandler
  implements IWebrtcLoggingInterface
{
  private static final Class<?> a = WebrtcLoggingHandler.class;
  private static final WtfToken b = new WtfToken();
  private static final WtfToken c = new WtfToken();
  private final AnalyticsLogger d;

  public WebrtcLoggingHandler(AnalyticsLogger paramAnalyticsLogger)
  {
    this.d = paramAnalyticsLogger;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcLoggingHandler
 * JD-Core Version:    0.6.0
 */