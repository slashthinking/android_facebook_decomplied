package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchTimelineSectionListParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchTimelineSectionListParams> CREATOR = new FetchTimelineSectionListParams.1();
  private final String a;
  private final String b;

  protected FetchTimelineSectionListParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public FetchTimelineSectionListParams(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
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
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineSectionListParams
 * JD-Core Version:    0.6.0
 */