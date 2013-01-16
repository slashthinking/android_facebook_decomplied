package com.facebook.katana.activity.media;

import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

class UploadPhotoActivity$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookProfile paramFacebookProfile)
  {
    if ((paramInt == 200) && (paramFacebookProfile != null) && (paramFacebookProfile.mId == UploadPhotoActivity.b(this.a)))
    {
      UploadPhotoActivity.a(this.a, paramFacebookProfile);
      UploadPhotoActivity.c(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.1
 * JD-Core Version:    0.6.0
 */