package com.facebook.zero.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ValidateZeroTokenMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new ValidateZeroTokenMethod.Params.1();
  private final String a;

  public ValidateZeroTokenMethod$Params(String paramString)
  {
    this.a = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.protocol.methods.ValidateZeroTokenMethod.Params
 * JD-Core Version:    0.6.2
 */