package com.facebook.katana.activity.media;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.util.StringUtils;

class PhotoSetActivity$PhotosActivityAppSessionListener extends AppSessionListener
{
  private PhotoSetActivity$PhotosActivityAppSessionListener(PhotoSetActivity paramPhotoSetActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3)
  {
    this.a.removeDialog(24);
    PhotoSetActivity.a(this.a, null);
    if (paramInt == 200)
    {
      if (PhotoSetActivity.a(this.a) != null)
      {
        PhotoSetActivity.a(this.a, null);
        this.a.removeDialog(23);
      }
      this.a.finish();
    }
    while (true)
    {
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131362818), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetActivity.PhotosActivityAppSessionListener
 * JD-Core Version:    0.6.0
 */