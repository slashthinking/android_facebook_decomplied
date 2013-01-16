package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GraphUserPostParams
  implements Parcelable
{
  public static final Parcelable.Creator<GraphUserPostParams> CREATOR = new GraphUserPostParams.1();
  private final int a;
  private final String b;
  private final String c;

  private GraphUserPostParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.GraphUserPostParams
 * JD-Core Version:    0.6.0
 */