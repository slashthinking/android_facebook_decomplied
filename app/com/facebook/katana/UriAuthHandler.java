package com.facebook.katana;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.annotations.AuthNotRequired;

@AuthNotRequired
public class UriAuthHandler extends BaseFacebookActivity
{
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Uri localUri = getIntent().getData();
    String str1 = localUri.getQueryParameter("android-redirect");
    boolean bool = StringUtils.c(str1);
    Intent localIntent1 = null;
    if (!bool)
      localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse(localUri.getQueryParameter(str1)));
    String str2 = localUri.getQueryParameter("contactpoint");
    AppSession localAppSession = AppSession.a(this, false);
    if ((localAppSession != null) && (localAppSession.i() != AppSession.LoginStatus.STATUS_LOGGED_OUT))
      if ((localAppSession.b() != null) && (!StringUtils.c(str2)) && (StringUtils.a(localAppSession.b().username, str2)))
        if (localIntent1 != null)
        {
          startActivity(localIntent1);
          finish();
        }
    while (true)
    {
      return;
      ApplicationUtils.b(this);
      break;
      showDialog(23984);
      continue;
      Intent localIntent2 = new Intent(this, LoginActivity.class).putExtra("username", str2).putExtra("reg_login_nonce", localUri.getQueryParameter("nonce"));
      if (localIntent1 != null)
        localIntent2.putExtra("calling_intent", localIntent1).putExtra("login_redirect", true);
      startActivity(localIntent2);
      finish();
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 23984:
    }
    for (Object localObject = super.onCreateDialog(paramInt); ; localObject = AlertDialogs.a(this, getString(2131362975), 17301543, getString(2131362976), getString(2131361888), new UriAuthHandler.1(this), null, null, null, true))
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UriAuthHandler
 * JD-Core Version:    0.6.0
 */