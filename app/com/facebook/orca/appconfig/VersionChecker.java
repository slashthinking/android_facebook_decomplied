package com.facebook.orca.appconfig;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.VersionStringComparator;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class VersionChecker
{
  private static Class<?> a = VersionChecker.class;
  private final DataCache b;
  private final OrcaConfig c;
  private final VersionStringComparator d;

  public VersionChecker(DataCache paramDataCache, OrcaConfig paramOrcaConfig, VersionStringComparator paramVersionStringComparator)
  {
    this.b = paramDataCache;
    this.c = paramOrcaConfig;
    this.d = paramVersionStringComparator;
  }

  private String a(AppConfig paramAppConfig)
  {
    return Objects.toStringHelper(paramAppConfig).add("minVersion", paramAppConfig.a()).add("minVersionCode", Integer.valueOf(paramAppConfig.d())).add("currentVersion", paramAppConfig.b()).add("currentVersionCode", Integer.valueOf(paramAppConfig.e())).toString();
  }

  private String a(AppConfig paramAppConfig, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = paramAppConfig.a(); ; str = paramAppConfig.b())
      return str;
  }

  private boolean a(boolean paramBoolean)
  {
    AppConfig localAppConfig = this.b.f();
    int i = 0;
    if (localAppConfig == null);
    while (true)
    {
      return i;
      BLog.a(a, a(localAppConfig));
      String str1 = this.c.a();
      String str2 = a(localAppConfig, paramBoolean);
      if (this.d.a(str1, str2) < 0)
      {
        i = 1;
        continue;
      }
      int j = this.c.b();
      int k = b(localAppConfig, paramBoolean);
      i = 0;
      if (j >= k)
        continue;
      i = 1;
    }
  }

  private int b(AppConfig paramAppConfig, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = paramAppConfig.d(); ; i = paramAppConfig.e())
      return i;
  }

  public boolean a()
  {
    return a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.appconfig.VersionChecker
 * JD-Core Version:    0.6.0
 */