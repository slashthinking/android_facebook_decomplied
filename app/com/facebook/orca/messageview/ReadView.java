package com.facebook.orca.messageview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class ReadView extends CustomViewGroup
{
  private TextView a;
  private ImageView b;

  public ReadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ReadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ReadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setContentView(2130903375);
    this.b = ((ImageView)getView(2131297353));
    this.a = ((TextView)getView(2131297354));
  }

  public void setShowReadReceiptIcon(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }

  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.ReadView
 * JD-Core Version:    0.6.0
 */