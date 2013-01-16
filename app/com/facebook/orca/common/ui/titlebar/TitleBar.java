package com.facebook.orca.common.ui.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R.styleable;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.annotations.IsSmsOnlyModeActive;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.common.visuals.VisualAppTheme;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;

public class TitleBar extends CustomViewGroup
  implements FbTitleBar
{
  private Provider<OrcaConfig> a;
  private MqttConnectionManager b;
  private OrcaAppType c;
  private AnalyticsLogger d;
  private Provider<Boolean> e;
  private TitleBarBackButton f;
  private View g;
  private ViewGroup h;
  private ViewGroup i;
  private ImageView j;
  private TitleBarDefaultTextTitle k;
  private View l;
  private LinearLayout m;
  private String n;
  private boolean o;
  private boolean p;
  private boolean q;
  private SafeLocalBroadcastReceiver r;
  private List<TitleBarButtonSpec> s = ImmutableList.d();
  private FbTitleBar.OnToolbarButtonListener t;
  private Paint u;
  private Paint v;
  private VisualAppTheme w;
  private OnQuickActionListener x;

  public TitleBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public TitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public TitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    FbInjector localFbInjector = getInjector();
    this.a = localFbInjector.b(OrcaConfig.class);
    this.b = ((MqttConnectionManager)localFbInjector.a(MqttConnectionManager.class));
    this.c = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.w = ((VisualAppTheme)localFbInjector.a(VisualAppTheme.class));
    this.d = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.e = localFbInjector.b(Boolean.class, IsSmsOnlyModeActive.class);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TitleBar);
    this.n = StringUtil.b(localTypedArray.getString(0));
    this.p = localTypedArray.getBoolean(1, true);
    this.o = localTypedArray.getBoolean(2, true);
    localTypedArray.recycle();
    setContentView(2130903424);
    this.f = ((TitleBarBackButton)getView(2131297511));
    this.g = getView(2131297509);
    this.k = ((TitleBarDefaultTextTitle)getView(2131297514));
    this.h = ((ViewGroup)getView(2131297512));
    this.i = ((ViewGroup)getView(2131297487));
    this.j = ((ImageView)getView(2131297515));
    this.m = ((LinearLayout)getView(2131297516));
    this.k.setText(this.n);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.ACTION_MQTT_CONFIG_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.login.OrcaAuthStateMachineMonitor.LOGIN_COMPLETE");
    localIntentFilter.addAction("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE");
    this.r = new TitleBar.1(this, paramContext, localIntentFilter);
    this.h.setOnClickListener(new TitleBar.2(this));
    if (this.c.h() == IntendedAudience.DEVELOPMENT)
      setWillNotDraw(false);
    if (!this.o)
      this.f.setVisibility(8);
    this.f.setOnClickListener(new TitleBar.3(this));
    c();
    this.u = new Paint();
    this.u.setColor(Color.rgb(255, 255, 255));
    this.u.setStyle(Paint.Style.FILL_AND_STROKE);
    this.u.setAntiAlias(true);
    this.v = new Paint();
    this.v.setColor(Color.rgb(136, 136, 136));
    this.v.setStyle(Paint.Style.FILL_AND_STROKE);
    this.v.setAntiAlias(true);
  }

  private void a(TitleBarButton paramTitleBarButton, int paramInt)
  {
    if (paramInt >= this.s.size())
      return;
    TitleBarButtonSpec localTitleBarButtonSpec = (TitleBarButtonSpec)this.s.get(paramInt);
    if (localTitleBarButtonSpec.c())
      if (localTitleBarButtonSpec.e())
        break label83;
    label83: for (boolean bool = true; ; bool = false)
    {
      paramTitleBarButton.setSelected(bool);
      localTitleBarButtonSpec.a(bool);
      if (this.t == null)
        break;
      a(localTitleBarButtonSpec.g());
      this.t.a(localTitleBarButtonSpec);
      break;
    }
  }

  private void a(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      Context localContext = getContext();
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click").f(paramString).e("button");
      if ((localContext instanceof AnalyticsActivity))
        localHoneyClientEvent.d(((AnalyticsActivity)localContext).a());
      this.d.a(localHoneyClientEvent);
    }
  }

  private void b()
  {
    Activity localActivity = (Activity)getContext();
    a("titlebar_back_button");
    localActivity.onBackPressed();
  }

  private void c()
  {
    for (int i1 = this.m.getChildCount(); i1 < this.s.size(); i1++)
    {
      TitleBarButton localTitleBarButton1 = new TitleBarButton(getContext());
      localTitleBarButton1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      this.m.addView(localTitleBarButton1);
      localTitleBarButton1.setOnClickListener(new TitleBar.4(this, i1));
      if (i1 != 0)
        continue;
      localTitleBarButton1.setId(2131296319);
    }
    int i2 = 0;
    int i3 = 0;
    int i6;
    if (i2 < this.s.size())
    {
      TitleBarButton localTitleBarButton3 = (TitleBarButton)this.m.getChildAt(i2);
      TitleBarButtonSpec localTitleBarButtonSpec = (TitleBarButtonSpec)this.s.get(i2);
      localTitleBarButton3.setImageDrawable(localTitleBarButtonSpec.b());
      localTitleBarButton3.setText(localTitleBarButtonSpec.i());
      if (localTitleBarButtonSpec.f())
      {
        i6 = 4;
        label163: localTitleBarButton3.setVisibility(i6);
        localTitleBarButton3.setSelected(localTitleBarButtonSpec.e());
        if (!localTitleBarButtonSpec.d())
          break label346;
        localTitleBarButton3.setShowProgress(this.q);
      }
    }
    label346: for (int i7 = 1; ; i7 = i3)
    {
      i2++;
      i3 = i7;
      break;
      i6 = 0;
      break label163;
      for (int i4 = this.s.size(); i4 < this.m.getChildCount(); i4++)
      {
        TitleBarButton localTitleBarButton2 = (TitleBarButton)this.m.getChildAt(i4);
        localTitleBarButton2.setVisibility(8);
        localTitleBarButton2.setShowProgress(false);
      }
      if (this.p)
        if (i3 != 0)
          this.k.setProgressBarVisibility(8);
      while (true)
      {
        d();
        return;
        TitleBarDefaultTextTitle localTitleBarDefaultTextTitle = this.k;
        boolean bool = this.q;
        int i5 = 0;
        if (bool);
        while (true)
        {
          localTitleBarDefaultTextTitle.setProgressBarVisibility(i5);
          break;
          i5 = 4;
        }
        this.k.setProgressBarVisibility(8);
      }
    }
  }

  private void d()
  {
    if (((OrcaConfig)this.a.b()).d())
      if (((Boolean)this.e.b()).booleanValue())
        setColorScheme(TitleBar.ColorScheme.SMS_ONLY);
    while (true)
    {
      return;
      setColorScheme(TitleBar.ColorScheme.FACEBOOK);
      continue;
      this.g.setBackgroundDrawable(new ColorDrawable(Color.rgb(0, 255, 0)));
    }
  }

  private void setColorScheme(TitleBar.ColorScheme paramColorScheme)
  {
    this.f.setColorScheme(paramColorScheme);
    for (int i1 = 0; i1 < this.m.getChildCount(); i1++)
      ((TitleBarButton)this.m.getChildAt(i1)).setColorScheme(paramColorScheme);
    switch (TitleBar.5.b[paramColorScheme.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      this.g.setBackgroundResource(2130838740);
      continue;
      this.g.setBackgroundResource(2130838741);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (!this.p)
      return;
    int i1 = 0;
    label15: if (i1 < this.s.size())
      if (((TitleBarButtonSpec)this.s.get(i1)).d())
        ((TitleBarButton)this.m.getChildAt(i1)).setShowProgress(paramBoolean);
    for (int i2 = 1; ; i2 = 0)
    {
      if (i2 != 0)
      {
        this.k.setProgressBarVisibility(8);
        break;
        i1++;
        break label15;
      }
      if (paramBoolean)
      {
        this.k.setProgressBarVisibility(0);
        break;
      }
      this.k.setProgressBarVisibility(4);
      break;
    }
  }

  public boolean a()
  {
    if (this.w != VisualAppTheme.FB4A);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.c.h() == IntendedAudience.DEVELOPMENT)
      if (!this.b.h())
        break label63;
    label63: for (Paint localPaint = this.u; ; localPaint = this.v)
    {
      int i1 = SizeUtil.a(getContext(), 10.0F);
      paramCanvas.drawCircle(paramCanvas.getWidth() - i1, i1, i1 / 2, localPaint);
      return;
    }
  }

  public List<TitleBarButtonSpec> getButtonSpecs()
  {
    return this.s;
  }

  public View getCustomTitleView()
  {
    return this.l;
  }

  public FbTitleBar.OnToolbarButtonListener getOnToolbarButtonListener()
  {
    return this.t;
  }

  public String getTitle()
  {
    return this.n;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r.a();
    d();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r.b();
  }

  public void setButtonSelected(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
    {
      TitleBarButtonSpec localTitleBarButtonSpec = (TitleBarButtonSpec)localIterator.next();
      if (localTitleBarButtonSpec.a() != paramInt)
        continue;
      if (localTitleBarButtonSpec.e() == paramBoolean)
        break;
      localTitleBarButtonSpec.a(paramBoolean);
    }
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        c();
      return;
    }
  }

  public void setButtonSpecs(List<TitleBarButtonSpec> paramList)
  {
    this.s = ImmutableList.a(paramList);
    c();
  }

  public void setCustomTitleView(View paramView)
  {
    this.l = paramView;
    if (this.i.getChildCount() > 1)
      this.i.removeViewAt(1);
    if (paramView != null)
    {
      this.i.addView(paramView);
      paramView.setVisibility(0);
      this.k.setVisibility(8);
    }
    while (true)
    {
      return;
      this.k.setVisibility(0);
    }
  }

  public void setHasBackButton(boolean paramBoolean)
  {
    this.o = paramBoolean;
    TitleBarBackButton localTitleBarBackButton = this.f;
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      localTitleBarBackButton.setVisibility(i1);
      return;
    }
  }

  public void setHasProgressBar(boolean paramBoolean)
  {
    if (this.p != paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      this.p = paramBoolean;
      if (i1 != 0)
        c();
      return;
    }
  }

  public void setOnToolbarButtonListener(FbTitleBar.OnToolbarButtonListener paramOnToolbarButtonListener)
  {
    this.t = paramOnToolbarButtonListener;
  }

  public void setQuickActionMenuListener(OnQuickActionListener paramOnQuickActionListener)
  {
    this.x = paramOnQuickActionListener;
  }

  public void setTitle(int paramInt)
  {
    this.n = getResources().getString(paramInt);
    this.k.setText(this.n);
  }

  public void setTitle(String paramString)
  {
    this.n = paramString;
    this.k.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBar
 * JD-Core Version:    0.6.0
 */