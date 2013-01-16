package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NearbyTopic$1
  implements Parcelable.Creator<NearbyTopic>
{
  public NearbyTopic a(Parcel paramParcel)
  {
    return new NearbyTopic(paramParcel, null);
  }

  public NearbyTopic[] a(int paramInt)
  {
    return new NearbyTopic[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.model.NearbyTopic.1
 * JD-Core Version:    0.6.0
 */