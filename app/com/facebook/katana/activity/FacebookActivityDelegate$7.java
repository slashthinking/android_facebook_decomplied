package com.facebook.katana.activity;

import android.view.View;
import com.facebook.katana.ui.TitleBar.OnPrimaryButtonClickListener;

class FacebookActivityDelegate$7
  implements TitleBar.OnPrimaryButtonClickListener
{
  public void a(View paramView)
  {
    if ((FacebookActivityDelegate.b(this.a) instanceof BookmarksMenuHost))
      ((BookmarksMenuHost)FacebookActivityDelegate.b(this.a)).titleBarPrimaryActionClickHandler(paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.7
 * JD-Core Version:    0.6.0
 */