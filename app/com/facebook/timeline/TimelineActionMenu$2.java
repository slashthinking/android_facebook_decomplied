package com.facebook.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

class TimelineActionMenu$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(TimelineActionMenu.b(this.a).d());
    String str = StringLocaleUtil.a("fb://messaging/compose/%s", arrayOfObject);
    TimelineActionMenu.d(this.a).a(TimelineActionMenu.c(this.a), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineActionMenu.2
 * JD-Core Version:    0.6.0
 */