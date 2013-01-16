package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

public class FolderType
  implements Parcelable
{
  public static final Parcelable.Creator<FolderType> CREATOR;
  public static final FolderType a;
  public static final FolderType b;
  public static final FolderType c;
  public static final FolderType d;
  public static final FolderType e;
  public static final FolderType f;
  private static final Class<?> g = FolderType.class;
  private static final ImmutableSet<FolderType> h;
  private final String i;

  static
  {
    a = new FolderType("none");
    b = new FolderType("inbox");
    c = new FolderType("other");
    d = new FolderType("mms-sms");
    e = new FolderType("inbox_mms-sms");
    f = new FolderType("archived-mms-sms");
    h = ImmutableSet.a(b, c, d, e, f);
    CREATOR = new FolderType.1();
  }

  private FolderType(Parcel paramParcel)
  {
    this.i = paramParcel.readString();
    if (!this.i.contains(":::::"));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  private FolderType(String paramString)
  {
    if (!paramString.contains(":::::"));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.i = paramString;
      return;
    }
  }

  public static FolderType a(String paramString)
  {
    return b(new FolderType(paramString));
  }

  private static FolderType b(FolderType paramFolderType)
  {
    Iterator localIterator = h.iterator();
    FolderType localFolderType;
    do
    {
      if (!localIterator.hasNext())
        break;
      localFolderType = (FolderType)localIterator.next();
    }
    while (!Objects.equal(localFolderType, paramFolderType));
    while (true)
    {
      return localFolderType;
      BLog.d(g, "Unexpected folder type %s", new Object[] { paramFolderType });
      localFolderType = paramFolderType;
    }
  }

  public String a()
  {
    return this.i;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int j = 1;
    if (this == paramObject);
    FolderType localFolderType;
    do
    {
      while (true)
      {
        return j;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        j = 0;
      }
      localFolderType = (FolderType)paramObject;
      if (this.i == null)
        break;
    }
    while (this.i.equals(localFolderType.i));
    while (true)
    {
      j = 0;
      break;
      if (localFolderType.i == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.i != null);
    for (int j = this.i.hashCode(); ; j = 0)
      return j;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderType
 * JD-Core Version:    0.6.0
 */