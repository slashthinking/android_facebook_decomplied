package com.facebook.katana.activity.profilelist;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.katana.util.Utils;

class FriendSingleSelectorActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    int i = this.a.getRootView().getHeight() - this.a.getHeight();
    float f = Utils.a(this.b.getResources().getDisplayMetrics().densityDpi, 100.0F);
    FriendSingleSelectorActivity localFriendSingleSelectorActivity = this.b;
    if (i > f);
    for (boolean bool = true; ; bool = false)
    {
      FriendSingleSelectorActivity.a(localFriendSingleSelectorActivity, bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity.2
 * JD-Core Version:    0.6.0
 */