package com.facebook.katana.activity.media;

import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter;

class PhotoGalleryActivity$DuplicateTagFilter
  implements BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter
{
  private PhotoGalleryActivity$DuplicateTagFilter(PhotoGalleryActivity paramPhotoGalleryActivity)
  {
  }

  public boolean a(long paramLong)
  {
    if ((paramLong <= 0L) || (PhotoGalleryActivity.I(this.a) == null));
    for (boolean bool = false; ; bool = PhotoGalleryActivity.I(this.a).b(paramLong))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.DuplicateTagFilter
 * JD-Core Version:    0.6.0
 */