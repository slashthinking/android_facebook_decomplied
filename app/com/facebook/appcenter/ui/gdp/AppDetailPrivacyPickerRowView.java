package com.facebook.appcenter.ui.gdp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appcenter.model.AppPrivacyOption;
import com.facebook.widget.CustomViewGroup;

public class AppDetailPrivacyPickerRowView extends CustomViewGroup
{
  private ImageView a;
  private TextView b;
  private ImageView c;

  public AppDetailPrivacyPickerRowView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailPrivacyPickerRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailPrivacyPickerRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903053);
    this.a = ((ImageView)getView(2131296383));
    this.b = ((TextView)getView(2131296384));
    this.c = ((ImageView)getView(2131296385));
    setSelected(false);
  }

  public void setPrivacyOption(AppPrivacyOption paramAppPrivacyOption)
  {
    this.a.setImageResource(paramAppPrivacyOption.d());
    this.b.setText(paramAppPrivacyOption.b());
  }

  public void setRowSelected(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
      this.c.setVisibility(0);
    while (true)
    {
      return;
      this.c.setVisibility(4);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.gdp.AppDetailPrivacyPickerRowView
 * JD-Core Version:    0.6.0
 */