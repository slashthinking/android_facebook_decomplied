package com.facebook.orca.push.c2dm;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import javax.inject.Provider;

public class PushTokenHolder
{
  private final OrcaSharedPreferences a;
  private final Provider<String> b;
  private final boolean c;

  public PushTokenHolder(OrcaSharedPreferences paramOrcaSharedPreferences, Provider<String> paramProvider, boolean paramBoolean)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramProvider;
    this.c = paramBoolean;
  }

  public PushTokenHolder.ServiceType a(String paramString)
  {
    PushTokenHolder.ServiceType localServiceType;
    if (paramString == null)
      localServiceType = PushTokenHolder.ServiceType.C2DM;
    while (true)
    {
      return localServiceType;
      try
      {
        localServiceType = (PushTokenHolder.ServiceType)Enum.valueOf(PushTokenHolder.ServiceType.class, paramString);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localServiceType = PushTokenHolder.ServiceType.C2DM;
      }
    }
  }

  public String a()
  {
    return this.a.a(C2DMPrefKeys.b, "");
  }

  public void a(String paramString, PushTokenHolder.ServiceType paramServiceType)
  {
    long l = System.currentTimeMillis();
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(C2DMPrefKeys.b, paramString);
    localEditor.a(C2DMPrefKeys.e, l);
    localEditor.a(C2DMPrefKeys.d, l);
    localEditor.a(C2DMPrefKeys.i, paramServiceType.toString());
    localEditor.a(C2DMPrefKeys.j, false);
    localEditor.a();
  }

  public PushTokenHolder.ServiceType b()
  {
    if (this.c);
    for (PushTokenHolder.ServiceType localServiceType = PushTokenHolder.ServiceType.GCM; ; localServiceType = PushTokenHolder.ServiceType.C2DM)
      return localServiceType;
  }

  public PushTokenHolder.ServiceType c()
  {
    return a(this.a.a(C2DMPrefKeys.h, null));
  }

  public PushTokenHolder.ServiceType d()
  {
    return a(this.a.a(C2DMPrefKeys.i, null));
  }

  public boolean e()
  {
    if (d() == PushTokenHolder.ServiceType.GCM);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void f()
  {
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(C2DMPrefKeys.b, "");
    localEditor.a(C2DMPrefKeys.c, "");
    localEditor.a(C2DMPrefKeys.e, System.currentTimeMillis());
    localEditor.a(C2DMPrefKeys.j, false);
    localEditor.a();
  }

  public String g()
  {
    return this.a.a(C2DMPrefKeys.c, "");
  }

  public String h()
  {
    String str = (String)this.b.b();
    if (!StringUtil.a(str));
    while (true)
    {
      return str;
      str = g();
    }
  }

  public boolean i()
  {
    return this.a.a(C2DMPrefKeys.j, false);
  }

  public long j()
  {
    return this.a.a(C2DMPrefKeys.d, 0L);
  }

  public void k()
  {
    this.a.b().a(C2DMPrefKeys.j, true).a(C2DMPrefKeys.k, System.currentTimeMillis()).a(C2DMPrefKeys.c, (String)this.b.b()).a();
  }

  public void l()
  {
    this.a.b().a(C2DMPrefKeys.j, false).a();
  }

  public long m()
  {
    return this.a.a(C2DMPrefKeys.k, 0L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.PushTokenHolder
 * JD-Core Version:    0.6.0
 */