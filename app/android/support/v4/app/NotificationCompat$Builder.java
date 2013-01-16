package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  Context a;
  CharSequence b;
  CharSequence c;
  PendingIntent d;
  PendingIntent e;
  RemoteViews f;
  Bitmap g;
  CharSequence h;
  int i;
  int j;
  boolean k;
  NotificationCompat.Style l;
  CharSequence m;
  int n;
  int o;
  boolean p;
  ArrayList<NotificationCompat.Action> q = new ArrayList();
  Notification r = new Notification();

  public NotificationCompat$Builder(Context paramContext)
  {
    this.a = paramContext;
    this.r.when = System.currentTimeMillis();
    this.r.audioStreamType = -1;
    this.j = 0;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Notification localNotification2 = this.r;
      localNotification2.flags = (paramInt | localNotification2.flags);
    }
    while (true)
    {
      return;
      Notification localNotification1 = this.r;
      localNotification1.flags &= (paramInt ^ 0xFFFFFFFF);
    }
  }

  @Deprecated
  public Notification a()
  {
    return NotificationCompat.a().a(this);
  }

  public Builder a(int paramInt)
  {
    this.r.icon = paramInt;
    return this;
  }

  public Builder a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 1;
    this.r.ledARGB = paramInt1;
    this.r.ledOnMS = paramInt2;
    this.r.ledOffMS = paramInt3;
    int i2;
    Notification localNotification;
    int i3;
    if ((this.r.ledOnMS != 0) && (this.r.ledOffMS != 0))
    {
      i2 = i1;
      localNotification = this.r;
      i3 = 0xFFFFFFFE & this.r.flags;
      if (i2 == 0)
        break label92;
    }
    while (true)
    {
      localNotification.flags = (i3 | i1);
      return this;
      i2 = 0;
      break;
      label92: i1 = 0;
    }
  }

  public Builder a(long paramLong)
  {
    this.r.when = paramLong;
    return this;
  }

  public Builder a(PendingIntent paramPendingIntent)
  {
    this.d = paramPendingIntent;
    return this;
  }

  public Builder a(Uri paramUri, int paramInt)
  {
    this.r.sound = paramUri;
    this.r.audioStreamType = paramInt;
    return this;
  }

  public Builder a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    a(2, paramBoolean);
    return this;
  }

  public Notification b()
  {
    return NotificationCompat.a().a(this);
  }

  public Builder b(int paramInt)
  {
    this.r.defaults = paramInt;
    if ((paramInt & 0x4) != 0)
    {
      Notification localNotification = this.r;
      localNotification.flags = (0x1 | localNotification.flags);
    }
    return this;
  }

  public Builder b(PendingIntent paramPendingIntent)
  {
    this.r.deleteIntent = paramPendingIntent;
    return this;
  }

  public Builder b(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    return this;
  }

  public Builder b(boolean paramBoolean)
  {
    a(16, paramBoolean);
    return this;
  }

  public Builder c(CharSequence paramCharSequence)
  {
    this.r.tickerText = paramCharSequence;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * JD-Core Version:    0.6.0
 */