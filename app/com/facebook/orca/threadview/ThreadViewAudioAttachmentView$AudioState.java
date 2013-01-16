package com.facebook.orca.threadview;

 enum ThreadViewAudioAttachmentView$AudioState
{
  static
  {
    DOWNLOADED = new AudioState("DOWNLOADED", 1);
    ERROR = new AudioState("ERROR", 2);
    AudioState[] arrayOfAudioState = new AudioState[3];
    arrayOfAudioState[0] = INIT;
    arrayOfAudioState[1] = DOWNLOADED;
    arrayOfAudioState[2] = ERROR;
    $VALUES = arrayOfAudioState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewAudioAttachmentView.AudioState
 * JD-Core Version:    0.6.0
 */