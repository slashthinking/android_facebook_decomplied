package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class NotificationsMarkRead extends ApiMethod
{
  public NotificationsMarkRead(Context paramContext, Intent paramIntent, String paramString, long[] paramArrayOfLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "notifications.markRead", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("session_key", paramString);
    Map localMap = this.e;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = IntentUtils.a(paramArrayOfLong);
    localMap.put("notification_ids", StringUtils.a(",", arrayOfObject));
  }

  public static void a(Context paramContext, String paramString)
  {
    NotificationsContract localNotificationsContract = (NotificationsContract)FbInjector.a(paramContext).a(NotificationsContract.class);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("is_unread", Integer.valueOf(0));
    String str = "notif_id IN(" + paramString + ")";
    paramContext.getContentResolver().update(localNotificationsContract.c, localContentValues, str, null);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonResponseVerifier.a(paramJsonParser);
    a(this.o, (String)this.e.get("notification_ids"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.NotificationsMarkRead
 * JD-Core Version:    0.6.0
 */