package com.facebook.orca.compose;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.media.MediaResource;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

public class MessageDraft
  implements Parcelable
{
  public static final Parcelable.Creator<MessageDraft> CREATOR = new MessageDraft.1();
  private final String a;
  private final int b;
  private final List<MediaResource> c;

  private MessageDraft(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readArrayList(MediaResource.class.getClassLoader());
  }

  public MessageDraft(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = Lists.a();
  }

  public MessageDraft(String paramString, int paramInt, List<MediaResource> paramList)
  {
    Preconditions.checkNotNull(paramList);
    this.a = paramString;
    this.b = paramInt;
    this.c = paramList;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public List<MediaResource> c()
  {
    return this.c;
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
      if (!(paramObject instanceof MessageDraft))
      {
        i = 0;
        continue;
      }
      MessageDraft localMessageDraft = (MessageDraft)paramObject;
      if ((Objects.equal(a(), localMessageDraft.a())) && (Objects.equal(c(), localMessageDraft.c())) && (b() == localMessageDraft.b()))
        continue;
      i = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeList(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.MessageDraft
 * JD-Core Version:    0.6.0
 */