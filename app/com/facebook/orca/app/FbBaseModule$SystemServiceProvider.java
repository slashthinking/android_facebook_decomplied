package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$SystemServiceProvider<T> extends AbstractProvider<T>
{
  private final String b;

  FbBaseModule$SystemServiceProvider(FbBaseModule paramFbBaseModule, String paramString)
  {
    this.b = paramString;
  }

  public T b()
  {
    return ((Context)b(Context.class)).getSystemService(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.SystemServiceProvider
 * JD-Core Version:    0.6.0
 */