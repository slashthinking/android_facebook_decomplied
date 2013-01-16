package com.facebook.orca.audio;

import android.media.AudioManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$AudioClipPlayerQueueProvider extends AbstractProvider<AudioClipPlayerQueue>
{
  private AudioModule$AudioClipPlayerQueueProvider(AudioModule paramAudioModule)
  {
  }

  public AudioClipPlayerQueue a()
  {
    return new AudioClipPlayerQueue((AudioManager)b(AudioManager.class, FromApplication.class), a(AudioClipPlayer.class), (VolumeControlStreamManager)b(VolumeControlStreamManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioClipPlayerQueueProvider
 * JD-Core Version:    0.6.0
 */