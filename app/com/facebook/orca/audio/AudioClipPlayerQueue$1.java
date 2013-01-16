package com.facebook.orca.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;

class AudioClipPlayerQueue$1
  implements AudioManager.OnAudioFocusChangeListener
{
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    default:
    case -3:
    case -2:
    case 1:
    case -1:
    }
    while (true)
    {
      return;
      if (AudioClipPlayerQueue.a(this.a) == null)
        continue;
      AudioClipPlayerQueue.a(this.a).d();
      continue;
      if ((AudioClipPlayerQueue.a(this.a) == null) || (!AudioClipPlayerQueue.a(this.a).f()))
        continue;
      AudioClipPlayerQueue.a(this.a).e();
      continue;
      if (AudioClipPlayerQueue.a(this.a) == null)
        continue;
      AudioClipPlayerQueue.a(this.a).c();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayerQueue.1
 * JD-Core Version:    0.6.0
 */