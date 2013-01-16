package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MessagesCollection$1
  implements Parcelable.Creator<MessagesCollection>
{
  public MessagesCollection a(Parcel paramParcel)
  {
    return new MessagesCollection(paramParcel, null);
  }

  public MessagesCollection[] a(int paramInt)
  {
    return new MessagesCollection[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagesCollection.1
 * JD-Core Version:    0.6.0
 */