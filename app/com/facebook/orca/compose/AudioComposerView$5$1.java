package com.facebook.orca.compose;

import android.media.MediaRecorder;
import android.os.Handler;

class AudioComposerView$5$1
  implements Runnable
{
  public void run()
  {
    AudioComposerView.a(this.b.b, this.a.getMaxAmplitude());
    this.b.a.postDelayed(this, 50L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView.5.1
 * JD-Core Version:    0.6.0
 */