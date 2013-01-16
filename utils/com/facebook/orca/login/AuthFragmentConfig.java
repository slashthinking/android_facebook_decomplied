package com.facebook.orca.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AuthFragmentConfig<T extends AuthFragmentBase>
  implements Parcelable
{
  public static final Parcelable.Creator<AuthFragmentConfig> CREATOR = new AuthFragmentConfig.1();
  final Class<? extends AuthFragmentViewGroup<T>> a;
  final Bundle b;

  private AuthFragmentConfig(Parcel paramParcel)
  {
    this.a = Class.forName(paramParcel.readString());
    this.b = ((Bundle)paramParcel.readParcelable(null));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.getCanonicalName());
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthFragmentConfig
 * JD-Core Version:    0.6.2
 */