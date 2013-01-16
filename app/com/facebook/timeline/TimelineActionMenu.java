package com.facebook.timeline;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.ui.AlertDialogMenuBuilder;
import com.facebook.friends.FriendingClient;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.timeline.ui.titlebar.ITitleBarController;

class TimelineActionMenu
{
  private final Context a;
  private final ITitleBarController b;
  private final TimelineHeaderData c;
  private final TimelineDataFetcher d;
  private final FriendingClient e;
  private final IFeedIntentBuilder f;
  private final SecureContextHelper g;

  public TimelineActionMenu(Context paramContext, ITitleBarController paramITitleBarController, TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher paramTimelineDataFetcher, FriendingClient paramFriendingClient, IFeedIntentBuilder paramIFeedIntentBuilder, SecureContextHelper paramSecureContextHelper)
  {
    this.a = paramContext;
    this.b = paramITitleBarController;
    this.c = paramTimelineHeaderData;
    this.d = paramTimelineDataFetcher;
    this.e = paramFriendingClient;
    this.f = paramIFeedIntentBuilder;
    this.g = paramSecureContextHelper;
  }

  private void c()
  {
    AlertDialogMenuBuilder localAlertDialogMenuBuilder = new AlertDialogMenuBuilder(this.a);
    if (this.c.o())
      localAlertDialogMenuBuilder.a(this.a.getResources().getString(2131361792), new TimelineActionMenu.2(this));
    localAlertDialogMenuBuilder.a(this.a.getResources().getString(2131361842), new TimelineActionMenu.3(this));
    localAlertDialogMenuBuilder.a(this.a.getResources().getString(2131361850), new TimelineActionMenu.4(this));
    localAlertDialogMenuBuilder.show();
  }

  private void d()
  {
    String str1 = this.a.getString(2131361843);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.c.j();
    String str2 = StringLocaleUtil.b(str1, arrayOfObject);
    View localView = LayoutInflater.from(this.a).inflate(2130903582, null);
    new AlertDialog.Builder(this.a).setInverseBackgroundForced(true).setTitle(str2).setView(localView).setPositiveButton(2131361842, new TimelineActionMenu.5(this)).setNegativeButton(2131361850, null).show();
  }

  public void a()
  {
    if (this.c.f());
    while (true)
    {
      return;
      this.b.a(new TitleBarButtonSpecBuilder().a(this.a.getResources().getDrawable(2130838372)).i());
      this.b.a(new TimelineActionMenu.1(this));
    }
  }

  public void b()
  {
    this.b.a(null);
    this.b.a(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineActionMenu
 * JD-Core Version:    0.6.0
 */