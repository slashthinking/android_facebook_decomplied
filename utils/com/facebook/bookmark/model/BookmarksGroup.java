package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BookmarksGroup
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<BookmarksGroup> CREATOR = new BookmarksGroup.1();
  public static final String FAVORITES_GROUP_ID = "pinned";
  public static final String PROFILE_GROUP_ID = "profile";
  public static final String SETTINGS_GROUP_ID = "settings";

  @JMAutogen.InferredType(jsonFieldName="id")
  public final String id;

  @JMAutogen.ListType(b={Bookmark.class}, jsonFieldName="all")
  private List<Bookmark> mAll;

  @JMAutogen.InferredType(jsonFieldName="visible_count")
  private int mVisibleCount;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String name;

  private BookmarksGroup()
  {
    this.id = null;
    this.name = null;
    this.mVisibleCount = 0;
    this.mAll = new ArrayList();
  }

  private BookmarksGroup(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.mVisibleCount = paramParcel.readInt();
    this.mAll = new ArrayList();
    paramParcel.readTypedList(this.mAll, Bookmark.CREATOR);
  }

  public BookmarksGroup(String paramString1, String paramString2, int paramInt, List<Bookmark> paramList)
  {
    this.id = ((String)Preconditions.checkNotNull(paramString1));
    this.name = ((String)Preconditions.checkNotNull(paramString2));
    this.mVisibleCount = paramInt;
    this.mAll = ((List)Preconditions.checkNotNull(paramList));
  }

  public BookmarksGroup(String paramString1, String paramString2, List<Bookmark> paramList1, List<Bookmark> paramList2)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.mVisibleCount = paramList1.size();
    this.mAll = Lists.a(paramList1);
    this.mAll.addAll(paramList2);
  }

  public static boolean a(BookmarksGroup paramBookmarksGroup1, BookmarksGroup paramBookmarksGroup2)
  {
    if ((Objects.equal(paramBookmarksGroup1.id, paramBookmarksGroup2.id)) && (Objects.equal(paramBookmarksGroup1.name, paramBookmarksGroup2.name)) && (paramBookmarksGroup1.mVisibleCount == paramBookmarksGroup2.mVisibleCount) && (Bookmark.a(paramBookmarksGroup1.mAll, paramBookmarksGroup2.mAll)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean a(List<BookmarksGroup> paramList1, List<BookmarksGroup> paramList2)
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
      boolean bool2 = a((BookmarksGroup)paramList1.get(k), (BookmarksGroup)paramList2.get(k));
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

  public List<Bookmark> a()
  {
    return this.mAll.subList(0, this.mVisibleCount);
  }

  public void a(List<Bookmark> paramList, int paramInt)
  {
    this.mAll = paramList;
    this.mVisibleCount = paramInt;
  }

  public boolean a(long paramLong)
  {
    Iterator localIterator = this.mAll.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Bookmark)localIterator.next()).id != paramLong);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean a(Bookmark paramBookmark)
  {
    return a(paramBookmark.id);
  }

  public int b()
  {
    return this.mVisibleCount;
  }

  public List<Bookmark> c()
  {
    return Collections.unmodifiableList(this.mAll);
  }

  public BookmarksGroup d()
  {
    ArrayList localArrayList = Lists.a(c());
    return new BookmarksGroup(this.id, this.name, this.mVisibleCount, localArrayList);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    if (this.mAll.size() > this.mVisibleCount);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.mVisibleCount);
    paramParcel.writeTypedList(this.mAll);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.model.BookmarksGroup
 * JD-Core Version:    0.6.2
 */