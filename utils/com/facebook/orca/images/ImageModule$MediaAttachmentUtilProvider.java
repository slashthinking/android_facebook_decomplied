package com.facebook.orca.images;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.attachments.ImageAttachmentDecoder;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class ImageModule$MediaAttachmentUtilProvider extends AbstractProvider<MediaAttachmentUtil>
{
  private ImageModule$MediaAttachmentUtilProvider(ImageModule paramImageModule)
  {
  }

  public MediaAttachmentUtil a()
  {
    return new MediaAttachmentUtil((Context)b(Context.class, FromApplication.class), (ImageAttachmentDecoder)b(ImageAttachmentDecoder.class), (ImageScalingUtil)b(ImageScalingUtil.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule.MediaAttachmentUtilProvider
 * JD-Core Version:    0.6.2
 */