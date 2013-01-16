package com.facebook.feed.module;

import android.content.Context;
import com.facebook.background.BackgroundTask;
import com.facebook.feed.background.PrefetchNewsFeedBackgroundTask;
import com.facebook.orca.app.FbBaseModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class NewsFeedPrefetchTaskModule extends AbstractModule
{
  private final Context a;

  public NewsFeedPrefetchTaskModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    e(FbBaseModule.class);
    e(NewsFeedModule.class);
    a(PrefetchNewsFeedBackgroundTask.class).a(new NewsFeedPrefetchTaskModule.PrefetchNewsFeedBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(PrefetchNewsFeedBackgroundTask.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedPrefetchTaskModule
 * JD-Core Version:    0.6.0
 */