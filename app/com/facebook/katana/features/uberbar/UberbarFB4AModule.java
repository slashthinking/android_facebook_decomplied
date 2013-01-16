package com.facebook.katana.features.uberbar;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class UberbarFB4AModule extends AbstractModule
{
  protected void a()
  {
    a(UberSearchResultsAdapter.class).a(new UberbarFB4AModule.UberSearchResultsAdapterProvider(this, null));
    a(UberbarResultFetcherFactory.class).a(new UberbarFB4AModule.UberbarResultFetcherFactoryProvider(this, null));
    a(UberbarResultView.class).a(new UberbarFB4AModule.UberSearchResultViewProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarFB4AModule
 * JD-Core Version:    0.6.0
 */