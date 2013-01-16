package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;

public class SimpleVariableTextLayoutView extends VariableTextLayoutView<String>
{
  private final SimpleVariableTextLayoutView.Computer a = new SimpleVariableTextLayoutView.Computer(null);

  public SimpleVariableTextLayoutView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public SimpleVariableTextLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SimpleVariableTextLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected VariableTextLayoutComputer<String> getVariableTextLayoutComputer()
  {
    return this.a;
  }

  public void setText(String paramString)
  {
    setData(paramString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.SimpleVariableTextLayoutView
 * JD-Core Version:    0.6.2
 */