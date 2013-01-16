package com.facebook.feed;

import android.os.Bundle;
import com.facebook.annotations.FragmentChromeActivity;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class NewsFeedIntentUriBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public NewsFeedIntentUriBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a("fb://feed", FragmentChromeActivity.class, 1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_platform_id", true);
    a(StringLocaleUtil.a("fb://native_post/{%s}?fallback_url={%s}", new Object[] { "extra_platform_id", "extra_fallback_url" }), FragmentChromeActivity.class, 2, localBundle);
  }

  public boolean a()
  {
    return ((Boolean)this.a.b()).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.NewsFeedIntentUriBuilder
 * JD-Core Version:    0.6.0
 */