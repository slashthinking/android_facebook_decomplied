package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class PhotosGetLikesAndComments extends FqlMultiQuery
  implements ApiMethodCallback
{
  private final long a;

  private PhotosGetLikesAndComments(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong, paramServiceOperationListener), paramServiceOperationListener);
    this.a = paramLong;
  }

  public static String a(Context paramContext, long paramLong)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new PhotosGetLikesAndComments(paramContext, null, localAppSession.b().sessionKey, paramLong, null), 1001, 1020, null);
    }
  }

  private static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("likes", new PhotosGetLikesAndComments.LikesQuery(paramContext, paramIntent, paramString, paramLong, paramServiceOperationListener));
    localLinkedHashMap.put("comments", new PhotosGetLikesAndComments.CommentsQuery(paramContext, paramIntent, paramString, paramLong, paramServiceOperationListener));
    return localLinkedHashMap;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
    {
      AppSessionListener localAppSessionListener = (AppSessionListener)localIterator.next();
      PhotosGetLikesAndComments.CommentsQuery localCommentsQuery = (PhotosGetLikesAndComments.CommentsQuery)c("comments");
      localAppSessionListener.a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a, PhotosGetLikesAndComments.LikesQuery.a((PhotosGetLikesAndComments.LikesQuery)c("likes")), PhotosGetLikesAndComments.CommentsQuery.a(localCommentsQuery));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosGetLikesAndComments
 * JD-Core Version:    0.6.0
 */