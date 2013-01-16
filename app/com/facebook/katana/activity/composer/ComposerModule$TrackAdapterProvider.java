package com.facebook.katana.activity.composer;

import com.facebook.katana.features.composer.TargetAdapter;
import com.facebook.orca.inject.AbstractProvider;

class ComposerModule$TrackAdapterProvider extends AbstractProvider<TargetAdapter>
{
  private ComposerModule$TrackAdapterProvider(ComposerModule paramComposerModule)
  {
  }

  public TargetAdapter a()
  {
    return new TargetAdapter(ComposerModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.TrackAdapterProvider
 * JD-Core Version:    0.6.0
 */