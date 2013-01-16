package com.facebook.orca.app;

import android.content.ContentResolver;
import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ContentResolverProviderFromApp extends AbstractProvider<ContentResolver>
{
  private FbBaseModule$ContentResolverProviderFromApp(FbBaseModule paramFbBaseModule)
  {
  }

  public ContentResolver a()
  {
    return FbBaseModule.b(this.a).getContentResolver();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ContentResolverProviderFromApp
 * JD-Core Version:    0.6.0
 */