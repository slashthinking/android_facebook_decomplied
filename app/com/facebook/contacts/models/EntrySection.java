package com.facebook.contacts.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.models.entry.Entry;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

public class EntrySection
  implements Parcelable
{
  public static final Parcelable.Creator<EntrySection> CREATOR = new EntrySection.1();
  private final String a;
  private final ImmutableList<Entry> b;
  private final ImmutableList<Entry> c;

  private EntrySection(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ImmutableList.a(paramParcel.readArrayList(Entry.class.getClassLoader()));
    this.c = ImmutableList.a(paramParcel.readArrayList(Entry.class.getClassLoader()));
  }

  @JsonCreator
  public EntrySection(@JsonProperty("title") String paramString, @JsonProperty("entries") ImmutableList<Entry> paramImmutableList1, @JsonProperty("hiddenEntries") ImmutableList<Entry> paramImmutableList2)
  {
    this.a = paramString;
    this.b = paramImmutableList1;
    this.c = paramImmutableList2;
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
      EntrySection localEntrySection = (EntrySection)paramObject;
      if ((Objects.equal(this.a, localEntrySection.getTitle())) && (Objects.equal(this.b, localEntrySection.getEntries())) && (Objects.equal(this.c, localEntrySection.getHiddenEntries())))
        continue;
      i = 0;
    }
  }

  @JsonProperty("entries")
  public ImmutableList<Entry> getEntries()
  {
    return this.b;
  }

  @JsonProperty("hiddenEntries")
  public ImmutableList<Entry> getHiddenEntries()
  {
    return this.c;
  }

  @JsonProperty("title")
  public String getTitle()
  {
    return this.a;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeList(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.EntrySection
 * JD-Core Version:    0.6.0
 */