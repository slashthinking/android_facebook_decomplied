package com.facebook.orca.users;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class MobileAppData
  implements Parcelable
{
  public static final Parcelable.Creator<MobileAppData> CREATOR = new MobileAppData.1();
  private final ImmutableMap<Long, Boolean> a;
  private final ImmutableMap<Long, Boolean> b;
  private final ImmutableMap<Long, Long> c;

  public MobileAppData(Parcel paramParcel)
  {
    this.a = ImmutableMap.a((Map)paramParcel.readSerializable());
    this.b = ImmutableMap.a((Map)paramParcel.readSerializable());
    this.c = ImmutableMap.a((Map)paramParcel.readSerializable());
  }

  public MobileAppData(ImmutableMap<Long, Boolean> paramImmutableMap1, ImmutableMap<Long, Boolean> paramImmutableMap2, ImmutableMap<Long, Long> paramImmutableMap)
  {
    this.a = paramImmutableMap1;
    this.b = paramImmutableMap2;
    this.c = paramImmutableMap;
  }

  ImmutableMap<Long, Boolean> a()
  {
    return this.a;
  }

  public Boolean a(Long paramLong)
  {
    if (!this.b.containsKey(paramLong));
    for (Boolean localBoolean = Boolean.valueOf(false); ; localBoolean = (Boolean)this.b.get(paramLong))
      return localBoolean;
  }

  ImmutableMap<Long, Boolean> b()
  {
    return this.b;
  }

  ImmutableMap<Long, Long> c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      MobileAppData localMobileAppData = (MobileAppData)paramObject;
      if (!this.a.equals(localMobileAppData.a))
      {
        i = 0;
        continue;
      }
      if (!this.b.equals(localMobileAppData.b))
      {
        i = 0;
        continue;
      }
      if (this.c.equals(localMobileAppData.c))
        continue;
      i = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.a);
    paramParcel.writeSerializable(this.b);
    paramParcel.writeSerializable(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.MobileAppData
 * JD-Core Version:    0.6.0
 */