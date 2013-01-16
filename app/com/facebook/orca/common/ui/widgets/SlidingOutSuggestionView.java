package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.widget.animatablelistview.AnimatingItemView;

public class SlidingOutSuggestionView extends SlidingOutSuggestionViewBase
{
  private final TextView a;
  private final View b;
  private final View c;
  private final Button d;
  private int e = 0;

  public SlidingOutSuggestionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingOutSuggestionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingOutSuggestionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903401);
    setContainer((AnimatingItemView)b(2131297430));
    this.a = ((TextView)b(2131297432));
    this.b = b(2131297431);
    this.c = b(2131297434);
    this.d = ((Button)b(2131297433));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlidingOutSuggestionView);
    int i = localTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = localTypedArray.getIndex(j);
      switch (k)
      {
      case 1:
      default:
      case 0:
      case 2:
      case 3:
      }
      while (true)
      {
        j++;
        break;
        setDividerPosition(localTypedArray.getInt(k, this.e));
        continue;
        setSuggestionText(localTypedArray.getText(k));
        continue;
        setButtonText(localTypedArray.getText(k));
      }
    }
    localTypedArray.recycle();
  }

  public void a()
  {
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public boolean b()
  {
    if ((0x4 & this.e) == 4);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c()
  {
    if ((0x8 & this.e) == 8);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void setButtonText(int paramInt)
  {
    this.d.setText(paramInt);
  }

  public void setButtonText(CharSequence paramCharSequence)
  {
    this.d.setText(paramCharSequence);
  }

  public void setDividerPosition(int paramInt)
  {
    this.e = paramInt;
    View localView1 = this.b;
    int i;
    View localView2;
    int j;
    if (b())
    {
      i = 0;
      localView1.setVisibility(i);
      localView2 = this.c;
      boolean bool = c();
      j = 0;
      if (!bool)
        break label58;
    }
    while (true)
    {
      localView2.setVisibility(j);
      return;
      i = 8;
      break;
      label58: j = 8;
    }
  }

  public void setOnButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }

  public void setSuggestionText(int paramInt)
  {
    this.a.setText(paramInt);
  }

  public void setSuggestionText(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView
 * JD-Core Version:    0.6.0
 */