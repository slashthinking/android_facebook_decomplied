package com.facebook.contacts.models.entry;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailEntry
  implements Entry
{
  public static final Parcelable.Creator<EmailEntry> CREATOR = new EmailEntry.1();
  private final String a;

  protected EmailEntry(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  @JsonCreator
  public EmailEntry(@JsonProperty("email") String paramString)
  {
    this.a = paramString;
  }

  public Entry.Type a()
  {
    return Entry.Type.EMAIL;
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
      EmailEntry localEmailEntry = (EmailEntry)paramObject;
      if (this.a.equals(localEmailEntry.getEmail()))
        continue;
      i = 0;
    }
  }

  @JsonProperty("email")
  public String getEmail()
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
 * Qualified Name:     com.facebook.contacts.models.entry.EmailEntry
 * JD-Core Version:    0.6.0
 */