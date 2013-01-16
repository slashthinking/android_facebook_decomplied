package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookAffiliation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class FqlGetFacebookAffiliation extends FqlQuery
{
  private static final Class<?> a = FqlGetFacebookAffiliation.class;

  public FqlGetFacebookAffiliation(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong)
  {
    super(paramContext, paramIntent, paramString, a(paramLong), paramServiceOperationListener);
  }

  private static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT affiliations FROM user WHERE uid=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }

  private static boolean b(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    FbJsonChecker.a(localJsonToken1);
    Assert.a(JsonToken.START_ARRAY, localJsonToken1);
    if (localJsonToken1 != JsonToken.END_ARRAY)
      if (localJsonToken1 == JsonToken.START_OBJECT)
      {
        String str = null;
        JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
        if (localJsonToken2 != JsonToken.END_OBJECT)
        {
          if (localJsonToken2 == JsonToken.FIELD_NAME)
            str = paramJsonParser.getText();
          do
          {
            localJsonToken2 = FbJsonChecker.a(paramJsonParser);
            break;
          }
          while ((localJsonToken2 != JsonToken.START_ARRAY) || (str == null) || (!str.equals("affiliations")));
        }
      }
    for (boolean bool = c(paramJsonParser); ; bool = false)
    {
      return bool;
      localJsonToken1 = FbJsonChecker.a(paramJsonParser);
      break;
    }
  }

  private static boolean c(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    FbJsonChecker.a(localJsonToken1);
    Assert.a(JsonToken.START_ARRAY, localJsonToken1);
    JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
    JsonToken localJsonToken3;
    if (localJsonToken2 != JsonToken.END_ARRAY)
      if (localJsonToken2 == JsonToken.START_OBJECT)
      {
        localJsonToken3 = FbJsonChecker.a(paramJsonParser);
        label41: if (localJsonToken3 == JsonToken.END_OBJECT)
          break label135;
        if (((localJsonToken3 != JsonToken.VALUE_STRING) && (localJsonToken3 != JsonToken.VALUE_NUMBER_INT)) || (!paramJsonParser.getCurrentName().equals("nid")) || (!paramJsonParser.getText().equals("50431648")));
      }
    for (int i = 1; ; i = 0)
    {
      return i;
      if ((localJsonToken3 == JsonToken.START_OBJECT) || (localJsonToken3 == JsonToken.START_ARRAY))
        paramJsonParser.skipChildren();
      localJsonToken3 = FbJsonChecker.a(paramJsonParser);
      break label41;
      if (localJsonToken2 == JsonToken.START_ARRAY)
        paramJsonParser.skipChildren();
      label135: localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      break;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken2 = JsonToken.START_ARRAY;
    boolean bool = false;
    if (localJsonToken1 == localJsonToken2)
      bool = b(paramJsonParser);
    FacebookAffiliation.a(this.o, bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetFacebookAffiliation
 * JD-Core Version:    0.6.0
 */