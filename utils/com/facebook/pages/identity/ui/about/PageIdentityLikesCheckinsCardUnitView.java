package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;

public class PageIdentityLikesCheckinsCardUnitView extends CustomLinearLayout
{
  private final Resources a;
  private final TextView b;
  private final TextView c;
  private final TextView d;
  private final TextView e;

  public PageIdentityLikesCheckinsCardUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityLikesCheckinsCardUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903460);
    this.a = ((Resources)getInjector().a(Resources.class));
    this.b = ((TextView)findViewById(2131297604));
    this.c = ((TextView)findViewById(2131297605));
    this.d = ((TextView)findViewById(2131297606));
    this.e = ((TextView)findViewById(2131297607));
  }

  public void setCheckinsCount(int paramInt)
  {
    TextView localTextView = this.d;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localTextView.setText(StringLocaleUtil.b("%,d", arrayOfObject));
    this.e.setText(this.a.getQuantityString(2131427335, paramInt));
  }

  public void setLikesCount(int paramInt)
  {
    TextView localTextView = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localTextView.setText(StringLocaleUtil.b("%,d", arrayOfObject));
    this.c.setText(this.a.getQuantityString(2131427334, paramInt));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityLikesCheckinsCardUnitView
 * JD-Core Version:    0.6.2
 */