package com.facebook.orca.audio;

import android.net.Uri;
import com.facebook.orca.media.MediaCacheKey;
import com.google.common.base.Preconditions;

public class AudioCacheKey extends MediaCacheKey
{
  private final Uri a;

  public AudioCacheKey(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    this.a = paramUri;
  }

  public Uri a()
  {
    return this.a;
  }

  public String b()
  {
    return this.a.toString();
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    AudioCacheKey localAudioCacheKey;
    do
    {
      while (true)
      {
        return i;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        i = 0;
      }
      localAudioCacheKey = (AudioCacheKey)paramObject;
      if (this.a == null)
        break;
    }
    while (this.a.equals(localAudioCacheKey.a));
    while (true)
    {
      i = 0;
      break;
      if (localAudioCacheKey.a == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioCacheKey
 * JD-Core Version:    0.6.0
 */