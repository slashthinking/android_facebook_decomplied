package com.facebook.katana.activity.pageidentity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.pages.identity.ui.PageFriendsInfoFragment;

public class PageFriendsInfoActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  public String a()
  {
    return "page_friends_info";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903450);
    ((PageFriendsInfoFragment)g().a(2131297585)).a(new PageFriendsInfoActivity.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageFriendsInfoActivity
 * JD-Core Version:    0.6.0
 */