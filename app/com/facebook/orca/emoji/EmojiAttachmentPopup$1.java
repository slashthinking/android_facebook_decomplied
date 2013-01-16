package com.facebook.orca.emoji;

import android.os.Handler;
import android.os.Message;

class EmojiAttachmentPopup$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (EmojiAttachmentPopup.a(this.a, false)))
      sendMessageDelayed(Message.obtain(this, 1), 100L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.1
 * JD-Core Version:    0.6.0
 */