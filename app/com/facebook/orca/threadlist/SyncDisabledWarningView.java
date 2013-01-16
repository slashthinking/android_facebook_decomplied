package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.orca.common.util.IntentUtil;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.widget.CustomFrameLayout;

public class SyncDisabledWarningView extends CustomFrameLayout
{
  private View a;
  private TextView b;
  private Button c;

  public SyncDisabledWarningView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public SyncDisabledWarningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public SyncDisabledWarningView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private CharSequence a(int paramInt)
  {
    String str = getResources().getString(paramInt);
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(getResources());
    localStyledStringBuilder.a(2131362670);
    localStyledStringBuilder.a("[[setting_type]]", str, new StyleSpan(1), 33);
    return localStyledStringBuilder.b();
  }

  private void a(Context paramContext)
  {
    setContentView(2130903402);
    this.a = b(2131297435);
    this.b = ((TextView)b(2131297436));
    this.c = ((Button)b(2131297437));
    this.c.setOnClickListener(new SyncDisabledWarningView.1(this));
    this.a.setVisibility(8);
    a();
  }

  private void c()
  {
    Context localContext = getContext();
    if (IntentUtil.a(localContext, "android.settings.SYNC_SETTINGS"))
      localContext.startActivity(new Intent("android.settings.SYNC_SETTINGS"));
    while (true)
    {
      return;
      if (IntentUtil.a(localContext, "android.settings.SETTINGS"))
      {
        localContext.startActivity(new Intent("android.settings.SETTINGS"));
        continue;
      }
    }
  }

  public void a()
  {
    if (!((ConnectivityManager)getContext().getSystemService("connectivity")).getBackgroundDataSetting())
    {
      this.b.setText(a(2131362672));
      this.a.setVisibility(0);
    }
    while (true)
    {
      return;
      this.a.setVisibility(8);
    }
  }

  public boolean b()
  {
    if (this.a.getVisibility() != 8);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.SyncDisabledWarningView
 * JD-Core Version:    0.6.0
 */