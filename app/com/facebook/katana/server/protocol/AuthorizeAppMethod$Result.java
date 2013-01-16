package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

public class AuthorizeAppMethod$Result
  implements Parcelable
{
  public static Parcelable.Creator<Result> CREATOR = new AuthorizeAppMethod.Result.1();
  private final String a;
  private final long b;
  private final List<String> c;

  private AuthorizeAppMethod$Result(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = Lists.a();
    paramParcel.readStringList(this.c);
  }

  private AuthorizeAppMethod$Result(String paramString, long paramLong, List<String> paramList)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramList;
  }

  public String a()
  {
    return this.a;
  }

  public List<String> b()
  {
    return this.c;
  }

  public long c()
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
    paramParcel.writeLong(this.b);
    paramParcel.writeStringList(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.AuthorizeAppMethod.Result
 * JD-Core Version:    0.6.0
 */