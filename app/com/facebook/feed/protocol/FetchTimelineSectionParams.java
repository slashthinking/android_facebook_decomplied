package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchTimelineSectionParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchTimelineSectionParams> CREATOR = new FetchTimelineSectionParams.1();
  private final String a;
  private final String b;
  private final boolean c;
  private final String d;

  private FetchTimelineSectionParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.b = paramParcel.readString();
      this.d = paramParcel.readString();
      return;
    }
  }

  public FetchTimelineSectionParams(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.c = paramBoolean;
    this.b = paramString2;
    this.d = paramString3;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.d);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineSectionParams
 * JD-Core Version:    0.6.0
 */