package com.facebook.katana.model;

import java.util.Comparator;

class MediaItem$DateCreatedComparator
  implements Comparator<MediaItem>
{
  public int a(MediaItem paramMediaItem1, MediaItem paramMediaItem2)
  {
    return Long.signum(paramMediaItem2.d() - paramMediaItem1.d());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.MediaItem.DateCreatedComparator
 * JD-Core Version:    0.6.0
 */