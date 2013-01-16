package com.facebook.katana.activity.composer;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.content.StringBody;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.graphql.model.Shareable;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SharePostMethod
  implements ApiMethod<PublishPostParams, SharePostMethod.SharePostResult>
{
  public static final String a = SharePostMethod.class.getSimpleName();

  public static void a(AppSession paramAppSession, Context paramContext, PublishPostParams paramPublishPostParams)
  {
    new SharePostMethod.1(FbInjector.a(paramContext), paramPublishPostParams, paramAppSession).execute(new PublishPostParams[] { paramPublishPostParams });
  }

  public SharePostMethod.SharePostResult a(PublishPostParams paramPublishPostParams, ApiResponse paramApiResponse)
  {
    try
    {
      localSharePostResult = new SharePostMethod.SharePostResult(paramApiResponse.c().get("id").asText(), paramApiResponse.a());
      return localSharePostResult;
    }
    catch (Exception localException)
    {
      while (true)
        SharePostMethod.SharePostResult localSharePostResult = new SharePostMethod.SharePostResult(null, paramApiResponse.a());
    }
  }

  public ApiRequest a(PublishPostParams paramPublishPostParams)
  {
    ArrayList localArrayList1 = Lists.a();
    ArrayList localArrayList2 = Lists.a();
    localArrayList1.add(new BasicNameValuePair("to", String.valueOf(paramPublishPostParams.b)));
    String str1 = paramPublishPostParams.h;
    if (!StringUtils.c(str1))
      localArrayList1.add(new BasicNameValuePair("privacy", str1));
    String str2 = paramPublishPostParams.c;
    if (!StringUtils.c(str2))
      localArrayList2.add(new FormBodyPart("message", new StringBody(str2, Charset.forName("UTF-8"))));
    return new ApiRequest("sharedposts", "POST", paramPublishPostParams.l.id + "/sharedposts", localArrayList1, ApiResponseType.JSON, localArrayList2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.SharePostMethod
 * JD-Core Version:    0.6.0
 */