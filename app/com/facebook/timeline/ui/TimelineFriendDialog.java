package com.facebook.timeline.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.facebook.friends.FriendingClient;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.timeline.TimelineDataFetcher;
import com.facebook.timeline.TimelineFriendingClient;
import com.facebook.timeline.TimelineHeaderData;
import com.facebook.timeline.TimelineHeaderData.SubscribeStatus;
import com.facebook.timeline.TimelineHeaderData.UserFriendshipStatus;
import com.facebook.timeline.TimelineHeaderFriendListData;
import com.facebook.timeline.TimelineHeaderFriendListData.FriendListData;
import com.facebook.widget.flyout.FlyoutFragment;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;

public class TimelineFriendDialog extends FlyoutFragment
{
  private static int b = 0;
  private final Context c;
  private TimelineDataFetcher d;
  private TimelineFriendingClient e;
  private TimelineHeaderData f;
  private TimelineFriendMenuItem g;
  private TimelineFriendMenuItem h;

  public TimelineFriendDialog(Context paramContext)
  {
    this.c = paramContext;
  }

  private void K()
  {
    Futures.a(this.e.a().a(this.f.d()), new TimelineFriendDialog.6(this));
    a();
  }

  public static int a(TimelineHeaderData.SubscribeStatus paramSubscribeStatus)
  {
    if (paramSubscribeStatus == TimelineHeaderData.SubscribeStatus.CANNOT_SUBSCRIBE);
    for (int i = 8; ; i = 0)
      return i;
  }

  private TimelineFriendMenuItem a(TimelineHeaderFriendListData.FriendListData paramFriendListData, ViewGroup paramViewGroup)
  {
    TimelineFriendMenuItem localTimelineFriendMenuItem = TimelineFriendMenuItem.a(n(), paramViewGroup);
    localTimelineFriendMenuItem.setText(paramFriendListData.b());
    localTimelineFriendMenuItem.setChecked(paramFriendListData.d());
    localTimelineFriendMenuItem.setOnCheckedChangeListener(new TimelineFriendDialog.7(this, paramFriendListData));
    return localTimelineFriendMenuItem;
  }

  private void a(TimelineFriendMenuItem paramTimelineFriendMenuItem)
  {
    paramTimelineFriendMenuItem.setChecked(b(this.f.v()));
  }

  public static boolean b()
  {
    if (b > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean b(TimelineHeaderData.SubscribeStatus paramSubscribeStatus)
  {
    if (paramSubscribeStatus == TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED);
    for (int i = 1; ; i = 0)
      return i;
  }

  private void d()
  {
    String str1 = e(2131361827);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.f.j();
    String str2 = StringLocaleUtil.b(str1, arrayOfObject);
    new AlertDialog.Builder(this.c).setMessage(str2).setPositiveButton(2131361828, new TimelineFriendDialog.5(this)).setNegativeButton(2131361850, null).show();
  }

  public void D()
  {
    b = -1 + b;
    super.D();
  }

  public ListenableFuture<Void> a(FragmentManager paramFragmentManager)
  {
    b = 1 + b;
    return super.a(paramFragmentManager);
  }

  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    TimelineHeaderFriendListData localTimelineHeaderFriendListData = this.f.B();
    View localView = paramLayoutInflater.inflate(2130903230, paramViewGroup);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131296971);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131296972);
    TimelineHeaderFriendListData.FriendListData localFriendListData1 = localTimelineHeaderFriendListData.b();
    if (localFriendListData1 != null)
    {
      this.g = a(localFriendListData1, localLinearLayout1);
      localLinearLayout1.addView(this.g);
    }
    TimelineHeaderFriendListData.FriendListData localFriendListData2 = localTimelineHeaderFriendListData.c();
    if (localFriendListData2 != null)
    {
      this.h = a(localFriendListData2, localLinearLayout1);
      localLinearLayout1.addView(this.h);
    }
    Iterator localIterator = localTimelineHeaderFriendListData.d().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      TimelineFriendMenuItem localTimelineFriendMenuItem3 = a((TimelineHeaderFriendListData.FriendListData)localIterator.next(), localLinearLayout2);
      if (i >= localTimelineHeaderFriendListData.e())
        localTimelineFriendMenuItem3.setVisibility(8);
      localLinearLayout2.addView(localTimelineFriendMenuItem3, i);
    }
    TimelineFriendMenuItem localTimelineFriendMenuItem1 = (TimelineFriendMenuItem)localLinearLayout2.findViewById(2131296973);
    Button localButton;
    if (localTimelineHeaderFriendListData.f())
    {
      localTimelineFriendMenuItem1.setOnClickListener(new TimelineFriendDialog.1(this, localLinearLayout2));
      localView.findViewById(2131296974).setVisibility(a(this.f.v()));
      TimelineFriendMenuItem localTimelineFriendMenuItem2 = (TimelineFriendMenuItem)localView.findViewById(2131296975);
      a(localTimelineFriendMenuItem2);
      localTimelineFriendMenuItem2.setOnClickListener(new TimelineFriendDialog.2(this, localTimelineFriendMenuItem2));
      localButton = (Button)localView.findViewById(2131296976);
      if (this.f.u() != TimelineHeaderData.UserFriendshipStatus.ARE_FRIENDS)
        break label324;
      localButton.setText(2131361816);
      localButton.setOnClickListener(new TimelineFriendDialog.3(this));
    }
    while (true)
    {
      return;
      localTimelineFriendMenuItem1.setVisibility(8);
      break;
      label324: localButton.setText(2131361818);
      localButton.setOnClickListener(new TimelineFriendDialog.4(this));
    }
  }

  public void a(TimelineDataFetcher paramTimelineDataFetcher, TimelineFriendingClient paramTimelineFriendingClient, TimelineHeaderData paramTimelineHeaderData)
  {
    this.d = paramTimelineDataFetcher;
    this.e = paramTimelineFriendingClient;
    this.f = paramTimelineHeaderData;
    this.g = null;
    this.h = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendDialog
 * JD-Core Version:    0.6.0
 */