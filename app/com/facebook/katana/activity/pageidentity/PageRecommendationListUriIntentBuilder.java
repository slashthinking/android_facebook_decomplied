package com.facebook.katana.activity.pageidentity;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;

public class PageRecommendationListUriIntentBuilder extends UriIntentBuilder
{
  public PageRecommendationListUriIntentBuilder()
  {
    a(StringLocaleUtil.a("fb://localpage/recommendations/{#%s}", new Object[] { "com.facebook.katana.profile.id" }), RecommendationListActivity.class);
  }

  protected boolean a()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageRecommendationListUriIntentBuilder
 * JD-Core Version:    0.6.0
 */