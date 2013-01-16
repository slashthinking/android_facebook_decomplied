package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookUserPersistent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FqlGetTaggedUserAlbum extends FqlQuery
  implements ApiMethodCallback
{
  private final List<FacebookAlbum> a = new ArrayList();
  private final FacebookUser b;
  private final boolean f;

  public FqlGetTaggedUserAlbum(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, b(paramLong), paramServiceOperationListener);
    FacebookUser localFacebookUser = AppSession.a(paramContext, true).b().a();
    if (localFacebookUser.mUserId == paramLong)
      this.b = localFacebookUser;
    for (this.f = true; ; this.f = false)
    {
      return;
      this.b = FacebookUserPersistent.a(paramContext, paramLong);
    }
  }

  public static String a(long paramLong)
  {
    return String.valueOf(paramLong);
  }

  public static boolean a(String paramString, long paramLong)
  {
    if (paramString == null);
    for (boolean bool = false; ; bool = paramString.equals(a(paramLong)))
      return bool;
  }

  private static String b(long paramLong)
  {
    return "SELECT pid FROM photo_tag WHERE subject = " + paramLong + " ORDER BY created DESC";
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramIntent.getIntExtra("extended_type", -1) != 85);
    while (true)
    {
      return;
      int i = g().size();
      FacebookAlbum localFacebookAlbum = null;
      if (i > 0)
        localFacebookAlbum = (FacebookAlbum)g().get(0);
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).b(paramAppSession, paramString1, paramInt, paramString2, paramException, localFacebookAlbum);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    ArrayList localArrayList = new ArrayList();
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      FacebookApiException localFacebookApiException = new FacebookApiException(paramJsonParser);
      if (localFacebookApiException.a() != -1)
        throw localFacebookApiException;
    }
    else
    {
      if (localJsonToken == JsonToken.START_ARRAY)
        while (localJsonToken != JsonToken.END_ARRAY)
        {
          if ((localJsonToken == JsonToken.VALUE_STRING) && (paramJsonParser.getCurrentName().equals("pid")))
            localArrayList.add(paramJsonParser.getText());
          localJsonToken = FbJsonChecker.a(paramJsonParser);
        }
      throw new IOException("Malformed JSON");
    }
    if (localArrayList.isEmpty())
      return;
    if (this.f);
    Context localContext;
    Object[] arrayOfObject;
    for (String str = this.o.getString(2131362826); ; str = localContext.getString(2131362825, arrayOfObject))
    {
      FacebookAlbum localFacebookAlbum = new FacebookAlbum(String.valueOf(this.b.mUserId), null, null, this.b.mUserId, str, 0L, System.currentTimeMillis() / 1000L, "", "", "", localArrayList.size(), "friends-of-friends", "tagged", null, 0L, (String[])localArrayList.toArray(new String[localArrayList.size()]));
      this.a.add(localFacebookAlbum);
      break;
      localContext = this.o;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b.mFirstName;
    }
  }

  public List<FacebookAlbum> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetTaggedUserAlbum
 * JD-Core Version:    0.6.0
 */