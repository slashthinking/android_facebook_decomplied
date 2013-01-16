package com.facebook.katana.activity.media;

import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter;

class CameraReviewActivity$DuplicateTagFilter
  implements BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter
{
  CameraReviewActivity$DuplicateTagFilter(CameraReviewActivity paramCameraReviewActivity)
  {
  }

  public boolean a(long paramLong)
  {
    if (paramLong <= 0L);
    for (boolean bool = false; ; bool = CameraReviewActivity.j(this.a).b(paramLong))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.DuplicateTagFilter
 * JD-Core Version:    0.6.0
 */