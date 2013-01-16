package com.facebook.orca.audio;

import android.net.Uri;
import com.google.common.base.Preconditions;

public class FetchAudioParams
{
  private final Uri a;

  public FetchAudioParams(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    Preconditions.checkArgument(paramUri.isAbsolute());
    this.a = paramUri;
  }

  public Uri a()
  {
    return this.a;
  }

  public AudioCacheKey b()
  {
    return new AudioCacheKey(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.FetchAudioParams
 * JD-Core Version:    0.6.0
 */