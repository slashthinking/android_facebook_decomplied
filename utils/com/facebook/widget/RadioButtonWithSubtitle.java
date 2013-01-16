package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.R.styleable;

public class RadioButtonWithSubtitle extends CustomLinearLayout
  implements Checkable
{
  private final RadioButton a;
  private final TextView b;
  private final TextView c;
  private final ViewGroup d;
  private RadioButtonWithSubtitle.OnCheckedChangeListener e;

  public RadioButtonWithSubtitle(Context paramContext)
  {
    this(paramContext, null);
  }

  public RadioButtonWithSubtitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903535);
    setOrientation(0);
    this.a = ((RadioButton)b(2131297798));
    this.d = ((ViewGroup)b(2131297799));
    this.b = ((TextView)b(2131297800));
    this.c = ((TextView)b(2131297801));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RadioButtonWithSubtitle);
    String str1 = localTypedArray.getString(0);
    String str2 = localTypedArray.getString(1);
    this.b.setText(str1);
    this.c.setText(str2);
    this.d.setOnClickListener(new RadioButtonWithSubtitle.1(this));
    this.a.setOnCheckedChangeListener(new RadioButtonWithSubtitle.2(this));
  }

  public boolean isChecked()
  {
    return this.a.isChecked();
  }

  public void setChecked(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }

  public void setOnCheckedChangeListener(RadioButtonWithSubtitle.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.e = paramOnCheckedChangeListener;
  }

  public void toggle()
  {
    this.a.toggle();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.RadioButtonWithSubtitle
 * JD-Core Version:    0.6.2
 */