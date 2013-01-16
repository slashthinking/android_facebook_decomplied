package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetPhoneContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetPhoneContactsParams> CREATOR;
  public static int a = 0;
  public static int b = 1;
  private final int c;
  private final int d;
  private final String e;
  private final String f;

  static
  {
    CREATOR = new GetPhoneContactsParams.1();
  }

  private GetPhoneContactsParams(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }

  public static GetPhoneContactsParamsBuilder newBuilder()
  {
    return new GetPhoneContactsParamsBuilder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.GetPhoneContactsParams
 * JD-Core Version:    0.6.0
 */