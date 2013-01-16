package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FolderType$1
  implements Parcelable.Creator<FolderType>
{
  public FolderType a(Parcel paramParcel)
  {
    return FolderType.a(new FolderType(paramParcel, null));
  }

  public FolderType[] a(int paramInt)
  {
    return new FolderType[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderType.1
 * JD-Core Version:    0.6.0
 */