package com.facebook.feed.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.feed.cache.FeedUnitPartialCache;
import com.facebook.feed.cache.FeedUnitPartialCache.FeedUnitPartialCacheInitializer;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class NewsFeedDbModule extends AbstractModule
{
  private final Context a;

  public NewsFeedDbModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(SQLiteDatabase.class).a(NewsFeedDb.class).a(new NewsFeedDbModule.NewsFeedDatabaseProvider(this, null)).a();
    a(NewsFeedDbOpenHelper.class).a(new NewsFeedDbModule.NewsFeedDatabaseOpenHelperProvider(this, null)).a();
    a(NewsFeedDatabaseSupplier.class).a(new NewsFeedDbModule.NewsFeedDatabaseSupplierProvider(this, null)).a();
    a(FastJsonNodeParser.class).a(new NewsFeedDbModule.FastJsonNodeParserProvider(this, null)).a();
    a(FeedUnitPartialCache.class).a(new NewsFeedDbModule.FeedUnitPartialCacheProvider(null)).a();
    a(FeedUnitPartialCache.FeedUnitPartialCacheInitializer.class).a(new NewsFeedDbModule.FeedUnitPartialCacheInitializerProvider(null)).a();
    a(DbFeedHomeStoriesSerialization.class).a(new NewsFeedDbModule.DbFeedHomeStoriesSerializationProvider(this, null));
    a(DbFeedHomeStoriesHandler.class).a(new NewsFeedDbModule.DbFeedHomeStoriesHandlerProvider(this, null)).a();
    a(DbPrefetchFeedHandler.class).a(new NewsFeedDbModule.DbPrefetchFeedHandlerProvider(this, null));
    a(DbFeedbackSerialization.class).a(new NewsFeedDbModule.DbFeedbackSerializationProvider(this, null));
    a(DbFeedbackHandler.class).a(new NewsFeedDbModule.DbFeedbackHandlerProvider(this, null));
    a(DbFeedUnitPartialHandler.class).a(new NewsFeedDbModule.DbFeedUnitPartialHandlerProvider(this, null));
    a(DbFeedStoryPartialSerialization.class).a(new NewsFeedDbModule.DbFeedStoryPartialSerializationProvider(this, null)).a();
    a(DbPagesYouMayLikeFeedUnitPartialSerialization.class).a(new NewsFeedDbModule.DbPagesYouMayLikeFeedUnitPartialSerializationProvider(this, null)).a();
    a(NFDbServiceHandler.class).a(new NewsFeedDbModule.NFDbServiceHandlerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(FeedUnitPartialCache.FeedUnitPartialCacheInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule
 * JD-Core Version:    0.6.0
 */