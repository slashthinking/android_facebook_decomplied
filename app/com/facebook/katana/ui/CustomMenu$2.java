package com.facebook.katana.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;
import java.util.Iterator;
import java.util.List;

class CustomMenu$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    CustomMenu.a(this.b, this.a);
    Iterator localIterator1 = CustomMenu.a(this.b).iterator();
    while (localIterator1.hasNext())
      ((CustomMenuActivity)localIterator1.next()).a(this.a);
    Iterator localIterator2 = CustomMenu.b(this.b).iterator();
    while (localIterator2.hasNext())
      ((ExportMenuToFbHostActivity)localIterator2.next()).a_(this.a.c());
    if (this.a.c() != 1006)
      this.b.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.CustomMenu.2
 * JD-Core Version:    0.6.0
 */