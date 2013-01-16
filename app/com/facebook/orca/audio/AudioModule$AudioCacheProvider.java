package com.facebook.orca.audio;

import android.content.Context;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class AudioModule$AudioCacheProvider extends AbstractProvider<AudioCache>
{
  private AudioModule$AudioCacheProvider(AudioModule paramAudioModule)
  {
  }

  public AudioCache a()
  {
    return new AudioCache((Context)b(Context.class, FromApplication.class), (Clock)b(Clock.class), (DiskUsageUtil)b(DiskUsageUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioModule.AudioCacheProvider
 * JD-Core Version:    0.6.0
 */