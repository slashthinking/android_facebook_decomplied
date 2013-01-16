package com.facebook.orca.push.c2dm;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.push.PushType;
import java.util.Iterator;
import java.util.Set;

public class C2DMService extends IntentService
{
  private static final Class<?> a = C2DMService.class;
  private C2DMRegistrar b;
  private C2DMReceiverWakeLockHolder c;
  private Set<C2DMPushHandler> d;
  private OrcaSharedPreferences e;
  private ReliabilityAnalyticsLogger f;

  public C2DMService()
  {
    super("C2DMReceiver");
  }

  private void a()
  {
    OrcaSharedPreferences.Editor localEditor = this.e.b();
    localEditor.a(C2DMPrefKeys.g, System.currentTimeMillis());
    localEditor.a();
  }

  private void a(int paramInt)
  {
    this.f.a(PushType.C2DM.toString(), "gcm_deleted_messages", paramInt);
  }

  static void a(Context paramContext, Intent paramIntent)
  {
    C2DMReceiverWakeLockHolder localC2DMReceiverWakeLockHolder = (C2DMReceiverWakeLockHolder)FbInjector.a(paramContext).a(C2DMReceiverWakeLockHolder.class);
    localC2DMReceiverWakeLockHolder.a.a();
    try
    {
      paramIntent.setClass(paramContext, C2DMService.class);
      ComponentName localComponentName = paramContext.startService(paramIntent);
      if (localComponentName != null)
      {
        i = 1;
        if (i == 0);
        return;
      }
      int i = 0;
    }
    finally
    {
      localC2DMReceiverWakeLockHolder.a.b();
      BLog.d(a, "Failed to start service");
    }
  }

  private void a(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("registration_id");
    String str2 = paramIntent.getStringExtra("error");
    String str3 = paramIntent.getStringExtra("unregistered");
    if (BLog.b(3))
      BLog.b(a, "dmControl: registrationId = " + str1 + ", error = " + str2 + ", removed = " + str3);
    C2DMRegistrar localC2DMRegistrar = this.b;
    if (str3 != null);
    for (boolean bool = true; ; bool = false)
    {
      localC2DMRegistrar.a(str1, str2, bool);
      return;
    }
  }

  private void b(Intent paramIntent)
  {
    BLog.b(a, "Received handleMessage");
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      if ("deleted_messages".equals(localBundle.getString("message_type")))
      {
        int i = localBundle.getInt("total_deleted", 1);
        a(i);
        Iterator localIterator2 = this.d.iterator();
        while (localIterator2.hasNext())
          ((C2DMPushHandler)localIterator2.next()).b(i);
      }
      if (!StringUtil.a(localBundle.getString("notification")))
      {
        a();
        String str = localBundle.getString("notification");
        Iterator localIterator1 = this.d.iterator();
        while (localIterator1.hasNext())
          ((C2DMPushHandler)localIterator1.next()).b(str);
      }
    }
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = ((C2DMRegistrar)localFbInjector.a(C2DMRegistrar.class));
    this.c = ((C2DMReceiverWakeLockHolder)localFbInjector.a(C2DMReceiverWakeLockHolder.class));
    this.d = localFbInjector.c(C2DMPushHandler.class);
    this.e = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.f = ((ReliabilityAnalyticsLogger)localFbInjector.a(ReliabilityAnalyticsLogger.class));
  }

  public final void onHandleIntent(Intent paramIntent)
  {
    while (true)
    {
      try
      {
        if (!paramIntent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION"))
          continue;
        a(paramIntent);
        return;
        if (paramIntent.getAction().equals("com.google.android.c2dm.intent.RECEIVE"))
        {
          b(paramIntent);
          continue;
        }
      }
      finally
      {
        this.c.a.b();
      }
      if (!paramIntent.getAction().equals("com.google.android.c2dm.intent.RETRY"))
        continue;
      this.b.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMService
 * JD-Core Version:    0.6.0
 */