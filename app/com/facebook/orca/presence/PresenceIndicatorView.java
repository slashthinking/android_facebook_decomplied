package com.facebook.orca.presence;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.widget.CustomViewGroup;

public class PresenceIndicatorView extends CustomViewGroup
{
  private final TextView a;
  private final ImageView b;
  private int c;
  private PresenceIndicatorView.PresenceType d = PresenceIndicatorView.PresenceType.NONE;
  private String e;
  private boolean f = true;

  public PresenceIndicatorView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PresenceIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PresenceIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903393);
    this.a = ((TextView)getView(2131297407));
    this.b = ((ImageView)getView(2131297406));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PresenceIndicatorView);
    if (localTypedArray.getInteger(1, 0) == 1)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
      localViewGroup.removeView(this.a);
      localViewGroup.addView(this.a, 0);
    }
    int i = localTypedArray.getColor(0, -1);
    if (i == -1)
      i = getResources().getColor(2131165409);
    setTextColor(i);
    localTypedArray.recycle();
  }

  private void a()
  {
    this.a.setVisibility(8);
    if (this.d == PresenceIndicatorView.PresenceType.ONLINE)
      a(2130838693);
    while (true)
    {
      return;
      if (this.d == PresenceIndicatorView.PresenceType.PUSHABLE)
      {
        a(2130838667);
        this.b.setVisibility(0);
        if (StringUtil.a(this.e))
          continue;
        this.a.setText(this.e);
        this.a.setVisibility(0);
        continue;
      }
      this.b.setVisibility(4);
    }
  }

  private void a(int paramInt)
  {
    if (this.f)
    {
      this.b.setImageResource(paramInt);
      this.b.setVisibility(0);
    }
    while (true)
    {
      return;
      this.b.setVisibility(4);
    }
  }

  public int getTextColor()
  {
    return this.c;
  }

  public void setShowIcon(boolean paramBoolean)
  {
    this.f = paramBoolean;
    a();
  }

  public void setStatus(PresenceIndicatorView.PresenceType paramPresenceType)
  {
    setStatus(paramPresenceType, null);
  }

  public void setStatus(PresenceIndicatorView.PresenceType paramPresenceType, String paramString)
  {
    this.d = paramPresenceType;
    this.e = paramString;
    a();
  }

  public void setTextColor(int paramInt)
  {
    this.c = paramInt;
    this.a.setTextColor(paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceIndicatorView
 * JD-Core Version:    0.6.0
 */