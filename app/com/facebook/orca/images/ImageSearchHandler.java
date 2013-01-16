package com.facebook.orca.images;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiResponseChecker;
import com.facebook.orca.protocol.base.StringResponseHandler;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ImageSearchHandler
  implements OrcaServiceHandler
{
  private final OrcaHttpRequestProcessor a;
  private final ApiResponseChecker b;

  public ImageSearchHandler(OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramOrcaHttpRequestProcessor;
    this.b = paramApiResponseChecker;
  }

  private Bundle a(HttpResponse paramHttpResponse, String paramString)
  {
    return JSONUtil.a(new JSONObject(new JSONTokener(paramString)));
  }

  private OperationResult a(Bundle paramBundle)
  {
    Uri.Builder localBuilder = Uri.parse("http://api.search.live.net/json.aspx").buildUpon();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      localBuilder.appendQueryParameter(str2, paramBundle.getString(str2));
    }
    StringResponseHandler localStringResponseHandler = new StringResponseHandler(this.b);
    HttpGet localHttpGet = new HttpGet(localBuilder.build().toString());
    String str1 = (String)this.a.a("imageSearch", localHttpGet, localStringResponseHandler);
    return OperationResult.a(a(localStringResponseHandler.a(), str1));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    Bundle localBundle = paramOperationParams.b();
    if ("image_search".equals(str))
      return a(localBundle);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchHandler
 * JD-Core Version:    0.6.0
 */