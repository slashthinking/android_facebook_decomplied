package com.facebook.contacts.contactcard;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.widget.RadioButtonWithSubtitle;

public class BlockContactDialogFragment extends DialogFragment
{
  private Dialog Y;
  private int Z = 0;
  private BlockContactDialogFragment.Listener aa;
  private RadioButtonWithSubtitle ab;
  private RadioButtonWithSubtitle ac;

  private void f(int paramInt)
  {
    this.Z = paramInt;
    switch (paramInt)
    {
    default:
    case -1:
    case 0:
    case 1:
    }
    while (true)
    {
      return;
      this.ac.setChecked(false);
      this.ab.setChecked(false);
      continue;
      this.ac.setChecked(false);
      this.ab.setChecked(true);
      continue;
      this.ac.setChecked(true);
      this.ab.setChecked(false);
    }
  }

  public void a(BlockContactDialogFragment.Listener paramListener)
  {
    this.aa = paramListener;
  }

  public Dialog c(Bundle paramBundle)
  {
    View localView = n().getLayoutInflater().inflate(2130903065, null);
    this.ab = ((RadioButtonWithSubtitle)localView.findViewById(2131296405));
    this.ac = ((RadioButtonWithSubtitle)localView.findViewById(2131296406));
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan.a(new BlockContactDialogFragment.1(this));
    TextView localTextView = (TextView)localView.findViewById(2131296407);
    Resources localResources = localView.getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(localResources.getString(2131362466));
    localStyledStringBuilder.a("[[here_link]]", localResources.getString(2131362467), localCustomUrlLikeSpan, 33);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setText(localStyledStringBuilder.b());
    this.ab.setOnCheckedChangeListener(new BlockContactDialogFragment.2(this));
    this.ac.setOnCheckedChangeListener(new BlockContactDialogFragment.3(this));
    this.Y = new AlertDialog.Builder(n()).setView(localView).setNegativeButton(2131362168, new BlockContactDialogFragment.5(this)).setPositiveButton(2131362169, new BlockContactDialogFragment.4(this)).create();
    return this.Y;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    int i = 0;
    if (paramBundle != null)
      i = paramBundle.getInt("radioSelectionBundleKey", 0);
    f(i);
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putInt("radioSelectionBundleKey", this.Z);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.BlockContactDialogFragment
 * JD-Core Version:    0.6.0
 */