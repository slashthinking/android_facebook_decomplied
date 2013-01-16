package com.facebook.katana.activity.pageidentity;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class PageIdentityUriIntentBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public PageIdentityUriIntentBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a(StringLocaleUtil.a("fb://localpage/{#%s}", new Object[] { "com.facebook.katana.profile.id" }), PageIdentityActivity.class);
  }

  public boolean a()
  {
    return ((Boolean)this.a.b()).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageIdentityUriIntentBuilder
 * JD-Core Version:    0.6.0
 */