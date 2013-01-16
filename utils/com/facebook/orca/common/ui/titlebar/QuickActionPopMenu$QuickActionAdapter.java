package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

class QuickActionPopMenu$QuickActionAdapter extends ArrayAdapter<TitleBarQuickActionItem>
{
  private final Context b;
  private final List<TitleBarQuickActionItem> c;

  public QuickActionPopMenu$QuickActionAdapter(Context paramContext, List<TitleBarQuickActionItem> paramList)
  {
    super(paramList, 2130903395, localList);
    this.b = paramList;
    this.c = localList;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903395, paramViewGroup, false);
    TextView localTextView = (TextView)localView.findViewById(2131297420);
    TitleBarQuickActionItem localTitleBarQuickActionItem = (TitleBarQuickActionItem)this.c.get(paramInt);
    localTextView.setText(localTitleBarQuickActionItem.a());
    localView.setTag(localTitleBarQuickActionItem);
    return localView;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.QuickActionPopMenu.QuickActionAdapter
 * JD-Core Version:    0.6.2
 */