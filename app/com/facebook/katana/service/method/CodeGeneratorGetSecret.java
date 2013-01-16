package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.CodeGeneratorGetSecretResponse;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CodeGeneratorGetSecret extends GraphApiMethod
  implements ApiMethodCallback
{
  private CodeGeneratorGetSecretResponse a;

  private CodeGeneratorGetSecret(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramString1, "POST", paramString2, paramString3);
    this.e.put("machine_id", paramString4);
  }

  public static String a(Context paramContext, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str1 = null;
    if (localAppSession == null);
    while (true)
    {
      return str1;
      String str2 = Constants.URL.d(paramContext) + localAppSession.b().userId + "/";
      str1 = localAppSession.a(paramContext, new CodeGeneratorGetSecret(paramContext, localAppSession.b().oAuthToken, "loginapprovalskeys", str2, paramString), 1001, 1020, null);
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
    this.a = CodeGeneratorGetSecretResponse.a(paramJsonParser);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.CodeGeneratorGetSecret
 * JD-Core Version:    0.6.0
 */