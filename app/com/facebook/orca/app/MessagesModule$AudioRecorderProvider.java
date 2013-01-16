package com.facebook.orca.app;

import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.file.TempFileManager;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$AudioRecorderProvider extends AbstractProvider<AudioRecorder>
{
  private MessagesModule$AudioRecorderProvider(MessagesModule paramMessagesModule)
  {
  }

  public AudioRecorder a()
  {
    return new AudioRecorder(MessagesModule.a(this.a), (MediaAttachmentFactory)b(MediaAttachmentFactory.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (TempFileManager)b(TempFileManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AudioRecorderProvider
 * JD-Core Version:    0.6.0
 */