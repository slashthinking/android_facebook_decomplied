package com.facebook.katana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class AlertDialogs$AlertDialogListAdapter extends ArrayAdapter<AlertDialogs.MenuOption>
{
  private Context a;
  private int b;
  private List<AlertDialogs.MenuOption> c;
  private LayoutInflater d;

  public AlertDialogs$AlertDialogListAdapter(Context paramContext, int paramInt, List<AlertDialogs.MenuOption> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramList;
    this.d = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AlertDialogs.AlertDialogListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = this.d.inflate(this.b, paramViewGroup, false);
      localViewHolder = new AlertDialogs.AlertDialogListAdapter.ViewHolder(null);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131297060));
      localViewHolder.b = ((TextView)paramView.findViewById(2131297061));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      AlertDialogs.MenuOption localMenuOption = (AlertDialogs.MenuOption)this.c.get(paramInt);
      localViewHolder.a.setImageResource(localMenuOption.b());
      localViewHolder.b.setText(localMenuOption.a());
      return paramView;
      localViewHolder = (AlertDialogs.AlertDialogListAdapter.ViewHolder)paramView.getTag();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.AlertDialogs.AlertDialogListAdapter
 * JD-Core Version:    0.6.0
 */