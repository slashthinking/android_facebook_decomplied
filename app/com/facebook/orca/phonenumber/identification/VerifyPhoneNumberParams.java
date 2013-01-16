package com.facebook.orca.phonenumber.identification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VerifyPhoneNumberParams
  implements Parcelable
{
  public static final Parcelable.Creator<VerifyPhoneNumberParams> CREATOR = new VerifyPhoneNumberParams.1();
  private String a;
  private String b;

  public VerifyPhoneNumberParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public VerifyPhoneNumberParams(String paramString1, String paramString2)
  {
    a(paramString1);
    b(paramString2);
  }

  private void a(String paramString)
  {
    this.a = paramString;
  }

  private void b(String paramString)
  {
    this.b = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
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

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.VerifyPhoneNumberParams
 * JD-Core Version:    0.6.0
 */