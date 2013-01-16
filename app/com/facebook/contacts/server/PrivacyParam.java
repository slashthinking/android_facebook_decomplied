package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PrivacyParam
  implements Parcelable
{
  public static final Parcelable.Creator<PrivacyParam> CREATOR;
  public static final PrivacyParam a = new PrivacyParam("MUTUAL_FRIENDS");
  public static final PrivacyParam b = new PrivacyParam("SELF");
  private final String c;

  static
  {
    CREATOR = new PrivacyParam.1();
  }

  private PrivacyParam(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
  }

  public PrivacyParam(String paramString)
  {
    this.c = paramString;
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'value':'");
    localStringBuilder.append(this.c);
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.PrivacyParam
 * JD-Core Version:    0.6.0
 */