package com.facebook.bookmark.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BookmarkSyncMethod
  implements ApiMethod<Void, String>
{
  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "JSON"));
    localArrayList.add(new BasicNameValuePair("one_column", "true"));
    return new ApiRequest("bookmarkSync", "GET", "method/bookmarks.get", localArrayList, ApiResponseType.STRING);
  }

  public String a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return paramApiResponse.b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.protocol.BookmarkSyncMethod
 * JD-Core Version:    0.6.2
 */