package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.nux.SmsNuxDetailActivity;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;

public class SmsUpsellController
{
  private final OrcaSharedPreferences a;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener b;
  private final SlidingOutSuggestionView c;

  public SmsUpsellController(OrcaSharedPreferences paramOrcaSharedPreferences, SlidingOutSuggestionView paramSlidingOutSuggestionView)
  {
    this.a = paramOrcaSharedPreferences;
    this.c = paramSlidingOutSuggestionView;
    paramSlidingOutSuggestionView.setOnButtonClickListener(new SmsUpsellController.1(this));
    this.b = new SmsUpsellController.2(this);
    paramOrcaSharedPreferences.a(this.b);
    b();
    e();
  }

  private void a(PrefKey paramPrefKey)
  {
    if (MessagesPrefKeys.i.equals(paramPrefKey))
      e();
  }

  private void b()
  {
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan.a(new SmsUpsellController.3(this));
    Resources localResources = this.c.getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(localResources.getString(2131362394));
    localStyledStringBuilder.a("[[learn_more_link]]", localResources.getString(2131362385), localCustomUrlLikeSpan, 33);
    this.c.a();
    this.c.setSuggestionText(localStyledStringBuilder.b());
  }

  private void c()
  {
    Intent localIntent = new Intent(this.c.getContext(), SmsNuxDetailActivity.class);
    this.c.getContext().startActivity(localIntent);
  }

  private void d()
  {
    this.c.f();
    this.a.b().a(MessagesPrefKeys.i, true).a();
  }

  private void e()
  {
    if (this.a.a(MessagesPrefKeys.i, true))
      this.c.e();
    while (true)
    {
      return;
      this.c.d();
    }
  }

  public void a()
  {
    e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.SmsUpsellController
 * JD-Core Version:    0.6.0
 */