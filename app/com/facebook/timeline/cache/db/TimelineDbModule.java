package com.facebook.timeline.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class TimelineDbModule extends AbstractModule
{
  private final Context a;

  public TimelineDbModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(SQLiteDatabase.class).a(TimelineDb.class).a(new TimelineDbModule.TimelineDatabaseProvider(this, null)).a();
    a(TimelineDbCache.OpenHelper.class).a(new TimelineDbModule.TimelineDatabaseOpenHelperProvider(this, null)).a();
    a(TimelineDatabaseSupplier.class).a(new TimelineDbModule.TimelineDatabaseSupplierProvider(this, null)).a();
    a(TimelineDbCache.class).a(new TimelineDbModule.TimelineDbCacheProvider(this, null));
    a(TimelineDbCacheServiceHandler.class).a(new TimelineDbModule.TimelineDbCacheServiceHandlerProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule
 * JD-Core Version:    0.6.0
 */