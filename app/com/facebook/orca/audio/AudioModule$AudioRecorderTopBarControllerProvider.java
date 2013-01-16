package com.facebook.orca.audio;

import android.content.res.Resources;
import android.view.LayoutInflater;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$AudioRecorderTopBarControllerProvider extends AbstractProvider<AudioRecorderTopBarController>
{
  private AudioModule$AudioRecorderTopBarControllerProvider(AudioModule paramAudioModule)
  {
  }

  public AudioRecorderTopBarController a()
  {
    return new AudioRecorderTopBarController((LayoutInflater)b(LayoutInflater.class), (Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioRecorderTopBarControllerProvider
 * JD-Core Version:    0.6.0
 */