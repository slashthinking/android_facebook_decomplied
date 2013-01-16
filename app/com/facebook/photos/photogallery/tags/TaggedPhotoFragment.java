package com.facebook.photos.photogallery.tags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.photos.photogallery.PhotoFragment;
import com.facebook.photos.photogallery.util.VisibilityAnimator;
import com.facebook.widget.ZoomableImageView;

public class TaggedPhotoFragment extends PhotoFragment<TaggedPhoto>
{
  private TagsView a;
  private VisibilityAnimator b;
  private TaggedPhotoFragment.TaggedPhotoFragmentListener c;
  private boolean d;

  public TaggedPhotoFragment(TaggedPhoto paramTaggedPhoto)
  {
    super(paramTaggedPhoto);
  }

  public void K()
  {
    this.a.setTags(((TaggedPhoto)d()).i());
  }

  public boolean L()
  {
    return this.b.a();
  }

  public void M()
  {
    this.b.b();
  }

  public void N()
  {
    this.b.c();
  }

  public void O()
  {
    this.b.d();
  }

  public void P()
  {
    this.b.e();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = new TagsView(p(), a(), ((TaggedPhoto)d()).i());
    this.a.a(new TaggedPhotoFragment.1(this));
    ((FrameLayout)localView).addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    a().a(new TaggedPhotoFragment.2(this));
    this.b = new VisibilityAnimator(this.a, 200L, false);
    if (this.d)
      N();
    while (true)
    {
      return localView;
      P();
    }
  }

  public void a(TaggedPhotoFragment.TaggedPhotoFragmentListener paramTaggedPhotoFragmentListener)
  {
    this.c = paramTaggedPhotoFragmentListener;
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggedPhotoFragment
 * JD-Core Version:    0.6.0
 */