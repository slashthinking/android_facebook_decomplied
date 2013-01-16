package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreadsCollection$1
  implements Parcelable.Creator<ThreadsCollection>
{
  public ThreadsCollection a(Parcel paramParcel)
  {
    return new ThreadsCollection(paramParcel, null);
  }

  public ThreadsCollection[] a(int paramInt)
  {
    return new ThreadsCollection[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadsCollection.1
 * JD-Core Version:    0.6.0
 */