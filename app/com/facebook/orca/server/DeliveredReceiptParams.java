package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.UserKey;

public class DeliveredReceiptParams
  implements Parcelable
{
  public static final Parcelable.Creator<DeliveredReceiptParams> CREATOR = new DeliveredReceiptParams.1();
  private final String a;
  private final UserKey b;
  private final String c;

  private DeliveredReceiptParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = UserKey.a(paramParcel.readString());
    this.c = paramParcel.readString();
  }

  public DeliveredReceiptParams(String paramString1, UserKey paramUserKey, String paramString2)
  {
    this.a = paramString1;
    this.b = paramUserKey;
    this.c = paramString2;
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.a;
  }

  public UserKey c()
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
    paramParcel.writeString(this.b.c());
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.DeliveredReceiptParams
 * JD-Core Version:    0.6.0
 */