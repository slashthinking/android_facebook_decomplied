package com.facebook.photos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class FbPhoto$AlbumFbid
{

  @JsonProperty("id")
  public final String fbid;

  private FbPhoto$AlbumFbid()
  {
    this.fbid = null;
  }

  private FbPhoto$AlbumFbid(String paramString)
  {
    this.fbid = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhoto.AlbumFbid
 * JD-Core Version:    0.6.0
 */