package com.facebook.orca.threadview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.threads.ThreadSummary;

public class ThreadViewTitleHelper
{
  private final Context a;
  private ThreadTitleView b;
  private ThreadTitleHeader c;
  private FbTitleBar d;

  public ThreadViewTitleHelper(Context paramContext)
  {
    this.a = paramContext;
  }

  private int a(ViewGroup paramViewGroup, View paramView)
  {
    return 1 + paramViewGroup.indexOfChild(paramView);
  }

  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramViewGroup.getChildCount() > paramInt) && ((paramViewGroup.getChildAt(paramInt) instanceof ThreadTitleHeader)))
      paramViewGroup.removeViewAt(paramInt);
  }

  public void a()
  {
    if ((this.d != null) && (!this.d.a()))
    {
      View localView = (View)this.d;
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      a(localViewGroup, a(localViewGroup, localView));
    }
  }

  public void a(FbTitleBar paramFbTitleBar)
  {
    this.d = paramFbTitleBar;
    if (paramFbTitleBar.a())
    {
      this.b = new ThreadTitleView(this.a);
      paramFbTitleBar.setCustomTitleView(this.b);
    }
    while (true)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.c = new ThreadTitleHeader(this.a);
      this.c.setLayoutParams(localLayoutParams);
      View localView = (View)paramFbTitleBar;
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      int i = a(localViewGroup, localView);
      a(localViewGroup, i);
      localViewGroup.addView(this.c, i);
    }
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    if (this.b != null)
      this.b.setThreadSummary(paramThreadSummary);
    while (true)
    {
      return;
      if (this.c != null)
      {
        this.c.setThreadSummary(paramThreadSummary);
        continue;
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    if ((this.d != null) && (this.d.a()))
      this.b.a(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewTitleHelper
 * JD-Core Version:    0.6.0
 */