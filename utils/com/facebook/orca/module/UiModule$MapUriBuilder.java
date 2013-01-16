package com.facebook.orca.module;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.widget.MapImage.MapUriBuilder;

class UiModule$MapUriBuilder extends AbstractProvider<MapImage.MapUriBuilder>
{
  private UiModule$MapUriBuilder(UiModule paramUiModule)
  {
  }

  public MapImage.MapUriBuilder a()
  {
    return new MapImage.MapUriBuilder(UiModule.a(this.a).getResources().getDisplayMetrics());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.MapUriBuilder
 * JD-Core Version:    0.6.2
 */