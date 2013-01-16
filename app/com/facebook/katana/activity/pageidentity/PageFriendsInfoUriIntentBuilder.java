package com.facebook.katana.activity.pageidentity;

import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.uri.UriIntentBuilder;

public class PageFriendsInfoUriIntentBuilder extends UriIntentBuilder
{
  public PageFriendsInfoUriIntentBuilder()
  {
    a(StringLocaleUtil.a("fb://localpage/friends/{#%s}", new Object[] { "com.facebook.katana.profile.id" }), PageFriendsInfoActivity.class);
  }

  public boolean a()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageFriendsInfoUriIntentBuilder
 * JD-Core Version:    0.6.0
 */