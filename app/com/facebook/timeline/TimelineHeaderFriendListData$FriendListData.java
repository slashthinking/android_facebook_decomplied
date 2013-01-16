package com.facebook.timeline;

import java.util.Set;

public class TimelineHeaderFriendListData$FriendListData
{
  private final long b;
  private final String c;
  private final TimelineHeaderFriendListData.FriendListType d;

  public TimelineHeaderFriendListData$FriendListData(TimelineHeaderFriendListData paramTimelineHeaderFriendListData, long paramLong, String paramString, TimelineHeaderFriendListData.FriendListType paramFriendListType)
  {
    this.b = paramLong;
    this.c = paramString;
    this.d = paramFriendListType;
  }

  public long a()
  {
    return this.b;
  }

  public void a(boolean paramBoolean)
  {
    if (TimelineHeaderFriendListData.a(this.a) != null)
    {
      if (!paramBoolean)
        break label35;
      TimelineHeaderFriendListData.a(this.a).add(Long.valueOf(this.b));
    }
    while (true)
    {
      return;
      label35: TimelineHeaderFriendListData.a(this.a).remove(Long.valueOf(this.b));
    }
  }

  public String b()
  {
    return this.c;
  }

  public TimelineHeaderFriendListData.FriendListType c()
  {
    return this.d;
  }

  public boolean d()
  {
    if ((TimelineHeaderFriendListData.a(this.a) != null) && (TimelineHeaderFriendListData.a(this.a).contains(Long.valueOf(this.b))));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderFriendListData.FriendListData
 * JD-Core Version:    0.6.0
 */