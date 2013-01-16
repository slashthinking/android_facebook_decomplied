package com.facebook.device_id;

import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.SharedPrefKeys;
import java.util.UUID;

public class UniqueIdForDeviceHolder
  implements INeedInit
{
  private static final Class<?> a = UniqueIdForDeviceHolder.class;
  private volatile UniqueDeviceId b;
  private final OrcaSharedPreferences c;
  private final Clock d;

  public UniqueIdForDeviceHolder(OrcaSharedPreferences paramOrcaSharedPreferences, Clock paramClock)
  {
    this.c = paramOrcaSharedPreferences;
    this.d = paramClock;
  }

  public static UniqueDeviceId a(Clock paramClock)
  {
    return new UniqueDeviceId(UUID.randomUUID().toString(), paramClock.a());
  }

  private void e()
  {
    BLog.b(a, "loading device id from shared prefs");
    String str = this.c.a(SharedPrefKeys.e, null);
    long l = this.c.a(SharedPrefKeys.f, 9223372036854775807L);
    if ((str == null) || (l == 9223372036854775807L))
    {
      this.b = a(this.d);
      f();
    }
    while (true)
    {
      BLog.b(a, "loaded device id from shared prefs: " + this.b);
      return;
      this.b = new UniqueDeviceId(str, l);
    }
  }

  private void f()
  {
    BLog.b(a, "saving device id from shared prefs: " + this.b);
    UniqueDeviceId localUniqueDeviceId = this.b;
    this.c.b().a(SharedPrefKeys.f, localUniqueDeviceId.b()).a(SharedPrefKeys.e, localUniqueDeviceId.a()).a();
  }

  public void a(UniqueDeviceId paramUniqueDeviceId)
  {
    this.b = paramUniqueDeviceId;
    f();
  }

  public String b()
  {
    if (this.b == null);
    for (String str = null; ; str = this.b.a())
      return str;
  }

  public String c()
  {
    return SecureHashUtil.a(b()).substring(0, 20);
  }

  public UniqueDeviceId d()
  {
    return this.b;
  }

  public void i_()
  {
    e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueIdForDeviceHolder
 * JD-Core Version:    0.6.0
 */