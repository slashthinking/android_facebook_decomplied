package com.facebook.katana.activity.places;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.Toaster;
import java.util.Collection;

class SelectAtTagActivity$10
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Collection localCollection = SelectAtTagActivity.s(this.a).a();
    if (localCollection.size() == 0)
      Toaster.a(this.a, 2131363346);
    while (true)
    {
      return;
      SelectAtTagActivity.SuggestEditsDialogFragment.a(localCollection).a(this.a.g(), "suggest_edits_frag");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.10
 * JD-Core Version:    0.6.0
 */