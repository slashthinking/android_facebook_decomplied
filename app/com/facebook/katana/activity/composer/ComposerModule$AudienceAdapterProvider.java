package com.facebook.katana.activity.composer;

import com.facebook.katana.features.composer.AudienceAdapter;
import com.facebook.orca.inject.AbstractProvider;

class ComposerModule$AudienceAdapterProvider extends AbstractProvider<AudienceAdapter>
{
  private ComposerModule$AudienceAdapterProvider(ComposerModule paramComposerModule)
  {
  }

  public AudienceAdapter a()
  {
    return new AudienceAdapter();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.AudienceAdapterProvider
 * JD-Core Version:    0.6.0
 */