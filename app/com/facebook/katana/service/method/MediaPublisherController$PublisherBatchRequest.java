package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.media.MediaRetryPublishActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.model.GraphFeedPublishResponse;
import com.facebook.katana.model.GraphRequestResponse;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MediaPublisherController$PublisherBatchRequest extends GraphBatchRequestDONOTUSE
  implements ApiMethodCallback
{
  private Set<Long> g;
  private String h;
  private String i;
  private String j;
  private List<MediaPublisherController.MediaPublishRetryRequest> r;
  private int s;
  private boolean t;
  private int u;
  private MediaPublisherController.MediaPublishRetryStatus v;
  private final PhotoFlowLogger w;
  private final String x;

  public MediaPublisherController$PublisherBatchRequest(Context paramContext, String paramString1, String paramString2, List<GraphApiMethod> paramList, String paramString3, Set<Long> paramSet, String paramString4, String paramString5)
  {
    super(paramContext, paramString1, paramString2, paramList);
    this.g = paramSet;
    this.h = paramString4;
    this.i = paramString3;
    this.r = Lists.a();
    this.s = 2;
    this.t = false;
    this.v = null;
    this.w = ((PhotoFlowLogger)FbInjector.a(paramContext).a(PhotoFlowLogger.class));
    this.w.a(paramString5);
    this.x = paramString5;
  }

  private Intent a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MediaRetryPublishActivity.class);
    ArrayList localArrayList = Lists.a(this.r);
    if (this.v != null)
      localIntent.putExtra("extra_publish_status_request", this.v);
    localIntent.putParcelableArrayListExtra("extra_publish_items", localArrayList);
    localIntent.putExtra("extra_publish_post_id", this.j);
    localIntent.putExtra("extra_publish_status_message", this.h);
    localIntent.putExtra("extra_publish_waterfall_id", this.x);
    return localIntent;
  }

  private void a(int paramInt, boolean paramBoolean, GraphApiMethod paramGraphApiMethod, GraphRequestResponse paramGraphRequestResponse)
  {
    String str4;
    int k;
    label158: String str1;
    label191: String str2;
    if ((paramInt == 0) && (!this.t))
    {
      GraphFeedPublish.GraphFeedPublishMethod localGraphFeedPublishMethod = (GraphFeedPublish.GraphFeedPublishMethod)paramGraphApiMethod;
      if (localGraphFeedPublishMethod.e.containsKey("privacy"))
      {
        str4 = (String)localGraphFeedPublishMethod.e.get("privacy");
        String str5 = localGraphFeedPublishMethod.i();
        int m = GraphFeedPublish.ImplicitLocation.UNKNOWN.getCode();
        if ((paramInt + 1 < this.s) && (this.a.size() > paramInt + 1))
          m = ((GraphFeedPublish.GraphFeedLocationMethod)this.a.get(paramInt + 1)).i();
        this.v = new MediaPublisherController.MediaPublishRetryStatus(this.h, str4, localGraphFeedPublishMethod.j(), str5, m);
      }
    }
    else if ((!paramBoolean) && (paramInt >= this.s))
    {
      if (paramInt != this.s)
        break label285;
      k = 1;
      if (!this.t)
        break label291;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(this.u);
      str1 = StringLocaleUtil.a("photo%d", arrayOfObject2);
      if (k == 0)
        break label305;
      boolean bool = this.t;
      str2 = null;
      if (!bool)
        break label298;
    }
    while (true)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(1 + this.u);
      String str3 = StringLocaleUtil.a("photo%d", arrayOfObject1);
      MediaPublisherController.MediaPublishRetryRequest localMediaPublishRetryRequest = new MediaPublisherController.MediaPublishRetryRequest(paramGraphApiMethod, this.j, str2, str3);
      this.u = (1 + this.u);
      this.r.add(localMediaPublishRetryRequest);
      return;
      str4 = null;
      break;
      label285: k = 0;
      break label158;
      label291: str1 = "photo1";
      break label191;
      label298: str2 = "status";
      continue;
      label305: str2 = str1;
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Log.e(MediaPublisherController.b(), "PublisherBatchRequest: " + paramInt + ", " + paramString2);
    int k;
    if (this.f == null)
    {
      ErrorReporting.a("photo_upload", "Publishing photos failed and no responses were available.");
      k = 0;
      if ((this.t) && (this.r.size() <= 0))
        break label158;
      Intent localIntent = a(this.o);
      SystemTrayNotificationManager.a(this.o, this.r.size(), k, localIntent);
      this.w.b(k - this.r.size(), this.r.size());
      if (this.t)
        break label169;
    }
    while (true)
    {
      return;
      k = this.f.size() - this.s;
      break;
      label158: this.w.b(k, 0);
      label169: paramAppSession.b();
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).e(paramAppSession, paramString1, paramInt, paramString2, paramException);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.f = JMParser.b(paramJsonParser, GraphRequestResponse.class);
    this.u = 0;
    int k = 0;
    if (k < this.f.size())
    {
      GraphRequestResponse localGraphRequestResponse = (GraphRequestResponse)this.f.get(k);
      boolean bool;
      if (localGraphRequestResponse.code == 200)
      {
        bool = true;
        label58: if ((!this.t) && (k == 0) && (bool))
        {
          if (!localGraphRequestResponse.body.equals("true"))
            break label129;
          Log.a(MediaPublisherController.b(), "Expected a status ID from the server. True returned instead.");
        }
      }
      while (true)
      {
        a(k, bool, (GraphApiMethod)this.a.get(k), localGraphRequestResponse);
        k++;
        break;
        bool = false;
        break label58;
        label129: if (localGraphRequestResponse.body.equals("false"))
        {
          Log.a(MediaPublisherController.b(), "Expected a status ID from the server. False returned instead.");
          continue;
        }
        this.j = ((GraphFeedPublishResponse)JMParser.a(new JsonFactory().createJsonParser(localGraphRequestResponse.body), GraphFeedPublishResponse.class)).id;
        if (StringUtils.c(this.j))
          continue;
        this.t = true;
      }
    }
  }

  public void e(String paramString)
  {
    this.j = paramString;
    this.t = true;
    this.s = 0;
    this.v = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController.PublisherBatchRequest
 * JD-Core Version:    0.6.0
 */