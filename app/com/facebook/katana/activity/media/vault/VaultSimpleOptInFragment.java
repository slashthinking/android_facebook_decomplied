package com.facebook.katana.activity.media.vault;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.VaultNotificationManager;
import com.facebook.katana.util.logging.VaultLogger;
import com.facebook.orca.inject.FbInjector;

public abstract class VaultSimpleOptInFragment extends VaultOptInFragment
  implements View.OnClickListener
{
  private static final String c = VaultSimpleOptInFragment.class.getSimpleName();
  private VaultLogger d;
  private VaultOptInFragment.OnOptionSelectedListener e;
  private Button f;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(this.b, paramViewGroup, false);
  }

  public void a(VaultOptInFragment.OnOptionSelectedListener paramOnOptionSelectedListener)
  {
    this.e = paramOnOptionSelectedListener;
  }

  protected String b(View paramView)
  {
    return "MOBILE_RADIO";
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.f = ((Button)A().findViewById(2131297949));
    this.f.setOnClickListener(this);
    A().findViewById(2131297951).setOnClickListener(new VaultSimpleOptInFragment.1(this));
    this.d = new VaultLogger(n());
  }

  public void onClick(View paramView)
  {
    String str = b(paramView);
    if (paramView.getId() == 2131297949)
    {
      FragmentActivity localFragmentActivity = n();
      this.d.e(str);
      UserValuesManager.e(localFragmentActivity, str);
      this.f.setBackgroundColor(q().getColor(2131165454));
      this.f.setEnabled(false);
      if (UserValuesManager.g(localFragmentActivity) != 0L)
      {
        Log.e(c, "forcing redraw!");
        ((VaultNotificationManager)FbInjector.a(localFragmentActivity).a(VaultNotificationManager.class)).a();
      }
      this.e.a(str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSimpleOptInFragment
 * JD-Core Version:    0.6.0
 */