package com.facebook.katana.activity.codegenerator;

import android.content.Intent;
import android.widget.Button;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.CodeGeneratorGetSecretResponse;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

class CodeGeneratorAutoProvisionSecretActivity$LoginApprovalsAutoProvisionAppSessionListener extends AppSessionListener
{
  private CodeGeneratorAutoProvisionSecretActivity$LoginApprovalsAutoProvisionAppSessionListener(CodeGeneratorAutoProvisionSecretActivity paramCodeGeneratorAutoProvisionSecretActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, CodeGeneratorGetSecretResponse paramCodeGeneratorGetSecretResponse)
  {
    Button localButton = (Button)this.a.findViewById(2131296499);
    this.a.removeDialog(1);
    if (paramInt == 200)
    {
      String str1 = paramCodeGeneratorGetSecretResponse.a();
      long l = AppSession.a(this.a, false).b().userId;
      String str2 = "login_approvals_secret:" + Long.toString(l);
      KeyValueManager.a(this.a, str2, str1);
      Intent localIntent = new Intent(this.a, CodeGeneratorActivity.class);
      this.a.startActivity(localIntent);
      this.a.finish();
      localButton.setClickable(true);
      return;
    }
    if (((paramException instanceof UnknownHostException)) || ((paramException instanceof SSLException)) || ((paramException instanceof ConnectTimeoutException)))
    {
      CodeGeneratorAutoProvisionSecretActivity.a(this.a, this.a.getString(2131363470));
      CodeGeneratorAutoProvisionSecretActivity.b(this.a, this.a.getString(2131363471));
    }
    while (true)
    {
      this.a.showDialog(2);
      break;
      CodeGeneratorAutoProvisionSecretActivity.a(this.a, this.a.getString(2131363469));
      CodeGeneratorAutoProvisionSecretActivity.b(this.a, this.a.getString(2131363472));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorAutoProvisionSecretActivity.LoginApprovalsAutoProvisionAppSessionListener
 * JD-Core Version:    0.6.0
 */