package com.facebook.orca.images;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$MediaAttachmentFactoryProvider extends AbstractProvider<MediaAttachmentFactory>
{
  private ImageModule$MediaAttachmentFactoryProvider(ImageModule paramImageModule)
  {
  }

  public MediaAttachmentFactory a()
  {
    return new MediaAttachmentFactory((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.MediaAttachmentFactoryProvider
 * JD-Core Version:    0.6.2
 */