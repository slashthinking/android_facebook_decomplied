package com.facebook.katana.dialog;

import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.activity.FbFragmentActivity;

abstract class BlackDialogActivity extends FbFragmentActivity
{
  protected void a(BlackDialogActivity.BlackDialogParameters paramBlackDialogParameters)
  {
    setContentView(2130903061);
    ((TextView)f(2131296397)).setText(paramBlackDialogParameters.b());
    if (paramBlackDialogParameters.c() != null)
    {
      ImageView localImageView = (ImageView)f(2131296396);
      localImageView.setImageResource(paramBlackDialogParameters.c().intValue());
      localImageView.setVisibility(0);
    }
    if ((paramBlackDialogParameters.d() != null) && (paramBlackDialogParameters.e() != null));
    for (int i = 2130903064; ; i = 2130903063)
    {
      ViewStub localViewStub1 = (ViewStub)f(2131296399);
      localViewStub1.setLayoutResource(i);
      View localView = localViewStub1.inflate();
      if (paramBlackDialogParameters.d() != null)
      {
        Button localButton2 = (Button)localView.findViewById(2131296402);
        localButton2.setText(paramBlackDialogParameters.d());
        localButton2.setOnClickListener(new BlackDialogActivity.1(this));
      }
      if (paramBlackDialogParameters.e() != null)
      {
        Button localButton1 = (Button)localView.findViewById(2131296403);
        localButton1.setText(paramBlackDialogParameters.e());
        localButton1.setOnClickListener(new BlackDialogActivity.2(this));
      }
      ViewStub localViewStub2 = (ViewStub)f(2131296398);
      localViewStub2.setLayoutResource(paramBlackDialogParameters.a().intValue());
      localViewStub2.inflate();
      i();
      return;
      if ((paramBlackDialogParameters.d() != null) || (paramBlackDialogParameters.e() == null))
        continue;
      throw new IllegalStateException("cannot have cancel button without confirm button");
    }
  }

  protected abstract void i();

  protected void j()
  {
  }

  protected void k()
  {
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.BlackDialogActivity
 * JD-Core Version:    0.6.0
 */