package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.UserKey;

public class ReadReceiptParams
  implements Parcelable
{
  public static final Parcelable.Creator<ReadReceiptParams> CREATOR = new ReadReceiptParams.1();
  private final String a;
  private final UserKey b;
  private final long c;

  private ReadReceiptParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = UserKey.a(paramParcel.readString());
    this.c = paramParcel.readLong();
  }

  public ReadReceiptParams(String paramString, UserKey paramUserKey, long paramLong)
  {
    this.a = paramString;
    this.b = paramUserKey;
    this.c = paramLong;
  }

  public long a()
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
    paramParcel.writeLong(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ReadReceiptParams
 * JD-Core Version:    0.6.0
 */