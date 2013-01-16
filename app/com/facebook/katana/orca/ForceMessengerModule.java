package com.facebook.katana.orca;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class ForceMessengerModule extends AbstractModule
{
  protected void a()
  {
    a(ForceMessenger.class).a(new ForceMessengerModule.ForceMessengerProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ForceMessengerModule
 * JD-Core Version:    0.6.0
 */