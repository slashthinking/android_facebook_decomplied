package com.facebook.contacts.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

public class ContactDetails
  implements Parcelable
{
  public static final Parcelable.Creator<ContactDetails> CREATOR = new ContactDetails.1();
  private final String a;
  private final EntrySection b;
  private final boolean c;

  private ContactDetails(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((EntrySection)paramParcel.readParcelable(EntrySection.class.getClassLoader()));
    if (paramParcel.readInt() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }

  @JsonCreator
  public ContactDetails(@JsonProperty("contactId") String paramString, @JsonProperty("contactInfoSection") EntrySection paramEntrySection, @JsonProperty("hasTimeline") boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramEntrySection);
    this.a = paramString;
    this.b = paramEntrySection;
    this.c = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonProperty("contactId")
  public String getContactId()
  {
    return this.a;
  }

  @JsonProperty("contactInfoSection")
  public EntrySection getContactInfoSection()
  {
    return this.b;
  }

  @JsonProperty("hasTimeline")
  public boolean getHasTimeline()
  {
    return this.c;
  }

  public String toString()
  {
    return super.toString() + "<" + this.a + "> has timeline: " + this.c;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactDetails
 * JD-Core Version:    0.6.0
 */