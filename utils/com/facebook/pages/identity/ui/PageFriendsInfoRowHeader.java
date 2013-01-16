package com.facebook.pages.identity.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class PageFriendsInfoRowHeader extends CustomViewGroup
{
  private final TextView a;

  public PageFriendsInfoRowHeader(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageFriendsInfoRowHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public PageFriendsInfoRowHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903457);
    this.a = ((TextView)findViewById(2131297595));
  }

  public void setHeader(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageFriendsInfoRowHeader
 * JD-Core Version:    0.6.2
 */