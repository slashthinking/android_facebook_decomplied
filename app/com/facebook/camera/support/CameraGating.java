package com.facebook.camera.support;

import android.content.Context;
import android.os.Build.VERSION;

public class CameraGating
{
  protected Context a = null;

  public void a(Context paramContext)
  {
    this.a = paramContext;
  }

  public boolean a()
  {
    return true;
  }

  public boolean b()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return false;
  }

  public boolean e()
  {
    if (Build.VERSION.SDK_INT < 14);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean f()
  {
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.support.CameraGating
 * JD-Core Version:    0.6.0
 */