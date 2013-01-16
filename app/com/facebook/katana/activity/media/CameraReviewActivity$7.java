package com.facebook.katana.activity.media;

import android.graphics.PointF;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.widget.tagging.TaggingProfile;

class CameraReviewActivity$7
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (CameraReviewActivity.i(this.a) == null);
    while (true)
    {
      return;
      if ((CameraReviewActivity.j(this.a) == null) || (CameraReviewActivity.j(this.a).a() < 50))
        break;
      Toaster.a(this.a, 2131363031, 17);
    }
    TaggingProfile localTaggingProfile;
    label75: long l;
    if (paramAdapterView == null)
    {
      localTaggingProfile = (TaggingProfile)CameraReviewActivity.a(this.a).getAdapter().getItem(paramInt);
      l = -1L;
      if (localTaggingProfile.b() <= 0L)
        break label279;
      l = localTaggingProfile.b();
      CameraReviewActivity.g(this.a).a(false, "camerareview");
    }
    while (true)
    {
      FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag("", l, 100.0F * CameraReviewActivity.i(this.a).x, 100.0F * CameraReviewActivity.i(this.a).y, 0L, localTaggingProfile.a(), localTaggingProfile.c());
      CameraReviewActivity.j(this.a).a(localFacebookPhotoTag);
      Log.e("ADDTAG", "The tag " + localFacebookPhotoTag.f() + " has been added");
      CameraReviewActivity.a(this.a, null);
      CameraReviewActivity.a(this.a).setText("");
      CameraReviewActivity.k(this.a);
      CameraReviewActivity.l(this.a);
      if (CameraReviewActivity.m(this.a) == null)
        break;
      CameraReviewActivity.m(this.a).b();
      break;
      localTaggingProfile = (TaggingProfile)paramAdapterView.getItemAtPosition(paramInt);
      break label75;
      label279: CameraReviewActivity.g(this.a).a(true, "camerareview");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.7
 * JD-Core Version:    0.6.0
 */