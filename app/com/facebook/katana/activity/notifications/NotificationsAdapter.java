package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;

public class NotificationsAdapter extends CursorAdapter
{
  public NotificationsAdapter.NotificationsRenderer j;

  public NotificationsAdapter(Context paramContext, Cursor paramCursor, int paramInt, NotificationsAdapter.NotificationsRenderer paramNotificationsRenderer)
  {
    super(paramContext, paramCursor, paramInt);
    this.j = paramNotificationsRenderer;
  }

  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.j.a();
  }

  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    this.j.a(paramView, paramContext, paramCursor);
  }

  public boolean isEmpty()
  {
    if ((a() == null) || (super.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsAdapter
 * JD-Core Version:    0.6.0
 */