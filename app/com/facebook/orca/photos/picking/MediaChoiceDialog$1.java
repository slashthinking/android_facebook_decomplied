package com.facebook.orca.photos.picking;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class MediaChoiceDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Iterator localIterator = MediaChoiceDialog.a(this.a).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramView != localEntry.getValue())
        continue;
      MediaChoiceDialog.a(this.a, MediaChoiceDialog.ButtonOption.access$200((MediaChoiceDialog.ButtonOption)localEntry.getKey()));
    }
    if (MediaChoiceDialog.b(this.a) == null)
      MediaChoiceDialog.a(this.a, MediaChoiceDialog.Result.CANCEL);
    this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.MediaChoiceDialog.1
 * JD-Core Version:    0.6.0
 */