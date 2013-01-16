package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookEvent$1
  implements Parcelable.Creator<FacebookEvent>
{
  public FacebookEvent a(Parcel paramParcel)
  {
    return new FacebookEvent(paramParcel);
  }

  public FacebookEvent[] a(int paramInt)
  {
    return new FacebookEvent[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookEvent.1
 * JD-Core Version:    0.6.0
 */