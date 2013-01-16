package com.facebook.timeline.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.R.styleable;

public class TimelineFriendMenuItem extends RelativeLayout
{
  private CheckBox a;

  public TimelineFriendMenuItem(Context paramContext)
  {
    this(paramContext, null);
  }

  public TimelineFriendMenuItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903585, this, true);
    this.a = ((CheckBox)findViewById(2131297886));
    setOnClickListener(new TimelineFriendMenuItem.1(this));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TimelineFriendMenuItem);
    setText(localTypedArray.getString(0));
    setHasCheckbox(localTypedArray.getBoolean(1, true));
    setChecked(localTypedArray.getBoolean(2, false));
    localTypedArray.recycle();
  }

  public static TimelineFriendMenuItem a(Context paramContext, ViewGroup paramViewGroup)
  {
    return (TimelineFriendMenuItem)LayoutInflater.from(paramContext).inflate(2130903586, paramViewGroup, false);
  }

  public boolean a()
  {
    return this.a.isChecked();
  }

  public void setChecked(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }

  public void setHasCheckbox(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.a;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localCheckBox.setVisibility(i);
      return;
    }
  }

  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a.setOnCheckedChangeListener(paramOnCheckedChangeListener);
  }

  public void setText(String paramString)
  {
    ((TextView)findViewById(2131297885)).setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendMenuItem
 * JD-Core Version:    0.6.0
 */