package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Message$1
  implements Parcelable.Creator<Message>
{
  public Message a(Parcel paramParcel)
  {
    return new Message(paramParcel, null);
  }

  public Message[] a(int paramInt)
  {
    return new Message[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.Message.1
 * JD-Core Version:    0.6.0
 */