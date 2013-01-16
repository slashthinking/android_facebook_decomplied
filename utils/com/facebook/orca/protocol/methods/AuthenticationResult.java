package com.facebook.orca.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.auth.FacebookCredentials;

public class AuthenticationResult
  implements Parcelable
{
  public static final Parcelable.Creator<AuthenticationResult> CREATOR = new AuthenticationResult.1();
  private final FacebookCredentials a;
  private final String b;

  private AuthenticationResult(Parcel paramParcel)
  {
    this.a = ((FacebookCredentials)paramParcel.readParcelable(null));
    this.b = paramParcel.readString();
  }

  public AuthenticationResult(FacebookCredentials paramFacebookCredentials, String paramString)
  {
    this.a = paramFacebookCredentials;
    this.b = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.AuthenticationResult
 * JD-Core Version:    0.6.2
 */