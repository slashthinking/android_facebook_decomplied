package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PasswordCredentials$1
  implements Parcelable.Creator<PasswordCredentials>
{
  public PasswordCredentials a(Parcel paramParcel)
  {
    return new PasswordCredentials(paramParcel, null);
  }

  public PasswordCredentials[] a(int paramInt)
  {
    return new PasswordCredentials[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.PasswordCredentials.1
 * JD-Core Version:    0.6.2
 */