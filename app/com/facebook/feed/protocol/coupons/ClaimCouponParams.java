package com.facebook.feed.protocol.coupons;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ClaimCouponParams
  implements Parcelable
{
  public static final Parcelable.Creator<ClaimCouponParams> CREATOR = new ClaimCouponParams.1();
  public final String a;
  public final String b;

  public ClaimCouponParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public ClaimCouponParams(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.coupons.ClaimCouponParams
 * JD-Core Version:    0.6.0
 */