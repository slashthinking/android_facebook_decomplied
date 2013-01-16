package com.facebook.katana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;

public class SyncContactsChangeActivity extends BaseFacebookActivity
  implements View.OnClickListener, NotNewNavEnabled
{
  private int n;
  private boolean o;
  private boolean p;
  private AppSession q;

  private void c(int paramInt)
  {
    boolean bool1 = true;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131297851);
    boolean bool2;
    boolean bool3;
    label47: RadioButton localRadioButton3;
    if (paramInt == 2131297851)
    {
      bool2 = bool1;
      localRadioButton1.setChecked(bool2);
      RadioButton localRadioButton2 = (RadioButton)findViewById(2131297854);
      if (paramInt != 2131297854)
        break label89;
      bool3 = bool1;
      localRadioButton2.setChecked(bool3);
      localRadioButton3 = (RadioButton)findViewById(2131297857);
      if (paramInt != 2131297857)
        break label95;
    }
    while (true)
    {
      localRadioButton3.setChecked(bool1);
      this.n = paramInt;
      return;
      bool2 = false;
      break;
      label89: bool3 = false;
      break label47;
      label95: bool1 = false;
    }
  }

  private void j()
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.n == 2131297851)
      bool2 = bool1;
    while (true)
    {
      FacebookAuthenticationService.a(this, this.q.b().username, bool2, bool1);
      if ((this.o) && (!bool2))
        startService(new Intent(this, RemoveRawContactsService.class));
      while (true)
      {
        return;
        if (this.n != 2131297854)
          break label95;
        bool2 = bool1;
        bool1 = false;
        break;
        if ((this.o) || (!bool2))
          continue;
        this.q.e(this);
      }
      label95: bool1 = false;
      bool2 = false;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903563);
    this.q = AppSession.a(this, true);
    a(TitleBarButtonSpec.newBuilder().b(getString(2131363212)).i());
    findViewById(2131297850).setOnClickListener(this);
    findViewById(2131297853).setOnClickListener(this);
    findViewById(2131297856).setOnClickListener(this);
    findViewById(2131297860).setVisibility(8);
    new SyncContactsChangeActivity.ReadAccountUserTask(this).c();
  }

  public String i()
  {
    return getString(2131362888);
  }

  public void onClick(View paramView)
  {
    TitleBarButtonSpecBuilder localTitleBarButtonSpecBuilder = TitleBarButtonSpec.newBuilder();
    int i = paramView.getId();
    if (i == 2131297850)
    {
      c(2131297851);
      a(localTitleBarButtonSpecBuilder.b(getString(2131363212)).i());
    }
    while (true)
    {
      return;
      if (i == 2131297853)
      {
        c(2131297854);
        a(localTitleBarButtonSpecBuilder.b(getString(2131363212)).i());
        continue;
      }
      if (i != 2131297856)
        continue;
      c(2131297857);
      a(localTitleBarButtonSpecBuilder.b(getString(2131362910)).i());
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    j();
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SyncContactsChangeActivity
 * JD-Core Version:    0.6.0
 */