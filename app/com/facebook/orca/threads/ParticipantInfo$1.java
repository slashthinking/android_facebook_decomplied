package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParticipantInfo$1
  implements Parcelable.Creator<ParticipantInfo>
{
  public ParticipantInfo a(Parcel paramParcel)
  {
    return new ParticipantInfo(paramParcel, null);
  }

  public ParticipantInfo[] a(int paramInt)
  {
    return new ParticipantInfo[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ParticipantInfo.1
 * JD-Core Version:    0.6.0
 */