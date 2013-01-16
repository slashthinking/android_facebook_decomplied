package com.facebook.orca.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;

public class AuthStateMachineConfig$ParcelableConfigInformation
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableConfigInformation> CREATOR = new AuthStateMachineConfig.ParcelableConfigInformation.1();
  public ImmutableMap<String, AuthFragmentConfig> a;

  private AuthStateMachineConfig$ParcelableConfigInformation(Parcel paramParcel)
  {
    this.a = ImmutableMap.a(paramParcel.readHashMap(AuthFragmentConfig.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthStateMachineConfig.ParcelableConfigInformation
 * JD-Core Version:    0.6.2
 */