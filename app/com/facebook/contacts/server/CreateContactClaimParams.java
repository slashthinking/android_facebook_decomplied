package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CreateContactClaimParams
  implements Parcelable
{
  public static final Parcelable.Creator<CreateContactClaimParams> CREATOR = new CreateContactClaimParams.1();
  private final String a;
  private final String b;
  private final String c;
  private final PrivacyParam d;

  private CreateContactClaimParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((PrivacyParam)paramParcel.readParcelable(PrivacyParam.class.getClassLoader()));
  }

  public CreateContactClaimParams(String paramString1, String paramString2, String paramString3, PrivacyParam paramPrivacyParam)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramPrivacyParam;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public PrivacyParam d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.CreateContactClaimParams
 * JD-Core Version:    0.6.0
 */