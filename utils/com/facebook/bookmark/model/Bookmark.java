package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;
import java.util.List;

public class Bookmark
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<Bookmark> CREATOR = new Bookmark.1();
  public static final long MESSAGES_ID = 217974574879787L;
  public static final long NEWS_FEED_ID = 4748854339L;

  @JMAutogen.InferredType(jsonFieldName="icon")
  public final String icon;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final long id;

  @JMAutogen.InferredType(jsonFieldName="count")
  private int mCount;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String name;

  @JMAutogen.InferredType(jsonFieldName="pic")
  public final String pic;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String type;

  @JMAutogen.InferredType(jsonFieldName="url")
  public final String url;

  private Bookmark()
  {
    this.id = -1L;
    this.name = null;
    this.url = null;
    this.mCount = 0;
    this.icon = null;
    this.pic = null;
    this.type = null;
  }

  public Bookmark(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramLong;
    this.name = paramString1;
    this.url = paramString2;
    this.mCount = paramInt;
    this.icon = paramString3;
    this.pic = paramString4;
    this.type = paramString5;
  }

  private Bookmark(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.mCount = paramParcel.readInt();
    this.icon = paramParcel.readString();
    this.pic = paramParcel.readString();
    this.type = paramParcel.readString();
  }

  public static boolean a(Bookmark paramBookmark1, Bookmark paramBookmark2)
  {
    if ((paramBookmark1.id == paramBookmark2.id) && (Objects.equal(paramBookmark1.name, paramBookmark2.name)) && (Objects.equal(paramBookmark1.icon, paramBookmark2.icon)) && (Objects.equal(paramBookmark1.pic, paramBookmark2.pic)) && (Objects.equal(paramBookmark1.url, paramBookmark2.url)) && (Objects.equal(paramBookmark1.type, paramBookmark2.type)) && (paramBookmark1.mCount == paramBookmark2.mCount));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean a(List<Bookmark> paramList1, List<Bookmark> paramList2)
  {
    int i = paramList1.size();
    int j = paramList2.size();
    boolean bool1 = false;
    int k;
    if (i == j)
    {
      k = 0;
      if (k >= paramList1.size())
        break label80;
      boolean bool2 = a((Bookmark)paramList1.get(k), (Bookmark)paramList2.get(k));
      bool1 = false;
      if (bool2)
        break label74;
    }
    while (true)
    {
      return bool1;
      label74: k++;
      break;
      label80: bool1 = true;
    }
  }

  public int a()
  {
    return this.mCount;
  }

  public void a(int paramInt)
  {
    this.mCount = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.mCount);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.pic);
    paramParcel.writeString(this.type);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.model.Bookmark
 * JD-Core Version:    0.6.2
 */