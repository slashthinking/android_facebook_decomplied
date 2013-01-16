package com.facebook.katana.service.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public class MediaPublisherController$MediaPublishRetryStatus
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPublishRetryStatus> CREATOR = new MediaPublisherController.MediaPublishRetryStatus.1();
  private String a;
  private String b;
  private Set<Long> c;
  private String d;
  private int e;

  private MediaPublisherController$MediaPublishRetryStatus(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = Sets.a();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      int[] arrayOfInt = new int[i];
      paramParcel.readIntArray(arrayOfInt);
      for (int j = 0; j < arrayOfInt.length; j++)
        this.c.add(Long.valueOf(arrayOfInt[j]));
    }
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
  }

  public MediaPublisherController$MediaPublishRetryStatus(String paramString1, String paramString2, Set<Long> paramSet, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramSet;
    this.d = paramString3;
    this.e = paramInt;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.d;
  }

  public Set<Long> c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    if (this.c != null)
    {
      int i = this.c.size();
      int[] arrayOfInt = new int[i];
      Iterator localIterator = this.c.iterator();
      for (int j = 0; localIterator.hasNext(); j++)
        arrayOfInt[j] = ((Long)localIterator.next()).intValue();
      paramParcel.writeInt(i);
      paramParcel.writeIntArray(arrayOfInt);
    }
    while (true)
    {
      paramParcel.writeString(this.d);
      paramParcel.writeInt(this.e);
      return;
      paramParcel.writeInt(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController.MediaPublishRetryStatus
 * JD-Core Version:    0.6.0
 */