package com.facebook.webrtc;

import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;

public class WebrtcEngine
{
  private static final Class<?> a = WebrtcEngine.class;
  private static boolean b;
  private static boolean c;
  private long d;

  public WebrtcEngine(IWebrtcSignalingMessageInterface paramIWebrtcSignalingMessageInterface, IWebrtcUiInterface paramIWebrtcUiInterface, IWebrtcLoggingInterface paramIWebrtcLoggingInterface, String paramString)
  {
    Preconditions.checkNotNull(paramIWebrtcSignalingMessageInterface);
    Preconditions.checkNotNull(paramIWebrtcUiInterface);
    Preconditions.checkNotNull(paramIWebrtcLoggingInterface);
    e();
    createEngineNative(paramIWebrtcSignalingMessageInterface, paramIWebrtcUiInterface, paramIWebrtcLoggingInterface, paramString, 0, true);
    BLog.c(a, "Loaded webrtc engine. id = " + Long.toString(this.d));
  }

  private native void acceptCallNative();

  private native void createEngineNative(IWebrtcSignalingMessageInterface paramIWebrtcSignalingMessageInterface, IWebrtcUiInterface paramIWebrtcUiInterface, IWebrtcLoggingInterface paramIWebrtcLoggingInterface, String paramString, int paramInt, boolean paramBoolean);

  private native void destroyEngineNative();

  private native void didShowUiNative();

  private static void e()
  {
    if (!b)
      b = true;
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("fbwebrtc-jni");
      c = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
      {
        c = true;
        BLog.d(a, "native library not available");
      }
    }
  }

  private native void endCallNative(int paramInt);

  private native void onMessageFromPeerNative(long paramLong, String paramString);

  private native void onMessageSendErrorNative(long paramLong, String paramString, int paramInt);

  private native void onMessageSendSuccessNative(long paramLong);

  private native void setMuteNative(boolean paramBoolean);

  private native void startCallNative(long paramLong);

  public void a(int paramInt)
  {
    endCallNative(paramInt);
  }

  public void a(long paramLong)
  {
    startCallNative(paramLong);
  }

  public void a(long paramLong, String paramString)
  {
    onMessageFromPeerNative(paramLong, paramString);
  }

  public void a(long paramLong, String paramString, int paramInt)
  {
    onMessageSendErrorNative(paramLong, paramString, paramInt);
  }

  public void a(boolean paramBoolean)
  {
    setMuteNative(paramBoolean);
  }

  public boolean a()
  {
    return c;
  }

  public void b()
  {
    if (this.d != 0L)
    {
      BLog.c(a, "Closing webrtc engine. id = " + Long.toString(this.d));
      destroyEngineNative();
    }
  }

  public void b(long paramLong)
  {
    onMessageSendSuccessNative(paramLong);
  }

  public void c()
  {
    acceptCallNative();
  }

  public void d()
  {
    didShowUiNative();
  }

  protected void finalize()
  {
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.webrtc.WebrtcEngine
 * JD-Core Version:    0.6.0
 */