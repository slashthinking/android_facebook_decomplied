package com.facebook.orca.audio;

import com.facebook.orca.annotations.IsAudioPlayerEnabled;
import com.facebook.orca.annotations.IsAudioRecorderEnabled;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.media.MediaCache;

public class AudioModule extends AbstractModule
{
  protected void a()
  {
    a(AudioCache.class).a(new AudioModule.AudioCacheProvider(this, null)).a();
    a(AudioMediaDownloader.class).a(new AudioModule.AudioMediaDownloaderProvider(this, null));
    a(FetchAudioExecutor.class).a(new AudioModule.FetchAudioExecutorProvider(this, null)).a();
    a(Boolean.class).a(IsAudioRecorderEnabled.class).c(IsAudioRecorderEnabledProvider.class);
    a(Boolean.class).a(IsAudioPlayerEnabled.class).c(IsAudioPlayerEnabledProvider.class);
    c(MediaCache.class).a(AudioCache.class);
    a(AudioUriCache.class).a(new AudioModule.AudioUriCacheProvider(this, null)).a();
    a(AudioRecorderTopBarController.class).a(new AudioModule.AudioRecorderTopBarControllerProvider(this, null));
    a(AudioPlaybackTimer.class).a(new AudioModule.AudioPlaybackTimerProvider(this, null));
    a(AudioClipPlayer.class).a(new AudioModule.AudioClipPlayerProvider(this, null));
    a(AudioClipPlayerQueue.class).a(new AudioModule.AudioClipPlayerQueueProvider(this, null)).a();
    a(VolumeControlStreamManager.class).a(new AudioModule.VolumeControlStreamManagerProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule
 * JD-Core Version:    0.6.0
 */