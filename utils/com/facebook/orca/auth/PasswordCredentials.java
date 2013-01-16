package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PasswordCredentials
  implements Parcelable
{
  public static final Parcelable.Creator<PasswordCredentials> CREATOR = new PasswordCredentials.1();
  private final String a;
  private final String b;

  private PasswordCredentials(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public PasswordCredentials(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
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
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.PasswordCredentials
 * JD-Core Version:    0.6.2
 */