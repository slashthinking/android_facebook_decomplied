package com.facebook.orca.push;

import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.login.AuthComponent;

public class PushModule extends AbstractModule
{
  protected void a()
  {
    a(PushInitializer.class).a(new PushModule.PushInitializerProvider(this, null)).a();
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class).a(PushInitializer.class);
    c(AuthComponent.class).a(PushInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushModule
 * JD-Core Version:    0.6.0
 */