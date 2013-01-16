package com.facebook.katana.activity.codegenerator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.katana.service.method.CodeGeneratorGetSecret;

class CodeGeneratorAutoProvisionSecretActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296499)
    {
      ((Button)this.a.findViewById(2131296499)).setClickable(false);
      this.a.showDialog(1);
      CodeGeneratorGetSecret.a(this.a, CodeGeneratorAutoProvisionSecretActivity.a(this.a));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorAutoProvisionSecretActivity.1
 * JD-Core Version:    0.6.0
 */