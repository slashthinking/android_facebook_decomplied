package com.facebook.katana.activity.codegenerator;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.provider.KeyValueManager;

public class CodeGeneratorAutoProvisionSecretActivity extends BaseFacebookActivity
{
  private String n;
  private String o;
  private String p;
  private AppSession q;
  private AppSessionListener r;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903097);
    findViewById(2131296499).setOnClickListener(new CodeGeneratorAutoProvisionSecretActivity.1(this));
    this.n = KeyValueManager.a(this, "machine_id", "");
    this.r = new CodeGeneratorAutoProvisionSecretActivity.LoginApprovalsAutoProvisionAppSessionListener(this, null);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131363464));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      continue;
      localObject = AlertDialogs.a(this, this.p, 17301659, this.o, getString(2131361888), new CodeGeneratorAutoProvisionSecretActivity.2(this), getString(2131363468), new CodeGeneratorAutoProvisionSecretActivity.3(this), null, false);
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.q != null)
      this.q.b(this.r);
  }

  protected void onResume()
  {
    super.onResume();
    this.q = AppSession.a(this, true);
    this.q.a(this.r);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorAutoProvisionSecretActivity
 * JD-Core Version:    0.6.0
 */