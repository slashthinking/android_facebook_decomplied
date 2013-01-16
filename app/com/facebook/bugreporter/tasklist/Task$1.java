package com.facebook.bugreporter.tasklist;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Task$1
  implements Parcelable.Creator<Task>
{
  public Task a(Parcel paramParcel)
  {
    return new Task(paramParcel, null);
  }

  public Task[] a(int paramInt)
  {
    return new Task[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.Task.1
 * JD-Core Version:    0.6.0
 */