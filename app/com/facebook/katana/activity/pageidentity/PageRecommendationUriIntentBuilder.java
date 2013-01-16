package com.facebook.katana.activity.pageidentity;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;

public class PageRecommendationUriIntentBuilder extends UriIntentBuilder
{
  public PageRecommendationUriIntentBuilder()
  {
    a(StringLocaleUtil.a("fb://localpage/recommendation", new Object[0]), PageRecommendationActivity.class);
  }

  protected boolean a()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageRecommendationUriIntentBuilder
 * JD-Core Version:    0.6.0
 */