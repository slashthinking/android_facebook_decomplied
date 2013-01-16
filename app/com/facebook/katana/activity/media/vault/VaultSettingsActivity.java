package com.facebook.katana.activity.media.vault;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.provider.UserValuesManager;

public class VaultSettingsActivity extends BaseFacebookActivity
  implements RadioGroup.OnCheckedChangeListener, NotNewNavEnabled
{
  private LinearLayout n;
  private CheckBox o;
  private TextView p;

  private int a(String paramString)
  {
    int i;
    if (paramString.equals("MOBILE_RADIO"))
      i = 2131297970;
    while (true)
    {
      return i;
      if (paramString.equals("WIFI_ONLY"))
      {
        i = 2131297971;
        continue;
      }
      if (!paramString.equals("OFF"))
        break;
      i = 2131297972;
    }
    throw new IllegalArgumentException("unknown sync mode: " + paramString);
  }

  private void b(String paramString)
  {
    UserValuesManager.e(this, paramString);
  }

  private String c(int paramInt)
  {
    String str;
    if (paramInt == 2131297970)
      str = "MOBILE_RADIO";
    while (true)
    {
      return str;
      if (paramInt == 2131297971)
      {
        str = "WIFI_ONLY";
        continue;
      }
      if (paramInt != 2131297972)
        break;
      str = "OFF";
    }
    throw new IllegalArgumentException("unknown id: " + paramInt);
  }

  private void c(boolean paramBoolean)
  {
    this.o.setChecked(paramBoolean);
    if (paramBoolean)
      this.p.setText(2131363586);
    while (true)
    {
      return;
      this.p.setText(2131363585);
    }
  }

  private void j()
  {
    String str = UserValuesManager.j(this);
    ((RadioButton)findViewById(a(str))).setChecked(true);
    if (str.equals("OFF"))
      this.n.setVisibility(8);
    while (true)
    {
      c(UserValuesManager.h(this));
      return;
      this.n.setVisibility(0);
    }
  }

  private void k()
  {
    new VaultSettingsActivity.FetchQuotaInfoTask(this).execute(new Void[] { null, null, null });
  }

  private void l()
  {
    VaultSettingsActivity.2 local2 = new VaultSettingsActivity.2(this);
    VaultSettingsActivity.3 local3 = new VaultSettingsActivity.3(this);
    VaultSettingsActivity.4 local4 = new VaultSettingsActivity.4(this);
    AlertDialogs.a(this, null, 17301659, getString(2131363593), getString(2131363594), local2, getString(2131363595), local4, local3, true).show();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903630);
    this.p = ((TextView)findViewById(2131297975));
    this.n = ((LinearLayout)findViewById(2131297973));
    this.o = ((CheckBox)findViewById(2131297974));
    this.o.setOnClickListener(new VaultSettingsActivity.1(this));
    j();
    ((RadioGroup)findViewById(2131297969)).setOnCheckedChangeListener(this);
    k();
  }

  public String i()
  {
    return getString(2131363591);
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    String str = c(paramInt);
    if (str.equals("OFF"))
      l();
    while (true)
    {
      return;
      b(str);
      this.n.setVisibility(0);
    }
  }

  public void onResume()
  {
    super.onResume();
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131297969);
    localRadioGroup.setOnCheckedChangeListener(null);
    j();
    localRadioGroup.setOnCheckedChangeListener(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSettingsActivity
 * JD-Core Version:    0.6.0
 */