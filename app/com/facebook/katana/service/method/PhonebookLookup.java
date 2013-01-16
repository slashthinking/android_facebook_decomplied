package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhonebookLookup extends ApiMethod
  implements ApiMethodCallback
{
  private List<FacebookPhonebookContact> a;

  private PhonebookLookup(Context paramContext, Intent paramIntent, String paramString1, List<FacebookPhonebookContact> paramList, boolean paramBoolean1, String paramString2, boolean paramBoolean2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "phonebook.lookup", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
    this.e.put("session_key", paramString1);
    this.e.put("entries", FacebookPhonebookContact.a(paramList));
    Map localMap1 = this.e;
    String str1;
    String str2;
    label120: Map localMap3;
    if (paramBoolean1)
    {
      str1 = "1";
      localMap1.put("include_non_fb", str1);
      this.e.put("country_code", paramString2);
      Map localMap2 = this.e;
      if (!paramBoolean2)
        break label192;
      str2 = "1";
      localMap2.put("continuous_import", str2);
      this.e.put("not_for_sync", "1");
      localMap3 = this.e;
      if (!paramBoolean2)
        break label199;
    }
    label192: label199: for (String str3 = "continuous_import"; ; str3 = HowFound.a())
    {
      localMap3.put("ci_how_found", str3);
      this.a = new ArrayList();
      return;
      str1 = "0";
      break;
      str2 = "0";
      break label120;
    }
  }

  public static String a(AppSession paramAppSession, Context paramContext, List<FacebookPhonebookContact> paramList, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    return paramAppSession.a(paramContext, new PhonebookLookup(paramContext, null, paramAppSession.b().sessionKey, paramList, paramBoolean1, paramString, paramBoolean2, null), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).f(paramAppSession, paramString1, paramInt, paramString2, paramException, g());
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookPhonebookContact.class);
    if (localList != null)
      this.a = localList;
  }

  public List<FacebookPhonebookContact> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhonebookLookup
 * JD-Core Version:    0.6.0
 */