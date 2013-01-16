package com.facebook.pages.identity.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchPageRecommendationDataMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new FetchPageRecommendationDataMethod.Params.1();
  public final long a;
  public final boolean b;

  public FetchPageRecommendationDataMethod$Params(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramBoolean;
  }

  private FetchPageRecommendationDataMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod.Params
 * JD-Core Version:    0.6.2
 */