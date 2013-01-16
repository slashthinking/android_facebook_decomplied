package com.facebook.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.inject.FbInjector;

class CelebrationsFeedUnitView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ((IFeedIntentBuilder)CelebrationsFeedUnitView.a(this.a).a(IFeedIntentBuilder.class)).a(paramView.getContext(), "fb://birthdays");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.CelebrationsFeedUnitView.1
 * JD-Core Version:    0.6.0
 */