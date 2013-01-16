package com.facebook.orca.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareMediaPhoto
  implements Parcelable
{
  public static final Parcelable.Creator<ShareMediaPhoto> CREATOR = new ShareMediaPhoto.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private final int f;

  private ShareMediaPhoto(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }

  ShareMediaPhoto(ShareMediaPhotoBuilder paramShareMediaPhotoBuilder)
  {
    this.a = paramShareMediaPhotoBuilder.a();
    this.b = paramShareMediaPhotoBuilder.b();
    this.c = paramShareMediaPhotoBuilder.c();
    this.d = paramShareMediaPhotoBuilder.d();
    this.e = paramShareMediaPhotoBuilder.e();
    this.f = paramShareMediaPhotoBuilder.f();
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

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.e;
  }

  public int f()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareMediaPhoto
 * JD-Core Version:    0.6.0
 */