package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaPublisherController
{
  private static final String o;
  private MediaPublisherController.PublisherBatchRequest b;
  private String c;
  private String d;
  private List<MediaItem> e;
  private Set<Long> f;
  private String g;
  private String h;
  private Context i;
  private String j;
  private String k;
  private String l;
  private String m;
  private GraphFeedPublish.ImplicitLocation n;

  static
  {
    if (!MediaPublisherController.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      o = MediaPublisherController.class.getSimpleName();
      return;
    }
  }

  public MediaPublisherController(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, List<MediaItem> paramList, String paramString5, Set<Long> paramSet, String paramString6, String paramString7, String paramString8, GraphFeedPublish.ImplicitLocation paramImplicitLocation)
  {
    this.i = paramContext;
    this.j = paramString1;
    this.k = paramString2;
    this.g = paramString5;
    this.f = paramSet;
    this.h = paramString6;
    this.d = paramString4;
    this.b = null;
    this.c = paramString3;
    this.e = paramList;
    this.l = paramString7;
    this.m = paramString8;
    this.n = paramImplicitLocation;
  }

  public static ApiMethod a(Context paramContext, String paramString1, MediaPublisherController.MediaPublishRetryStatus paramMediaPublishRetryStatus, String paramString2, List<MediaPublisherController.MediaPublishRetryRequest> paramList, String paramString3, String paramString4)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if ((!a) && (localAppSession == null))
      throw new AssertionError();
    MediaPublisherController.PublisherBatchRequest localPublisherBatchRequest = a(paramContext, localAppSession.b().oAuthToken, paramMediaPublishRetryStatus, null, paramString3, paramString2, paramList, paramString4);
    localAppSession.a(paramContext, localPublisherBatchRequest, 1001, 1020, null);
    return localPublisherBatchRequest;
  }

  public static GraphFeedPublish.GraphFeedPublishMethod a(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, Set<Long> paramSet, String paramString4, String paramString5)
  {
    GraphFeedPublish.GraphFeedPublishMethod localGraphFeedPublishMethod = new GraphFeedPublish.GraphFeedPublishMethod(paramContext, paramString1, paramLong, paramLong, paramString2, paramString3, paramSet, paramString4, paramString5);
    localGraphFeedPublishMethod.c("status");
    return localGraphFeedPublishMethod;
  }

  public static MediaPublisherController.PublisherBatchRequest a(Context paramContext, String paramString1, MediaPublisherController.MediaPublishRetryStatus paramMediaPublishRetryStatus, Set<Long> paramSet, String paramString2, String paramString3, List<MediaPublisherController.MediaPublishRetryRequest> paramList, String paramString4)
  {
    MediaPublisherController.PublisherBatchRequest localPublisherBatchRequest;
    if (paramList.size() <= 0)
      localPublisherBatchRequest = null;
    while (true)
    {
      return localPublisherBatchRequest;
      String str1 = MediaPublisherController.MediaPublishRetryRequest.a((MediaPublisherController.MediaPublishRetryRequest)paramList.get(0));
      String str2 = MediaPublisherController.MediaPublishRetryRequest.b((MediaPublisherController.MediaPublishRetryRequest)paramList.get(0));
      ArrayList localArrayList = new ArrayList();
      GraphFeedPublish.ImplicitLocation localImplicitLocation;
      if (paramMediaPublishRetryStatus != null)
      {
        localArrayList.add(a(paramContext, "me/feed", AppSession.b(paramContext, false).b().userId, paramString3, paramMediaPublishRetryStatus.b(), paramMediaPublishRetryStatus.c(), paramMediaPublishRetryStatus.a(), null));
        localImplicitLocation = GraphFeedPublish.ImplicitLocation.UNKNOWN;
        if (MediaPublisherController.MediaPublishRetryStatus.a(paramMediaPublishRetryStatus) != GraphFeedPublish.ImplicitLocation.ENABLED.getCode())
          break label216;
        localImplicitLocation = GraphFeedPublish.ImplicitLocation.ENABLED;
      }
      while (true)
      {
        localArrayList.add(new GraphFeedPublish.GraphFeedLocationMethod(paramContext, localImplicitLocation));
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MediaPublisherController.MediaPublishRetryRequest localMediaPublishRetryRequest = (MediaPublisherController.MediaPublishRetryRequest)localIterator.next();
          localArrayList.add(new MediaPublisherController.PublishPhotoWithAttachMethod(paramContext, MediaPublisherController.MediaPublishRetryRequest.c(localMediaPublishRetryRequest), MediaPublisherController.MediaPublishRetryRequest.a(localMediaPublishRetryRequest), MediaPublisherController.MediaPublishRetryRequest.d(localMediaPublishRetryRequest), MediaPublisherController.MediaPublishRetryRequest.e(localMediaPublishRetryRequest), MediaPublisherController.MediaPublishRetryRequest.f(localMediaPublishRetryRequest), MediaPublisherController.MediaPublishRetryRequest.b(localMediaPublishRetryRequest)));
        }
        label216: if (MediaPublisherController.MediaPublishRetryStatus.a(paramMediaPublishRetryStatus) != GraphFeedPublish.ImplicitLocation.DISABLED.getCode())
          continue;
        localImplicitLocation = GraphFeedPublish.ImplicitLocation.ENABLED;
      }
      localPublisherBatchRequest = new MediaPublisherController.PublisherBatchRequest(paramContext, paramString1, str1, localArrayList, paramString2, paramSet, paramString3, paramString4);
      if (StringUtils.c(str2))
        continue;
      localPublisherBatchRequest.e(str2);
    }
  }

  public static MediaPublisherController a(Context paramContext, String paramString1, String paramString2, String paramString3, List<MediaItem> paramList, String paramString4, Set<Long> paramSet, String paramString5, String paramString6, String paramString7, GraphFeedPublish.ImplicitLocation paramImplicitLocation)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if ((!a) && (localAppSession == null))
      throw new AssertionError();
    MediaPublisherController localMediaPublisherController = new MediaPublisherController(paramContext, localAppSession.b().oAuthToken, paramString1, paramString2, paramString3, paramList, paramString4, paramSet, paramString5, paramString6, paramString7, paramImplicitLocation);
    localAppSession.a(paramContext, localMediaPublisherController.a(), 1001, 1020, null);
    return localMediaPublisherController;
  }

  private String a(JSONArray paramJSONArray, long paramLong)
  {
    String str = paramJSONArray.toString();
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = str;
    arrayOfObject[2] = "qn";
    arrayOfObject[3] = this.m;
    return StringLocaleUtil.a("/%d/tags?tags=%s&%s=%s", arrayOfObject);
  }

  private JSONArray a(Set<Long> paramSet)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        long l1 = ((Long)localIterator.next()).longValue();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("tag_uid", l1);
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          Log.a(o, "Error formatting tag_uid " + l1);
        }
      }
    }
    return localJSONArray;
  }

  public GraphBatchRequestDONOTUSE a()
  {
    AppSession localAppSession = AppSession.b(this.i, false);
    if ((!a) && (localAppSession == null))
      throw new AssertionError();
    long l1 = localAppSession.b().userId;
    ArrayList localArrayList = new ArrayList();
    GraphFeedPublish.GraphFeedPublishMethod localGraphFeedPublishMethod = a(this.i, "me/feed", l1, this.c, this.h, this.f, this.g, this.d);
    if (this.f != null)
      this.f.clear();
    localArrayList.add(localGraphFeedPublishMethod);
    localArrayList.add(new GraphFeedPublish.GraphFeedLocationMethod(this.i, this.n));
    Iterator localIterator = this.e.iterator();
    int i1 = 1;
    if (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      if (i1 == 1);
      for (String str = "status"; ; str = "photo1")
      {
        localArrayList.addAll(a(localMediaItem, this.f, i1, str));
        i1++;
        break;
      }
    }
    this.b = new MediaPublisherController.PublisherBatchRequest(this.i, this.j, this.k, localArrayList, this.l, this.f, this.c, this.m);
    return this.b;
  }

  public ArrayList<GraphApiMethod> a(MediaItem paramMediaItem, Set<Long> paramSet, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    long l1;
    if (paramMediaItem.g())
      l1 = paramMediaItem.f();
    while (true)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l1);
      String str1 = StringLocaleUtil.a("%d?published=1", arrayOfObject);
      String str2 = "photo" + paramInt;
      localArrayList.add(new MediaPublisherController.PublishPhotoWithAttachMethod(this.i, str1, this.k, str2, paramString, "", null));
      JSONArray localJSONArray = a(paramSet);
      if (localJSONArray.length() > 0)
      {
        String str3 = a(localJSONArray, l1);
        String str4 = "tag" + paramInt;
        GraphApiMethod localGraphApiMethod = new GraphApiMethod(this.i, "POST", str3, this.k);
        localGraphApiMethod.c(str4);
        localGraphApiMethod.d(str2);
        localArrayList.add(localGraphApiMethod);
      }
      return localArrayList;
      l1 = paramMediaItem.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController
 * JD-Core Version:    0.6.0
 */