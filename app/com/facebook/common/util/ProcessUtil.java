package com.facebook.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;

public class ProcessUtil
{
  private static final Class<?> a = ProcessUtil.class;
  private final Context b;
  private final ActivityManager c;
  private final Provider<Integer> d;
  private volatile Optional<String> e;

  public ProcessUtil(Context paramContext, ActivityManager paramActivityManager, Provider<Integer> paramProvider)
  {
    this.b = paramContext;
    this.c = paramActivityManager;
    this.d = paramProvider;
  }

  private List<ActivityManager.RunningAppProcessInfo> b()
  {
    return this.c.getRunningAppProcesses();
  }

  public String a()
  {
    String str;
    if (this.e != null)
      str = (String)this.e.orNull();
    while (true)
    {
      return str;
      str = a(((Integer)this.d.b()).intValue());
      if (str == null)
      {
        BLog.d(a, "Couldn't find own process name");
        this.e = Optional.absent();
        str = null;
        continue;
      }
      this.e = Optional.of(str);
    }
  }

  public String a(int paramInt)
  {
    Iterator localIterator = b().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext())
        break;
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    }
    while (localRunningAppProcessInfo.pid != paramInt);
    for (String str = localRunningAppProcessInfo.processName; ; str = null)
      return str;
  }

  public boolean a(String paramString)
  {
    String str = a();
    if (str == null)
      BLog.d(a, "Couldn't find own process name");
    for (boolean bool = false; ; bool = Objects.equal(str, paramString))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ProcessUtil
 * JD-Core Version:    0.6.0
 */