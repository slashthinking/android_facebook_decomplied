package com.facebook.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

class TimelineHeaderView$6
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.a.d());
    arrayOfObject[1] = "timeline_composer";
    String str = StringLocaleUtil.a("fb://gift/sendinterstitial/?recipient=%s&entry_point=%s", arrayOfObject);
    this.b.getIntentBuilder().a(this.b.getContext(), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderView.6
 * JD-Core Version:    0.6.0
 */