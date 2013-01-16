package com.facebook.bookmark.client;

import android.app.Application;
import com.facebook.background.BackgroundTask;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaService;
import com.facebook.orca.server.OrcaServiceRegistry;

public class BookmarkClientModule extends AbstractModule
{
  private final Application a;
  private String b = null;
  private Class<? extends OrcaService> c = null;
  private final boolean d;

  public BookmarkClientModule(Application paramApplication, Class<? extends OrcaService> paramClass)
  {
    this.a = paramApplication;
    this.c = paramClass;
    this.d = true;
  }

  protected void a()
  {
    a(BookmarkManager.class).a(new BookmarkClientModule.BookmarkClientProvider(this, null)).a();
    c(IHaveUserData.class).a(BookmarkManager.class);
    a(BookmarkPreloadBackgroundTask.class).a(new BookmarkClientModule.BookmarkPreloadBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(BookmarkPreloadBackgroundTask.class);
  }

  public void a(FbInjector paramFbInjector)
  {
    super.a(paramFbInjector);
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    if (this.b != null)
      localOrcaServiceRegistry.a(BookmarkSyncQueue.class, this.b);
    while (true)
    {
      localOrcaServiceRegistry.a("syncWithDB", BookmarkSyncQueue.class);
      localOrcaServiceRegistry.a("syncWithServer", BookmarkSyncQueue.class);
      localOrcaServiceRegistry.a("setFavoriteBookmarks", BookmarkSyncQueue.class);
      localOrcaServiceRegistry.a("updateUnreadCount", BookmarkSyncQueue.class);
      return;
      localOrcaServiceRegistry.a(BookmarkSyncQueue.class, this.c);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClientModule
 * JD-Core Version:    0.6.2
 */