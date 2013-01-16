package com.facebook.contacts.models.entry;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultEntry
  implements Entry
{
  public static final Parcelable.Creator<DefaultEntry> CREATOR = new DefaultEntry.1();
  private final String a;
  private final String b;

  protected DefaultEntry(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  @JsonCreator
  public DefaultEntry(@JsonProperty("label") String paramString1, @JsonProperty("value") String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public Entry.Type a()
  {
    return Entry.Type.DEFAULT;
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
      DefaultEntry localDefaultEntry = (DefaultEntry)paramObject;
      if (!this.a.equals(localDefaultEntry.getLabel()))
      {
        i = 0;
        continue;
      }
      if (this.b.equals(localDefaultEntry.getValue()))
        continue;
      i = 0;
    }
  }

  @JsonProperty("label")
  public String getLabel()
  {
    return this.a;
  }

  @JsonProperty("value")
  public String getValue()
  {
    return this.b;
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.entry.DefaultEntry
 * JD-Core Version:    0.6.0
 */