package com.facebook.orca.audio;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$AudioPlaybackTimerProvider extends AbstractProvider<AudioPlaybackTimer>
{
  private AudioModule$AudioPlaybackTimerProvider(AudioModule paramAudioModule)
  {
  }

  public AudioPlaybackTimer a()
  {
    return new AudioPlaybackTimer((Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioPlaybackTimerProvider
 * JD-Core Version:    0.6.0
 */