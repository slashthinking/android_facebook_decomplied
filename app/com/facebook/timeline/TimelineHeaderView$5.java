package com.facebook.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

class TimelineHeaderView$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(this.a.d());
    String str = StringLocaleUtil.a("fb://messaging/compose/%s", arrayOfObject);
    this.b.getIntentBuilder().a(this.b.getContext(), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderView.5
 * JD-Core Version:    0.6.0
 */