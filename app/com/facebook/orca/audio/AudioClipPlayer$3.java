package com.facebook.orca.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class AudioClipPlayer$3
  implements MediaPlayer.OnErrorListener
{
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioClipPlayer.b(this.a);
    AudioClipPlayer.a(this.a, AudioClipPlayer.Event.PLAYBACK_ERROR);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer.3
 * JD-Core Version:    0.6.0
 */