package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookApiException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONStringer;

public class FqlMultiQuery extends ApiMethod
{
  private final Map<String, FqlQuery> a;

  public FqlMultiQuery(Context paramContext, Intent paramIntent, String paramString, LinkedHashMap<String, FqlQuery> paramLinkedHashMap, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "fql.multiquery", Constants.URL.c(paramContext), paramServiceOperationListener);
    this.a = paramLinkedHashMap;
    this.e.put("call_id", "" + System.currentTimeMillis());
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.object();
      Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONStringer.key((String)localEntry.getKey());
        localJSONStringer.value(((FqlQuery)localEntry.getValue()).i());
      }
    }
    catch (JSONException localJSONException)
    {
    }
    while (true)
    {
      if (paramString != null)
        this.e.put("session_key", paramString);
      return;
      localJSONStringer.endObject();
      this.e.put("queries", localJSONStringer.toString());
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    if (localJsonToken1 == JsonToken.START_OBJECT)
      throw new FacebookApiException(paramJsonParser);
    if (localJsonToken1 != JsonToken.START_ARRAY)
      throw new IOException("Unexpected JSON response");
    for (JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser); localJsonToken2 != JsonToken.END_ARRAY; localJsonToken2 = FbJsonChecker.a(paramJsonParser))
    {
      if (localJsonToken2 != JsonToken.START_OBJECT)
        throw new IOException("Unexpected JSON response");
      JsonToken localJsonToken3 = FbJsonChecker.a(paramJsonParser);
      TokenBuffer localTokenBuffer = null;
      JsonToken localJsonToken4 = localJsonToken3;
      FqlQuery localFqlQuery = null;
      if (localJsonToken4 != JsonToken.END_OBJECT)
      {
        if (localJsonToken4 != JsonToken.FIELD_NAME);
        while (true)
        {
          localJsonToken4 = FbJsonChecker.a(paramJsonParser);
          break;
          String str = paramJsonParser.getText();
          FbJsonChecker.a(paramJsonParser);
          if (str.equals("fql_result_set"))
          {
            localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
            localTokenBuffer.copyCurrentStructure(paramJsonParser);
            continue;
          }
          if (!str.equals("name"))
            continue;
          localFqlQuery = (FqlQuery)this.a.get(paramJsonParser.getText());
        }
      }
      JsonParser localJsonParser = localTokenBuffer.asParser();
      FbJsonChecker.a(localJsonParser);
      localFqlQuery.a(localJsonParser);
    }
  }

  public FqlQuery c(String paramString)
  {
    return (FqlQuery)this.a.get(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlMultiQuery
 * JD-Core Version:    0.6.0
 */