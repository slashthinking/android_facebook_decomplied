package com.facebook.appcenter.intent;

import com.facebook.appcenter.activity.AppCenterBrowseActivity;
import com.facebook.appcenter.activity.AppCenterDetailActivity;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class AppCenterUriIntentBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public AppCenterUriIntentBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a("fb://appcenter", AppCenterBrowseActivity.class);
    a(StringLocaleUtil.a("fb://appcenter/detail?app_id={%s}", new Object[] { "id" }), AppCenterDetailActivity.class);
  }

  public boolean a()
  {
    return ((Boolean)this.a.b()).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.intent.AppCenterUriIntentBuilder
 * JD-Core Version:    0.6.0
 */