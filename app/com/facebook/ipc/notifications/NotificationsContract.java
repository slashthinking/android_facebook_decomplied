package com.facebook.ipc.notifications;

import android.net.Uri;
import com.facebook.base.BuildConstants;
import com.google.common.base.Preconditions;

public class NotificationsContract
{
  public static final String a = BuildConstants.b() + ".provider.NotificationsProvider";
  public final String b;
  public final Uri c;

  public NotificationsContract(String paramString)
  {
    this.b = ((String)Preconditions.checkNotNull(paramString));
    this.c = Uri.parse("content://" + paramString + "/" + "notifications");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.notifications.NotificationsContract
 * JD-Core Version:    0.6.0
 */