package com.facebook.katana.server.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class PlatformOperationHandler$GetAuthorizationStringParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetAuthorizationStringParams> CREATOR = new PlatformOperationHandler.GetAuthorizationStringParams.1();
  private final String a;
  private final List<String> b;
  private final String c;

  private PlatformOperationHandler$GetAuthorizationStringParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ImmutableList.a(paramParcel.createStringArrayList());
    this.c = paramParcel.readString();
  }

  public PlatformOperationHandler$GetAuthorizationStringParams(String paramString1, List<String> paramList, String paramString2)
  {
    Preconditions.checkNotNull(paramString1, "Application name is required.");
    Preconditions.checkNotNull(paramList, "Permission list is required.");
    this.a = paramString1;
    this.b = ImmutableList.a(paramList);
    this.c = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public List<String> b()
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
    paramParcel.writeStringList(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.handler.PlatformOperationHandler.GetAuthorizationStringParams
 * JD-Core Version:    0.6.0
 */