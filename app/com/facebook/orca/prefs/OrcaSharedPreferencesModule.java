package com.facebook.orca.prefs;

import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class OrcaSharedPreferencesModule extends AbstractModule
{
  private final String a;
  private final String b;

  public OrcaSharedPreferencesModule(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  protected void a()
  {
    a(OrcaSharedPreferencesImpl.class).a(new OrcaSharedPreferencesModule.OrcaSharedPreferencesProvider(this, null)).a();
    a(OrcaSharedPreferences.class).b(OrcaSharedPreferencesImpl.class);
    a(OrcaSharedPreferencesContract.class).a(new OrcaSharedPreferencesContract(this.a, this.b));
    a(OrcaSharedPreferencesInitializer.class).a(new OrcaSharedPreferencesModule.OrcaSharedPreferencesInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(OrcaSharedPreferencesInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesModule
 * JD-Core Version:    0.6.0
 */