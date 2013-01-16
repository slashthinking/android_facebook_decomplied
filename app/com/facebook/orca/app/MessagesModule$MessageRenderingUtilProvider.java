package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.share.ShareRenderingLogic;

class MessagesModule$MessageRenderingUtilProvider extends AbstractProvider<MessageRenderingUtil>
{
  private MessagesModule$MessageRenderingUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessageRenderingUtil a()
  {
    return new MessageRenderingUtil((Resources)b(Resources.class), (ShareRenderingLogic)b(ShareRenderingLogic.class), (EmojiUtil)b(EmojiUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessageRenderingUtilProvider
 * JD-Core Version:    0.6.0
 */