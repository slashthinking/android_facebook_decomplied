package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetFriendsParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetFriendsParams> CREATOR = new GetFriendsParams.1();
  private final int a;
  private final String b;
  private final Long c;

  private GetFriendsParams(int paramInt, String paramString, Long paramLong)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramLong;
  }

  private GetFriendsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = Long.valueOf(paramParcel.readLong());
  }

  public static GetFriendsParams a(int paramInt, String paramString)
  {
    return new GetFriendsParams(paramInt, paramString, null);
  }

  public static GetFriendsParams a(long paramLong)
  {
    return new GetFriendsParams(-1, null, Long.valueOf(paramLong));
  }

  public int a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public boolean c()
  {
    if (this.c != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public long d()
  {
    return this.c.longValue();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c.longValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.GetFriendsParams
 * JD-Core Version:    0.6.0
 */