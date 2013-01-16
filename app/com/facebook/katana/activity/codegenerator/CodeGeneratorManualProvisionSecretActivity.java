package com.facebook.katana.activity.codegenerator;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.CodeGeneratorGetSecretResponse;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;

public class CodeGeneratorManualProvisionSecretActivity extends BaseFacebookActivity
  implements View.OnClickListener
{
  private AppSession n;

  private void i()
  {
    AlertDialogs.a(this, getString(2131363466), 17301659, getString(2131363467), getString(2131361888), new CodeGeneratorManualProvisionSecretActivity.1(this), null, null, null, false).show();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903098);
    findViewById(2131296502).setOnClickListener(this);
    ((TextView)findViewById(2131296500)).setText("http://fb.me/cg");
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296502)
    {
      String str = CodeGeneratorGetSecretResponse.a(((EditText)findViewById(2131296501)).getText().toString());
      if (!CodeGeneratorGetSecretResponse.b(str))
        break label95;
      long l = this.n.b().userId;
      KeyValueManager.a(this, "login_approvals_secret:" + Long.toString(l), str);
      startActivity(new Intent(getApplicationContext(), CodeGeneratorActivity.class));
      finish();
    }
    while (true)
    {
      return;
      label95: i();
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorManualProvisionSecretActivity
 * JD-Core Version:    0.6.0
 */