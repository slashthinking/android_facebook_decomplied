package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FolderCounts$1
  implements Parcelable.Creator<FolderCounts>
{
  public FolderCounts a(Parcel paramParcel)
  {
    return new FolderCounts(paramParcel, null);
  }

  public FolderCounts[] a(int paramInt)
  {
    return new FolderCounts[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderCounts.1
 * JD-Core Version:    0.6.0
 */