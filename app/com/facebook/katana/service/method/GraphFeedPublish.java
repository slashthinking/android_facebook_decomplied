package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.GraphFeedPublishError;
import com.facebook.katana.model.GraphFeedPublishResponse;
import com.facebook.katana.model.GraphRequestResponse;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GraphFeedPublish extends GraphBatchRequestDONOTUSE
  implements ApiMethodCallback
{
  private static final Class<?> g = GraphFeedPublish.class;
  private String h = null;
  private final long i;
  private final Set<Long> j;
  private final String r;

  private GraphFeedPublish(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, Set<Long> paramSet, String paramString5, GraphFeedPublish.ImplicitLocation paramImplicitLocation, String paramString6)
  {
    super(paramContext, paramString1, Constants.URL.d(paramContext), a(paramContext, paramString2, paramLong2, paramLong1, paramString3, paramString4, paramSet, paramString5, paramImplicitLocation, paramString6));
    this.i = paramLong2;
    this.j = paramSet;
    this.r = paramString3;
  }

  public static String a(Context paramContext, long paramLong, String paramString1, String paramString2, Set<Long> paramSet, String paramString3, GraphFeedPublish.ImplicitLocation paramImplicitLocation, String paramString4)
  {
    Log.d(g, "Publishing post via graph API");
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null)
      Log.a(g, "Session is null, aborting status update");
    String str1;
    for (String str2 = null; ; str2 = localAppSession.a(paramContext, new GraphFeedPublish(paramContext, localAppSession.b().oAuthToken, str1, localAppSession.b().userId, paramLong, paramString1, paramString2, paramSet, paramString3, paramImplicitLocation, paramString4), 1001, 1020, null))
    {
      return str2;
      if (paramLong <= 0L)
        throw new GraphFeedPublishException("Invalid targetId to publishPost");
      str1 = paramLong + "/feed";
    }
  }

  private static List<GraphApiMethod> a(Context paramContext, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, Set<Long> paramSet, String paramString4, GraphFeedPublish.ImplicitLocation paramImplicitLocation, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new GraphFeedPublish.GraphFeedPublishMethod(paramContext, paramString1, paramLong1, paramLong2, paramString2, paramString3, paramSet, paramString4, paramString5));
    localArrayList.add(new GraphFeedPublish.GraphFeedLocationMethod(paramContext, paramImplicitLocation));
    return localArrayList;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    paramAppSession.b();
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).e(paramAppSession, paramString1, paramInt, paramString2, paramException);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.f = JMParser.b(paramJsonParser, GraphRequestResponse.class);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      GraphRequestResponse localGraphRequestResponse = (GraphRequestResponse)localIterator.next();
      if (localGraphRequestResponse.code == 200)
      {
        if (localGraphRequestResponse.body.equals("true"))
          continue;
        if (localGraphRequestResponse.body.equals("false"))
        {
          Log.a(g, "Unknown error updating settings");
          continue;
        }
      }
      GraphFeedPublishResponse localGraphFeedPublishResponse = (GraphFeedPublishResponse)JMParser.a(new JsonFactory().createJsonParser(localGraphRequestResponse.body), GraphFeedPublishResponse.class);
      this.h = localGraphFeedPublishResponse.id;
      GraphFeedPublishError localGraphFeedPublishError = localGraphFeedPublishResponse.error;
      if (!StringUtils.c(this.h))
        continue;
      if ((localGraphFeedPublishError == null) || (localGraphFeedPublishError.code == 0))
        throw new FacebookApiException(paramJsonParser);
      throw new FacebookApiException(localGraphFeedPublishError.code, localGraphFeedPublishError.message);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphFeedPublish
 * JD-Core Version:    0.6.0
 */