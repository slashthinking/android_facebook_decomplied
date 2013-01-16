package com.facebook.katana.binding;

import java.util.Comparator;

class StreamPhotosCache$2
  implements Comparator<StreamPhoto>
{
  public int a(StreamPhoto paramStreamPhoto1, StreamPhoto paramStreamPhoto2)
  {
    int i;
    if (paramStreamPhoto1.e() > paramStreamPhoto2.e())
      i = 1;
    while (true)
    {
      return i;
      if (paramStreamPhoto1.e() == paramStreamPhoto2.e())
      {
        i = 0;
        continue;
      }
      i = -1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.StreamPhotosCache.2
 * JD-Core Version:    0.6.0
 */