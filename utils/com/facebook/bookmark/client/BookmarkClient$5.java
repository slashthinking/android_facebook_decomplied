package com.facebook.bookmark.client;

import com.facebook.bookmark.model.Bookmark;
import com.google.common.base.Function;
import java.util.Map;

class BookmarkClient$5
  implements Function<Long, Bookmark>
{
  BookmarkClient$5(BookmarkClient paramBookmarkClient)
  {
  }

  public Bookmark a(Long paramLong)
  {
    Bookmark localBookmark = (Bookmark)BookmarkClient.d(this.a).get(paramLong);
    if (localBookmark == null)
      throw new IllegalStateException("The favorite bookmark with id " + paramLong + " was not found in BookmarkManager.");
    return localBookmark;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.client.BookmarkClient.5
 * JD-Core Version:    0.6.2
 */