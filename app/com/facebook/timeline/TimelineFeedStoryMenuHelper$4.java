package com.facebook.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.graphql.model.FeedStory;

class TimelineFeedStoryMenuHelper$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    TimelineFeedStoryMenuHelper.d(this.b, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFeedStoryMenuHelper.4
 * JD-Core Version:    0.6.0
 */