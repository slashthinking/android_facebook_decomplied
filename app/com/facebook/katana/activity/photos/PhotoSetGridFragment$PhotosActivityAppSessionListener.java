package com.facebook.katana.activity.photos;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.util.Toaster;
import com.facebook.katana.activity.media.PhotoSetGridAdapter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoSet;
import java.util.List;
import java.util.Set;

class PhotoSetGridFragment$PhotosActivityAppSessionListener extends AppSessionListener
{
  private PhotoSetGridFragment$PhotosActivityAppSessionListener(PhotoSetGridFragment paramPhotoSetGridFragment)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, FacebookPhotoSet paramFacebookPhotoSet)
  {
    if (!PhotoSetGridFragment.e(this.a).equals(paramString3));
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null) && (paramFacebookPhotoSet != null))
      {
        PhotoSetGridFragment.a(this.a, paramFacebookPhotoSet);
        continue;
      }
      FragmentActivity localFragmentActivity = this.a.n();
      Toaster.a(localFragmentActivity, 2131363040);
      localFragmentActivity.finish();
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, String paramString4)
  {
    this.a.a();
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, String paramString4, long paramLong)
  {
    PhotoSetGridFragment.a(this.a).a(paramLong);
  }

  public void c(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookPhoto> paramList)
  {
    if (!PhotoSetGridFragment.d(this.a).contains(paramString1));
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        PhotoSetGridFragment.a(this.a).notifyDataSetChanged();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.PhotoSetGridFragment.PhotosActivityAppSessionListener
 * JD-Core Version:    0.6.0
 */