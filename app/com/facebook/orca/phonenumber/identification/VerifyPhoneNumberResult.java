package com.facebook.orca.phonenumber.identification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VerifyPhoneNumberResult
  implements Parcelable
{
  public static final Parcelable.Creator<VerifyPhoneNumberResult> CREATOR = new VerifyPhoneNumberResult.1();
  private String a;

  public VerifyPhoneNumberResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public VerifyPhoneNumberResult(String paramString)
  {
    a(paramString);
  }

  private void a(String paramString)
  {
    this.a = paramString;
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
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.VerifyPhoneNumberResult
 * JD-Core Version:    0.6.0
 */