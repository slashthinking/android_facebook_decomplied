package com.facebook.katana.activity.media;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;

class PhotosLegacyAdapterActivity$AppListener extends AppSessionListener
{
  private PhotosLegacyAdapterActivity$AppListener(PhotosLegacyAdapterActivity paramPhotosLegacyAdapterActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String[] paramArrayOfString, long paramLong)
  {
    if ((paramArrayOfString.length == 1) && (paramLong == PhotosLegacyAdapterActivity.a(this.a)) && (paramArrayOfString[0].equals(PhotosLegacyAdapterActivity.b(this.a))))
    {
      FacebookAlbum localFacebookAlbum = null;
      if (paramInt == 200)
      {
        localFacebookAlbum = null;
        if (paramException == null)
          localFacebookAlbum = FacebookAlbum.a(this.a, PhotosLegacyAdapterActivity.b(this.a));
      }
      if (localFacebookAlbum == null)
        break label96;
      PhotosLegacyAdapterActivity.a(this.a, localFacebookAlbum.m());
    }
    while (true)
    {
      this.a.finish();
      return;
      label96: Toaster.a(this.a, 2131362822);
      ErrorReporting.a("album_redirect", "Failed to redirect owner=" + PhotosLegacyAdapterActivity.a(this.a) + " aid=" + PhotosLegacyAdapterActivity.b(this.a));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotosLegacyAdapterActivity.AppListener
 * JD-Core Version:    0.6.0
 */