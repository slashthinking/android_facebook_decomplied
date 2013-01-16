package com.facebook.katana.activity.composer;

import android.app.Application;
import com.facebook.analytics.InteractionLogger;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.katana.activity.media.AlbumsAdapterFactory;
import com.facebook.katana.activity.media.MediaItemFactory;
import com.facebook.katana.features.composer.AudienceAdapter;
import com.facebook.katana.features.composer.TargetAdapter;
import com.facebook.katana.features.events.AggressiveSuggestionPreferences;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.WaterfallIdGenerator;

public class ComposerModule extends AbstractModule
{
  private final Application a;

  public ComposerModule(Application paramApplication)
  {
    this.a = paramApplication;
  }

  protected void a()
  {
    a(AlbumsAdapterFactory.class).a(new ComposerModule.AlbumsAdapterFactoryProvider(this));
    a(AudienceAdapter.class).a(new ComposerModule.AudienceAdapterProvider(this, null));
    a(InteractionLogger.class).a(new ComposerModule.InteractionLoggerProvider(this, null)).a();
    a(MediaItemFactory.class).a(new ComposerModule.MediaItemFactoryProvider(this));
    a(TargetAdapter.class).a(new ComposerModule.TrackAdapterProvider(this, null));
    a(PhotoFlowLogger.class).a(new ComposerModule.PhotoFlowLoggerProvider(this, null));
    a(WaterfallIdGenerator.class).a(new ComposerModule.WaterfallIdGeneratorProvider(this, null));
    a(EventTaggingAnalyticsLogger.class).a(new ComposerModule.EventTaggingAnalyticsLoggerProvider(this, null));
    a(GraphQLProfileCache.class).a(new ComposerModule.GraphQLProfileCacheProvider(this, null)).a();
    a(AggressiveSuggestionPreferences.class).a(new ComposerModule.EventPreferencesProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule
 * JD-Core Version:    0.6.0
 */