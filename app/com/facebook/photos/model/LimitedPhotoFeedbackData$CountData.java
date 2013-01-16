package com.facebook.photos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LimitedPhotoFeedbackData$CountData
{

  @JsonProperty("count")
  public final long count;

  private LimitedPhotoFeedbackData$CountData()
  {
    this.count = 0L;
  }

  private LimitedPhotoFeedbackData$CountData(long paramLong)
  {
    this.count = paramLong;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.LimitedPhotoFeedbackData.CountData
 * JD-Core Version:    0.6.0
 */