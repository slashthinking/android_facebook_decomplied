package com.facebook.katana.activity.places;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.service.method.PlaceSuggestions;
import java.util.ArrayList;

class SelectAtTagActivity$SuggestEditsDialogFragment$3 extends AlertDialogs.MenuOption
{
  public int a()
  {
    return 2131363348;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SelectAtTagActivity localSelectAtTagActivity = (SelectAtTagActivity)this.b.n();
    SelectAtTagActivity.a(localSelectAtTagActivity, true);
    SelectAtTagActivity.a(localSelectAtTagActivity, ProgressDialogFragment.a(2131362850, true, false));
    SelectAtTagActivity.h(localSelectAtTagActivity).a(localSelectAtTagActivity.g(), null);
    PlaceSuggestions localPlaceSuggestions = PlaceSuggestions.a(localSelectAtTagActivity, (FacebookPlace)this.a.get(0));
    if (localPlaceSuggestions == null)
      localSelectAtTagActivity.finish();
    while (true)
    {
      return;
      localPlaceSuggestions.a(this.a);
      SelectAtTagActivity.c(localSelectAtTagActivity, localPlaceSuggestions.i());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.SuggestEditsDialogFragment.3
 * JD-Core Version:    0.6.0
 */