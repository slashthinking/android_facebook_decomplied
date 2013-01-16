package com.facebook.orca.media;

import java.io.File;
import java.io.FilenameFilter;

class MediaCache$2
  implements FilenameFilter
{
  MediaCache$2(MediaCache paramMediaCache)
  {
  }

  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".lru");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache.2
 * JD-Core Version:    0.6.2
 */