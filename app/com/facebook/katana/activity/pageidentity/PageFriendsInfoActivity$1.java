package com.facebook.katana.activity.pageidentity;

import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.pages.identity.ui.PageFriendsInfoFragment.OnFriendRowClickedListener;

class PageFriendsInfoActivity$1
  implements PageFriendsInfoFragment.OnFriendRowClickedListener
{
  public boolean a(String paramString)
  {
    String str = StringLocaleUtil.a("fb://profile/%s", new Object[] { paramString });
    return IntentUriHandler.b(this.a, str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.pageidentity.PageFriendsInfoActivity.1
 * JD-Core Version:    0.6.0
 */