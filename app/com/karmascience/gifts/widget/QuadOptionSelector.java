package com.karmascience.gifts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class QuadOptionSelector extends LinearLayout
  implements View.OnClickListener
{
  private final ArrayList<QuadOptionSelector.OptionPair> a;
  private final LayoutInflater b;
  private int c = 0;
  private QuadOptionSelector.OnOptionSelectedListener d;

  public QuadOptionSelector(Context paramContext)
  {
    this(paramContext, null);
  }

  public QuadOptionSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    this.a = new ArrayList();
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public QuadOptionSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    this.a = new ArrayList();
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  private void a()
  {
    int i = 1;
    ((QuadOptionSelector.OptionPair)this.a.get(0)).a.setBackgroundResource(2130838909);
    if (this.a.size() > i)
    {
      ((QuadOptionSelector.OptionPair)this.a.get(-1 + this.a.size())).a.setBackgroundResource(2130838913);
      while (i < -1 + this.a.size())
      {
        ((QuadOptionSelector.OptionPair)this.a.get(i)).a.setBackgroundResource(2130838911);
        i++;
      }
    }
  }

  public void a(String paramString, Object paramObject)
  {
    FrameLayout localFrameLayout = (FrameLayout)this.b.inflate(2130903534, this, false);
    localFrameLayout.setOnClickListener(this);
    localFrameLayout.setId(this.a.size());
    QuadOptionSelector.OptionPair localOptionPair = new QuadOptionSelector.OptionPair(this, localFrameLayout, paramObject, null);
    this.a.add(localOptionPair);
    addView(localFrameLayout);
    ((TextView)localFrameLayout.getChildAt(0)).setText(paramString);
    a();
    onClick(((QuadOptionSelector.OptionPair)this.a.get(0)).a);
  }

  public Object getCurrentSelection()
  {
    return ((QuadOptionSelector.OptionPair)this.a.get(this.c)).b;
  }

  public void onClick(View paramView)
  {
    a();
    this.c = paramView.getId();
    if (this.c == 0)
      ((QuadOptionSelector.OptionPair)this.a.get(this.c)).a.setBackgroundResource(2130838910);
    while (true)
    {
      ((QuadOptionSelector.OptionPair)this.a.get(this.c)).a.setSelected(true);
      if (this.d != null)
        this.d.a(getCurrentSelection());
      return;
      if (this.c == -1 + this.a.size())
      {
        ((QuadOptionSelector.OptionPair)this.a.get(this.c)).a.setBackgroundResource(2130838914);
        continue;
      }
      ((QuadOptionSelector.OptionPair)this.a.get(this.c)).a.setBackgroundResource(2130838912);
    }
  }

  public void setOnOptionSelectedListener(QuadOptionSelector.OnOptionSelectedListener paramOnOptionSelectedListener)
  {
    this.d = paramOnOptionSelectedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.QuadOptionSelector
 * JD-Core Version:    0.6.0
 */