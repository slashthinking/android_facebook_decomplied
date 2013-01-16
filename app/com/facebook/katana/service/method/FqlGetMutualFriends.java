package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FqlGetMutualFriends extends FqlQuery
{
  private static final Class<?> a = FqlGetMutualFriends.class;
  private final Map<Long, List<Long>> b = new HashMap();

  public FqlGetMutualFriends(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, long paramLong, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, a(paramLong, paramString2), paramServiceOperationListener);
  }

  protected static String a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT uid1, uid2 FROM friend WHERE uid1 IN (SELECT uid1  FROM friend  WHERE uid2=");
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append(") AND ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    FbJsonChecker.a(localJsonToken1);
    Assert.a(JsonToken.START_ARRAY, localJsonToken1);
    JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
    if (localJsonToken2 != JsonToken.END_ARRAY)
    {
      Object localObject2;
      Object localObject3;
      if (localJsonToken2 == JsonToken.START_OBJECT)
      {
        Object localObject1 = FbJsonChecker.a(paramJsonParser);
        localObject2 = null;
        localObject3 = null;
        if (localObject1 != JsonToken.END_OBJECT)
        {
          Object localObject6;
          Object localObject5;
          if ((localObject1 == JsonToken.VALUE_NUMBER_INT) || (localObject1 == JsonToken.VALUE_STRING))
            if (paramJsonParser.getCurrentName() == "uid1")
            {
              Long localLong = Long.valueOf(paramJsonParser.getText());
              Object localObject8 = localObject2;
              localObject6 = localLong;
              localObject5 = localObject8;
            }
          while (true)
          {
            JsonToken localJsonToken3 = FbJsonChecker.a(paramJsonParser);
            Object localObject7 = localObject5;
            localObject1 = localJsonToken3;
            localObject3 = localObject6;
            localObject2 = localObject7;
            break;
            if (paramJsonParser.getCurrentName() == "uid2")
            {
              localObject5 = Long.valueOf(paramJsonParser.getText());
              localObject6 = localObject3;
              continue;
              if ((localObject1 == JsonToken.START_OBJECT) || (localObject1 == JsonToken.START_ARRAY))
                paramJsonParser.skipChildren();
            }
            localObject5 = localObject2;
            localObject6 = localObject3;
          }
        }
        if ((localObject3 == null) || (localObject2 == null))
          Log.a(a, "Missing uid1 or uid2 from response");
      }
      while (true)
      {
        localJsonToken2 = FbJsonChecker.a(paramJsonParser);
        break;
        Object localObject4 = (List)this.b.get(localObject2);
        if (localObject4 == null)
        {
          localObject4 = new ArrayList();
          this.b.put(localObject2, localObject4);
        }
        ((List)localObject4).add(localObject3);
        continue;
        if (localJsonToken2 != JsonToken.START_ARRAY)
          continue;
        paramJsonParser.skipChildren();
      }
    }
  }

  public Map<Long, List<Long>> g()
  {
    return Collections.unmodifiableMap(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetMutualFriends
 * JD-Core Version:    0.6.0
 */