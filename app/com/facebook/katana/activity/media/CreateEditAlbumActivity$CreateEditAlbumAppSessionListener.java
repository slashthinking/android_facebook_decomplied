package com.facebook.katana.activity.media;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;

class CreateEditAlbumActivity$CreateEditAlbumAppSessionListener extends AppSessionListener
{
  private CreateEditAlbumActivity$CreateEditAlbumAppSessionListener(CreateEditAlbumActivity paramCreateEditAlbumActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookAlbum paramFacebookAlbum)
  {
    this.a.removeDialog(1);
    CreateEditAlbumActivity.a(this.a, null);
    if (paramInt == 200)
    {
      Toaster.a(this.a, 2131362892);
      this.a.setResult(-1);
      this.a.finish();
    }
    while (true)
    {
      return;
      Toaster.a(this.a, 2131362890);
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3)
  {
    this.a.removeDialog(2);
    CreateEditAlbumActivity.b(this.a, null);
    if (paramInt == 200)
    {
      Toaster.a(this.a, 2131362899);
      this.a.setResult(-1);
      this.a.finish();
    }
    while (true)
    {
      return;
      Toaster.a(this.a, 2131362897);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CreateEditAlbumActivity.CreateEditAlbumAppSessionListener
 * JD-Core Version:    0.6.0
 */