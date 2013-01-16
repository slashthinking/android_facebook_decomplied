package com.facebook.bookmark.provider;

import android.database.SQLException;
import com.facebook.bookmark.model.BookmarksGroup;
import java.util.Comparator;
import java.util.Map;

class DBBookmarkHelper$1
  implements Comparator<BookmarksGroup>
{
  DBBookmarkHelper$1(DBBookmarkHelper paramDBBookmarkHelper, Map paramMap)
  {
  }

  public int a(BookmarksGroup paramBookmarksGroup1, BookmarksGroup paramBookmarksGroup2)
  {
    Integer localInteger1 = (Integer)this.a.get(paramBookmarksGroup1.id);
    Integer localInteger2 = (Integer)this.a.get(paramBookmarksGroup2.id);
    if ((localInteger1 == null) || (localInteger2 == null))
      throw new SQLException("Can not find the order information of group " + paramBookmarksGroup1.id + " or " + paramBookmarksGroup2.id);
    return localInteger1.compareTo(localInteger2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.provider.DBBookmarkHelper.1
 * JD-Core Version:    0.6.2
 */