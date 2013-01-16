package com.facebook.orca.users;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Name
  implements Parcelable
{
  public static final Parcelable.Creator<Name> CREATOR = new Name.1();
  private final String a;
  private final String b;
  private final String c;

  @JsonIgnore
  private String d;

  private Name(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }

  public Name(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }

  @JsonCreator
  public Name(@JsonProperty("firstName") String paramString1, @JsonProperty("lastName") String paramString2, @JsonProperty("displayName") String paramString3)
  {
    this.a = StringUtil.c(paramString1);
    this.b = StringUtil.c(paramString2);
    this.c = StringUtil.c(paramString3);
  }

  public boolean a()
  {
    if (this.a != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean b()
  {
    if (this.b != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c()
  {
    if ((this.a != null) && (this.b != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  @JsonIgnore
  public String d()
  {
    if (this.d == null)
    {
      if ((this.a == null) || (this.a.length() <= 0) || (this.b == null) || (this.b.length() <= 0))
        break label79;
      this.d = (this.a + " " + this.b);
    }
    while (true)
    {
      return this.d;
      label79: if ((this.a != null) && (this.a.length() > 0))
      {
        this.d = this.a;
        continue;
      }
      if ((this.b != null) && (this.b.length() > 0))
      {
        this.d = this.b;
        continue;
      }
      this.d = "";
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    if (this.c != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    Name localName;
    do
    {
      while (true)
      {
        return i;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        i = 0;
      }
      localName = (Name)paramObject;
      if (this.c != null)
      {
        if (this.c.equals(localName.c));
      }
      else
        do
        {
          i = 0;
          break;
        }
        while (localName.c != null);
      if (this.a != null)
      {
        if (this.a.equals(localName.a));
      }
      else
        do
        {
          i = 0;
          break;
        }
        while (localName.a != null);
      if (this.d != null)
      {
        if (this.d.equals(localName.d));
      }
      else
        do
        {
          i = 0;
          break;
        }
        while (localName.d != null);
      if (this.b == null)
        break;
    }
    while (this.b.equals(localName.b));
    while (true)
    {
      i = 0;
      break;
      if (localName.b == null)
        break;
    }
  }

  @JsonIgnore
  public String f()
  {
    if (this.c != null);
    for (String str = this.c; ; str = d())
      return str;
  }

  @JsonProperty("displayName")
  public String getDisplayName()
  {
    return this.c;
  }

  @JsonProperty("firstName")
  public String getFirstName()
  {
    return this.a;
  }

  @JsonProperty("lastName")
  public String getLastName()
  {
    return this.b;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label103;
      k = this.b.hashCode();
      m = 31 * (k + j);
      if (this.c == null)
        break label108;
    }
    label103: label108: for (int n = this.c.hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      String str = this.d;
      int i2 = 0;
      if (str != null)
        i2 = this.d.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public String toString()
  {
    return d();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.Name
 * JD-Core Version:    0.6.0
 */