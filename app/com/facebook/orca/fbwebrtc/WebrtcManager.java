package com.facebook.orca.fbwebrtc;

import com.facebook.orca.debug.BLog;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.webrtc.WebrtcEngine;
import javax.inject.Provider;

public class WebrtcManager
{
  private static final Class<?> a = WebrtcManager.class;
  private final Provider<Boolean> b;
  private final WebrtcSignalingHandler c;
  private final WebrtcUiHandler d;
  private final WebrtcLoggingHandler e;
  private final Provider<WebrtcConfig> f;
  private WebrtcEngine g;

  public WebrtcManager(Provider<Boolean> paramProvider, WebrtcSignalingHandler paramWebrtcSignalingHandler, WebrtcUiHandler paramWebrtcUiHandler, WebrtcLoggingHandler paramWebrtcLoggingHandler, Provider<WebrtcConfig> paramProvider1)
  {
    this.b = paramProvider;
    this.c = paramWebrtcSignalingHandler;
    this.d = paramWebrtcUiHandler;
    this.e = paramWebrtcLoggingHandler;
    this.f = paramProvider1;
  }

  private boolean e()
  {
    boolean bool;
    if (!b())
      bool = false;
    while (true)
    {
      return bool;
      if (this.g == null)
      {
        WebrtcConfig localWebrtcConfig = (WebrtcConfig)this.f.b();
        if (localWebrtcConfig == null)
        {
          BLog.c(a, "can't find user config (not logged in etc)");
          bool = false;
          continue;
        }
        BLog.c(a, "webrtc is initializing");
        this.g = new WebrtcEngine(this.c, this.d, this.e, localWebrtcConfig.a());
        BLog.c(a, "webrtc is initialized");
      }
      bool = this.g.a();
    }
  }

  public int a()
  {
    if (this.d == null);
    for (int i = 0; ; i = this.d.a())
      return i;
  }

  public void a(long paramLong)
  {
    if (!e());
    while (true)
    {
      return;
      this.d.a(2);
      this.g.a(paramLong);
    }
  }

  public void a(long paramLong, String paramString)
  {
    if (!e());
    while (true)
    {
      return;
      Class localClass = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(paramLong);
      arrayOfObject[1] = paramString;
      BLog.a(localClass, "message from peer %d: %s", arrayOfObject);
      this.g.a(paramLong, paramString);
    }
  }

  public void a(long paramLong, String paramString, int paramInt)
  {
    if (!e());
    while (true)
    {
      return;
      if (paramInt == 0)
      {
        this.g.b(paramLong);
        continue;
      }
      this.g.a(paramLong, paramString, paramInt);
    }
  }

  public void a(IWebrtcUiInterface.EndCallReason paramEndCallReason)
  {
    if (!e());
    while (true)
    {
      return;
      this.g.a(paramEndCallReason.ordinal());
    }
  }

  public void a(boolean paramBoolean)
  {
    if (!e());
    while (true)
    {
      return;
      this.g.a(paramBoolean);
    }
  }

  public boolean b()
  {
    return ((Boolean)this.b.b()).booleanValue();
  }

  public void c()
  {
    if (!e());
    while (true)
    {
      return;
      this.g.c();
    }
  }

  public void d()
  {
    if (!e());
    while (true)
    {
      return;
      this.g.d();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcManager
 * JD-Core Version:    0.6.0
 */