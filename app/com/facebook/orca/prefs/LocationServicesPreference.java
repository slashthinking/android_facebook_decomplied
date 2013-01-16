package com.facebook.orca.prefs;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.orca.inject.FbInjector;

public class LocationServicesPreference extends DialogPreference
{
  private final OrcaSharedPreferences a;
  private final LayoutInflater b;
  private Boolean c;

  public LocationServicesPreference(Context paramContext)
  {
    super(paramContext, null);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.a = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.b = ((LayoutInflater)localFbInjector.a(LayoutInflater.class));
    setSummary(a());
  }

  private String a()
  {
    if (this.a.a(MessagesPrefKeys.r, true));
    for (String str = getContext().getString(2131362600); ; str = getContext().getString(2131362601))
      return str;
  }

  private void a(View paramView)
  {
    int i = 0;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      while (i < localViewGroup.getChildCount())
      {
        a(localViewGroup.getChildAt(i));
        i++;
      }
    }
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setSingleLine(false);
      localTextView.setEllipsize(null);
    }
  }

  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    a(paramView);
  }

  protected void onDialogClosed(boolean paramBoolean)
  {
    super.onDialogClosed(paramBoolean);
    if ((paramBoolean) && (this.c != null))
    {
      OrcaSharedPreferences.Editor localEditor = this.a.b();
      localEditor.a(MessagesPrefKeys.r, this.c.booleanValue());
      localEditor.a();
      setSummary(a());
      notifyChanged();
    }
  }

  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    paramBuilder.setInverseBackgroundForced(true);
    boolean bool = this.a.a(MessagesPrefKeys.r, true);
    paramBuilder.setTitle(2131362602);
    View localView = this.b.inflate(2130903358, null);
    ((TextView)localView.findViewById(2131297316)).setText(getContext().getString(2131362603) + "\n\n" + getContext().getString(2131362604));
    CheckBox localCheckBox = (CheckBox)localView.findViewById(2131297317);
    localCheckBox.setChecked(bool);
    localCheckBox.setOnCheckedChangeListener(new LocationServicesPreference.1(this));
    paramBuilder.setView(localView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.LocationServicesPreference
 * JD-Core Version:    0.6.0
 */