package com.facebook.contacts.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.TriState;
import com.facebook.orca.users.Name;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

public class ContactSummary
  implements Parcelable
{
  public static final Parcelable.Creator<ContactSummary> CREATOR;
  public static final ContactSummary a = newBuilder().q();
  private final String b;
  private final String c;
  private final String d;
  private final Name e;
  private final Name f;
  private final String g;
  private final String h;
  private final float i;
  private final String j;
  private final ImmutableList<ContactPhone> k;
  private final boolean l;
  private final TriState m;
  private final boolean n;

  static
  {
    CREATOR = new ContactSummary.1();
  }

  private ContactSummary(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((Name)paramParcel.readParcelable(Name.class.getClassLoader()));
    this.f = ((Name)paramParcel.readParcelable(Name.class.getClassLoader()));
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readFloat();
    this.j = paramParcel.readString();
    this.k = ImmutableList.a(paramParcel.readArrayList(ContactPhone.class.getClassLoader()));
    int i2;
    if (paramParcel.readInt() == i1)
    {
      i2 = i1;
      this.l = i2;
      this.m = ((TriState)Enum.valueOf(TriState.class, paramParcel.readString()));
      if (paramParcel.readInt() != i1)
        break label160;
    }
    while (true)
    {
      this.n = i1;
      return;
      i2 = 0;
      break;
      label160: i1 = 0;
    }
  }

  ContactSummary(ContactSummaryBuilder paramContactSummaryBuilder)
  {
    this(paramContactSummaryBuilder.a(), paramContactSummaryBuilder.b(), paramContactSummaryBuilder.c(), a(paramContactSummaryBuilder), paramContactSummaryBuilder.e(), paramContactSummaryBuilder.i(), paramContactSummaryBuilder.j(), paramContactSummaryBuilder.k(), paramContactSummaryBuilder.l(), paramContactSummaryBuilder.m(), paramContactSummaryBuilder.n(), paramContactSummaryBuilder.o(), paramContactSummaryBuilder.p());
  }

  @JsonCreator
  public ContactSummary(@JsonProperty("contactId") String paramString1, @JsonProperty("profileFbid") String paramString2, @JsonProperty("graphApiWriteId") String paramString3, @JsonProperty("name") Name paramName1, @JsonProperty("phoneticName") Name paramName2, @JsonProperty("smallPictureUrl") String paramString4, @JsonProperty("bigPictureUrl") String paramString5, @JsonProperty("communicationRank") float paramFloat, @JsonProperty("lookupKey") String paramString6, @JsonProperty("phones") ImmutableList<ContactPhone> paramImmutableList, @JsonProperty("canMessage") boolean paramBoolean1, @JsonProperty("isMobilePushable") TriState paramTriState, @JsonProperty("isMemorialized") boolean paramBoolean2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramName1;
    this.f = paramName2;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramFloat;
    this.j = paramString6;
    this.k = paramImmutableList;
    this.l = paramBoolean1;
    this.m = paramTriState;
    this.n = paramBoolean2;
  }

  private static Name a(ContactSummaryBuilder paramContactSummaryBuilder)
  {
    if (paramContactSummaryBuilder.d() != null);
    for (Name localName = paramContactSummaryBuilder.d(); ; localName = new Name(paramContactSummaryBuilder.g(), paramContactSummaryBuilder.h(), paramContactSummaryBuilder.f()))
      return localName;
  }

  public static ContactSummaryBuilder newBuilder()
  {
    return new ContactSummaryBuilder();
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonProperty("bigPictureUrl")
  public String getBigPictureUrl()
  {
    return this.h;
  }

  @JsonProperty("canMessage")
  public boolean getCanMessage()
  {
    return this.l;
  }

  @JsonProperty("communicationRank")
  public float getCommunicationRank()
  {
    return this.i;
  }

  @JsonProperty("contactId")
  public String getContactId()
  {
    return this.b;
  }

  @JsonProperty("graphApiWriteId")
  public String getGraphApiWriteId()
  {
    return this.d;
  }

  @JsonProperty("isMemorialized")
  public boolean getIsMemorialized()
  {
    return this.n;
  }

  @JsonProperty("isMobilePushable")
  public TriState getIsMobilePushable()
  {
    return this.m;
  }

  @JsonProperty("lookupKey")
  public String getLookupKey()
  {
    return this.j;
  }

  @JsonProperty("name")
  public Name getName()
  {
    return this.e;
  }

  @JsonProperty("phones")
  public ImmutableList<ContactPhone> getPhones()
  {
    return this.k;
  }

  @JsonProperty("phoneticName")
  public Name getPhoneticName()
  {
    return this.f;
  }

  @JsonProperty("profileFbid")
  public String getProfileFbid()
  {
    return this.c;
  }

  @JsonProperty("smallPictureUrl")
  public String getSmallPictureUrl()
  {
    return this.g;
  }

  public String toString()
  {
    return getName() + " (phonetic name: " + getPhoneticName() + ") <contactId:" + getContactId() + "> <profileFbid:" + getProfileFbid() + "> <commRank:" + getCommunicationRank() + "> <canMessage:" + getCanMessage() + "> " + "<isMemorialized:" + this.n + ">";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeFloat(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeList(this.k);
    int i2;
    if (this.l)
    {
      i2 = i1;
      paramParcel.writeInt(i2);
      paramParcel.writeString(this.m.toString());
      if (!this.n)
        break label130;
    }
    while (true)
    {
      paramParcel.writeInt(i1);
      return;
      i2 = 0;
      break;
      label130: i1 = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactSummary
 * JD-Core Version:    0.6.0
 */