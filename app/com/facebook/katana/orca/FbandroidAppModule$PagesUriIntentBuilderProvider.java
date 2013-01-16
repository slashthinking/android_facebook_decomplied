package com.facebook.katana.orca;

import com.facebook.katana.activity.pageidentity.PageIdentityUriIntentBuilder;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.pages.identity.annotations.IsNewPageIdentityEnabled;

class FbandroidAppModule$PagesUriIntentBuilderProvider extends AbstractProvider<PageIdentityUriIntentBuilder>
{
  private FbandroidAppModule$PagesUriIntentBuilderProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public PageIdentityUriIntentBuilder a()
  {
    return new PageIdentityUriIntentBuilder(a(Boolean.class, IsNewPageIdentityEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.PagesUriIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */