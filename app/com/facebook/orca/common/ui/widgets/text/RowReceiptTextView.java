package com.facebook.orca.common.ui.widgets.text;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.VariableTextLayoutComputer;
import com.facebook.widget.VariableTextLayoutView;

public class RowReceiptTextView extends VariableTextLayoutView<RowReceiptTextView.Data>
{
  private RowReceiptTextViewComputer a;

  public RowReceiptTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public RowReceiptTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public RowReceiptTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private void b()
  {
    this.a = ((RowReceiptTextViewComputer)FbInjector.a(getContext()).a(RowReceiptTextViewComputer.class));
  }

  protected VariableTextLayoutComputer<RowReceiptTextView.Data> getVariableTextLayoutComputer()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.RowReceiptTextView
 * JD-Core Version:    0.6.0
 */