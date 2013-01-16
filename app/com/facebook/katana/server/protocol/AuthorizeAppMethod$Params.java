package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Optional;
import java.io.Serializable;

public class AuthorizeAppMethod$Params
  implements Parcelable
{
  public static Parcelable.Creator<Params> CREATOR = new AuthorizeAppMethod.Params.1();
  private final String a;
  private final String b;
  private final Optional<String> c;
  private final Optional<String> d;
  private final Optional<Boolean> e;

  private AuthorizeAppMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = Optional.fromNullable(paramParcel.readString());
    this.d = Optional.fromNullable(paramParcel.readString());
    this.e = Optional.fromNullable((Boolean)paramParcel.readSerializable());
  }

  private AuthorizeAppMethod$Params(String paramString1, String paramString2, Optional<String> paramOptional1, Optional<String> paramOptional2, Optional<Boolean> paramOptional)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramOptional1;
    this.d = paramOptional2;
    this.e = paramOptional;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public Optional<String> c()
  {
    return this.c;
  }

  public Optional<String> d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public Optional<Boolean> e()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString((String)this.c.get());
    paramParcel.writeString((String)this.d.get());
    paramParcel.writeSerializable((Serializable)this.e.get());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.AuthorizeAppMethod.Params
 * JD-Core Version:    0.6.0
 */