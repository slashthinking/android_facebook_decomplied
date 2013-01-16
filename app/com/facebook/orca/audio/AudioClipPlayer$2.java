package com.facebook.orca.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class AudioClipPlayer$2
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioClipPlayer.b(this.a);
    AudioClipPlayer.a(this.a, AudioClipPlayer.Event.PLAYBACK_COMPLETED);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer.2
 * JD-Core Version:    0.6.0
 */