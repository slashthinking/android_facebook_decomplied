package com.facebook.timeline;

import com.facebook.annotations.FragmentChromeActivity;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class TimelineUriIntentBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public TimelineUriIntentBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a("fb://profile", FragmentChromeActivity.class, 3);
    a(StringLocaleUtil.a("fb://profile/{#%s}", new Object[] { "com.facebook.katana.profile.id" }), FragmentChromeActivity.class, 3);
  }

  public boolean a()
  {
    return ((Boolean)this.a.b()).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineUriIntentBuilder
 * JD-Core Version:    0.6.0
 */