package com.facebook.bookmark.protocol;

import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BookmarkSetFavoritesMethod
  implements ApiMethod<BookmarksGroup, Void>
{
  public ApiRequest a(BookmarksGroup paramBookmarksGroup)
  {
    ArrayList localArrayList = Lists.a();
    Iterable localIterable = Iterables.a(paramBookmarksGroup.a(), new BookmarkSetFavoritesMethod.1(this));
    localArrayList.add(new BasicNameValuePair("ids", Joiner.on(',').join(localIterable)));
    localArrayList.add(new BasicNameValuePair("format", "JSON"));
    return new ApiRequest("bookmarkSetFavorites", "GET", "method/bookmarks.set", localArrayList, ApiResponseType.JSONPARSER);
  }

  public Void a(BookmarksGroup paramBookmarksGroup, ApiResponse paramApiResponse)
  {
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod
 * JD-Core Version:    0.6.2
 */