package com.facebook.composer;

import com.facebook.composer.protocol.PublishCheckinMethod;
import com.facebook.composer.protocol.PublishLocationMethod;
import com.facebook.composer.protocol.PublishPostMethod;
import com.facebook.composer.protocol.PublishShareMethod;
import com.facebook.composer.protocol.SimplePhotoUploadMethod;
import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.BatchRunner;

class ComposerLibModule$ComposerPublishServiceHandlerProvider extends AbstractProvider<ComposerPublishServiceHandler>
{
  private ComposerLibModule$ComposerPublishServiceHandlerProvider(ComposerLibModule paramComposerLibModule)
  {
  }

  public ComposerPublishServiceHandler a()
  {
    return new ComposerPublishServiceHandler(a(BatchRunner.class), (PublishCheckinMethod)b(PublishCheckinMethod.class), (PublishPostMethod)b(PublishPostMethod.class), (PublishLocationMethod)b(PublishLocationMethod.class), (PublishShareMethod)b(PublishShareMethod.class), (SimplePhotoUploadMethod)b(SimplePhotoUploadMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ComposerLibModule.ComposerPublishServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */