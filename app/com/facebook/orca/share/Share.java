package com.facebook.orca.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

public class Share
  implements Parcelable
{
  public static final Parcelable.Creator<Share> CREATOR = new Share.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final ImmutableList<ShareMedia> e;
  private final ImmutableList<ShareProperty> f;

  private Share(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.e = ImmutableList.a(paramParcel.readArrayList(ShareMedia.class.getClassLoader()));
    this.d = paramParcel.readString();
    this.f = ImmutableList.a(paramParcel.readArrayList(ShareProperty.class.getClassLoader()));
  }

  Share(ShareBuilder paramShareBuilder)
  {
    this.a = paramShareBuilder.a();
    this.b = paramShareBuilder.b();
    this.c = paramShareBuilder.c();
    this.e = ImmutableList.a(paramShareBuilder.d());
    this.d = paramShareBuilder.e();
    this.f = ImmutableList.a(paramShareBuilder.f());
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

  public ImmutableList<ShareMedia> d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.d;
  }

  public ImmutableList<ShareProperty> f()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeList(this.e);
    paramParcel.writeString(this.d);
    paramParcel.writeList(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.Share
 * JD-Core Version:    0.6.0
 */