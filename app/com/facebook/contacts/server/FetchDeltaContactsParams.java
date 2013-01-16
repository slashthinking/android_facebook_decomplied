package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchDeltaContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchDeltaContactsParams> CREATOR = new FetchDeltaContactsParams.1();
  private final int a;
  private final String b;

  public FetchDeltaContactsParams(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  private FetchDeltaContactsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
  }

  public int a()
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
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchDeltaContactsParams
 * JD-Core Version:    0.6.0
 */