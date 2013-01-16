package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class iTunesContent
{

  @JsonProperty("content_url")
  private final String mContentUrl = null;

  @JsonProperty("image_url")
  private final String mImageUrl = null;

  @JsonProperty("media_type")
  private final String mMediaType = null;

  @JsonProperty("subtitle")
  private final String mSubtitle = null;

  @JsonProperty("title")
  private final String mTitle = null;

  @JsonProperty("itunes_id")
  private final String miTunesId = null;

  public String a()
  {
    return this.mSubtitle;
  }

  public String b()
  {
    return this.mTitle;
  }

  public String c()
  {
    return this.miTunesId;
  }

  public String d()
  {
    return this.mImageUrl;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.iTunesContent
 * JD-Core Version:    0.6.0
 */