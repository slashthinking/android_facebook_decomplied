package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;

public class ThreadCriteria
  implements Parcelable
{
  public static final Parcelable.Creator<ThreadCriteria> CREATOR = new ThreadCriteria.1();
  private final String a;
  private final UserKey b;

  private ThreadCriteria(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = UserKey.a(paramParcel.readString());
  }

  private ThreadCriteria(String paramString, UserKey paramUserKey)
  {
    int j;
    if (paramString == null)
    {
      j = i;
      if (paramUserKey != null)
        break label41;
    }
    while (true)
    {
      Preconditions.checkArgument(i ^ j);
      this.a = paramString;
      this.b = paramUserKey;
      return;
      j = 0;
      break;
      label41: i = 0;
    }
  }

  public static ThreadCriteria a(UserKey paramUserKey)
  {
    return new ThreadCriteria(null, paramUserKey);
  }

  public static ThreadCriteria a(String paramString)
  {
    return new ThreadCriteria(paramString, null);
  }

  public String a()
  {
    return this.a;
  }

  public UserKey b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    ThreadCriteria localThreadCriteria;
    do
    {
      while (true)
      {
        return i;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        i = 0;
      }
      localThreadCriteria = (ThreadCriteria)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localThreadCriteria.a));
      }
      else
        do
        {
          i = 0;
          break;
        }
        while (localThreadCriteria.a != null);
      if (this.b == null)
        break;
    }
    while (this.b.equals(localThreadCriteria.b));
    while (true)
    {
      i = 0;
      break;
      if (localThreadCriteria.b == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      UserKey localUserKey = this.b;
      int k = 0;
      if (localUserKey != null)
        k = this.b.hashCode();
      return j + k;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.b != null);
    for (String str = this.b.c(); ; str = null)
    {
      paramParcel.writeString(str);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ThreadCriteria
 * JD-Core Version:    0.6.0
 */