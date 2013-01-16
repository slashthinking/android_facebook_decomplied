package com.facebook.ipc.notifications;

import android.net.Uri;
import com.facebook.base.BuildConstants;

public class PushNotificationsContract
{
  public static final String a = BuildConstants.b() + ".provider.PushNotificationsProvider";
  public static final Uri b = Uri.parse("content://" + a + "/" + "push_notifications");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.notifications.PushNotificationsContract
 * JD-Core Version:    0.6.0
 */