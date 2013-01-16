package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;

public class FetchNodeListParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNodeListParams> CREATOR = new FetchNodeListParams.1();
  private final String a;
  private final int b;
  private final String c;
  private final String d;
  private final DataFreshnessParam e;

  protected FetchNodeListParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = DataFreshnessParam.valueOf(paramParcel.readString());
  }

  public FetchNodeListParams(String paramString1, int paramInt, String paramString2, String paramString3, DataFreshnessParam paramDataFreshnessParam)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramDataFreshnessParam;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public String c()
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

  public DataFreshnessParam e()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNodeListParams
 * JD-Core Version:    0.6.0
 */