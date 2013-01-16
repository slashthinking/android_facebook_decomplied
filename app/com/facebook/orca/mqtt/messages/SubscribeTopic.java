package com.facebook.orca.mqtt.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

public class SubscribeTopic
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeTopic> CREATOR = new SubscribeTopic.1();
  private final String a;
  private final int b;

  public SubscribeTopic(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
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
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      SubscribeTopic localSubscribeTopic = (SubscribeTopic)paramObject;
      if (this.b != localSubscribeTopic.b)
      {
        i = 0;
        continue;
      }
      if (Objects.equal(this.a, localSubscribeTopic.a))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Integer.valueOf(this.b);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return this.a;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubscribeTopic
 * JD-Core Version:    0.6.0
 */