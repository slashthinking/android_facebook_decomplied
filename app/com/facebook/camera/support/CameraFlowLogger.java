package com.facebook.camera.support;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public abstract interface CameraFlowLogger
{
  public abstract void a(int paramInt);

  public abstract void a(Intent paramIntent);

  public abstract void a(Uri paramUri);

  public abstract void a(Bundle paramBundle);

  public abstract void a(Bundle paramBundle, String paramString);

  public abstract void a(String paramString);

  public abstract void a(String paramString, Exception paramException);

  public abstract void b();

  public abstract void b(int paramInt);

  public abstract void b(Uri paramUri);

  public abstract void b(String paramString);

  public abstract void c();

  public abstract void c(String paramString);

  public abstract void d();

  public abstract void e();

  public abstract void f();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.support.CameraFlowLogger
 * JD-Core Version:    0.6.0
 */