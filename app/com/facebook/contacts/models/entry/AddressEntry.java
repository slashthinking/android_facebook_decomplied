package com.facebook.contacts.models.entry;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressEntry
  implements Entry
{
  public static final Parcelable.Creator<AddressEntry> CREATOR = new AddressEntry.1();
  private final String a;

  protected AddressEntry(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  @JsonCreator
  public AddressEntry(@JsonProperty("address") String paramString)
  {
    this.a = paramString;
  }

  public Entry.Type a()
  {
    return Entry.Type.ADDRESS;
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
      AddressEntry localAddressEntry = (AddressEntry)paramObject;
      if (this.a.equals(localAddressEntry.getAddress()))
        continue;
      i = 0;
    }
  }

  @JsonProperty("address")
  public String getAddress()
  {
    return this.a;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.entry.AddressEntry
 * JD-Core Version:    0.6.0
 */