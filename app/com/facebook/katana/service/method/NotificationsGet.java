package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.google.common.base.Preconditions;
import java.util.Map;

public class NotificationsGet extends ApiMethod
{
  private static ManagedDataStore<String, FacebookNotifications> a;
  private FacebookNotifications b;

  public NotificationsGet(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "notifications.get", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("session_key", paramString);
  }

  public static FacebookNotifications a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    FacebookNotifications localFacebookNotifications = (FacebookNotifications)b(paramContext).a("notifications_history");
    if (localFacebookNotifications == null)
      localFacebookNotifications = new FacebookNotifications();
    return localFacebookNotifications;
  }

  public static void a(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext);
    FacebookNotifications localFacebookNotifications = a(paramContext);
    localFacebookNotifications.a(paramInt);
    b(paramContext).a(paramContext, true, "notifications_history", JMStaticKeysDictDestination.Encoder.a(localFacebookNotifications), localFacebookNotifications);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramContext);
    FacebookNotifications localFacebookNotifications = a(paramContext);
    localFacebookNotifications.a(paramInt1, paramInt2);
    b(paramContext).a(paramContext, true, "notifications_history", JMStaticKeysDictDestination.Encoder.a(localFacebookNotifications), localFacebookNotifications);
  }

  public static void a(Context paramContext, MarkJewelSeen.Jewel paramJewel)
  {
    MarkJewelSeen.a(paramContext, paramJewel);
    FacebookNotifications localFacebookNotifications = a(paramContext);
    switch (NotificationsGet.1.a[paramJewel.ordinal()])
    {
    default:
      ErrorReporting.a("JEWEL_STATE", "Impossible exception: invalid jewel type.", true);
      return;
    case 1:
      localFacebookNotifications.g();
    case 2:
    case 3:
    }
    while (true)
    {
      b(paramContext).a(paramContext, true, "notifications_history", JMStaticKeysDictDestination.Encoder.a(localFacebookNotifications), localFacebookNotifications);
      break;
      localFacebookNotifications.e();
      continue;
      localFacebookNotifications.f();
    }
  }

  private static ManagedDataStore<String, FacebookNotifications> b(Context paramContext)
  {
    if (a == null)
      a = new ManagedDataStore(new NotificationsGet.NotificationsManagedStoreClient(), ManagedDataStore.Mode.SINGLE_REQUEST, paramContext);
    return a;
  }

  public static void b(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext);
    FacebookNotifications localFacebookNotifications = a(paramContext);
    localFacebookNotifications.b(paramInt);
    b(paramContext).a(paramContext, true, "notifications_history", JMStaticKeysDictDestination.Encoder.a(localFacebookNotifications), localFacebookNotifications);
  }

  private static FacebookNotifications d(String paramString)
  {
    return (FacebookNotifications)JMParser.a(FBJsonFactory.a.createJsonParser(paramString), FacebookNotifications.class);
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    String str = paramResponseInputStream.b();
    this.b = d(str);
    b(this.o).a(this.o, true, "notifications_history", str, this.b);
  }

  public FacebookNotifications g()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.NotificationsGet
 * JD-Core Version:    0.6.0
 */