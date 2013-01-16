package com.facebook.katana.binding;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.facebook.orca.common.util.StringUtil;

public class SystemTrayNotificationManager$MyNotification
{
  public final String a;
  public Notification b;
  public int c;
  private final int d;
  private int e;
  private final String f;
  private final int g;
  private int h;

  public SystemTrayNotificationManager$MyNotification(int paramInt1, Notification paramNotification, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramString1;
    this.b = paramNotification;
    this.a = paramString2;
    this.c = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
  }

  private void a(Context paramContext)
  {
    switch (this.e)
    {
    default:
      ((NotificationManager)paramContext.getSystemService("notification")).notify(this.d, this.b);
      return;
    case 0:
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903525);
      localRemoteViews.setImageViewResource(2131297762, 2130838952);
      if (!TextUtils.isEmpty(this.f))
      {
        Object[] arrayOfObject10 = new Object[2];
        arrayOfObject10[0] = Integer.valueOf(this.g);
        arrayOfObject10[1] = Integer.valueOf(this.h);
        String str3 = paramContext.getString(2131363250, arrayOfObject10);
        Object[] arrayOfObject11 = new Object[2];
        arrayOfObject11[0] = str3;
        arrayOfObject11[1] = this.f;
        localRemoteViews.setTextViewText(2131296686, StringUtil.a("%s : %s", arrayOfObject11));
      }
      while (true)
      {
        localRemoteViews.setTextViewText(2131297763, this.c + "%");
        localRemoteViews.setProgressBar(2131296685, 100, this.c, false);
        this.b.contentView = localRemoteViews;
        break;
        Object[] arrayOfObject9 = new Object[2];
        arrayOfObject9[0] = Integer.valueOf(this.g);
        arrayOfObject9[1] = Integer.valueOf(this.h);
        localRemoteViews.setTextViewText(2131296686, paramContext.getString(2131363250, arrayOfObject9));
      }
    case 2:
      Notification localNotification6;
      Object[] arrayOfObject8;
      if (!TextUtils.isEmpty(this.f))
      {
        Object[] arrayOfObject7 = new Object[2];
        arrayOfObject7[0] = Integer.valueOf(this.g);
        arrayOfObject7[1] = Integer.valueOf(this.h);
        String str2 = paramContext.getString(2131363248, arrayOfObject7);
        localNotification6 = this.b;
        arrayOfObject8 = new Object[2];
        arrayOfObject8[0] = str2;
        arrayOfObject8[1] = this.f;
      }
      Notification localNotification5;
      Object[] arrayOfObject6;
      for (localNotification6.tickerText = StringUtil.a("%s : %s", arrayOfObject8); ; localNotification5.tickerText = paramContext.getString(2131363248, arrayOfObject6))
      {
        this.b.setLatestEventInfo(paramContext, paramContext.getResources().getString(2131363249), this.b.tickerText, this.b.contentIntent);
        break;
        localNotification5 = this.b;
        arrayOfObject6 = new Object[2];
        arrayOfObject6[0] = Integer.valueOf(this.g);
        arrayOfObject6[1] = Integer.valueOf(this.h);
      }
    case 3:
      Notification localNotification4;
      Object[] arrayOfObject5;
      if (!TextUtils.isEmpty(this.f))
      {
        localNotification4 = this.b;
        arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = this.f;
      }
      Notification localNotification3;
      Object[] arrayOfObject4;
      for (localNotification4.tickerText = paramContext.getString(2131363259, arrayOfObject5); ; localNotification3.tickerText = paramContext.getString(2131363260, arrayOfObject4))
      {
        this.b.setLatestEventInfo(paramContext, paramContext.getResources().getString(2131363249), this.b.tickerText, this.b.contentIntent);
        break;
        localNotification3 = this.b;
        arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = Integer.valueOf(this.g);
        arrayOfObject4[1] = Integer.valueOf(this.h);
      }
    case 1:
    }
    Notification localNotification2;
    Object[] arrayOfObject3;
    if (!TextUtils.isEmpty(this.f))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.g);
      arrayOfObject2[1] = Integer.valueOf(this.h);
      String str1 = paramContext.getString(2131363247, arrayOfObject2);
      localNotification2 = this.b;
      arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = str1;
      arrayOfObject3[1] = this.f;
    }
    Notification localNotification1;
    Object[] arrayOfObject1;
    for (localNotification2.tickerText = StringUtil.a("%s : %s", arrayOfObject3); ; localNotification1.tickerText = paramContext.getString(2131363247, arrayOfObject1))
    {
      this.b.setLatestEventInfo(paramContext, paramContext.getResources().getString(2131363249), this.b.tickerText, this.b.contentIntent);
      break;
      localNotification1 = this.b;
      arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.g);
      arrayOfObject1[1] = Integer.valueOf(this.h);
    }
  }

  public int a()
  {
    return this.e;
  }

  public void a(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    a(paramContext);
  }

  public void a(Context paramContext, Notification paramNotification, int paramInt)
  {
    this.b = paramNotification;
    this.e = paramInt;
    a(paramContext);
  }

  public String b()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.SystemTrayNotificationManager.MyNotification
 * JD-Core Version:    0.6.0
 */