package com.facebook.orca.audio;

import android.media.AudioManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$VolumeControlStreamManagerProvider extends AbstractProvider<VolumeControlStreamManager>
{
  private AudioModule$VolumeControlStreamManagerProvider(AudioModule paramAudioModule)
  {
  }

  public VolumeControlStreamManager a()
  {
    return new VolumeControlStreamManager((AudioManager)b(AudioManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.VolumeControlStreamManagerProvider
 * JD-Core Version:    0.6.0
 */