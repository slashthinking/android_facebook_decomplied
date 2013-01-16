package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;

public class TextRowView extends CustomRelativeLayout
{
  private TextView a;

  public TextRowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TextRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903123);
    setClickable(true);
    if (Build.VERSION.SDK_INT >= 14)
      setBackgroundResource(2130838636);
    while (true)
    {
      this.a = ((TextView)b(2131296616));
      return;
      setBackgroundResource(17301602);
    }
  }

  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.TextRowView
 * JD-Core Version:    0.6.0
 */