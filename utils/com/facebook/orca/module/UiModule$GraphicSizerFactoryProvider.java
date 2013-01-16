package com.facebook.orca.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;

class UiModule$GraphicSizerFactoryProvider extends AbstractProvider<GraphicSizerFactory>
{
  private UiModule$GraphicSizerFactoryProvider(UiModule paramUiModule)
  {
  }

  public GraphicSizerFactory a()
  {
    return new GraphicSizerFactory();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.GraphicSizerFactoryProvider
 * JD-Core Version:    0.6.2
 */