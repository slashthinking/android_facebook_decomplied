package com.facebook.katana.activity.composer;

import com.facebook.analytics.InteractionLogger;
import com.facebook.orca.inject.AbstractProvider;

class ComposerModule$InteractionLoggerProvider extends AbstractProvider<InteractionLogger>
{
  private ComposerModule$InteractionLoggerProvider(ComposerModule paramComposerModule)
  {
  }

  public InteractionLogger a()
  {
    return new InteractionLogger(ComposerModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.InteractionLoggerProvider
 * JD-Core Version:    0.6.0
 */