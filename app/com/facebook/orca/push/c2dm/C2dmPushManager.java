package com.facebook.orca.push.c2dm;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.push.PushManager;
import javax.inject.Provider;

public class C2dmPushManager
  implements PushManager
{
  private static final Class<?> a = C2dmPushManager.class;
  private final C2DMRegistrar b;
  private final FacebookPushServerRegistrar c;
  private final Provider<String> d;

  public C2dmPushManager(C2DMRegistrar paramC2DMRegistrar, FacebookPushServerRegistrar paramFacebookPushServerRegistrar, Provider<String> paramProvider)
  {
    this.b = paramC2DMRegistrar;
    this.c = paramFacebookPushServerRegistrar;
    this.d = paramProvider;
  }

  public void a()
  {
    BLog.b(a, "registering for push notifications");
    this.b.a(true);
  }

  public void b()
  {
    BLog.b(a, "checking push notifications registration");
    if (!StringUtil.a((String)this.d.b()))
      this.b.a(false);
  }

  public void c()
  {
    BLog.b(a, "unregistering from push notifications");
    this.c.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2dmPushManager
 * JD-Core Version:    0.6.0
 */