package com.facebook.orca.ops;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ServiceException$1
  implements Parcelable.Creator<ServiceException>
{
  public ServiceException a(Parcel paramParcel)
  {
    return new ServiceException(paramParcel, null);
  }

  public ServiceException[] a(int paramInt)
  {
    return new ServiceException[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.ServiceException.1
 * JD-Core Version:    0.6.0
 */