package com.facebook.graphql.module;

import android.content.Context;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class GraphQLModule extends AbstractModule
{
  private final Context a;

  public GraphQLModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(GraphQLJacksonInitializer.class).a(new GraphQLModule.GraphQLJacksonInitializerProvider(this, null));
    a(GraphQLHelper.class).a(new GraphQLModule.GraphQLHelperProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(GraphQLJacksonInitializer.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.module.GraphQLModule
 * JD-Core Version:    0.6.2
 */