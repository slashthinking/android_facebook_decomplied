package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class TaggingGraphGetSearch extends GraphApiMethod
  implements ApiMethodCallback
{
  private TaggingGraphGetSearchResponse a;

  private TaggingGraphGetSearch(Context paramContext, String paramString1, String paramString2, String paramString3, CharSequence paramCharSequence)
  {
    super(paramContext, paramString1, "GET", paramString2, paramString3);
    this.e.put("query", paramCharSequence.toString());
  }

  public static String a(Context paramContext, CharSequence paramCharSequence)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new TaggingGraphGetSearch(paramContext, localAppSession.b().oAuthToken, "tagsearch", Constants.URL.d(paramContext), paramCharSequence), 1001, 1020, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = TaggingGraphGetSearchResponse.a(paramJsonParser);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.TaggingGraphGetSearch
 * JD-Core Version:    0.6.0
 */