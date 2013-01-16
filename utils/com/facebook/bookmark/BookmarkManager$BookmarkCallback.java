package com.facebook.bookmark;

import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.ops.ServiceException;

public abstract interface BookmarkManager$BookmarkCallback
{
  public abstract void a(FetchBookmarksResult paramFetchBookmarksResult, boolean paramBoolean);

  public abstract void a(Bookmark paramBookmark);

  public abstract void a(BookmarksGroup paramBookmarksGroup);

  public abstract void a(ServiceException paramServiceException);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.BookmarkManager.BookmarkCallback
 * JD-Core Version:    0.6.2
 */