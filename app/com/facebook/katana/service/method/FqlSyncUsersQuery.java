package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookFriendInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

public class FqlSyncUsersQuery extends FqlQuery
{
  private final List<FacebookFriendInfo> a = new ArrayList();

  public FqlSyncUsersQuery(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, "SELECT uid,first_name,last_name,name,pic_square,cell,other_phone,contact_email,birthday_date,search_tokens FROM user WHERE (uid IN (SELECT uid2 FROM friend WHERE uid1=%1));".replaceFirst("%1", "" + paramLong), paramServiceOperationListener);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    FbJsonChecker.a(localJsonToken1);
    if (localJsonToken1 == JsonToken.START_OBJECT)
    {
      int i = -1;
      String str = null;
      JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      if (localJsonToken2 != JsonToken.END_OBJECT)
      {
        if (localJsonToken2 == JsonToken.VALUE_NUMBER_INT)
          if (paramJsonParser.getCurrentName().equals("error_code"))
            i = paramJsonParser.getIntValue();
        while (true)
        {
          localJsonToken2 = FbJsonChecker.a(paramJsonParser);
          break;
          if ((localJsonToken2 != JsonToken.VALUE_STRING) || (!paramJsonParser.getCurrentName().equals("error_msg")))
            continue;
          str = paramJsonParser.getText();
        }
      }
      if (i > 0)
        throw new FacebookApiException(i, str);
    }
    else if (localJsonToken1 == JsonToken.START_ARRAY)
    {
      while (localJsonToken1 != JsonToken.END_ARRAY)
      {
        if (localJsonToken1 == JsonToken.START_OBJECT)
          this.a.add((FacebookFriendInfo)FacebookUser.a(FacebookFriendInfo.class, paramJsonParser));
        localJsonToken1 = FbJsonChecker.a(paramJsonParser);
      }
    }
  }

  public List<FacebookFriendInfo> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlSyncUsersQuery
 * JD-Core Version:    0.6.0
 */