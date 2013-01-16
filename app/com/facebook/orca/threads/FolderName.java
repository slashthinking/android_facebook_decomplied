package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

public class FolderName
  implements Parcelable
{
  public static final Parcelable.Creator<FolderName> CREATOR;
  public static final FolderName a = new FolderName(FolderType.a);
  public static final FolderName b = new FolderName(FolderType.b);
  public static final FolderName c = new FolderName(FolderType.c);
  public static final FolderName d = new FolderName(FolderType.d);
  public static final FolderName e = new FolderName(FolderType.e);
  public static final FolderName f = new FolderName(FolderType.f);
  private static final ImmutableSet<FolderName> g = ImmutableSet.a(b, c, d, e, f);
  private final FolderType h;
  private final String i;
  private final String j;

  static
  {
    CREATOR = new FolderName.1();
  }

  private FolderName(Parcel paramParcel)
  {
    this.h = ((FolderType)paramParcel.readParcelable(FolderType.class.getClassLoader()));
    this.i = paramParcel.readString();
    this.j = b(this.h, this.i);
    c();
  }

  private FolderName(FolderType paramFolderType)
  {
    this(paramFolderType, null);
  }

  private FolderName(FolderType paramFolderType, String paramString)
  {
    this.h = paramFolderType;
    this.i = paramString;
    this.j = b(paramFolderType, paramString);
    c();
  }

  public static FolderName a(FolderType paramFolderType)
  {
    return b(new FolderName(paramFolderType));
  }

  public static FolderName a(FolderType paramFolderType, String paramString)
  {
    return b(new FolderName(paramFolderType, paramString));
  }

  public static FolderName a(String paramString)
  {
    String[] arrayOfString = paramString.split(":::::");
    if (arrayOfString.length == 1);
    for (FolderName localFolderName = a(FolderType.a(arrayOfString[0])); ; localFolderName = a(FolderType.a(arrayOfString[0]), arrayOfString[1]))
    {
      return localFolderName;
      if (arrayOfString.length != 2)
        break;
    }
    throw new IllegalArgumentException("Invalid name " + paramString);
  }

  private static FolderName b(FolderName paramFolderName)
  {
    Iterator localIterator = g.iterator();
    FolderName localFolderName;
    do
    {
      if (!localIterator.hasNext())
        break;
      localFolderName = (FolderName)localIterator.next();
    }
    while (!Objects.equal(localFolderName, paramFolderName));
    while (true)
    {
      return localFolderName;
      localFolderName = paramFolderName;
    }
  }

  private static String b(FolderType paramFolderType, String paramString)
  {
    if (paramString != null);
    for (String str = paramFolderType.a() + ":::::" + paramString; ; str = paramFolderType.a())
      return str;
  }

  private void c()
  {
    if ((this.i != null) && (this.h != FolderType.b) && (this.h != FolderType.c))
      throw new IllegalArgumentException("Unexpected folder name for a pages profile: " + this.j);
  }

  public FolderType a()
  {
    return this.h;
  }

  public String b()
  {
    return this.j;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int k = 1;
    if (this == paramObject);
    FolderName localFolderName;
    do
    {
      while (true)
      {
        return k;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        k = 0;
      }
      localFolderName = (FolderName)paramObject;
      if (this.j == null)
        break;
    }
    while (this.j.equals(localFolderName.j));
    while (true)
    {
      k = 0;
      break;
      if (localFolderName.j == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.j != null);
    for (int k = this.j.hashCode(); ; k = 0)
      return k;
  }

  public String toString()
  {
    return this.j;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.h, paramInt);
    paramParcel.writeString(this.i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.FolderName
 * JD-Core Version:    0.6.0
 */