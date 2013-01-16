package com.facebook.katana.features.composer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.katana.ui.SectionedListAdapter;

public class TimeAdapter extends SectionedListAdapter
{
  private Context a;
  private LayoutInflater b;
  private int c;
  private TimeAdapter.Period[] d;

  public TimeAdapter(Context paramContext, TimeAdapter.Period[] paramArrayOfPeriod)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = -1;
    this.d = paramArrayOfPeriod;
  }

  public int a(int paramInt)
  {
    return 0;
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView1 = this.b.inflate(2130903092, null); ; localView1 = paramView)
    {
      LinearLayout localLinearLayout = (LinearLayout)localView1;
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131296489);
      View localView2 = localLinearLayout.findViewById(2131296490);
      if (paramInt2 == e());
      for (int i = 0; ; i = 8)
      {
        localView2.setVisibility(i);
        localTextView.setText(this.d[paramInt2].localizedString(this.a));
        return localLinearLayout;
      }
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = this.b.inflate(2130903239, null); ; localView = paramView)
    {
      ((TextView)localView).setText(this.a.getString(2131363232));
      return localView;
    }
  }

  public int b(int paramInt)
  {
    if (paramInt != 0)
      throw new IllegalArgumentException("sectionPosition must be 0, as we have only one section");
    return this.d.length;
  }

  public int b(int paramInt1, int paramInt2)
  {
    return 1;
  }

  public int c()
  {
    return 2;
  }

  public Object c(int paramInt)
  {
    if (paramInt != 0)
      throw new IllegalArgumentException("sectionPosition must be 0, as we have only one section");
    return this.d;
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public TimeAdapter.Period d(int paramInt1, int paramInt2)
  {
    return this.d[paramInt2];
  }

  public boolean d()
  {
    return false;
  }

  public int d_()
  {
    return 1;
  }

  public int e()
  {
    return this.c;
  }

  public TimeAdapter.Period f()
  {
    int i = e();
    if (i == -1);
    for (TimeAdapter.Period localPeriod = null; ; localPeriod = this.d[i])
      return localPeriod;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.TimeAdapter
 * JD-Core Version:    0.6.0
 */