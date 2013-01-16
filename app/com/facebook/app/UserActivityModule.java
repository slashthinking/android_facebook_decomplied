package com.facebook.app;

import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class UserActivityModule extends AbstractModule
{
  protected void a()
  {
    a(UserActivityManager.class).a(new UserActivityModule.UserActivityManagerProvider(this, null)).a();
    a(UserActivityManager.MyActivityListener.class).a(new UserActivityModule.UserActivityManagerListenerProvider(this, null)).a();
    c(FbActivityListener.class).a(UserActivityManager.MyActivityListener.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.UserActivityModule
 * JD-Core Version:    0.6.0
 */