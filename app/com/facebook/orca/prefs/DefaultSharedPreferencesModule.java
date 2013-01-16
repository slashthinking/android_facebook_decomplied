package com.facebook.orca.prefs;

import android.content.SharedPreferences;
import com.facebook.orca.annotations.DefaultSharedPreferences;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class DefaultSharedPreferencesModule extends AbstractModule
{
  protected void a()
  {
    a(SharedPreferences.class).a(DefaultSharedPreferences.class).a(new DefaultSharedPreferencesModule.DefaultSharedPreferencesProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.DefaultSharedPreferencesModule
 * JD-Core Version:    0.6.0
 */