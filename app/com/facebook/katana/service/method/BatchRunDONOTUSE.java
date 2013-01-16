package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookApiException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

@Deprecated
public class BatchRunDONOTUSE extends ApiMethod
{
  private final List<ApiMethod> a;

  @Deprecated
  public BatchRunDONOTUSE(Context paramContext, Intent paramIntent, String paramString, List<ApiMethod> paramList, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "batch.run", Constants.URL.b(paramContext), paramServiceOperationListener);
    try
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ApiMethod localApiMethod = (ApiMethod)localIterator.next();
        localApiMethod.c();
        localApiMethod.d();
        localJSONArray.put(localApiMethod.e());
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      JSONArray localJSONArray;
      paramServiceOperationListener.a_(this, 0, null, localNoSuchAlgorithmException);
      while (true)
      {
        this.a = paramList;
        return;
        this.e.put("session_key", paramString);
        this.e.put("call_id", "" + System.currentTimeMillis());
        this.e.put("method_feed", localJSONArray.toString());
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        paramServiceOperationListener.a_(this, 0, null, localUnsupportedEncodingException);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    if (localJsonToken1 == JsonToken.START_OBJECT)
      throw new FacebookApiException(paramJsonParser);
    Object localObject;
    int i;
    if (localJsonToken1 == JsonToken.START_ARRAY)
    {
      localObject = FbJsonChecker.a(paramJsonParser);
      i = 0;
      if (localObject == JsonToken.END_ARRAY)
        break label169;
      if (localObject != JsonToken.VALUE_STRING)
        break label170;
      if (i >= this.a.size())
        throw new IOException("Methods index: " + i + ", size: " + this.a.size());
      ((ApiMethod)this.a.get(i)).a(ApiMethod.b(paramJsonParser.getText()));
    }
    label169: label170: for (int j = i + 1; ; j = i)
    {
      JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      int k = j;
      localObject = localJsonToken2;
      i = k;
      break;
      throw new IOException("Malformed JSON");
      return;
    }
  }

  public List<ApiMethod> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.BatchRunDONOTUSE
 * JD-Core Version:    0.6.0
 */