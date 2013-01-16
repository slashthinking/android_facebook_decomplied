package com.facebook.orca.notify;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class MessagingNotificationFeedback$1
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessagingNotificationFeedback.1
 * JD-Core Version:    0.6.0
 */