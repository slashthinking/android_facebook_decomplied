package com.facebook.contacts.models.entry;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class PhoneEntry
  implements Entry
{
  public static final Parcelable.Creator<PhoneEntry> CREATOR = new PhoneEntry.1();
  private final String a;
  private final boolean b;
  private final String c;
  private final long d;
  private final String e;
  private final int f;

  protected PhoneEntry(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.b = i;
      this.c = paramParcel.readString();
      this.d = paramParcel.readLong();
      this.e = paramParcel.readString();
      this.f = paramParcel.readInt();
      return;
      i = 0;
    }
  }

  @JsonCreator
  public PhoneEntry(@JsonProperty("graphApiWriteId") String paramString1, @JsonProperty("isVerified") boolean paramBoolean, @JsonProperty("source") String paramString2, @JsonProperty("creationTime") long paramLong, @JsonProperty("number") String paramString3, @JsonProperty("type") int paramInt)
  {
    this.a = paramString1;
    this.b = paramBoolean;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramString3;
    this.f = paramInt;
  }

  public Entry.Type a()
  {
    return Entry.Type.PHONE_NUMBER;
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
      PhoneEntry localPhoneEntry = (PhoneEntry)paramObject;
      if ((Objects.equal(this.a, localPhoneEntry.getGraphApiWriteId())) && (Objects.equal(Boolean.valueOf(this.b), Boolean.valueOf(localPhoneEntry.getIsVerified()))) && (Objects.equal(this.c, localPhoneEntry.getSource())) && (Objects.equal(Long.valueOf(this.d), Long.valueOf(localPhoneEntry.getCreationTime()))) && (Objects.equal(this.e, localPhoneEntry.getNumber())) && (Objects.equal(Integer.valueOf(this.f), Integer.valueOf(localPhoneEntry.getType()))))
        continue;
      i = 0;
    }
  }

  @JsonProperty("creationTime")
  public long getCreationTime()
  {
    return this.d;
  }

  @JsonProperty("graphApiWriteId")
  public String getGraphApiWriteId()
  {
    return this.a;
  }

  @JsonProperty("isVerified")
  public boolean getIsVerified()
  {
    return this.b;
  }

  @JsonProperty("number")
  public String getNumber()
  {
    return this.e;
  }

  @JsonProperty("source")
  public String getSource()
  {
    return this.c;
  }

  @JsonProperty("type")
  public int getType()
  {
    return this.f;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Boolean.valueOf(this.b);
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = Long.valueOf(this.d);
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = Integer.valueOf(this.f);
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.c);
      paramParcel.writeLong(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeInt(this.f);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.entry.PhoneEntry
 * JD-Core Version:    0.6.0
 */