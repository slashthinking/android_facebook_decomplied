package com.facebook.katana.activity.places;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;
import com.facebook.katana.service.method.PlacesFlag;
import com.facebook.katana.service.method.PlacesFlag.FlagType;
import java.util.List;

class SelectAtTagActivity$SuggestEditsDialogFragment$PlacesFlagMenuOption extends AlertDialogs.MenuOption
{
  private int b;
  private PlacesFlag.FlagType c;
  private List<FacebookPlace> d;

  public SelectAtTagActivity$SuggestEditsDialogFragment$PlacesFlagMenuOption(int paramInt, PlacesFlag.FlagType paramFlagType, List<FacebookPlace> paramList)
  {
    this.b = paramFlagType;
    this.c = paramList;
    Object localObject;
    this.d = localObject;
  }

  public int a()
  {
    return this.b;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SelectAtTagActivity localSelectAtTagActivity = (SelectAtTagActivity)this.a.n();
    SelectAtTagActivity.a(localSelectAtTagActivity, true);
    SelectAtTagActivity.a(localSelectAtTagActivity, ProgressDialogFragment.a(2131362850, true, false));
    SelectAtTagActivity.h(localSelectAtTagActivity).a(localSelectAtTagActivity.g(), null);
    SelectAtTagActivity.b(localSelectAtTagActivity, PlacesFlag.a(SelectAtTagActivity.t(localSelectAtTagActivity), this.a.n(), this.d, this.c));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.SuggestEditsDialogFragment.PlacesFlagMenuOption
 * JD-Core Version:    0.6.0
 */