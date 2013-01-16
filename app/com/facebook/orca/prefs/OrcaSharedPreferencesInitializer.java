package com.facebook.orca.prefs;

import com.facebook.orca.app.INeedInit;

public class OrcaSharedPreferencesInitializer
  implements INeedInit
{
  private final OrcaSharedPreferencesImpl a;

  public OrcaSharedPreferencesInitializer(OrcaSharedPreferencesImpl paramOrcaSharedPreferencesImpl)
  {
    this.a = paramOrcaSharedPreferencesImpl;
  }

  public void i_()
  {
    this.a.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesInitializer
 * JD-Core Version:    0.6.0
 */