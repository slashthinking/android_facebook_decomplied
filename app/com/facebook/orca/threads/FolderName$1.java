package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FolderName$1
  implements Parcelable.Creator<FolderName>
{
  public FolderName a(Parcel paramParcel)
  {
    return FolderName.a(new FolderName(paramParcel, null));
  }

  public FolderName[] a(int paramInt)
  {
    return new FolderName[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderName.1
 * JD-Core Version:    0.6.0
 */