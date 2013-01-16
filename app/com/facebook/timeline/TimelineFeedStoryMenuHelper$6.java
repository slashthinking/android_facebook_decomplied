package com.facebook.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLProfile;

class TimelineFeedStoryMenuHelper$6
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TimelineFeedStoryMenuHelper.e(this.c, this.a);
    TimelineFeedStoryMenuHelper.b(this.c).a(TimelineFeedStoryMenuHelper.a(this.c).d(), Long.parseLong(this.b.id));
    TimelineFeedStoryMenuHelper.c(this.c).g();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFeedStoryMenuHelper.6
 * JD-Core Version:    0.6.0
 */