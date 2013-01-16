package com.facebook.orca.audio;

import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.Callable;

class FetchAudioExecutor$1
  implements Callable<Uri>
{
  public Uri a()
  {
    Uri localUri = FetchAudioExecutor.a(this.b, this.a);
    if (localUri == null)
      throw new IOException("Error downloading audio.");
    return localUri;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.FetchAudioExecutor.1
 * JD-Core Version:    0.6.0
 */