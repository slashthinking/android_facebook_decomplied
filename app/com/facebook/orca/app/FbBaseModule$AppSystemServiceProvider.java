package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$AppSystemServiceProvider<T> extends AbstractProvider<T>
{
  private final String b;

  FbBaseModule$AppSystemServiceProvider(FbBaseModule paramFbBaseModule, String paramString)
  {
    this.b = paramString;
  }

  public T b()
  {
    return FbBaseModule.b(this.a).getSystemService(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.AppSystemServiceProvider
 * JD-Core Version:    0.6.0
 */