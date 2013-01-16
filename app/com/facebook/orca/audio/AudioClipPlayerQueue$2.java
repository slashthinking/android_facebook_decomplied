package com.facebook.orca.audio;

import android.net.Uri;
import java.util.HashMap;

class AudioClipPlayerQueue$2
  implements AudioClipPlayer.Callback
{
  public void a(AudioClipPlayer.Event paramEvent)
  {
    switch (AudioClipPlayerQueue.3.a[paramEvent.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      AudioClipPlayerQueue.b(this.b);
      AudioClipPlayerQueue.c(this.b).remove(this.a);
      AudioClipPlayerQueue.a(this.b, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayerQueue.2
 * JD-Core Version:    0.6.0
 */