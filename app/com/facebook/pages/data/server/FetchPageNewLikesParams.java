package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchPageNewLikesParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPageNewLikesParams> CREATOR = new FetchPageNewLikesParams.1();
  private String a;
  private long b;

  public FetchPageNewLikesParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchPageNewLikesParams
 * JD-Core Version:    0.6.0
 */