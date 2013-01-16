package com.facebook.katana.view.vault;

import android.graphics.PointF;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import com.facebook.common.util.Toaster;
import com.facebook.facedetection.Tracker;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.widget.tagging.TaggingProfile;

class PickerGalleryView$3
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (PickerGalleryView.e(this.a) == null);
    while (true)
    {
      return;
      if (PickerGalleryView.f(this.a).h() < 50)
        break;
      Toaster.a(PickerGalleryView.g(this.a), 2131363031, 17);
    }
    TaggingProfile localTaggingProfile;
    label68: long l;
    String str;
    label133: int i;
    label183: double d;
    float f2;
    if (paramAdapterView == null)
    {
      localTaggingProfile = (TaggingProfile)PickerGalleryView.h(this.a).getAdapter().getItem(paramInt);
      l = -1L;
      boolean bool = true;
      if (localTaggingProfile.b() > 0L)
      {
        l = localTaggingProfile.b();
        bool = false;
      }
      if (PickerGalleryView.e(this.a) != null)
      {
        if (!PickerGalleryView.i(this.a))
          break label323;
        if (!Tracker.a(PickerGalleryView.g(this.a)))
          break label316;
        str = "mp_facecom";
        if (PickerGalleryView.d(this.a) != null)
          PickerGalleryView.d(this.a).a(bool, str);
        float f1 = PickerGalleryView.e(this.a).x;
        if (!PickerGalleryView.i(this.a))
          break label330;
        i = 1;
        d = f1 * i;
        f2 = PickerGalleryView.e(this.a).y;
        if (!PickerGalleryView.i(this.a))
          break label337;
      }
    }
    label316: label323: label330: label337: for (int j = 1; ; j = 100)
    {
      FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag("", l, d, f2 * j, 0L, localTaggingProfile.a());
      PickerGalleryView.f(this.a).a(localFacebookPhotoTag);
      if (PickerGalleryView.i(this.a))
        PickerGalleryView.f(this.a).a(PickerGalleryView.e(this.a));
      PickerGalleryView.b(this.a, false);
      PickerGalleryView.j(this.a);
      break;
      localTaggingProfile = (TaggingProfile)paramAdapterView.getItemAtPosition(paramInt);
      break label68;
      str = "mp_face";
      break label133;
      str = "mp";
      break label133;
      i = 100;
      break label183;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.3
 * JD-Core Version:    0.6.0
 */