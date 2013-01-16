package com.facebook.composer;

import com.facebook.composer.protocol.LinksPreviewMethod;
import com.facebook.composer.protocol.PostRecommendationMethod;
import com.facebook.composer.server.ComposerServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class ComposerLibModule$ComposerServiceHandlerProvider extends AbstractProvider<ComposerServiceHandler>
{
  private ComposerLibModule$ComposerServiceHandlerProvider(ComposerLibModule paramComposerLibModule)
  {
  }

  public ComposerServiceHandler a()
  {
    return new ComposerServiceHandler(a(SingleMethodRunner.class), (LinksPreviewMethod)b(LinksPreviewMethod.class), (PostRecommendationMethod)b(PostRecommendationMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ComposerLibModule.ComposerServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */