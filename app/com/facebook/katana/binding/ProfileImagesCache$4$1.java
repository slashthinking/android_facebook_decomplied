package com.facebook.katana.binding;

import java.util.Map;

class ProfileImagesCache$4$1
  implements Runnable
{
  public void run()
  {
    ProfileImagesCache.b(this.a.e).remove(Long.valueOf(this.a.b));
    if (this.a.c.c() != null)
    {
      this.a.c.b();
      if (ProfileImagesCache.c(this.a.e).size() >= 75L)
        ProfileImagesCache.d(this.a.e);
      ProfileImagesCache.c(this.a.e).put(Long.valueOf(this.a.b), this.a.c);
      this.a.d.a(this.a.a, this.a.c);
    }
    while (true)
    {
      return;
      if (!ProfileImagesCache.e(this.a.e).containsKey(Long.valueOf(this.a.b)))
      {
        ProfileImagesCache.a(this.a.e).a(this.a.a, this.a.b, this.a.c.b);
        ProfileImagesCache.e(this.a.e).put(Long.valueOf(this.a.b), this.a.c.b);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ProfileImagesCache.4.1
 * JD-Core Version:    0.6.0
 */