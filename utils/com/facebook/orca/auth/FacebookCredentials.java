package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FacebookCredentials
  implements Parcelable
{
  public static final Parcelable.Creator<FacebookCredentials> CREATOR = new FacebookCredentials.1();
  private final String a;
  private final long b;
  private final String c;

  private FacebookCredentials(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
  }

  public FacebookCredentials(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = null;
  }

  public FacebookCredentials(String paramString1, long paramLong, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.FacebookCredentials
 * JD-Core Version:    0.6.2
 */