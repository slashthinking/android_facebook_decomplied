package com.facebook.katana.activity.media.vault;

import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.photos.VaultPhoto;
import java.util.Comparator;

class VaultGridAdapter$1
  implements Comparator<Photo>
{
  public int a(Photo paramPhoto1, Photo paramPhoto2)
  {
    long l1 = ((VaultPhoto)paramPhoto1).c();
    long l2 = ((VaultPhoto)paramPhoto2).c();
    int i;
    if (l1 == l2)
      i = 0;
    while (true)
    {
      return i;
      if (l2 > l1)
      {
        i = 1;
        continue;
      }
      i = -1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultGridAdapter.1
 * JD-Core Version:    0.6.0
 */