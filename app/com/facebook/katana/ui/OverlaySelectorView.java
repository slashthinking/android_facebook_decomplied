package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;

public class OverlaySelectorView extends LinearLayout
{
  private Context a;
  private SectionedListView b;

  public OverlaySelectorView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OverlaySelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundColor(-2147483648);
    setOrientation(1);
    this.a = paramContext;
    View.inflate(this.a, 2130903449, this);
    this.b = ((SectionedListView)findViewById(2131297584));
  }

  public void setOnFillerClickListener(View.OnClickListener paramOnClickListener)
  {
    findViewById(2131297583).setOnClickListener(paramOnClickListener);
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.b.setOnItemClickListener(paramOnItemClickListener);
  }

  public void setSectionedListAdapter(SectionedListAdapter paramSectionedListAdapter)
  {
    this.b.setSectionedListAdapter(paramSectionedListAdapter);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.OverlaySelectorView
 * JD-Core Version:    0.6.0
 */