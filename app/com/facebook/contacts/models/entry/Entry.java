package com.facebook.contacts.models.entry;

import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(include=JsonTypeInfo.As.PROPERTY, property="@class", use=JsonTypeInfo.Id.CLASS)
public abstract interface Entry extends Parcelable
{
  @JsonIgnore
  public abstract Entry.Type a();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.entry.Entry
 * JD-Core Version:    0.6.0
 */