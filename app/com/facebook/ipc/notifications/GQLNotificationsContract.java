package com.facebook.ipc.notifications;

import android.net.Uri;
import com.facebook.base.BuildConstants;

public class GQLNotificationsContract
{
  public static final String[] a = { "_id", "notif_id", "recipient_id", "seen_state", "updated", "cache_id", "cursor", "gql_payload" };
  public static final String[] b = { "notif_id" };
  public static final String c = BuildConstants.b() + ".provider.GQLNotificationsProvider";
  public final String d = c;
  public final Uri e = Uri.parse("content://" + this.d + "/" + "gql_notifications");

  public GQLNotificationsContract(String paramString)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.notifications.GQLNotificationsContract
 * JD-Core Version:    0.6.0
 */