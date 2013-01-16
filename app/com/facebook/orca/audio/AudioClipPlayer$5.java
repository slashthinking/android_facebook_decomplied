package com.facebook.orca.audio;

import android.os.Handler;
import com.google.common.util.concurrent.FutureCallback;

class AudioClipPlayer$5
  implements FutureCallback<Object>
{
  public void a(Object paramObject)
  {
    AudioClipPlayer.a(this.a, null);
    AudioClipPlayer.a(this.a, AudioClipPlayer.Event.PLAYBACK_STARTED);
    AudioClipPlayer.a(this.a).post(AudioClipPlayer.d(this.a));
  }

  public void a(Throwable paramThrowable)
  {
    AudioClipPlayer.a(this.a, null);
    AudioClipPlayer.b(this.a);
    AudioClipPlayer.a(this.a, AudioClipPlayer.Event.PLAYBACK_ERROR);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipPlayer.5
 * JD-Core Version:    0.6.0
 */