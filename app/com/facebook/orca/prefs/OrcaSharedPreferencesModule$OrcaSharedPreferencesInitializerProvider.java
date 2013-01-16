package com.facebook.orca.prefs;

import com.facebook.orca.inject.AbstractProvider;

class OrcaSharedPreferencesModule$OrcaSharedPreferencesInitializerProvider extends AbstractProvider<OrcaSharedPreferencesInitializer>
{
  private OrcaSharedPreferencesModule$OrcaSharedPreferencesInitializerProvider(OrcaSharedPreferencesModule paramOrcaSharedPreferencesModule)
  {
  }

  public OrcaSharedPreferencesInitializer a()
  {
    return new OrcaSharedPreferencesInitializer((OrcaSharedPreferencesImpl)b(OrcaSharedPreferencesImpl.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesModule.OrcaSharedPreferencesInitializerProvider
 * JD-Core Version:    0.6.0
 */