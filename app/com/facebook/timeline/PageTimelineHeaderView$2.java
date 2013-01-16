package com.facebook.timeline;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

class PageTimelineHeaderView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    IFeedIntentBuilder localIFeedIntentBuilder = this.a.getIntentBuilder();
    Context localContext = this.a.getContext();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(this.a.getHeaderData().d());
    localIFeedIntentBuilder.a(localContext, StringLocaleUtil.a("fb://page/%s/info", arrayOfObject));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.PageTimelineHeaderView.2
 * JD-Core Version:    0.6.0
 */