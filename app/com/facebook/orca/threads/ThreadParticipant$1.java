package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreadParticipant$1
  implements Parcelable.Creator<ThreadParticipant>
{
  public ThreadParticipant a(Parcel paramParcel)
  {
    return new ThreadParticipant(paramParcel, null);
  }

  public ThreadParticipant[] a(int paramInt)
  {
    return new ThreadParticipant[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadParticipant.1
 * JD-Core Version:    0.6.0
 */