package com.facebook.composer;

import com.facebook.composer.optimistic.ComposerActivityBroadcaster;
import com.facebook.orca.inject.AbstractProvider;

class ComposerLibModule$ComposerActivityBroadcasterProvider extends AbstractProvider<ComposerActivityBroadcaster>
{
  private ComposerLibModule$ComposerActivityBroadcasterProvider(ComposerLibModule paramComposerLibModule)
  {
  }

  public ComposerActivityBroadcaster a()
  {
    return new ComposerActivityBroadcaster(ComposerLibModule.a(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ComposerLibModule.ComposerActivityBroadcasterProvider
 * JD-Core Version:    0.6.2
 */