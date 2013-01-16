package com.facebook.orca.protocol.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ApiErrorResult
  implements Parcelable
{
  public static final Parcelable.Creator<ApiErrorResult> CREATOR = new ApiErrorResult.1();
  private final int a;
  private final String b;
  private final String c;
  private final ApiErrorResult.ErrorDomain d;

  public ApiErrorResult(int paramInt, String paramString1, String paramString2, ApiErrorResult.ErrorDomain paramErrorDomain)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramErrorDomain;
  }

  private ApiErrorResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((ApiErrorResult.ErrorDomain)Enum.valueOf(ApiErrorResult.ErrorDomain.class, paramParcel.readString()));
  }

  public int a()
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

  public ApiErrorResult.ErrorDomain d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d.toString());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiErrorResult
 * JD-Core Version:    0.6.2
 */