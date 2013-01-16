package com.facebook.orca.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareMedia
  implements Parcelable
{
  public static final Parcelable.Creator<ShareMedia> CREATOR = new ShareMedia.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final ShareMediaPhoto e;
  private final ShareMediaVideo f;

  private ShareMedia(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((ShareMediaPhoto)paramParcel.readParcelable(ShareMediaPhoto.class.getClassLoader()));
    this.f = ((ShareMediaVideo)paramParcel.readParcelable(ShareMediaVideo.class.getClassLoader()));
  }

  ShareMedia(ShareMediaBuilder paramShareMediaBuilder)
  {
    this.a = paramShareMediaBuilder.a();
    this.b = paramShareMediaBuilder.b();
    this.c = paramShareMediaBuilder.c();
    this.d = paramShareMediaBuilder.d();
    this.e = paramShareMediaBuilder.e();
    this.f = paramShareMediaBuilder.f();
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

  public ShareMediaPhoto e()
  {
    return this.e;
  }

  public ShareMediaVideo f()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareMedia
 * JD-Core Version:    0.6.0
 */