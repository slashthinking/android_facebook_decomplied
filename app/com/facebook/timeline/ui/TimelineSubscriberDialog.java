package com.facebook.timeline.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.timeline.TimelineDataFetcher;
import com.facebook.timeline.TimelineFriendingClient;
import com.facebook.timeline.TimelineHeaderData;
import com.facebook.widget.flyout.FlyoutFragment;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

public class TimelineSubscriberDialog extends FlyoutFragment
{
  private static int b = 0;
  private final Context c;
  private TimelineDataFetcher d;
  private TimelineFriendingClient e;
  private TimelineHeaderData f;

  public TimelineSubscriberDialog(Context paramContext)
  {
    this.c = ((Context)Preconditions.checkNotNull(paramContext));
  }

  public static boolean b()
  {
    if (b > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  private void d()
  {
    String str1 = e(2131361829);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.f.j();
    String str2 = StringLocaleUtil.b(str1, arrayOfObject);
    new AlertDialog.Builder(this.c).setMessage(str2).setPositiveButton(2131361811, new TimelineSubscriberDialog.2(this)).setNegativeButton(2131361850, null).show();
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
    ((Button)paramLayoutInflater.inflate(2130903562, paramViewGroup).findViewById(2131297849)).setOnClickListener(new TimelineSubscriberDialog.1(this));
  }

  public void a(TimelineDataFetcher paramTimelineDataFetcher, TimelineFriendingClient paramTimelineFriendingClient, TimelineHeaderData paramTimelineHeaderData)
  {
    this.d = ((TimelineDataFetcher)Preconditions.checkNotNull(paramTimelineDataFetcher));
    this.e = ((TimelineFriendingClient)Preconditions.checkNotNull(paramTimelineFriendingClient));
    this.f = ((TimelineHeaderData)Preconditions.checkNotNull(paramTimelineHeaderData));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineSubscriberDialog
 * JD-Core Version:    0.6.0
 */