package com.facebook.pages.identity.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class PageRecommendationRowHeader extends CustomViewGroup
{
  private final TextView a;

  public PageRecommendationRowHeader(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageRecommendationRowHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public PageRecommendationRowHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903463);
    this.a = ((TextView)findViewById(2131297618));
  }

  public void setHeader(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationRowHeader
 * JD-Core Version:    0.6.2
 */