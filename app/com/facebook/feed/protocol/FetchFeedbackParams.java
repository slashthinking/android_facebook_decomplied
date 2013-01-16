package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;

public class FetchFeedbackParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchFeedbackParams> CREATOR = new FetchFeedbackParams.1();
  private final String a;
  private final int b;
  private final int c;
  private final DataFreshnessParam d;

  protected FetchFeedbackParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = DataFreshnessParam.valueOf(paramParcel.readString());
  }

  public FetchFeedbackParams(String paramString, int paramInt1, int paramInt2, DataFreshnessParam paramDataFreshnessParam)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramDataFreshnessParam;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public DataFreshnessParam d()
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
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchFeedbackParams
 * JD-Core Version:    0.6.0
 */