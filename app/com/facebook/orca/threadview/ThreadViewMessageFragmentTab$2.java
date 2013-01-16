package com.facebook.orca.threadview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ThreadViewMessageFragmentTab$2
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramAdapterView.getItemAtPosition(paramInt);
    if ((localObject instanceof RowItem))
      ThreadViewMessageFragmentTab.a(this.a, (RowItem)localObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMessageFragmentTab.2
 * JD-Core Version:    0.6.0
 */