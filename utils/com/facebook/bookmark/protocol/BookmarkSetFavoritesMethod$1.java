package com.facebook.bookmark.protocol;

import com.facebook.bookmark.model.Bookmark;
import com.google.common.base.Function;

class BookmarkSetFavoritesMethod$1
  implements Function<Bookmark, Long>
{
  BookmarkSetFavoritesMethod$1(BookmarkSetFavoritesMethod paramBookmarkSetFavoritesMethod)
  {
  }

  public Long a(Bookmark paramBookmark)
  {
    return Long.valueOf(paramBookmark.id);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod.1
 * JD-Core Version:    0.6.2
 */