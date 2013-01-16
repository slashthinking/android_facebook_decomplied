package com.facebook.ipc.feed;

import android.app.Application;
import com.facebook.ipc.intent.FacebookOnlyIntentActionFactory;
import com.facebook.orca.app.FbBaseModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.google.common.base.Preconditions;

public class FeedIpcModule extends AbstractModule
{
  private final Application a;

  public FeedIpcModule(Application paramApplication)
  {
    this.a = ((Application)Preconditions.checkNotNull(paramApplication));
  }

  protected void a()
  {
    e(FbBaseModule.class);
    a(FacebookOnlyIntentActionFactory.class).a(new FeedIpcModule.FacebookOnlyIntentActionFactoryProvider(this, null)).a();
    a(ViewPermalinkIntentFactory.class).a(new FeedIpcModule.ViewPermalinkIntentFactoryProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.feed.FeedIpcModule
 * JD-Core Version:    0.6.0
 */