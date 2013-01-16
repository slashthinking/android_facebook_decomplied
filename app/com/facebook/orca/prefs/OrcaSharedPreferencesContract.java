package com.facebook.orca.prefs;

import android.net.Uri;

class OrcaSharedPreferencesContract
{
  private final String a;
  private final String b;
  private final String c;
  private final Uri d;
  private final OrcaSharedPreferencesContract.PrefColumns e;

  OrcaSharedPreferencesContract(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = (paramString1 + ".CHANGED_ACTION");
    this.c = paramString2;
    this.d = Uri.parse("content://" + paramString1);
    this.e = new OrcaSharedPreferencesContract.PrefColumns(this.d);
  }

  public String a()
  {
    return this.a;
  }

  public Uri b()
  {
    return this.e.a();
  }

  public String c()
  {
    return this.b;
  }

  public OrcaSharedPreferencesContract.PrefColumns d()
  {
    return this.e;
  }

  public String e()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesContract
 * JD-Core Version:    0.6.0
 */