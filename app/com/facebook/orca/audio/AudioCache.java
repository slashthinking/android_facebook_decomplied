package com.facebook.orca.audio;

import android.content.Context;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.media.MediaCache;
import com.facebook.orca.media.MediaCacheParams;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileOutputStream;

public class AudioCache extends MediaCache<AudioCacheKey, byte[]>
{
  public AudioCache(Context paramContext, Clock paramClock, DiskUsageUtil paramDiskUsageUtil)
  {
    super(paramContext, paramClock, paramDiskUsageUtil, d());
  }

  private static MediaCacheParams d()
  {
    return new MediaCacheParams().a("audio").b(".audio").a(2147483647).b(2147483647).c(0).d(0).a(false);
  }

  protected int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length;
  }

  protected void a(AudioCacheKey paramAudioCacheKey, byte[] paramArrayOfByte, File paramFile)
  {
    paramFile.setReadable(true, false);
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      localFileOutputStream.write(paramArrayOfByte);
      return;
    }
    finally
    {
      Closeables.a(localFileOutputStream);
    }
    throw localObject;
  }

  protected byte[] a(AudioCacheKey paramAudioCacheKey, File paramFile)
  {
    return Files.c(paramFile);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioCache
 * JD-Core Version:    0.6.0
 */