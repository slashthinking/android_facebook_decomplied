package com.facebook.katana.activity.codegenerator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class CodeGeneratorAutoProvisionSecretActivity$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a, CodeGeneratorManualProvisionSecretActivity.class);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorAutoProvisionSecretActivity.3
 * JD-Core Version:    0.6.0
 */