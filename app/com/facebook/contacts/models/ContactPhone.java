package com.facebook.contacts.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactPhone
  implements Parcelable
{
  public static final Parcelable.Creator<ContactPhone> CREATOR = new ContactPhone.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final boolean e;

  private ContactPhone(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.e = i;
      return;
      i = 0;
    }
  }

  @JsonCreator
  public ContactPhone(@JsonProperty("id") String paramString1, @JsonProperty("label") String paramString2, @JsonProperty("displayNumber") String paramString3, @JsonProperty("universalNumber") String paramString4, @JsonProperty("isVerified") boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonProperty("displayNumber")
  public String getDisplayNumber()
  {
    return this.c;
  }

  @JsonProperty("id")
  public String getId()
  {
    return this.a;
  }

  @JsonProperty("isVerified")
  public boolean getIsVerified()
  {
    return this.e;
  }

  @JsonProperty("label")
  public String getLabel()
  {
    return this.b;
  }

  @JsonProperty("universalNumber")
  public String getUniversalNumber()
  {
    return this.d;
  }

  public String toString()
  {
    return "ContactPhone<" + this.a + ":" + this.b + "> " + this.d + " (" + this.c + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactPhone
 * JD-Core Version:    0.6.0
 */