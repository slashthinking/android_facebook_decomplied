package com.facebook.timeline;

import android.view.View;
import android.view.View.OnClickListener;

class TimelineScrubberView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((this.a instanceof TimelineSectionData.Scrubber))
      if (!this.a.a);
    while (true)
    {
      return;
      if ((!(this.a instanceof TimelineSectionData.TimelineSectionLabel)) || (!this.b.b(this.a.b)))
      {
        this.c.setVisibility(0);
        TimelineSectionFetcher.Params localParams = new TimelineSectionFetcher.Params();
        localParams.a = this.a.b;
        localParams.d = this.a.c;
        localParams.e = this.d.a.intValue();
        localParams.f = this.d.b.intValue();
        this.d.a(localParams);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineScrubberView.1
 * JD-Core Version:    0.6.0
 */