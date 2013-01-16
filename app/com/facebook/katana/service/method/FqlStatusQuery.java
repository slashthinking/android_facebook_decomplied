package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.ipc.katana.model.FacebookStatus;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.platform.PlatformStorage;
import com.facebook.katana.provider.UserStatusesProvider;
import com.facebook.katana.util.PlatformUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FqlStatusQuery extends FqlQuery
{
  private final List<FacebookStatus> a = new ArrayList();
  private final String b;

  public FqlStatusQuery(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString1, paramString2, paramServiceOperationListener);
    this.b = paramString3;
  }

  private static void a(Context paramContext, String paramString, List<FacebookStatus> paramList)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    localContentResolver.delete(UserStatusesProvider.a, null, null);
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookStatus localFacebookStatus = (FacebookStatus)localIterator.next();
      localContentValues.clear();
      localContentValues.put("user_id", Long.valueOf(localFacebookStatus.a().mUserId));
      localContentValues.put("first_name", localFacebookStatus.a().mFirstName);
      localContentValues.put("last_name", localFacebookStatus.a().mLastName);
      localContentValues.put("display_name", localFacebookStatus.a().a());
      localContentValues.put("user_pic", localFacebookStatus.a().mImageUrl);
      localContentValues.put("message", localFacebookStatus.b());
      localContentValues.put("status_id", Long.valueOf(localFacebookStatus.d()));
      localContentValues.put("timestamp", Long.valueOf(localFacebookStatus.c()));
      localContentResolver.insert(UserStatusesProvider.a, localContentValues);
    }
    if (PlatformUtils.a(paramContext))
      PlatformStorage.a(paramContext, paramString, paramList);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    if (localJsonToken1 == JsonToken.START_OBJECT)
    {
      FacebookApiException localFacebookApiException = new FacebookApiException(paramJsonParser);
      if (localFacebookApiException.a() != -1)
        throw localFacebookApiException;
    }
    else
    {
      if (localJsonToken1 == JsonToken.START_ARRAY)
        for (JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser); localJsonToken2 != JsonToken.END_ARRAY; localJsonToken2 = FbJsonChecker.a(paramJsonParser))
        {
          if (localJsonToken2 != JsonToken.START_OBJECT)
            continue;
          this.a.add(new FacebookStatus(paramJsonParser));
        }
      throw new IOException("Malformed JSON");
    }
    if (this.a.size() > 0)
      a(this.o, this.b, this.a);
  }

  public List<FacebookStatus> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlStatusQuery
 * JD-Core Version:    0.6.0
 */