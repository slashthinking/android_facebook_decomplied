package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchAllContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAllContactsParams> CREATOR = new FetchAllContactsParams.1();
  private final int a;
  private final String b;
  private final long c;
  private final boolean d;

  private FetchAllContactsParams(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramLong;
    this.d = paramBoolean;
  }

  private FetchAllContactsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  public static FetchAllContactsParams a(int paramInt, String paramString)
  {
    return new FetchAllContactsParams(paramInt, paramString, -1L, false);
  }

  public static FetchAllContactsParams b(int paramInt, String paramString)
  {
    return new FetchAllContactsParams(paramInt, paramString, -1L, true);
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
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    if (this.d);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchAllContactsParams
 * JD-Core Version:    0.6.0
 */