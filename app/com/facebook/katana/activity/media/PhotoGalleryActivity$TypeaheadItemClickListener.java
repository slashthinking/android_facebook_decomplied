package com.facebook.katana.activity.media;

import android.graphics.PointF;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.widget.tagging.TaggingProfile;
import java.util.ArrayList;
import java.util.List;

class PhotoGalleryActivity$TypeaheadItemClickListener
  implements AdapterView.OnItemClickListener
{
  private PhotoGalleryActivity$TypeaheadItemClickListener(PhotoGalleryActivity paramPhotoGalleryActivity)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FacebookPhoto localFacebookPhoto = PhotoGalleryActivity.y(this.a);
    if ((PhotoGalleryActivity.B(this.a) == null) || (localFacebookPhoto == null));
    while (true)
    {
      return;
      if ((PhotoGalleryActivity.I(this.a) == null) || (PhotoGalleryActivity.I(this.a).a() < 50))
        break;
      Toaster.a(this.a, 2131363031, 17);
    }
    TaggingProfile localTaggingProfile;
    label89: long l;
    if (paramAdapterView == null)
    {
      localTaggingProfile = (TaggingProfile)PhotoGalleryActivity.J(this.a).getAdapter().getItem(paramInt);
      l = -1L;
      if (localTaggingProfile.b() <= 0L)
        break label312;
      l = localTaggingProfile.b();
    }
    label312: for (boolean bool = false; ; bool = true)
    {
      String str = localTaggingProfile.a();
      FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag(localFacebookPhoto.a(), l, 100.0F * PhotoGalleryActivity.B(this.a).x, 100.0F * PhotoGalleryActivity.B(this.a).y, 0L, str);
      PhotoGalleryActivity.I(this.a).a(localFacebookPhotoTag);
      PhotoGalleryActivity.a(this.a, null);
      PhotoGalleryActivity.J(this.a).setText("");
      PhotoGalleryActivity.s(this.a);
      PhotoGalleryActivity.t(this.a);
      ArrayList localArrayList = new ArrayList();
      PhotoGalleryActivity.H(this.a).a(bool);
      localArrayList.add(localFacebookPhotoTag);
      PhotoGalleryActivity.g(this.a).a(this.a, localFacebookPhoto.a(), localArrayList);
      PhotoGalleryActivity.t(this.a);
      if (PhotoGalleryActivity.A(this.a) == null)
        break;
      PhotoGalleryActivity.A(this.a).b();
      break;
      localTaggingProfile = (TaggingProfile)paramAdapterView.getItemAtPosition(paramInt);
      break label89;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.TypeaheadItemClickListener
 * JD-Core Version:    0.6.0
 */