package com.facebook.katana.activity.composer;

import com.facebook.analytics.InteractionLogger;
import com.facebook.orca.inject.AbstractProvider;

class ComposerModule$EventTaggingAnalyticsLoggerProvider extends AbstractProvider<EventTaggingAnalyticsLogger>
{
  private ComposerModule$EventTaggingAnalyticsLoggerProvider(ComposerModule paramComposerModule)
  {
  }

  public EventTaggingAnalyticsLogger a()
  {
    return new EventTaggingAnalyticsLogger((InteractionLogger)b(InteractionLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.EventTaggingAnalyticsLoggerProvider
 * JD-Core Version:    0.6.0
 */