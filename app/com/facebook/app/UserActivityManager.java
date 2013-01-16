package com.facebook.app;

import android.app.KeyguardManager;
import com.facebook.orca.app.ActivityBroadcaster;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;

public class UserActivityManager
{
  private final ActivityBroadcaster a;
  private final AndroidThreadUtil b;
  private final Clock c;
  private final KeyguardManager d;
  private final UserActivityManager.MyActivityListener e;
  private volatile boolean f;
  private volatile long g;
  private volatile long h;
  private volatile long i;

  public UserActivityManager(ActivityBroadcaster paramActivityBroadcaster, AndroidThreadUtil paramAndroidThreadUtil, Clock paramClock, KeyguardManager paramKeyguardManager)
  {
    this.a = paramActivityBroadcaster;
    this.b = paramAndroidThreadUtil;
    this.c = paramClock;
    this.d = paramKeyguardManager;
    this.e = new UserActivityManager.MyActivityListener(this);
  }

  private void f()
  {
    this.b.a();
    this.f = false;
    this.h = this.c.a();
    this.a.a("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
  }

  private void g()
  {
    this.b.a();
    this.f = true;
    this.g = this.c.a();
    this.a.a("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
  }

  private void h()
  {
    this.b.a();
    this.i = this.c.a();
    this.a.a("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
  }

  private boolean i()
  {
    return this.d.inKeyguardRestrictedInputMode();
  }

  public boolean a()
  {
    if ((!this.f) && (this.c.a() - this.h > 5000L));
    for (int j = 1; ; j = 0)
      return j;
  }

  public boolean a(long paramLong)
  {
    if (this.c.a() - this.i <= paramLong);
    for (int j = 1; ; j = 0)
      return j;
  }

  public boolean b()
  {
    if ((this.f) && (!i()));
    for (int j = 1; ; j = 0)
      return j;
  }

  public boolean b(long paramLong)
  {
    int j = 1;
    long l = this.c.a();
    if (l - this.i < paramLong);
    while (true)
    {
      return j;
      if ((this.f) && (l - this.g < paramLong))
        continue;
      j = 0;
    }
  }

  public boolean c()
  {
    return this.f;
  }

  public long d()
  {
    return this.i;
  }

  public UserActivityManager.MyActivityListener e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.UserActivityManager
 * JD-Core Version:    0.6.0
 */