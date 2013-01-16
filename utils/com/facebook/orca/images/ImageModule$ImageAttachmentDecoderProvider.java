package com.facebook.orca.images;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.attachments.ImageAttachmentDecoder;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$ImageAttachmentDecoderProvider extends AbstractProvider<ImageAttachmentDecoder>
{
  private ImageModule$ImageAttachmentDecoderProvider(ImageModule paramImageModule)
  {
  }

  public ImageAttachmentDecoder a()
  {
    return new ImageAttachmentDecoder((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.ImageAttachmentDecoderProvider
 * JD-Core Version:    0.6.2
 */