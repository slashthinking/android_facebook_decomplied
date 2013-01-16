package com.facebook.bookmark.service;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.bookmark.client.BookmarkSyncQueue;
import com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod;
import com.facebook.bookmark.protocol.BookmarkSyncMethod;
import com.facebook.bookmark.provider.BookmarkDB;
import com.facebook.bookmark.provider.BookmarkDBUserDataCleaner;
import com.facebook.bookmark.provider.DBBookmarkHelper;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class BookmarkServiceModule extends AbstractModule
{
  private final Application a;
  private final int b;
  private final boolean c;

  public BookmarkServiceModule(Application paramApplication, int paramInt)
  {
    this(paramApplication, paramInt, true);
  }

  public BookmarkServiceModule(Application paramApplication, int paramInt, boolean paramBoolean)
  {
    this.a = paramApplication;
    this.b = paramInt;
    this.c = paramBoolean;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<? extends OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(SQLiteOpenHelper.class).a(BookmarkDB.class).a(new BookmarkServiceModule.BookmarkDBProvider(this, null)).a();
    a(DBBookmarkHelper.class).a(new BookmarkServiceModule.BookmarkDBOperationsProvider(this, null)).a();
    a(BroadcastSender.class).a(new BookmarkServiceModule.BroadcastSenderProvider(this, null)).a();
    a(BookmarkSyncMethod.class).a(new BookmarkServiceModule.BookmarkSyncMethodProvider(this, null)).a();
    a(BookmarkSetFavoritesMethod.class).a(new BookmarkServiceModule.BookmarkSetFavoritesMethodProvider(this, null)).a();
    a(BookmarkSyncQueue.class, new BookmarkServiceModule.BookmarkServiceHandlerProvider(this, null));
    a(BookmarkDBUserDataCleaner.class).a(new BookmarkServiceModule.BookmarkUserDataCleanerProvider(this, null)).a();
    c(IHaveUserData.class).a(BookmarkDBUserDataCleaner.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule
 * JD-Core Version:    0.6.2
 */