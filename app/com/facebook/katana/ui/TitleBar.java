package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.orca.common.ui.titlebar.OnQuickActionListener;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.inject.FbInjector;
import java.util.List;

public class TitleBar extends ListenableRelativeLayout
  implements FbTitleBar
{
  private TitleBar.OnPrimaryButtonClickListener a;
  private TitleBarButtonSpec b;
  private boolean c = false;
  private boolean d = false;
  private ProgressBar e;
  private TextView f;
  private FacebookActivityDelegate g;

  public TitleBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public TitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = ((FacebookActivityDelegate)FbInjector.a(paramContext).a(FacebookActivityDelegate.class));
  }

  protected void a(View paramView)
  {
    if (this.g != null)
      this.g.t();
    if (this.a != null)
      this.a.a(paramView);
  }

  public void a(boolean paramBoolean)
  {
    if ((this.d) && (paramBoolean));
    for (int i = 0; ; i = 8)
    {
      this.e.setVisibility(i);
      return;
    }
  }

  public boolean a()
  {
    return false;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = ((ProgressBar)findViewById(2131297916));
    this.f = ((TextView)findViewById(2131296686));
    TitleBar.1 local1 = new TitleBar.1(this);
    ((ImageButton)findViewById(2131296342)).setOnClickListener(local1);
    ((Button)findViewById(2131296341)).setOnClickListener(local1);
  }

  public void setButtonSpecs(List<TitleBarButtonSpec> paramList)
  {
    if (paramList.size() > 0)
    {
      this.b = ((TitleBarButtonSpec)paramList.get(0));
      setPrimaryActionButton(this.b);
    }
    while (true)
    {
      return;
      this.b = null;
      setPrimaryActionButton(this.b);
    }
  }

  public void setCustomTitleView(View paramView)
  {
  }

  public void setHasBackButton(boolean paramBoolean)
  {
  }

  public void setHasProgressBar(boolean paramBoolean)
  {
  }

  public void setOnToolbarButtonListener(FbTitleBar.OnToolbarButtonListener paramOnToolbarButtonListener)
  {
    if (this.b == null);
    while (true)
    {
      return;
      this.a = new TitleBar.2(this, paramOnToolbarButtonListener);
      this.c = true;
    }
  }

  public void setPrimaryActionButton(TitleBarButtonSpec paramTitleBarButtonSpec)
  {
    ImageButton localImageButton = (ImageButton)findViewById(2131296342);
    Button localButton = (Button)findViewById(2131296341);
    View localView1 = findViewById(2131296344);
    View localView2 = findViewById(2131296343);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localImageButton.setVisibility(8);
    localButton.setVisibility(8);
    if (paramTitleBarButtonSpec == null)
      return;
    if (paramTitleBarButtonSpec.i() != null)
    {
      localButton.setText(paramTitleBarButtonSpec.i());
      localButton.setVisibility(0);
      localView2.setVisibility(0);
    }
    while (true)
    {
      localImageButton.setSelected(paramTitleBarButtonSpec.e());
      break;
      if (paramTitleBarButtonSpec.h() != -1)
      {
        localImageButton.setImageResource(paramTitleBarButtonSpec.h());
        localImageButton.setVisibility(0);
        localView1.setVisibility(0);
        continue;
      }
      if (paramTitleBarButtonSpec.b() == null)
        continue;
      localImageButton.setImageDrawable(paramTitleBarButtonSpec.b());
      localImageButton.setVisibility(0);
      localView1.setVisibility(0);
    }
  }

  public void setPrimaryOnClickListener(TitleBar.OnPrimaryButtonClickListener paramOnPrimaryButtonClickListener)
  {
    if (!this.c)
      this.a = paramOnPrimaryButtonClickListener;
  }

  public void setQuickActionMenuListener(OnQuickActionListener paramOnQuickActionListener)
  {
  }

  public void setTitle(int paramInt)
  {
    if (this.f != null)
      this.f.setText(paramInt);
  }

  public void setTitle(String paramString)
  {
    if (this.f != null)
      this.f.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TitleBar
 * JD-Core Version:    0.6.0
 */