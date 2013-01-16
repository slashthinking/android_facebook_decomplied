package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;

public class LabelValueRowView extends CustomRelativeLayout
{
  private final TextView a;
  private final TextView b;

  public LabelValueRowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LabelValueRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LabelValueRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903112);
    setClickable(true);
    if (Build.VERSION.SDK_INT >= 14)
      setBackgroundResource(2130838636);
    while (true)
    {
      this.b = ((TextView)b(2131296586));
      this.a = ((TextView)b(2131296585));
      return;
      setBackgroundResource(17301602);
    }
  }

  public void setLabelText(int paramInt)
  {
    this.a.setText(paramInt);
  }

  public void setLabelText(String paramString)
  {
    this.a.setText(paramString);
  }

  public void setValueText(int paramInt)
  {
    this.b.setText(paramInt);
  }

  public void setValueText(String paramString)
  {
    this.b.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.LabelValueRowView
 * JD-Core Version:    0.6.0
 */