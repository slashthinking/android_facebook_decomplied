package com.facebook.katana.activity.media;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.StringUtils;

class LegacyPhotoGalleryActivity$AppListener extends AppSessionListener
{
  private LegacyPhotoGalleryActivity$AppListener(LegacyPhotoGalleryActivity paramLegacyPhotoGalleryActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, String[] paramArrayOfString, long paramLong)
  {
    if (!StringUtils.a(paramString1, LegacyPhotoGalleryActivity.d(this.a)));
    while (true)
    {
      return;
      FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this.a, LegacyPhotoGalleryActivity.e(this.a));
      if ((paramInt == 200) && (paramException == null) && (localFacebookPhoto != null))
      {
        LegacyPhotoGalleryActivity.b(this.a, localFacebookPhoto.j());
        LegacyPhotoGalleryActivity.b(this.a, true);
        LegacyPhotoGalleryActivity.c(this.a);
        continue;
      }
      Toaster.a(this.a, 2131363040);
      this.a.finish();
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String[] paramArrayOfString, long paramLong)
  {
    if (!StringUtils.a(paramString1, LegacyPhotoGalleryActivity.a(this.a)));
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        FacebookAlbum localFacebookAlbum = FacebookAlbum.a(this.a, LegacyPhotoGalleryActivity.b(this.a));
        if (localFacebookAlbum != null)
          LegacyPhotoGalleryActivity.a(this.a, localFacebookAlbum.m());
        while (true)
        {
          LegacyPhotoGalleryActivity.a(this.a, true);
          LegacyPhotoGalleryActivity.c(this.a);
          break;
          LegacyPhotoGalleryActivity.a(this.a, -1L);
          LegacyPhotoGalleryActivity.a(this.a, null);
        }
      }
      Toaster.a(this.a, 2131363040);
      this.a.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.LegacyPhotoGalleryActivity.AppListener
 * JD-Core Version:    0.6.0
 */