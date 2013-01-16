package com.facebook.orca.app;

import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.SendMessageParameterHelper;

class MessagesModule$SendMessageParameterHelperProvider extends AbstractProvider<SendMessageParameterHelper>
{
  private MessagesModule$SendMessageParameterHelperProvider(MessagesModule paramMessagesModule)
  {
  }

  public SendMessageParameterHelper a()
  {
    return new SendMessageParameterHelper((MediaAttachmentFactory)b(MediaAttachmentFactory.class), (MediaAttachmentUtil)b(MediaAttachmentUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SendMessageParameterHelperProvider
 * JD-Core Version:    0.6.0
 */