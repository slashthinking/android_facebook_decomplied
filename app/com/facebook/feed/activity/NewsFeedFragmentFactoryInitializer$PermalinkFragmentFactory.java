package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.feed.ui.permalink.PermalinkFragment;
import com.facebook.fragment.IFragmentFactory;
import com.google.common.base.Preconditions;

class NewsFeedFragmentFactoryInitializer$PermalinkFragmentFactory
  implements IFragmentFactory
{
  public int a()
  {
    return 2;
  }

  public Fragment a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("extra_is_platform_id", false));
    String str;
    for (PermalinkFragment localPermalinkFragment = PermalinkFragment.a(paramIntent.getStringExtra("extra_platform_id"), paramIntent.getStringExtra("extra_fallback_url")); ; localPermalinkFragment = PermalinkFragment.a(str))
    {
      return localPermalinkFragment;
      str = paramIntent.getStringExtra("permalink_story");
      Preconditions.checkNotNull(str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer.PermalinkFragmentFactory
 * JD-Core Version:    0.6.0
 */