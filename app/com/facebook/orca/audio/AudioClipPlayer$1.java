package com.facebook.orca.audio;

import android.os.Handler;

class AudioClipPlayer$1
  implements Runnable
{
  public void run()
  {
    AudioClipPlayer.a(this.a, AudioClipPlayer.Event.PLAYBACK_POSITION_UPDATED);
    AudioClipPlayer.a(this.a).postDelayed(this, 25L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer.1
 * JD-Core Version:    0.6.0
 */