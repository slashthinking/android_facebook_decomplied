package com.facebook.orca.media;

import java.io.File;
import java.io.FilenameFilter;

class MediaCache$1
  implements FilenameFilter
{
  MediaCache$1(MediaCache paramMediaCache)
  {
  }

  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(MediaCache.b(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache.1
 * JD-Core Version:    0.6.2
 */