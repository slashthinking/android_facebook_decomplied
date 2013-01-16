package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.util.ArrayList;
import java.util.List;

public class PageTopic
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<PageTopic> CREATOR = new PageTopic.1();
  public static final int INVALID_COUNT = -1;
  public static final long INVALID_ID = -1L;
  public static final long NO_PARENT;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String displayName;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final long id;

  @JMAutogen.InferredType(jsonFieldName="count")
  public final int pageCount;

  @JMAutogen.ListType(b={Long.class}, jsonFieldName="parent_ids")
  public final List<Long> parentIds;

  @JMAutogen.InferredType(jsonFieldName="pic_square")
  public final String pic;

  private PageTopic()
  {
    this.id = -1L;
    this.displayName = null;
    this.pic = null;
    this.parentIds = null;
    this.pageCount = -1;
  }

  public PageTopic(long paramLong, String paramString1, String paramString2, List<Long> paramList, int paramInt)
  {
    this.id = paramLong;
    this.displayName = paramString1;
    this.pic = paramString2;
    this.parentIds = new ArrayList(paramList);
    this.pageCount = paramInt;
  }

  protected PageTopic(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.displayName = paramParcel.readString();
    this.pic = paramParcel.readString();
    this.parentIds = new ArrayList();
    paramParcel.readList(this.parentIds, List.class.getClassLoader());
    this.pageCount = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (paramObject != null)
    {
      boolean bool1 = paramObject instanceof PageTopic;
      i = 0;
      if (bool1)
        break label19;
    }
    while (true)
    {
      return i;
      label19: boolean bool2 = this.id < ((PageTopic)paramObject).id;
      i = 0;
      if (bool2)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    return (int)this.id;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.displayName);
    paramParcel.writeString(this.pic);
    paramParcel.writeList(this.parentIds);
    paramParcel.writeInt(this.pageCount);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.PageTopic
 * JD-Core Version:    0.6.0
 */