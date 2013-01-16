package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;

public class NotificationsChangeReadParams
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationsChangeReadParams> CREATOR = new NotificationsChangeReadParams.1();
  private final ImmutableSet<String> a;
  private final boolean b;

  public NotificationsChangeReadParams(Parcel paramParcel)
  {
    ImmutableSet.Builder localBuilder = ImmutableSet.e();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      int j = paramParcel.readInt();
      while (i < j)
      {
        localBuilder.b(paramParcel.readString());
        i++;
      }
    }
    this.a = localBuilder.b();
  }

  public ImmutableSet<String> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.a.size());
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        paramParcel.writeString((String)localIterator.next());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.NotificationsChangeReadParams
 * JD-Core Version:    0.6.2
 */