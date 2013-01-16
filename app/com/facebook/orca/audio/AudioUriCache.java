package com.facebook.orca.audio;

import android.net.Uri;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class AudioUriCache
{
  private final ConcurrentMap<Uri, Uri> a = new MapMaker().b(600L, TimeUnit.SECONDS).b(100).n();

  public Uri a(Uri paramUri)
  {
    return (Uri)this.a.get(paramUri);
  }

  public Uri a(Uri paramUri1, Uri paramUri2)
  {
    return (Uri)this.a.put(paramUri1, paramUri2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioUriCache
 * JD-Core Version:    0.6.0
 */