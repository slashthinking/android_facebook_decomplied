package com.facebook.orca.audio;

import android.os.Handler;
import com.facebook.orca.common.util.Clock;

class AudioRecorderTooltipView$1
  implements Runnable
{
  public void run()
  {
    AudioRecorderTooltipView.a(this.a, AudioRecorderTooltipView.a(this.a).a() - AudioRecorderTooltipView.b(this.a));
    AudioRecorderTooltipView.d(this.a).postDelayed(AudioRecorderTooltipView.c(this.a), 50L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioRecorderTooltipView.1
 * JD-Core Version:    0.6.0
 */