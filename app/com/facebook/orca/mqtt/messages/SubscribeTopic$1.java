package com.facebook.orca.mqtt.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SubscribeTopic$1
  implements Parcelable.Creator<SubscribeTopic>
{
  public SubscribeTopic a(Parcel paramParcel)
  {
    return new SubscribeTopic(paramParcel.readString(), paramParcel.readInt());
  }

  public SubscribeTopic[] a(int paramInt)
  {
    return new SubscribeTopic[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubscribeTopic.1
 * JD-Core Version:    0.6.0
 */