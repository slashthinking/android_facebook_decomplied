package com.facebook.katana.activity.composer;

import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.photos.analytics.WaterfallIdGenerator;

class ComposerModule$WaterfallIdGeneratorProvider extends AbstractProvider<WaterfallIdGenerator>
{
  private ComposerModule$WaterfallIdGeneratorProvider(ComposerModule paramComposerModule)
  {
  }

  public WaterfallIdGenerator a()
  {
    return new WaterfallIdGenerator((UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.WaterfallIdGeneratorProvider
 * JD-Core Version:    0.6.0
 */