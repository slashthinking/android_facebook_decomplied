package com.karmascience.gifts.content.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URLDecoder;

public class Image
  implements Parcelable
{
  private Uri a;

  @JsonProperty("height")
  private final int mHeight = 0;

  @JsonProperty("uri")
  private final String mUrl = null;

  @JsonProperty("width")
  private final int mWidth = 0;

  public Uri a()
  {
    if (this.a == null)
      this.a = Uri.parse(URLDecoder.decode(this.mUrl).replace("https", "http"));
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Image
 * JD-Core Version:    0.6.0
 */