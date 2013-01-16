package com.facebook.orca.audio;

import android.os.Handler;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

class AudioModule$AudioClipPlayerProvider extends AbstractProvider<AudioClipPlayer>
{
  private AudioModule$AudioClipPlayerProvider(AudioModule paramAudioModule)
  {
  }

  public AudioClipPlayer a()
  {
    return new AudioClipPlayer((AndroidThreadUtil)b(AndroidThreadUtil.class), (ListeningExecutorService)b(ListeningExecutorService.class, DefaultExecutorService.class), (Executor)b(Executor.class, ForUiThread.class), (AudioPlaybackTimer)b(AudioPlaybackTimer.class), (Handler)b(Handler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioClipPlayerProvider
 * JD-Core Version:    0.6.0
 */