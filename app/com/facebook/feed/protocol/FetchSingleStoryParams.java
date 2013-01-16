package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;

public class FetchSingleStoryParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchSingleStoryParams> CREATOR = new FetchSingleStoryParams.1();
  public final String a;
  public final DataFreshnessParam b;
  public final boolean c;
  public final int d;
  public final int e;

  public FetchSingleStoryParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = DataFreshnessParam.valueOf(paramParcel.readString());
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      return;
    }
  }

  public FetchSingleStoryParams(String paramString, DataFreshnessParam paramDataFreshnessParam, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramDataFreshnessParam;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b.toString());
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchSingleStoryParams
 * JD-Core Version:    0.6.0
 */