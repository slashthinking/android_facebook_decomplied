package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BookmarksGroup$1
  implements Parcelable.Creator<BookmarksGroup>
{
  public BookmarksGroup a(Parcel paramParcel)
  {
    return new BookmarksGroup(paramParcel, null);
  }

  public BookmarksGroup[] a(int paramInt)
  {
    return new BookmarksGroup[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.model.BookmarksGroup.1
 * JD-Core Version:    0.6.2
 */