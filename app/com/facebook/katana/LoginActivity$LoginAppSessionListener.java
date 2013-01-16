package com.facebook.katana;

import android.view.View;
import android.widget.EditText;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.view.FacebookProgressCircleView;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

class LoginActivity$LoginAppSessionListener extends AppSessionListener
{
  private LoginActivity$LoginAppSessionListener(LoginActivity paramLoginActivity)
  {
  }

  public void a(AppSession paramAppSession, int paramInt, boolean paramBoolean)
  {
    LoginActivity.a(this.a, paramInt);
    LoginActivity.f(this.a, paramBoolean);
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (!paramString1.equals(LoginActivity.r(this.a)))
      if (paramInt == 200)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString1;
        arrayOfObject[1] = LoginActivity.r(this.a);
        ErrorReporting.a("LOGIN_ERROR", StringLocaleUtil.a("stale succesful onLoginComplete received (reqID=%s,mLoginReqID=%s. Discarding login state", arrayOfObject));
      }
    while (true)
    {
      return;
      if (paramInt != 200)
        break;
      LoginActivity.d(this.a, true);
    }
    LoginActivity.s(this.a).b("Login");
    paramAppSession.b(LoginActivity.q(this.a));
    LoginActivity.a(this.a, null);
    String str;
    if (paramInt == 0)
      if ((paramException instanceof FacebookApiException))
      {
        paramInt = ((FacebookApiException)paramException).a();
        paramString2 = ((FacebookApiException)paramException).b();
        str = ((FacebookApiException)paramException).c();
      }
    while (true)
    {
      label148: if ((LoginActivity.h(this.a)) && (LoginActivity.d(this.a, str)))
      {
        if (LoginActivity.t(this.a))
        {
          paramInt = 406;
          LoginActivity.b(this.a, this.a.getString(2131363003));
          LoginActivity.c(this.a, this.a.getString(2131363004));
        }
        if (StringUtils.c(LoginActivity.u(this.a)))
        {
          this.a.showDialog(2);
          label239: if (paramInt != 406)
            break label842;
          LoginActivity.e(this.a, true);
          this.a.findViewById(2131296674).setVisibility(0);
          LoginActivity.b(this.a).setText("");
        }
      }
      while (true)
      {
        LoginActivity.b(this.a, true);
        LoginActivity.m(this.a).setVisibility(8);
        LoginActivity.c(this.a, true);
        break;
        if (((paramException instanceof UnknownHostException)) || ((paramException instanceof SSLException)) || ((paramException instanceof ConnectTimeoutException)))
        {
          paramString2 = paramException.getMessage();
          paramInt = -600;
          str = null;
          break label148;
        }
        paramString2 = paramException.getMessage();
        str = null;
        break label148;
        this.a.removeDialog(3);
        this.a.showDialog(3);
        break label239;
        LoginActivity.b(this.a, this.a.getString(2131362995));
        switch (paramInt)
        {
        default:
          LoginActivity.b(this.a, this.a.getString(2131362988));
          LoginActivity.c(this.a, LoginActivity.a(this.a, this.a.getString(2131362989), paramInt, paramString2, null));
          ErrorReporting.a("LOGIN_ERROR", "unexpected login error: " + LoginActivity.a(this.a, "", paramInt, paramString2, paramException));
        case 400:
        case 401:
        case 405:
        case 406:
        case 407:
        case 2:
        case -600:
        }
        while (LoginActivity.h(this.a))
        {
          this.a.showDialog(2);
          break;
          LoginActivity.b(this.a, this.a.getString(2131362978));
          LoginActivity.c(this.a, this.a.getString(2131362979));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131362980));
          LoginActivity.c(this.a, this.a.getString(2131362981));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131362982));
          LoginActivity.c(this.a, this.a.getString(2131362983));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131363003));
          LoginActivity.c(this.a, this.a.getString(2131363004));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131362984));
          LoginActivity.c(this.a, this.a.getString(2131362985));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131362986));
          LoginActivity.c(this.a, this.a.getString(2131362987));
          continue;
          LoginActivity.b(this.a, this.a.getString(2131362988));
          LoginActivity.c(this.a, LoginActivity.a(this.a, this.a.getString(2131362990), 0, paramString2, paramException));
        }
        label842: this.a.findViewById(2131296669).setVisibility(0);
        if (paramInt != 401)
          continue;
        LoginActivity.c(this.a).setText("");
        LoginActivity.b(this.a).setText("");
      }
      str = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.LoginAppSessionListener
 * JD-Core Version:    0.6.0
 */