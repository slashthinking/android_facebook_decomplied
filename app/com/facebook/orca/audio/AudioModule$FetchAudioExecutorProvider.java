package com.facebook.orca.audio;

import com.facebook.orca.common.async.KeyedExecutor;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$FetchAudioExecutorProvider extends AbstractProvider<FetchAudioExecutor>
{
  private AudioModule$FetchAudioExecutorProvider(AudioModule paramAudioModule)
  {
  }

  public FetchAudioExecutor a()
  {
    return new FetchAudioExecutor((AudioCache)b(AudioCache.class), (AudioUriCache)b(AudioUriCache.class), (KeyedExecutor)b(KeyedExecutor.class), (AudioMediaDownloader)b(AudioMediaDownloader.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.FetchAudioExecutorProvider
 * JD-Core Version:    0.6.0
 */