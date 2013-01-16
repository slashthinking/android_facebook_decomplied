package com.facebook.katana.server.background;

import android.content.Context;
import android.os.Bundle;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod.Params;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.Utils;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class UserSetContactInfoBackgroundTask extends AbstractBackgroundTask
{
  public static Class<?> a = UserSetContactInfoBackgroundTask.class;
  private Context b;
  private KeyValueManager c;
  private Clock d;
  private final OrcaServiceOperationFactory e;
  private Provider<String> f;
  private ListenableFuture<OperationResult> g;

  public UserSetContactInfoBackgroundTask(Context paramContext, KeyValueManager paramKeyValueManager, Clock paramClock, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Provider<String> paramProvider)
  {
    super("USER_SET_CONTACT_INFO");
    this.b = paramContext;
    this.c = paramKeyValueManager;
    this.d = paramClock;
    this.e = paramOrcaServiceOperationFactory;
    this.f = paramProvider;
  }

  public boolean b()
  {
    Object localObject = this.f.b();
    int i = 0;
    if (localObject != null)
    {
      ListenableFuture localListenableFuture = this.g;
      i = 0;
      if (localListenableFuture == null)
        break label29;
    }
    while (true)
    {
      return i;
      label29: boolean bool1 = Boolean.TRUE.equals(Gatekeeper.a(this.b, "android_update_user_phone"));
      i = 0;
      if (!bool1)
        continue;
      String str = Utils.a(this.b);
      i = 0;
      if (str == null)
        continue;
      boolean bool2 = StringUtils.c(str);
      i = 0;
      if (bool2)
        continue;
      boolean bool3 = str.equals(GrowthUtils.a().b(this.b));
      i = 0;
      if (bool3)
        continue;
      boolean bool4 = this.d.a() - this.c.a("last_login_time", 0L) < 3600000L;
      i = 0;
      if (bool4)
        continue;
      i = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    String str = Utils.a(this.b);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("user_set_contact_info", new UserSetContactInfoMethod.Params(str, true));
    this.g = this.e.a("user_set_contact_info", localBundle).d();
    UserSetContactInfoBackgroundTask.1 local1 = new UserSetContactInfoBackgroundTask.1(this, a, str);
    Futures.a(this.g, local1);
    return local1;
  }

  public long h()
  {
    long l = -1L;
    if (this.f.b() == null);
    while (true)
    {
      return l;
      if (!Boolean.TRUE.equals(Gatekeeper.a(this.b, "android_update_user_phone")))
        continue;
      String str = Utils.a(this.b);
      if ((str == null) || (StringUtils.c(str)) || (str.equals(GrowthUtils.a().b(this.b))))
        continue;
      l = 3600000L + this.d.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.background.UserSetContactInfoBackgroundTask
 * JD-Core Version:    0.6.0
 */