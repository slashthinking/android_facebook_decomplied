package com.facebook.orca.notify;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.push.PushSource;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.Message;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public class OrcaNotificationManager
{
  private static final Class<?> a = OrcaNotificationManager.class;
  private final Context b;
  private final NotificationSettingsUtil c;
  private final UserActivityManager d;
  private final Set<MessagingNotificationHandler> e;
  private final AndroidThreadUtil f;
  private final MeUserAuthDataStore g;
  private final Handler h;
  private final String i;
  private final ReliabilityAnalyticsLogger j;
  private final Provider<Boolean> k;
  private final PushTokenHolder l;
  private final Map<String, AlertDisposition> m = Maps.a();
  private volatile long n;
  private volatile FolderCounts o;

  public OrcaNotificationManager(Context paramContext, NotificationSettingsUtil paramNotificationSettingsUtil, UserActivityManager paramUserActivityManager, Set<MessagingNotificationHandler> paramSet, AndroidThreadUtil paramAndroidThreadUtil, MeUserAuthDataStore paramMeUserAuthDataStore, String paramString, ReliabilityAnalyticsLogger paramReliabilityAnalyticsLogger, Provider<Boolean> paramProvider, PushTokenHolder paramPushTokenHolder)
  {
    this.b = paramContext;
    this.c = paramNotificationSettingsUtil;
    this.d = paramUserActivityManager;
    this.e = paramSet;
    this.f = paramAndroidThreadUtil;
    this.g = paramMeUserAuthDataStore;
    this.h = new Handler(Looper.getMainLooper());
    this.i = paramString;
    this.j = paramReliabilityAnalyticsLogger;
    this.k = paramProvider;
    this.l = paramPushTokenHolder;
  }

  private AlertDisposition a(Message paramMessage)
  {
    synchronized (this.m)
    {
      AlertDisposition localAlertDisposition = (AlertDisposition)this.m.get(paramMessage.a());
      if ((localAlertDisposition == null) && (paramMessage.t() != null))
        localAlertDisposition = (AlertDisposition)this.m.get(paramMessage.t());
      if (localAlertDisposition == null)
        localAlertDisposition = new AlertDisposition();
      this.m.put(paramMessage.a(), localAlertDisposition);
      if (paramMessage.t() != null)
        this.m.put(paramMessage.t(), localAlertDisposition);
      localAlertDisposition.a(System.currentTimeMillis());
      return localAlertDisposition;
    }
  }

  // ERROR //
  private OrcaNotificationManager.ThreadNotificationsState a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: getstatic 42	com/facebook/orca/notify/OrcaNotificationManager:a	Ljava/lang/Class;
    //   5: new 124	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   12: ldc 127
    //   14: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_2
    //   18: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 139	com/facebook/orca/debug/BLog:b	(Ljava/lang/Class;Ljava/lang/String;)V
    //   27: new 141	com/fasterxml/jackson/databind/node/ObjectNode
    //   30: dup
    //   31: getstatic 147	com/fasterxml/jackson/databind/node/JsonNodeFactory:instance	Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
    //   34: invokespecial 150	com/fasterxml/jackson/databind/node/ObjectNode:<init>	(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc 152
    //   43: aload_1
    //   44: invokevirtual 155	com/fasterxml/jackson/databind/node/ObjectNode:put	(Ljava/lang/String;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/ObjectNode;
    //   47: pop
    //   48: aload 4
    //   50: ldc 157
    //   52: aload_2
    //   53: invokevirtual 155	com/fasterxml/jackson/databind/node/ObjectNode:put	(Ljava/lang/String;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/ObjectNode;
    //   56: pop
    //   57: aload_0
    //   58: getfield 55	com/facebook/orca/notify/OrcaNotificationManager:b	Landroid/content/Context;
    //   61: invokevirtual 163	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   64: aload_0
    //   65: getfield 80	com/facebook/orca/notify/OrcaNotificationManager:i	Ljava/lang/String;
    //   68: invokestatic 169	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   71: aconst_null
    //   72: aload 4
    //   74: invokevirtual 170	com/fasterxml/jackson/databind/node/ObjectNode:toString	()Ljava/lang/String;
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 176	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 11
    //   84: aload 11
    //   86: ifnull +241 -> 327
    //   89: iconst_0
    //   90: istore 12
    //   92: iconst_0
    //   93: istore 6
    //   95: aload 11
    //   97: invokeinterface 182 1 0
    //   102: ifeq +83 -> 185
    //   105: aload 11
    //   107: iconst_0
    //   108: invokeinterface 186 2 0
    //   113: istore 20
    //   115: iload 20
    //   117: ifle +56 -> 173
    //   120: iconst_1
    //   121: istore 21
    //   123: iload 21
    //   125: iload 6
    //   127: ior
    //   128: istore 14
    //   130: aload 11
    //   132: invokeinterface 190 1 0
    //   137: iconst_2
    //   138: if_icmplt +182 -> 320
    //   141: aload 11
    //   143: iconst_1
    //   144: invokeinterface 186 2 0
    //   149: istore 22
    //   151: iload 22
    //   153: ifle +26 -> 179
    //   156: iconst_1
    //   157: istore 23
    //   159: iload 12
    //   161: iload 23
    //   163: ior
    //   164: istore 12
    //   166: iload 14
    //   168: istore 6
    //   170: goto -75 -> 95
    //   173: iconst_0
    //   174: istore 21
    //   176: goto -53 -> 123
    //   179: iconst_0
    //   180: istore 23
    //   182: goto -23 -> 159
    //   185: aload 11
    //   187: invokeinterface 193 1 0
    //   192: iload 12
    //   194: istore_3
    //   195: new 195	com/facebook/orca/notify/OrcaNotificationManager$ThreadNotificationsState
    //   198: dup
    //   199: iload 6
    //   201: iload_3
    //   202: aconst_null
    //   203: invokespecial 198	com/facebook/orca/notify/OrcaNotificationManager$ThreadNotificationsState:<init>	(ZZLcom/facebook/orca/notify/OrcaNotificationManager$1;)V
    //   206: areturn
    //   207: astore 13
    //   209: iload 6
    //   211: istore 14
    //   213: aload 13
    //   215: astore 15
    //   217: aload 11
    //   219: invokeinterface 193 1 0
    //   224: aload 15
    //   226: athrow
    //   227: astore 17
    //   229: iload 12
    //   231: istore_3
    //   232: iload 14
    //   234: istore 6
    //   236: getstatic 42	com/facebook/orca/notify/OrcaNotificationManager:a	Ljava/lang/Class;
    //   239: ldc 200
    //   241: invokestatic 202	com/facebook/orca/debug/BLog:a	(Ljava/lang/Class;Ljava/lang/String;)V
    //   244: goto -49 -> 195
    //   247: astore 7
    //   249: aload 7
    //   251: astore 8
    //   253: iconst_0
    //   254: istore 6
    //   256: getstatic 42	com/facebook/orca/notify/OrcaNotificationManager:a	Ljava/lang/Class;
    //   259: ldc 204
    //   261: aload 8
    //   263: invokestatic 207	com/facebook/orca/debug/BLog:b	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: goto -71 -> 195
    //   269: astore 19
    //   271: iload 12
    //   273: istore_3
    //   274: aload 19
    //   276: astore 8
    //   278: goto -22 -> 256
    //   281: astore 16
    //   283: iload 12
    //   285: istore_3
    //   286: aload 16
    //   288: astore 8
    //   290: iload 14
    //   292: istore 6
    //   294: goto -38 -> 256
    //   297: astore 5
    //   299: iconst_0
    //   300: istore 6
    //   302: iconst_0
    //   303: istore_3
    //   304: goto -68 -> 236
    //   307: astore 18
    //   309: iload 12
    //   311: istore_3
    //   312: goto -76 -> 236
    //   315: astore 15
    //   317: goto -100 -> 217
    //   320: iload 14
    //   322: istore 6
    //   324: goto -229 -> 95
    //   327: iconst_0
    //   328: istore 6
    //   330: iconst_0
    //   331: istore_3
    //   332: goto -137 -> 195
    //
    // Exception table:
    //   from	to	target	type
    //   95	115	207	finally
    //   217	227	227	java/lang/SecurityException
    //   27	84	247	java/lang/Exception
    //   185	192	269	java/lang/Exception
    //   217	227	281	java/lang/Exception
    //   27	84	297	java/lang/SecurityException
    //   185	192	307	java/lang/SecurityException
    //   130	151	315	finally
  }

  private void a(PushSource paramPushSource, String paramString, Map<String, String> paramMap)
  {
    String str = "messaging_push_notif_" + paramPushSource;
    this.j.a(str, paramString, paramMap, null, null);
  }

  private void a(Message paramMessage, PushSource paramPushSource, String paramString)
  {
    this.j.a(paramMessage.a(), paramMessage.b(), paramPushSource.toString(), paramString);
  }

  // ERROR //
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/facebook/orca/notify/OrcaNotificationManager:m	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/facebook/orca/notify/OrcaNotificationManager:m	Ljava/util/Map;
    //   11: invokeinterface 239 1 0
    //   16: bipush 100
    //   18: if_icmpge +8 -> 26
    //   21: aload_1
    //   22: monitorexit
    //   23: goto +78 -> 101
    //   26: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   29: lstore_3
    //   30: aload_0
    //   31: getfield 53	com/facebook/orca/notify/OrcaNotificationManager:m	Ljava/util/Map;
    //   34: invokeinterface 243 1 0
    //   39: invokeinterface 249 1 0
    //   44: astore 5
    //   46: aload 5
    //   48: invokeinterface 254 1 0
    //   53: ifeq +46 -> 99
    //   56: lload_3
    //   57: aload 5
    //   59: invokeinterface 258 1 0
    //   64: checkcast 100	com/facebook/orca/notify/AlertDisposition
    //   67: invokevirtual 260	com/facebook/orca/notify/AlertDisposition:a	()J
    //   70: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 269	java/lang/Long:longValue	()J
    //   76: lsub
    //   77: ldc2_w 270
    //   80: lcmp
    //   81: ifle -35 -> 46
    //   84: aload 5
    //   86: invokeinterface 274 1 0
    //   91: goto -45 -> 46
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: aload_1
    //   100: monitorexit
    //   101: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	97	94	finally
    //   99	101	94	finally
  }

  private void b(LoggedOutMessageNotification paramLoggedOutMessageNotification)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("type", String.valueOf(10004));
    if (!c())
    {
      a(paramLoggedOutMessageNotification.d(), "notifications_disabled", localHashMap);
      return;
    }
    Iterator localIterator = this.e.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((MessagingNotificationHandler)localIterator.next()).a(paramLoggedOutMessageNotification));
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        a(paramLoggedOutMessageNotification.d(), "user_alerted_", localHashMap);
        break;
      }
      a(paramLoggedOutMessageNotification.d(), "user_not_alerted_", localHashMap);
      break;
    }
  }

  private void b(String paramString, Message paramMessage, PushSource paramPushSource)
  {
    monitorenter;
    while (true)
    {
      String str;
      try
      {
        str = this.l.h();
        if (!StringUtil.a(str))
          continue;
        a(paramMessage, paramPushSource, "no_user");
        return;
        if ((paramPushSource == PushSource.SMS) && (!((Boolean)this.k.b()).booleanValue()))
          continue;
        if (!c())
        {
          a(paramMessage, paramPushSource, "notifications_disabled");
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (!c(paramMessage.b()))
      {
        a(paramMessage, paramPushSource, "notifications_disabled_thread");
        continue;
      }
      OrcaNotificationManager.ThreadNotificationsState localThreadNotificationsState = a(str, paramMessage.b());
      if (localThreadNotificationsState.a())
      {
        a(paramMessage, paramPushSource, "thread_in_fg_elsewhere");
        BLog.b(a, "Thread is in FG elsewhere, eating notification");
        continue;
      }
      if (!localThreadNotificationsState.b())
        break;
      a(paramMessage, paramPushSource, "displays_in_app_notification_elsewhere");
      BLog.b(a, "In App notification will display elsewhere, eating notification");
    }
    this.n = System.currentTimeMillis();
    NewMessageNotification.PresenceLevel localPresenceLevel;
    if (!this.d.b())
      localPresenceLevel = NewMessageNotification.PresenceLevel.NOT_IN_APP;
    AlertDisposition localAlertDisposition;
    boolean bool;
    while (true)
    {
      localAlertDisposition = a(paramMessage);
      bool = localAlertDisposition.l();
      NewMessageNotification localNewMessageNotification = new NewMessageNotification(paramString, paramMessage, localPresenceLevel, paramPushSource, localAlertDisposition);
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        ((MessagingNotificationHandler)localIterator.next()).a(localNewMessageNotification);
      if (this.d.a(10000L))
      {
        localPresenceLevel = NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_10S;
        continue;
      }
      if (this.d.a(30000L))
      {
        localPresenceLevel = NewMessageNotification.PresenceLevel.IN_APP_ACTIVE_30S;
        continue;
      }
      localPresenceLevel = NewMessageNotification.PresenceLevel.IN_APP_IDLE;
    }
    if ((localAlertDisposition.l()) && (!bool))
      a(paramMessage, paramPushSource, "user_alerted_" + localPresenceLevel.toString());
    while (true)
    {
      b();
      break;
      if (!bool)
      {
        a(paramMessage, paramPushSource, "user_not_alerted_" + localPresenceLevel.toString());
        continue;
      }
      a(paramMessage, paramPushSource, "has_recent_message");
    }
  }

  private boolean c()
  {
    NotificationSetting localNotificationSetting = this.c.a();
    return this.c.a(localNotificationSetting);
  }

  private boolean c(String paramString)
  {
    NotificationSetting localNotificationSetting = this.c.a(paramString);
    return this.c.a(localNotificationSetting);
  }

  private void d()
  {
    FolderCounts localFolderCounts = this.o;
    if (localFolderCounts == null);
    while (true)
    {
      return;
      if (localFolderCounts.b() == 0)
      {
        long l1 = 120000L + this.n;
        long l2 = System.currentTimeMillis();
        if (l1 <= l2)
        {
          a();
          continue;
        }
        this.h.postDelayed(new OrcaNotificationManager.6(this), l1 - l2);
        continue;
      }
    }
  }

  public void a()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((MessagingNotificationHandler)localIterator.next()).a();
  }

  public void a(LoggedOutMessageNotification paramLoggedOutMessageNotification)
  {
    this.f.a(new OrcaNotificationManager.3(this, paramLoggedOutMessageNotification));
  }

  public void a(FolderCounts paramFolderCounts)
  {
    this.o = paramFolderCounts;
    this.h.post(new OrcaNotificationManager.5(this));
  }

  public void a(String paramString)
  {
    this.f.a(new OrcaNotificationManager.2(this, paramString));
  }

  public void a(String paramString, Message paramMessage, PushSource paramPushSource)
  {
    this.f.a(new OrcaNotificationManager.1(this, paramString, paramMessage, paramPushSource));
  }

  public void b(String paramString)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((MessagingNotificationHandler)localIterator.next()).a(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.OrcaNotificationManager
 * JD-Core Version:    0.6.0
 */