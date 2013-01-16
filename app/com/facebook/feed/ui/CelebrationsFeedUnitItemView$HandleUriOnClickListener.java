package com.facebook.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.inject.FbInjector;

class CelebrationsFeedUnitItemView$HandleUriOnClickListener
  implements View.OnClickListener
{
  private String b = null;

  private CelebrationsFeedUnitItemView$HandleUriOnClickListener(CelebrationsFeedUnitItemView paramCelebrationsFeedUnitItemView)
  {
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void onClick(View paramView)
  {
    if (this.b != null)
      ((IFeedIntentBuilder)CelebrationsFeedUnitItemView.a(this.a).a(IFeedIntentBuilder.class)).a(paramView.getContext(), this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.CelebrationsFeedUnitItemView.HandleUriOnClickListener
 * JD-Core Version:    0.6.0
 */