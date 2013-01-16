package com.facebook.katana.c2dm;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.base.BuildConstants;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.notifications.PushNotificationsContract;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookPushNotification;
import com.facebook.katana.model.FacebookPushNotification.NotificationType;
import com.facebook.katana.provider.PushNotificationsProvider;
import com.facebook.katana.util.MessengerUserUtils;
import com.facebook.katana.util.MessengerUserUtils.UserStatus;
import com.facebook.katana.util.logging.NotificationsLogger;
import com.facebook.katana.util.logging.NotificationsLogger.Event;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.LoggedOutMessageNotification;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.push.PushSource;
import com.facebook.orca.push.c2dm.BaseC2DMPushHandler;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.threads.Message;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONStringer;

public class FbandroidC2dmPushHandler extends BaseC2DMPushHandler
{
  private static final Class<?> a = FbandroidC2dmPushHandler.class;
  private final Context b;
  private final SharedPreferences c;
  private final ObjectMapper d;
  private final PushDeserialization e;
  private final OrcaNotificationManager f;
  private final PushTokenHolder g;
  private final Resources h;

  public FbandroidC2dmPushHandler(Context paramContext, SharedPreferences paramSharedPreferences, ObjectMapper paramObjectMapper, PushDeserialization paramPushDeserialization, OrcaNotificationManager paramOrcaNotificationManager, ReliabilityAnalyticsLogger paramReliabilityAnalyticsLogger, PushTokenHolder paramPushTokenHolder, Resources paramResources)
  {
    super(paramReliabilityAnalyticsLogger);
    this.b = paramContext;
    this.c = paramSharedPreferences;
    this.d = paramObjectMapper;
    this.e = paramPushDeserialization;
    this.f = paramOrcaNotificationManager;
    this.g = paramPushTokenHolder;
    this.h = paramResources;
  }

  private void a(Context paramContext, FacebookPushNotification paramFacebookPushNotification)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("noti_type", paramFacebookPushNotification.mType);
    localContentValues.put("noti_time", Long.valueOf(paramFacebookPushNotification.mTimestamp));
    localContentValues.put("receipt_time", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("target_uid", Long.valueOf(paramFacebookPushNotification.mTargetUid));
    localContentValues.put("message", paramFacebookPushNotification.mMessage);
    localContentValues.put("unread_count", Integer.valueOf(paramFacebookPushNotification.mUnreadCount));
    if (!TextUtils.isEmpty(paramFacebookPushNotification.mHref))
      localContentValues.put("href", paramFacebookPushNotification.mHref);
    JSONStringer localJSONStringer;
    if ((paramFacebookPushNotification.mParams != null) && (paramFacebookPushNotification.mParams.size() > 0))
      try
      {
        localJSONStringer = new JSONStringer();
        localJSONStringer.object();
        Iterator localIterator = paramFacebookPushNotification.mParams.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONStringer.key(String.valueOf(localEntry.getKey())).value(localEntry.getValue());
        }
      }
      catch (JSONException localJSONException)
      {
        BLog.e(a, "Error in serializing params of push notification", localJSONException);
      }
    while (true)
    {
      return;
      localJSONStringer.endObject();
      localContentValues.put("params", localJSONStringer.toString());
      ContentResolver localContentResolver = paramContext.getContentResolver();
      localContentResolver.insert(PushNotificationsContract.b, localContentValues);
      PushNotificationsProvider.a(localContentResolver);
    }
  }

  private void a(Context paramContext, String paramString)
  {
    JsonNode localJsonNode1 = this.d.readTree(paramString);
    String str1 = JSONUtil.b(localJsonNode1.get("type"));
    String str2 = JSONUtil.b(localJsonNode1.get("message"));
    if ((!"msg".equals(str1)) && (!"orca_message".equals(str1)));
    while (true)
    {
      return;
      JsonNode localJsonNode2 = localJsonNode1.get("params");
      Message localMessage = this.e.a(str2, localJsonNode2);
      if (localMessage == null)
      {
        c("invalid_payload");
        continue;
      }
      if (MessengerUserUtils.a(paramContext, this.g.h()).a())
      {
        BLog.b(a, "User logged into Messenger, eating notification");
        c("eaten_messenger");
        continue;
      }
      this.f.a(str2, localMessage, PushSource.C2DM);
    }
  }

  private void b(Context paramContext, String paramString)
  {
    JsonNode localJsonNode = this.d.readTree(paramString);
    boolean bool = JSONUtil.f(localJsonNode.get("is_logged_out_push"));
    String str = JSONUtil.b(localJsonNode.get("message"));
    if (!bool);
    while (true)
    {
      return;
      if (MessengerUserUtils.a(paramContext, this.g.h()).b())
      {
        BLog.b(a, "User receives notifications in Messenger, eating notification");
        c("eaten_messenger");
        continue;
      }
      LoggedOutMessageNotification localLoggedOutMessageNotification = new LoggedOutMessageNotification(this.h.getString(2131362037), str, PushSource.C2DM);
      this.f.a(localLoggedOutMessageNotification);
    }
  }

  private FacebookPushNotification d(String paramString)
  {
    return (FacebookPushNotification)JMParser.a(new JsonFactory().createJsonParser(paramString), FacebookPushNotification.class);
  }

  public void a(int paramInt)
  {
  }

  public void a(String paramString)
  {
    if (StringUtil.a(paramString))
      c("invalid_payload");
    FacebookPushNotification localFacebookPushNotification;
    AppSession localAppSession;
    while (true)
    {
      return;
      try
      {
        localFacebookPushNotification = d(paramString);
        localAppSession = AppSession.b(this.b, false);
        if ((localAppSession != null) || (localFacebookPushNotification.c()))
          break label91;
        BLog.b(a, "Ignore push no meUser");
        c("logged_out_user");
      }
      catch (IOException localIOException1)
      {
        BLog.e(a, "IOException", localIOException1);
      }
      catch (JMException localJMException)
      {
        BLog.e(a, "JMException", localJMException);
      }
      continue;
      label91: if ((localAppSession != null) && (localFacebookPushNotification.c()))
      {
        BLog.b(a, "Ignore logged out push since a user is logged in");
        c("logged_in_user");
        continue;
      }
      NotificationsLogger.a(this.b, localFacebookPushNotification.b(), NotificationsLogger.Event.PUSH_NOTIFICATION_RECEIVED);
      if ((!localFacebookPushNotification.e()) || (Long.toString(localFacebookPushNotification.d()).equals(this.g.h())))
        break;
      c("eaten_wrong_user");
    }
    if (this.c.getBoolean("notif", true))
      if (localFacebookPushNotification.a() != FacebookPushNotification.NotificationType.MSG);
    while (true)
    {
      try
      {
        if (!localFacebookPushNotification.c())
          continue;
        b(this.b, paramString);
        if (!BuildConstants.a())
          break;
        a(this.b, localFacebookPushNotification);
        break;
        a(this.b, paramString);
        continue;
      }
      catch (IOException localIOException2)
      {
        BLog.e(a, "IOException processing orca message", localIOException2);
      }
      break;
      localFacebookPushNotification.a(this.b);
      if (localAppSession == null)
        continue;
      localAppSession.b(this.b, 1, false);
      continue;
      NotificationsLogger.a(this.b, localFacebookPushNotification.b(), NotificationsLogger.Event.DROPPED_BY_OVERALL_SETTING);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.FbandroidC2dmPushHandler
 * JD-Core Version:    0.6.0
 */