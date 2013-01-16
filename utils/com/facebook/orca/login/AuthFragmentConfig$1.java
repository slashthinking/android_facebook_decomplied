package com.facebook.orca.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AuthFragmentConfig$1
  implements Parcelable.Creator<AuthFragmentConfig>
{
  public AuthFragmentConfig a(Parcel paramParcel)
  {
    try
    {
      localAuthFragmentConfig = new AuthFragmentConfig(paramParcel, null);
      return localAuthFragmentConfig;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        AuthFragmentConfig localAuthFragmentConfig = null;
    }
  }

  public AuthFragmentConfig[] a(int paramInt)
  {
    return new AuthFragmentConfig[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthFragmentConfig.1
 * JD-Core Version:    0.6.2
 */