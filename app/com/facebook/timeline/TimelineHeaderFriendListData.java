package com.facebook.timeline;

import com.facebook.graphql.model.FriendList;
import com.facebook.graphql.model.FriendListList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TimelineHeaderFriendListData
{
  TimelineHeaderFriendListData.FriendListData a = null;
  TimelineHeaderFriendListData.FriendListData b = null;
  private List<TimelineHeaderFriendListData.FriendListData> c = null;
  private Set<Long> d = null;
  private TimelineHeaderFriendListData.ViewHandler e;

  public static TimelineHeaderFriendListData.FriendListType a(String paramString)
  {
    Object localObject = null;
    if (paramString == null);
    while (true)
    {
      return localObject;
      try
      {
        TimelineHeaderFriendListData.FriendListType localFriendListType = TimelineHeaderFriendListData.FriendListType.valueOf(paramString);
        localObject = localFriendListType;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = null;
      }
    }
  }

  private void g()
  {
    if ((a()) && (this.e != null))
      this.e.a();
  }

  public void a(FriendListList paramFriendListList)
  {
    this.c = new ArrayList();
    Iterator localIterator = paramFriendListList.lists.iterator();
    while (localIterator.hasNext())
    {
      FriendList localFriendList = (FriendList)localIterator.next();
      TimelineHeaderFriendListData.FriendListData localFriendListData = new TimelineHeaderFriendListData.FriendListData(this, localFriendList.id, localFriendList.name, a(localFriendList.listType));
      if (localFriendListData.c() == TimelineHeaderFriendListData.FriendListType.CLOSE_FRIENDS)
      {
        this.a = localFriendListData;
        continue;
      }
      if (localFriendListData.c() == TimelineHeaderFriendListData.FriendListType.ACQUAINTANCES)
      {
        this.b = localFriendListData;
        continue;
      }
      this.c.add(localFriendListData);
    }
    g();
  }

  public void a(TimelineHeaderFriendListData.ViewHandler paramViewHandler)
  {
    this.e = paramViewHandler;
  }

  public boolean a()
  {
    if ((this.c != null) && (this.d != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public TimelineHeaderFriendListData.FriendListData b()
  {
    return this.a;
  }

  public void b(FriendListList paramFriendListList)
  {
    this.d = new HashSet();
    Iterator localIterator = paramFriendListList.lists.iterator();
    while (localIterator.hasNext())
    {
      FriendList localFriendList = (FriendList)localIterator.next();
      this.d.add(Long.valueOf(localFriendList.id));
    }
    g();
  }

  public TimelineHeaderFriendListData.FriendListData c()
  {
    return this.b;
  }

  public List<TimelineHeaderFriendListData.FriendListData> d()
  {
    return this.c;
  }

  public int e()
  {
    int i = this.c.size();
    if (i > 3)
      i = 2;
    return i;
  }

  public boolean f()
  {
    if (this.c.size() > 3);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderFriendListData
 * JD-Core Version:    0.6.0
 */