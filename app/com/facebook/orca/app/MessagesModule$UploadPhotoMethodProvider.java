package com.facebook.orca.app;

import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.UploadShareMethod;

class MessagesModule$UploadPhotoMethodProvider extends AbstractProvider<UploadShareMethod>
{
  private MessagesModule$UploadPhotoMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public UploadShareMethod a()
  {
    return new UploadShareMethod((MediaAttachmentFactory)b(MediaAttachmentFactory.class), (MediaAttachmentUtil)b(MediaAttachmentUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UploadPhotoMethodProvider
 * JD-Core Version:    0.6.0
 */