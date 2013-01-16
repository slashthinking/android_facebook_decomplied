package com.facebook.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Set;

public class GetDeviceLocationParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetDeviceLocationParams> CREATOR = new GetDeviceLocationParams.1();
  public final long a;
  public final long b;
  public final float c;
  public final long d;
  public final float e;
  public final long f;
  public final float g;
  public final long h;
  public final float i;
  public final Set<String> j;
  public final boolean k;

  private GetDeviceLocationParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readFloat();
    ArrayList localArrayList = Lists.a();
    paramParcel.readStringList(localArrayList);
    this.j = ImmutableSet.a(localArrayList);
    if (paramParcel.readInt() == m);
    while (true)
    {
      this.k = m;
      return;
      m = 0;
    }
  }

  GetDeviceLocationParams(GetDeviceLocationParamsBuilder paramGetDeviceLocationParamsBuilder)
  {
    this.a = paramGetDeviceLocationParamsBuilder.a();
    this.b = paramGetDeviceLocationParamsBuilder.b();
    this.c = paramGetDeviceLocationParamsBuilder.c();
    this.d = paramGetDeviceLocationParamsBuilder.d();
    this.e = paramGetDeviceLocationParamsBuilder.e();
    this.f = paramGetDeviceLocationParamsBuilder.f();
    this.g = paramGetDeviceLocationParamsBuilder.g();
    this.h = paramGetDeviceLocationParamsBuilder.h();
    this.i = paramGetDeviceLocationParamsBuilder.i();
    this.j = paramGetDeviceLocationParamsBuilder.j();
    this.k = paramGetDeviceLocationParamsBuilder.k();
  }

  public static GetDeviceLocationParamsBuilder newBuilder()
  {
    return new GetDeviceLocationParamsBuilder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeFloat(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeFloat(this.i);
    paramParcel.writeStringList(ImmutableList.a(this.j));
    if (this.k);
    for (int m = 1; ; m = 0)
    {
      paramParcel.writeInt(m);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationParams
 * JD-Core Version:    0.6.0
 */