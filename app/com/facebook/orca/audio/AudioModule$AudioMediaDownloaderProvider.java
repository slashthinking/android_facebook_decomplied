package com.facebook.orca.audio;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$AudioMediaDownloaderProvider extends AbstractProvider<AudioMediaDownloader>
{
  private AudioModule$AudioMediaDownloaderProvider(AudioModule paramAudioModule)
  {
  }

  public AudioMediaDownloader a()
  {
    return new AudioMediaDownloader((Context)b(Context.class, FromApplication.class), (OrcaHttpRequestProcessor)b(OrcaHttpRequestProcessor.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioMediaDownloaderProvider
 * JD-Core Version:    0.6.0
 */