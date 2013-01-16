package com.facebook.orca.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareProperty
  implements Parcelable
{
  public static final Parcelable.Creator<ShareProperty> CREATOR = new ShareProperty.1();
  private final String a;
  private final String b;
  private final String c;

  private ShareProperty(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }

  ShareProperty(SharePropertyBuilder paramSharePropertyBuilder)
  {
    this.a = paramSharePropertyBuilder.a();
    this.b = paramSharePropertyBuilder.b();
    this.c = paramSharePropertyBuilder.c();
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

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareProperty
 * JD-Core Version:    0.6.0
 */