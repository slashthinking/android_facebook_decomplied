package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookCredentials$1
  implements Parcelable.Creator<FacebookCredentials>
{
  public FacebookCredentials a(Parcel paramParcel)
  {
    return new FacebookCredentials(paramParcel, null);
  }

  public FacebookCredentials[] a(int paramInt)
  {
    return new FacebookCredentials[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.FacebookCredentials.1
 * JD-Core Version:    0.6.2
 */