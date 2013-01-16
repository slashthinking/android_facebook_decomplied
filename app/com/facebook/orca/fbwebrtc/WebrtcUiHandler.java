package com.facebook.orca.fbwebrtc;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.content.SecureContextHelper;
import com.facebook.webrtc.IWebrtcUiInterface;

public class WebrtcUiHandler
  implements IWebrtcUiInterface
{
  private static final Class<?> a = WebrtcUiHandler.class;
  private final Context b;
  private final LocalBroadcastManager c;
  private final SecureContextHelper d;
  private WebrtcNotificationManager e;
  private int f;

  public WebrtcUiHandler(Context paramContext, LocalBroadcastManager paramLocalBroadcastManager, SecureContextHelper paramSecureContextHelper, WebrtcNotificationManager paramWebrtcNotificationManager)
  {
    this.b = paramContext;
    this.c = paramLocalBroadcastManager;
    this.d = paramSecureContextHelper;
    this.e = paramWebrtcNotificationManager;
    this.f = 0;
  }

  public int a()
  {
    return this.f;
  }

  void a(int paramInt)
  {
    this.f = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcUiHandler
 * JD-Core Version:    0.6.0
 */