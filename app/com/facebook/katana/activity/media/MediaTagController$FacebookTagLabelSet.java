package com.facebook.katana.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.katana.model.FacebookPhotoTag;
import java.util.ListIterator;
import java.util.Map;

class MediaTagController$FacebookTagLabelSet extends FacebookPhotoTagSet
  implements MediaTagController.LabelSet<FacebookPhotoTag>
{
  private MediaTagController$FacebookTagLabelSet(MediaTagController paramMediaTagController)
  {
  }

  public void b(FacebookPhotoTag paramFacebookPhotoTag)
  {
    super.b(paramFacebookPhotoTag);
    ViewGroup localViewGroup = (ViewGroup)MediaTagController.a(this.a).get(paramFacebookPhotoTag);
    if (localViewGroup != null)
    {
      MediaTagController.c(this.a).removeView((View)MediaTagController.a(this.a).get(paramFacebookPhotoTag));
      MediaTagController.a(this.a).remove(paramFacebookPhotoTag);
      View localView = localViewGroup.findViewById(2131297803);
      MediaTagController.b(this.a).remove(localView);
    }
  }

  public View.OnClickListener c(FacebookPhotoTag paramFacebookPhotoTag)
  {
    return null;
  }

  public ListIterator<FacebookPhotoTag> f()
  {
    return c();
  }

  public Map<FacebookPhotoTag, ViewGroup> g()
  {
    return MediaTagController.a(this.a);
  }

  public Map<View, FacebookPhotoTag> h()
  {
    return MediaTagController.b(this.a);
  }

  public View.OnClickListener i()
  {
    return new MediaTagController.FacebookTagLabelSet.1(this);
  }

  public int j()
  {
    return 2130837607;
  }

  public void k()
  {
    MediaTagController.d(this.a).e();
    MediaTagController.a(this.a).clear();
    MediaTagController.b(this.a).clear();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaTagController.FacebookTagLabelSet
 * JD-Core Version:    0.6.0
 */