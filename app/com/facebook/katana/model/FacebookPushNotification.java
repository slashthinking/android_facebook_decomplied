package com.facebook.katana.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.NotificationBuilder;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.NotificationsLogger;
import com.facebook.katana.util.logging.NotificationsLogger.Event;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.photos.util.PhotoUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public class FacebookPushNotification
  implements JMStaticKeysDictDestination
{
  private static final String KEY_ALERT_ID = "i";
  private static final String KEY_CLOSE_FRIEND_TYPE = "type";
  private static final String KEY_COMMENT_ID = "comment_id";
  private static final String KEY_DISABLE_LIGHT = "disable_light";
  private static final String KEY_DISABLE_SOUND = "disable_sound";
  private static final String KEY_DISABLE_VIBRATE = "disable_vibrate";
  private static final String KEY_EID = "eid";
  private static final String KEY_FQL_OBJECT_ID = "obj_id";
  private static final String KEY_FQL_OBJECT_TYPE = "obj_type";
  private static final String KEY_GROUP_ID = "group_id";
  private static final String KEY_ID_OVERRIDE = "id_override";
  private static final String KEY_IS_LOGGED_OUT_PUSH = "is_logged_out_push";
  private static final String KEY_LOG_DATA = "log_data";
  private static final String KEY_MESSAGE_ID = "message_id";
  private static final String KEY_OBJECT_ID = "o";
  private static final String KEY_OBJECT_TYPE = "p";
  private static final String KEY_OID = "oid";
  private static final String KEY_PID = "pid";
  private static final String KEY_POST_ID = "post_id";
  private static final String KEY_UID = "uid";
  private static final String LOG_TAG = FacebookPushNotification.class.getSimpleName();
  private static final Map<FacebookPushNotification.NotificationType, Integer> MAP_IDS;
  private static final Map<FacebookPushNotification.NotificationType, String> MAP_SETTINGS;
  private static final ImmutableMap<String, FacebookPushNotification.NotificationType> MAP_TYPES = ImmutableMap.k().b("orca_message", FacebookPushNotification.NotificationType.MSG).b("msg", FacebookPushNotification.NotificationType.MSG).b("chat", FacebookPushNotification.NotificationType.CHAT).b("wall", FacebookPushNotification.NotificationType.WALL).b("mention", FacebookPushNotification.NotificationType.MENTION).b("friend", FacebookPushNotification.NotificationType.FRIEND).b("friend_confirmed", FacebookPushNotification.NotificationType.FRIEND_CONFIRMED).b("photo_tag", FacebookPushNotification.NotificationType.PHOTO_TAG).b("photo_tag_request", FacebookPushNotification.NotificationType.PHOTO_TAG_REQUEST).b("photo_tagged_by_non_owner", FacebookPushNotification.NotificationType.PHOTO_TAGGED_BY_NON_OWNER).b("event_invite", FacebookPushNotification.NotificationType.EVENT).b("plan_user_invited", FacebookPushNotification.NotificationType.EVENT).b("place_tagged_in_checkin", FacebookPushNotification.NotificationType.PLACE_TAG).b("place_checkin_nearby", FacebookPushNotification.NotificationType.NEARBY).b("item_comment", FacebookPushNotification.NotificationType.COMMENT).b("item_reply", FacebookPushNotification.NotificationType.COMMENT).b("comment_mention", FacebookPushNotification.NotificationType.COMMENT_MENTION).b("like", FacebookPushNotification.NotificationType.LIKE).b("app_request", FacebookPushNotification.NotificationType.APP_REQUEST).b("group_activity", FacebookPushNotification.NotificationType.GROUP_ACTIVITY).b("group_comment", FacebookPushNotification.NotificationType.GROUP_ACTIVITY).b("hotp_login_approvals", FacebookPushNotification.NotificationType.CODE_GENERATOR).b("close_friend_activity", FacebookPushNotification.NotificationType.CLOSE_FRIEND_ACTIVITY).b("tagged_with_story", FacebookPushNotification.NotificationType.TAGGED_WITH_STORY).b("share_wall_create", FacebookPushNotification.NotificationType.SHARE_WALL_CREATE).b("activate_vault", FacebookPushNotification.NotificationType.ACTIVATE_VAULT).b("birthday_reminder", FacebookPushNotification.NotificationType.BIRTHDAY_REMINDER).b("gift_recipient", FacebookPushNotification.NotificationType.GIFT_RECIPIENT).b("stale_client_notification", FacebookPushNotification.NotificationType.STALE_CLIENT_NOTIFICATION).b("request_location_update", FacebookPushNotification.NotificationType.BACKGROUND_LOCATION).b();
  private static final String OBJECT_TYPE_STREAM = "stream";
  private static final String TRACE_INFO_KEY = "trace_info";
  private Long mAlertID;

  @JMAutogen.InferredType(jsonFieldName="href")
  public final String mHref = null;

  @JMAutogen.InferredType(jsonFieldName="is_logged_out_push")
  public final boolean mIsLoggedOutPush = false;

  @JMAutogen.InferredType(jsonFieldName="message")
  public final String mMessage = null;

  @JMAutogen.InferredType(jsonFieldName="params")
  public final Map<Object, Object> mParams = null;
  public String mRawPushData;

  @JMAutogen.InferredType(jsonFieldName="target_uid")
  public final long mTargetUid = -1L;

  @JMAutogen.InferredType(jsonFieldName="time")
  public final long mTimestamp = 0L;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String mType = null;

  @JMAutogen.InferredType(jsonFieldName="unread_count")
  public final int mUnreadCount = 0;

  static
  {
    MAP_SETTINGS = ImmutableMap.k().b(FacebookPushNotification.NotificationType.MSG, "notif_messages").b(FacebookPushNotification.NotificationType.WALL, "notif_wall_posts").b(FacebookPushNotification.NotificationType.SHARE_WALL_CREATE, "notif_wall_posts").b(FacebookPushNotification.NotificationType.FRIEND, "notif_friend_requests").b(FacebookPushNotification.NotificationType.FRIEND_CONFIRMED, "notif_friend_confirmations").b(FacebookPushNotification.NotificationType.PHOTO_TAG, "notif_photo_tags").b(FacebookPushNotification.NotificationType.PHOTO_TAG_REQUEST, "notif_photo_tags").b(FacebookPushNotification.NotificationType.PHOTO_TAGGED_BY_NON_OWNER, "notif_photo_tags").b(FacebookPushNotification.NotificationType.EVENT, "notif_event_invites").b(FacebookPushNotification.NotificationType.PLACE_TAG, "notif_place_tags").b(FacebookPushNotification.NotificationType.TAGGED_WITH_STORY, "notif_place_tags").b(FacebookPushNotification.NotificationType.NEARBY, "notif_nearby_friends").b(FacebookPushNotification.NotificationType.COMMENT, "notif_comments").b(FacebookPushNotification.NotificationType.COMMENT_MENTION, "notif_comments").b(FacebookPushNotification.NotificationType.APP_REQUEST, "notif_app_requests").b(FacebookPushNotification.NotificationType.GROUP_ACTIVITY, "notif_groups").b();
    MAP_IDS = ImmutableMap.k().b(FacebookPushNotification.NotificationType.MSG, Integer.valueOf(1)).b(FacebookPushNotification.NotificationType.WALL, Integer.valueOf(9)).b(FacebookPushNotification.NotificationType.MENTION, Integer.valueOf(25)).b(FacebookPushNotification.NotificationType.FRIEND, Integer.valueOf(2)).b(FacebookPushNotification.NotificationType.FRIEND_CONFIRMED, Integer.valueOf(10)).b(FacebookPushNotification.NotificationType.PHOTO_TAG, Integer.valueOf(8)).b(FacebookPushNotification.NotificationType.PHOTO_TAG_REQUEST, Integer.valueOf(24)).b(FacebookPushNotification.NotificationType.PHOTO_TAGGED_BY_NON_OWNER, Integer.valueOf(8)).b(FacebookPushNotification.NotificationType.EVENT, Integer.valueOf(3)).b(FacebookPushNotification.NotificationType.PLACE_TAG, Integer.valueOf(14)).b(FacebookPushNotification.NotificationType.NEARBY, Integer.valueOf(5)).b(FacebookPushNotification.NotificationType.COMMENT, Integer.valueOf(12)).b(FacebookPushNotification.NotificationType.COMMENT_MENTION, Integer.valueOf(12)).b(FacebookPushNotification.NotificationType.LIKE, Integer.valueOf(26)).b(FacebookPushNotification.NotificationType.APP_REQUEST, Integer.valueOf(13)).b(FacebookPushNotification.NotificationType.GROUP_ACTIVITY, Integer.valueOf(6)).b(FacebookPushNotification.NotificationType.CHAT, Integer.valueOf(4)).b(FacebookPushNotification.NotificationType.CODE_GENERATOR, Integer.valueOf(15)).b(FacebookPushNotification.NotificationType.CLOSE_FRIEND_ACTIVITY, Integer.valueOf(20)).b(FacebookPushNotification.NotificationType.TAGGED_WITH_STORY, Integer.valueOf(21)).b(FacebookPushNotification.NotificationType.SHARE_WALL_CREATE, Integer.valueOf(22)).b(FacebookPushNotification.NotificationType.ACTIVATE_VAULT, Integer.valueOf(27)).b(FacebookPushNotification.NotificationType.BIRTHDAY_REMINDER, Integer.valueOf(23)).b(FacebookPushNotification.NotificationType.GIFT_RECIPIENT, Integer.valueOf(30)).b(FacebookPushNotification.NotificationType.STALE_CLIENT_NOTIFICATION, Integer.valueOf(31)).b(FacebookPushNotification.NotificationType.DEFAULT, Integer.valueOf(1000)).b();
  }

  private static Integer a(Map<Object, Object> paramMap, String paramString)
  {
    try
    {
      String str = c(paramMap, paramString);
      if (!StringUtils.c(str))
      {
        Integer localInteger2 = Integer.valueOf(Integer.parseInt(str));
        localInteger1 = localInteger2;
        return localInteger1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        Log.a(LOG_TAG, "NumberFormatException: " + paramString + " must be a number", localNumberFormatException);
        Integer localInteger1 = null;
      }
    }
  }

  private void a(Intent paramIntent, Context paramContext, CharSequence paramCharSequence, int paramInt, NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    if (paramIntent != null)
    {
      String str = paramContext.getResources().getString(2131362037);
      NotificationBuilder localNotificationBuilder = new NotificationBuilder(paramContext).a(paramCharSequence).b(paramCharSequence).c(str).a(paramInt).a(System.currentTimeMillis());
      if (a("disable_light"))
        localNotificationBuilder.a();
      if (a("disable_sound"))
        localNotificationBuilder.c();
      if (a("disable_vibrate"))
        localNotificationBuilder.b();
      SystemTrayNotificationManager.a(paramContext, paramNotificationLogObject.c(), localNotificationBuilder, paramIntent, paramNotificationLogObject);
    }
    while (true)
    {
      return;
      ErrorReporting.a(LOG_TAG, "intent is null for notification type: " + a(), true);
    }
  }

  private static boolean a(SharedPreferences paramSharedPreferences, String paramString)
  {
    int i;
    if (!Boolean.valueOf(paramSharedPreferences.getBoolean(FbandroidPrefKeys.n.toString(), false)).booleanValue())
    {
      boolean bool = paramSharedPreferences.getBoolean(paramString, true);
      i = 0;
      if (!bool);
    }
    else
    {
      i = 1;
    }
    return i;
  }

  private static FacebookPushNotification.NotificationType b(String paramString)
  {
    FacebookPushNotification.NotificationType localNotificationType;
    if (paramString != null)
    {
      int i = paramString.indexOf(':');
      if (i >= 0)
        paramString = paramString.substring(0, i);
      localNotificationType = (FacebookPushNotification.NotificationType)MAP_TYPES.get(paramString);
      if (localNotificationType == null);
    }
    while (true)
    {
      return localNotificationType;
      localNotificationType = FacebookPushNotification.NotificationType.DEFAULT;
    }
  }

  private static Long b(Map<Object, Object> paramMap, String paramString)
  {
    try
    {
      String str = c(paramMap, paramString);
      if (!StringUtils.c(str))
      {
        Long localLong2 = Long.valueOf(Long.parseLong(str));
        localLong1 = localLong2;
        return localLong1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        Log.a(LOG_TAG, "NumberFormatException: " + paramString + " must be a number", localNumberFormatException);
        Long localLong1 = null;
      }
    }
  }

  private static String c(Map<Object, Object> paramMap, String paramString)
  {
    boolean bool = paramMap.containsKey(paramString);
    String str = null;
    Object localObject;
    if (bool)
    {
      localObject = paramMap.get(paramString);
      str = null;
      if (localObject != null)
        break label32;
    }
    while (true)
    {
      return str;
      label32: str = localObject.toString();
    }
  }

  private Long f()
  {
    long l;
    if (this.mAlertID == null)
    {
      this.mAlertID = b(this.mParams, "i");
      if (this.mAlertID != null)
        break label42;
      l = 0L;
    }
    while (true)
    {
      this.mAlertID = Long.valueOf(l);
      return this.mAlertID;
      label42: l = this.mAlertID.longValue();
    }
  }

  public FacebookPushNotification.NotificationType a()
  {
    return b(this.mType);
  }

  public void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    NotificationHelper localNotificationHelper = (NotificationHelper)FbInjector.a(paramContext).a(NotificationHelper.class);
    FacebookPushNotification.NotificationType localNotificationType = a();
    String str1 = this.mMessage;
    int i = 2130838949;
    Integer localInteger1 = (Integer)MAP_IDS.get(localNotificationType);
    Intent localIntent1 = null;
    Object localObject1;
    Object localObject2;
    switch (FacebookPushNotification.1.a[localNotificationType.ordinal()])
    {
    default:
      localObject1 = Integer.valueOf(1000);
      localObject2 = null;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    }
    while (true)
    {
      if (localObject1 == null)
      {
        ErrorReporting.a(LOG_TAG, "id was null, defaulting to SystemTrayNotificationManager.TYPE_DEFAULT", true);
        localObject1 = Integer.valueOf(1000);
      }
      Integer localInteger2 = a(this.mParams, "id_override");
      if ((localInteger2 != null) && (localInteger2.intValue() >= 110001) && (localInteger2.intValue() <= 120000))
        localObject1 = localInteger2;
      NotificationsLogger.NotificationLogObject localNotificationLogObject = b().a(((Integer)localObject1).intValue());
      String str2 = (String)MAP_SETTINGS.get(localNotificationType);
      label296: String str13;
      Long localLong2;
      if ((str2 != null) && (!a(localSharedPreferences, str2)))
      {
        NotificationsLogger.a(paramContext, localNotificationLogObject, NotificationsLogger.Event.DROPPED_BY_INDIVIDUAL_SETTING);
        return;
        AppSession localAppSession2 = AppSession.b(paramContext, false);
        if (localAppSession2 == null)
          break label1383;
        Intent localIntent21 = IntentUtils.a(paramContext, localAppSession2.b().userId);
        localObject1 = localInteger1;
        localObject2 = localIntent21;
        continue;
        i = 2130838950;
        Intent localIntent20 = IntentUriHandler.a(paramContext, "fb://friends/requests/");
        localObject1 = localInteger1;
        localObject2 = localIntent20;
        continue;
        Long localLong5 = b(this.mParams, "uid");
        if (localLong5 == null)
          break label1383;
        Intent localIntent19 = IntentUtils.a(paramContext, localLong5.longValue());
        localObject1 = localInteger1;
        localObject2 = localIntent19;
        continue;
        i = 2130838951;
        String str16 = c(this.mParams, "eid");
        boolean bool2 = StringUtils.c(str16);
        Intent localIntent17 = null;
        if (!bool2)
          localIntent17 = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://event/%s", new Object[] { str16 }));
        if (localIntent17 == null)
        {
          Intent localIntent18 = IntentUriHandler.a(paramContext, "fb://events");
          localObject1 = Integer.valueOf(3);
          localObject2 = localIntent18;
          continue;
        }
        localObject1 = Integer.valueOf(11);
        localObject2 = localIntent17;
        continue;
        String str14 = c(this.mParams, "obj_id");
        String str15 = c(this.mParams, "obj_type");
        if ((StringUtils.c(str14)) || (StringUtils.c(str15)))
          break label1383;
        Intent localIntent16 = localNotificationHelper.a(str15, str14, "", "");
        localObject1 = localInteger1;
        localObject2 = localIntent16;
        continue;
        Long localLong3 = b(this.mParams, "uid");
        Long localLong4 = b(this.mParams, "pid");
        if ((localLong3 == null) || (localLong4 == null))
          break label1383;
        Intent localIntent15 = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://photo/%s/%s", new Object[] { localLong3, PhotoUtils.a(localLong4.longValue(), localLong3.longValue()) }));
        localObject1 = localInteger1;
        localObject2 = localIntent15;
        continue;
        str13 = c(this.mParams, "group_id");
        if (StringUtils.c(str13))
          break label1383;
        localLong2 = b(this.mParams, "message_id");
        if (localLong2 == null)
          break label1393;
      }
      label1383: label1393: for (Intent localIntent13 = IntentUriHandler.a(paramContext, localNotificationHelper.a(str13, localLong2.toString(), StringLocaleUtil.a("fb://group/%s/wall/inner", new Object[] { str13 }))); ; localIntent13 = null)
      {
        Intent localIntent14 = localIntent13;
        localObject1 = localInteger1;
        localObject2 = localIntent14;
        break;
        String str8 = c(this.mParams, "post_id");
        String str9 = c(this.mParams, "pid");
        if (!StringUtils.c(str8))
        {
          Intent localIntent12 = localNotificationHelper.a("stream", str8, "", "");
          localObject1 = localInteger1;
          localObject2 = localIntent12;
          break;
        }
        if (!StringUtils.c(str9))
        {
          try
          {
            String str10 = PhotoUtils.b(str9);
            String str11 = PhotoUtils.a(str9);
            Boolean localBoolean = (Boolean)FbInjector.a(paramContext).a(Boolean.class, IsNativeNewsFeedEnabled.class);
            boolean bool1 = Boolean.TRUE.equals(localBoolean);
            localIntent1 = null;
            if (bool1);
            String str12;
            for (Object localObject3 = StringLocaleUtil.a("fb://photo/%s/%s", new Object[] { str10, str9 }); ; localObject3 = str12)
            {
              localIntent1 = null;
              if (localObject3 == null)
                break;
              localIntent1 = IntentUriHandler.a(paramContext, (String)localObject3);
              break;
              str12 = StringLocaleUtil.a("fb://photofeedback/%s/%s", new Object[] { str10, str11 });
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.a(LOG_TAG, "Error in splitting photo id");
            localObject1 = localInteger1;
            localObject2 = localIntent1;
          }
          break;
          String str6 = c(this.mParams, "obj_id");
          String str7 = c(this.mParams, "obj_type");
          if ((!StringUtils.c(str6)) && (!StringUtils.c(str7)))
          {
            Intent localIntent11 = localNotificationHelper.a(str7, str6, "", "");
            localObject1 = localInteger1;
            localObject2 = localIntent11;
            break;
            Intent localIntent10 = IntentUriHandler.a(paramContext, "fb://codegenerator");
            localObject1 = localInteger1;
            localObject2 = localIntent10;
            break;
            Intent localIntent9 = localNotificationHelper.a(c(this.mParams, "type"), c(this.mParams, "oid"), "", "");
            localObject1 = localInteger1;
            localObject2 = localIntent9;
            break;
            String str5 = c(this.mParams, "o");
            if (!StringUtils.c(str5))
            {
              Intent localIntent8 = localNotificationHelper.a("stream", str5, "", "");
              localObject1 = localInteger1;
              localObject2 = localIntent8;
              break;
              String str3 = c(this.mParams, "o");
              if (!StringUtils.c(str3))
              {
                String str4 = StringLocaleUtil.a("fb://photo/%s", new Object[] { str3 });
                if (str4 != null)
                {
                  Intent localIntent7 = IntentUriHandler.a(paramContext, str4);
                  localObject1 = localInteger1;
                  localObject2 = localIntent7;
                  break;
                  Intent localIntent6 = IntentUriHandler.a(paramContext, this.mHref);
                  localObject1 = localInteger1;
                  localObject2 = localIntent6;
                  break;
                  Intent localIntent5 = IntentUriHandler.a(paramContext, "fb://photosync");
                  localIntent5.putExtra("nux_ref", "web_notif");
                  localObject1 = localInteger1;
                  localObject2 = localIntent5;
                  break;
                  i = 2130838947;
                  Long localLong1 = b(this.mParams, "uid");
                  if (localLong1 != null)
                  {
                    Intent localIntent4 = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://profile/%s", new Object[] { localLong1 }));
                    localObject1 = localInteger1;
                    localObject2 = localIntent4;
                    break;
                  }
                  Intent localIntent3 = IntentUriHandler.a(paramContext, "fb://birthdays");
                  localObject1 = localInteger1;
                  localObject2 = localIntent3;
                  break;
                  Intent localIntent2 = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://gift/receive?gid=%s", new Object[] { b(this.mParams, "o") }));
                  localObject1 = localInteger1;
                  localObject2 = localIntent2;
                  break;
                  if (localObject2 == null)
                  {
                    AppSession localAppSession1 = AppSession.a(paramContext, false);
                    if (localAppSession1 == null)
                      break label296;
                    localAppSession1.a(new FacebookPushNotification.FetchNotificationListener(this, paramContext, str1, i, localNotificationLogObject, localAppSession1.f(paramContext)));
                    break label296;
                  }
                  a((Intent)localObject2, paramContext, str1, i, localNotificationLogObject);
                  break label296;
                }
              }
            }
          }
        }
        localObject1 = localInteger1;
        localObject2 = null;
        break;
      }
      localObject1 = localInteger1;
      localObject2 = localIntent1;
    }
  }

  public boolean a(String paramString)
  {
    Long localLong = b(this.mParams, paramString);
    int i = 0;
    if (localLong != null)
    {
      boolean bool = 1L < localLong.longValue();
      i = 0;
      if (!bool)
        i = 1;
    }
    return i;
  }

  public NotificationsLogger.NotificationLogObject b()
  {
    return new NotificationsLogger.NotificationLogObject().a(this.mType).a(a()).d(c(this.mParams, "log_data")).a(f().longValue()).b(c(this.mParams, "o")).c(c(this.mParams, "p"));
  }

  public boolean c()
  {
    return this.mIsLoggedOutPush;
  }

  public long d()
  {
    return this.mTargetUid;
  }

  public boolean e()
  {
    if (this.mTargetUid != -1L);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPushNotification
 * JD-Core Version:    0.6.0
 */