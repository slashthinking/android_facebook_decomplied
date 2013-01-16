package com.facebook.orca.app;

import android.content.ContentResolver;
import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ContentResolverProvider extends AbstractProvider<ContentResolver>
{
  private FbBaseModule$ContentResolverProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ContentResolver a()
  {
    return ((Context)b(Context.class)).getContentResolver();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ContentResolverProvider
 * JD-Core Version:    0.6.0
 */