package com.facebook.katana.features.uberbar;

import android.view.LayoutInflater;
import com.facebook.orca.inject.AbstractProvider;

class UberbarFB4AModule$UberSearchResultsAdapterProvider extends AbstractProvider<UberSearchResultsAdapter>
{
  private UberbarFB4AModule$UberSearchResultsAdapterProvider(UberbarFB4AModule paramUberbarFB4AModule)
  {
  }

  public UberSearchResultsAdapter a()
  {
    return new UberSearchResultsAdapter((LayoutInflater)b(LayoutInflater.class), a(UberbarResultView.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarFB4AModule.UberSearchResultsAdapterProvider
 * JD-Core Version:    0.6.0
 */