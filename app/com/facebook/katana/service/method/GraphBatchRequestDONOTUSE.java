package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.model.GraphRequestResponse;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphBatchRequestDONOTUSE extends GraphApiMethod
{
  private static final Class<?> g = GraphApiMethod.class;
  protected final List<GraphApiMethod> a;
  protected List<GraphRequestResponse> f;

  @Deprecated
  public GraphBatchRequestDONOTUSE(Context paramContext, String paramString1, String paramString2, List<GraphApiMethod> paramList)
  {
    super(paramContext, paramString1, "POST", null, paramString2);
    this.a = paramList;
    this.e.put("batch", i());
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.f = JMParser.b(paramJsonParser, GraphRequestResponse.class);
    int i = 0;
    if (i < this.f.size())
    {
      GraphRequestResponse localGraphRequestResponse = (GraphRequestResponse)this.f.get(i);
      if (localGraphRequestResponse.code != 200);
      while (true)
      {
        i++;
        break;
        HttpOperation.ResponseInputStream localResponseInputStream = new HttpOperation.ResponseInputStream(new ByteArrayInputStream(localGraphRequestResponse.body.getBytes()), "application/json", null);
        ((GraphApiMethod)this.a.get(i)).a(localResponseInputStream);
      }
    }
  }

  @Deprecated
  public void b()
  {
    try
    {
      if (this.k.equals("POST"))
      {
        this.l = new HttpOperation(this.o, a(true, false), e().toString(), "application/x-www-form-urlencoded", this.m, true);
        this.l.b();
      }
      else
      {
        throw new IllegalArgumentException("HTTP method must be POST for GraphBatchRequest");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.q != null)
        this.q.a_(this, 0, null, localException);
    }
  }

  protected String i()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GraphApiMethod localGraphApiMethod = (GraphApiMethod)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("method", localGraphApiMethod.k);
        if (localGraphApiMethod.k.equals("POST"))
        {
          localJSONObject.put("relative_url", localGraphApiMethod.a(false, false));
          localJSONObject.put("body", localGraphApiMethod.e().toString());
          String str1 = localGraphApiMethod.h();
          if (!StringUtils.c(str1))
            localJSONObject.put("depends_on", str1);
          String str2 = localGraphApiMethod.g();
          if (!StringUtils.c(str2))
            localJSONObject.put("name", str2);
          localJSONObject.put("omit_response_on_success", false);
          localJSONArray.put(localJSONObject);
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          Log.a(g, "error while constructing the batch param", localJSONException);
          break;
          localJSONObject.put("relative_url", localGraphApiMethod.a(false, true));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.a(g, "error encoding something for the batch param", localUnsupportedEncodingException);
      }
    }
    return localJSONArray.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphBatchRequestDONOTUSE
 * JD-Core Version:    0.6.0
 */