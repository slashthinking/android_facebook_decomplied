package com.karmascience.gifts.content.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Sku
  implements Parcelable
{

  @JsonProperty("description")
  private final String mDescription = null;

  @JsonProperty("full_images")
  private final List<Image> mFullImages = null;

  @JsonProperty("id")
  private final String mId = null;

  @JsonProperty("name")
  private final String mName = null;

  @JsonProperty("price")
  private final int mPrice = 0;

  @JsonProperty("shipping_price")
  private final int mShippingPrice = 0;

  @JsonProperty("shipping_surcharge")
  private final int mShippingSurchage = 0;

  @JsonProperty("thumb_images")
  private final List<Image> mThumbImages = null;

  @JsonProperty("total_price")
  private final int mTotalPrice = 0;

  public String a()
  {
    return this.mName;
  }

  public String b()
  {
    return this.mDescription;
  }

  public String c()
  {
    return this.mId;
  }

  public int d()
  {
    return this.mPrice;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.mShippingPrice;
  }

  public Image f()
  {
    if ((this.mThumbImages != null) && (this.mThumbImages.size() > 0));
    for (Image localImage = (Image)this.mThumbImages.get(0); ; localImage = null)
      return localImage;
  }

  public List<Image> g()
  {
    return this.mFullImages;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Sku
 * JD-Core Version:    0.6.0
 */