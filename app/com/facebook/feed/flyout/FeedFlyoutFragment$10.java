package com.facebook.feed.flyout;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.feed.ui.OnSoftKeyboardStateChangeListener;

class FeedFlyoutFragment$10
  implements OnSoftKeyboardStateChangeListener
{
  public void a(View paramView)
  {
    FeedFlyoutFragment.r(this.a).setBackgroundResource(2131165254);
    FeedFlyoutFragment.q(this.a).setVisibility(0);
    if (this.a.q().getConfiguration().orientation == 2);
    while (true)
    {
      return;
      FeedFlyoutFragment.s(this.a);
    }
  }

  public void b(View paramView)
  {
    FeedFlyoutFragment.r(this.a).setBackgroundResource(2131165307);
    if (FeedFlyoutFragment.t(this.a).getText().length() == 0)
      FeedFlyoutFragment.q(this.a).setVisibility(8);
    if (this.a.q().getConfiguration().orientation == 2);
    while (true)
    {
      return;
      FeedFlyoutFragment.a(this.a, this.a.q().getConfiguration());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.10
 * JD-Core Version:    0.6.0
 */