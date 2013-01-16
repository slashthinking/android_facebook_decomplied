package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionViewBase;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PayForPlayPresence;
import com.facebook.orca.push.prefs.PushPrefKeys;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import javax.inject.Provider;

public class DivebarChatAvailabilityWarning extends SlidingOutSuggestionViewBase
{
  private final OrcaSharedPreferences a;
  private final Button b;
  private final Provider<PayForPlayPresence> c;
  private final AnalyticsLogger d;

  public DivebarChatAvailabilityWarning(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public DivebarChatAvailabilityWarning(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DivebarChatAvailabilityWarning(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.a = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.c = localFbInjector.b(PayForPlayPresence.class);
    this.d = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    setContentView(2130903337);
    setContainer((AnimatingItemView)b(2131297258));
    this.b = ((Button)b(2131297259));
    this.b.setOnClickListener(new DivebarChatAvailabilityWarning.1(this));
    a();
  }

  private void b()
  {
    f();
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click").e("button").f("divebar_availability_warning_turn_on");
    this.d.a(localHoneyClientEvent);
    this.a.b().a(PushPrefKeys.a, true).a();
  }

  void a()
  {
    if ((PayForPlayPresence)this.c.b() == PayForPlayPresence.DISABLED)
      d();
    while (true)
    {
      return;
      e();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarChatAvailabilityWarning
 * JD-Core Version:    0.6.0
 */