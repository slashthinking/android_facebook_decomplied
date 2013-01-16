package com.facebook.orca.prefs;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.ModifyThreadParamsBuilder;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ThreadNotificationPrefsSynchronizer
{
  private static Class<?> a = ThreadNotificationPrefsSynchronizer.class;
  private static long b = 4000L;
  private static long c = 600000L;
  private static long d = 5L;
  private final Handler e;
  private final OrcaServiceOperation f;
  private final OrcaSharedPreferences g;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener h;
  private final DataCache i;
  private Map<String, ModifyThreadParams> j;
  private ModifyThreadParams k;
  private long l;
  private int m;
  private volatile boolean n;

  public ThreadNotificationPrefsSynchronizer(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaServiceOperation paramOrcaServiceOperation, DataCache paramDataCache)
  {
    this.g = paramOrcaSharedPreferences;
    this.f = paramOrcaServiceOperation;
    this.i = paramDataCache;
    this.e = new Handler();
    this.h = new ThreadNotificationPrefsSynchronizer.1(this);
    paramOrcaSharedPreferences.a(this.h);
    paramOrcaServiceOperation.a(new ThreadNotificationPrefsSynchronizer.2(this));
    paramOrcaServiceOperation.a(true);
  }

  private void a(PrefKey paramPrefKey)
  {
    label7: if (this.n)
      break label7;
    while (true)
    {
      return;
      if (!paramPrefKey.a(MessagesPrefKeys.t))
        continue;
      String[] arrayOfString = paramPrefKey.b(MessagesPrefKeys.t).split("/");
      if (arrayOfString.length != 2)
        break;
      String str = Uri.decode(arrayOfString[0]);
      if ((!"muted_until2".equals(arrayOfString[1])) || (this.i.b(str) == null))
        break;
      PrefKey localPrefKey = MessagesPrefKeys.a(str);
      NotificationSetting localNotificationSetting = NotificationSetting.b(this.g.a(localPrefKey, 0L));
      monitorenter;
      try
      {
        b().put(str, new ModifyThreadParamsBuilder().a(str).c(true).a(localNotificationSetting).h());
        monitorexit;
        continue;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
    }
    throw localObject;
  }

  private void a(Exception paramException)
  {
    monitorenter;
    try
    {
      if (this.j == null)
        this.j = Maps.a();
      String str = this.k.a();
      if (!this.j.containsKey(str))
        this.j.put(str, this.k);
      this.k = null;
      if (this.m < d)
      {
        this.m = (1 + this.m);
        this.l = Math.min(2L * this.l, c);
        BLog.c(a, "Failed to update thread notification settings. Retrying in " + this.l / 1000L + " seconds");
        c();
      }
      while (true)
      {
        return;
        this.m = 0;
        this.l = b;
        this.j = null;
        BLog.c(a, "Failed to update thread notification settings. Giving up.");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Map<String, ModifyThreadParams> b()
  {
    if (this.j == null)
    {
      this.j = Maps.a();
      this.l = b;
      c();
    }
    return this.j;
  }

  private void c()
  {
    this.e.postDelayed(new ThreadNotificationPrefsSynchronizer.3(this), this.l);
  }

  private void d()
  {
    monitorenter;
    while (true)
    {
      Iterator localIterator;
      try
      {
        Map localMap = this.j;
        if (localMap == null)
          return;
        if (this.f.c() != OrcaServiceOperation.State.INIT)
          continue;
        localIterator = this.j.values().iterator();
        if (!localIterator.hasNext())
        {
          this.j = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      ModifyThreadParams localModifyThreadParams = (ModifyThreadParams)localIterator.next();
      localIterator.remove();
      this.k = localModifyThreadParams;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("modifyThreadParams", localModifyThreadParams);
      this.f.a("modify_thread", localBundle);
    }
  }

  private void e()
  {
    monitorenter;
    try
    {
      this.k = null;
      this.l = b;
      this.m = 0;
      d();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:i	Lcom/facebook/orca/cache/DataCache;
    //   4: invokevirtual 286	com/facebook/orca/cache/DataCache:a	()Lcom/facebook/orca/users/User;
    //   7: invokevirtual 291	com/facebook/orca/users/User:c	()Lcom/facebook/orca/users/UserKey;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 57	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:i	Lcom/facebook/orca/cache/DataCache;
    //   15: invokevirtual 294	com/facebook/orca/cache/DataCache:d	()Ljava/util/List;
    //   18: astore_2
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 88	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:n	Z
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_2
    //   29: invokeinterface 297 1 0
    //   34: astore 6
    //   36: aload 6
    //   38: invokeinterface 262 1 0
    //   43: ifeq +190 -> 233
    //   46: aload 6
    //   48: invokeinterface 266 1 0
    //   53: checkcast 299	com/facebook/orca/threads/ThreadSummary
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 300	com/facebook/orca/threads/ThreadSummary:a	()Ljava/lang/String;
    //   63: astore 8
    //   65: aload 7
    //   67: aload_1
    //   68: invokevirtual 303	com/facebook/orca/threads/ThreadSummary:a	(Lcom/facebook/orca/users/UserKey;)Lcom/facebook/orca/threads/ThreadParticipant;
    //   71: astore 9
    //   73: aload 9
    //   75: ifnull -39 -> 36
    //   78: aload 9
    //   80: invokevirtual 308	com/facebook/orca/threads/ThreadParticipant:h	()Lcom/facebook/orca/notify/NotificationSetting;
    //   83: astore 10
    //   85: aload 10
    //   87: ifnull -51 -> 36
    //   90: aload 8
    //   92: invokestatic 130	com/facebook/orca/prefs/MessagesPrefKeys:a	(Ljava/lang/String;)Lcom/facebook/orca/prefs/PrefKey;
    //   95: astore 11
    //   97: aload_0
    //   98: getfield 53	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:g	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   101: aload 11
    //   103: lconst_0
    //   104: invokeinterface 133 4 0
    //   109: invokestatic 138	com/facebook/orca/notify/NotificationSetting:b	(J)Lcom/facebook/orca/notify/NotificationSetting;
    //   112: astore 12
    //   114: aload 10
    //   116: invokevirtual 311	com/facebook/orca/notify/NotificationSetting:d	()J
    //   119: aload 12
    //   121: invokevirtual 311	com/facebook/orca/notify/NotificationSetting:d	()J
    //   124: lcmp
    //   125: ifeq +132 -> 257
    //   128: aload_0
    //   129: getfield 180	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:k	Lcom/facebook/orca/server/ModifyThreadParams;
    //   132: ifnull +24 -> 156
    //   135: aload_0
    //   136: getfield 180	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:k	Lcom/facebook/orca/server/ModifyThreadParams;
    //   139: invokevirtual 185	com/facebook/orca/server/ModifyThreadParams:a	()Ljava/lang/String;
    //   142: aload 8
    //   144: invokestatic 317	com/google/common/base/Objects:equal	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   147: ifeq +9 -> 156
    //   150: aload_3
    //   151: astore 13
    //   153: goto +107 -> 260
    //   156: aload_0
    //   157: getfield 173	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:j	Ljava/util/Map;
    //   160: ifnull +23 -> 183
    //   163: aload_0
    //   164: getfield 173	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:j	Ljava/util/Map;
    //   167: aload 8
    //   169: invokeinterface 188 2 0
    //   174: ifeq +9 -> 183
    //   177: aload_3
    //   178: astore 13
    //   180: goto +80 -> 260
    //   183: aload_3
    //   184: ifnonnull +67 -> 251
    //   187: aload_0
    //   188: getfield 53	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:g	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   191: invokeinterface 320 1 0
    //   196: astore 13
    //   198: aload 13
    //   200: aload 11
    //   202: aload 10
    //   204: invokevirtual 311	com/facebook/orca/notify/NotificationSetting:d	()J
    //   207: invokeinterface 325 4 0
    //   212: pop
    //   213: goto +47 -> 260
    //   216: astore 5
    //   218: aload_0
    //   219: monitorexit
    //   220: aload 5
    //   222: athrow
    //   223: astore 4
    //   225: aload_0
    //   226: iconst_0
    //   227: putfield 88	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:n	Z
    //   230: aload 4
    //   232: athrow
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_3
    //   236: ifnull +9 -> 245
    //   239: aload_3
    //   240: invokeinterface 327 1 0
    //   245: aload_0
    //   246: iconst_0
    //   247: putfield 88	com/facebook/orca/prefs/ThreadNotificationPrefsSynchronizer:n	Z
    //   250: return
    //   251: aload_3
    //   252: astore 13
    //   254: goto -56 -> 198
    //   257: aload_3
    //   258: astore 13
    //   260: aload 13
    //   262: astore_3
    //   263: goto -227 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   28	220	216	finally
    //   233	235	216	finally
    //   26	28	223	finally
    //   220	223	223	finally
    //   239	245	223	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.ThreadNotificationPrefsSynchronizer
 * JD-Core Version:    0.6.0
 */