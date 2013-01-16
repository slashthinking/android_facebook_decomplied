package com.facebook.katana.service.method;

import com.facebook.katana.UserTask;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.FacebookDatabaseHelper;
import com.facebook.katana.provider.UserValuesManager;

class AuthLogin$ClearAccountDataTask extends UserTask
{
  private final String b;
  private final int c;
  private final String d;
  private final Exception e;

  public AuthLogin$ClearAccountDataTask(AuthLogin paramAuthLogin, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    super(ServiceOperation.n);
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramString2;
    this.e = paramException;
  }

  protected void a()
  {
    int i = 1;
    try
    {
      String str1 = UserValuesManager.d(this.a.o);
      if (str1 != null)
      {
        String str2 = FacebookSessionInfo.a(str1).username;
        if (str2 != null)
        {
          boolean bool = str2.equals(this.b);
          if (bool)
            break label86;
        }
      }
      while (true)
      {
        label47: if (i != 0)
        {
          UserValuesManager.n(this.a.o);
          FacebookDatabaseHelper.b(this.a.o);
          FacebookAuthenticationService.e(this.a.o, this.b);
        }
        return;
        label86: i = 0;
      }
    }
    catch (Throwable localThrowable)
    {
      break label47;
    }
  }

  protected void b()
  {
    AuthLogin.a(this.a).a_(this.a, this.c, this.d, this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AuthLogin.ClearAccountDataTask
 * JD-Core Version:    0.6.0
 */