package com.facebook.timeline.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.timeline.TimelineDataFetcher;
import com.facebook.timeline.TimelineHeaderFriendListData.FriendListData;
import com.facebook.timeline.TimelineHeaderFriendListData.FriendListType;

class TimelineFriendDialog$7
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.a.d() != paramBoolean)
    {
      this.a.a(paramBoolean);
      if (!paramBoolean)
        break label122;
      TimelineFriendDialog.e(this.b).a(this.a.a());
      if (this.a.c() != TimelineHeaderFriendListData.FriendListType.CLOSE_FRIENDS)
        break label85;
      if (TimelineFriendDialog.g(this.b) != null)
        TimelineFriendDialog.g(this.b).setChecked(false);
    }
    while (true)
    {
      TimelineFriendDialog.e(this.b).j();
      return;
      label85: if ((this.a.c() != TimelineHeaderFriendListData.FriendListType.ACQUAINTANCES) || (TimelineFriendDialog.h(this.b) == null))
        continue;
      TimelineFriendDialog.h(this.b).setChecked(false);
      continue;
      label122: TimelineFriendDialog.e(this.b).b(this.a.a());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendDialog.7
 * JD-Core Version:    0.6.0
 */