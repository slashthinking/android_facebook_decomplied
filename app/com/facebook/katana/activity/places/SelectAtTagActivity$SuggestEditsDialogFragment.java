package com.facebook.katana.activity.places;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.service.method.PlacesFlag.FlagType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SelectAtTagActivity$SuggestEditsDialogFragment extends DialogFragment
{
  private Dialog a(FacebookPlace paramFacebookPlace)
  {
    AlertDialogs.MenuOption[] arrayOfMenuOption = new AlertDialogs.MenuOption[4];
    arrayOfMenuOption[0] = new SelectAtTagActivity.SuggestEditsDialogFragment.1(this, paramFacebookPlace);
    arrayOfMenuOption[1] = new SelectAtTagActivity.SuggestEditsDialogFragment.2(this);
    arrayOfMenuOption[2] = new SelectAtTagActivity.SuggestEditsDialogFragment.PlacesFlagMenuOption(this, 2131363349, PlacesFlag.FlagType.OFFENSIVE, Arrays.asList(new FacebookPlace[] { paramFacebookPlace }));
    arrayOfMenuOption[3] = new SelectAtTagActivity.SuggestEditsDialogFragment.PlacesFlagMenuOption(this, 2131363350, PlacesFlag.FlagType.NOT_PUBLIC, Arrays.asList(new FacebookPlace[] { paramFacebookPlace }));
    return AlertDialogs.a(n(), 0, arrayOfMenuOption, false);
  }

  private Dialog a(ArrayList<FacebookPlace> paramArrayList)
  {
    AlertDialogs.MenuOption[] arrayOfMenuOption = new AlertDialogs.MenuOption[3];
    arrayOfMenuOption[0] = new SelectAtTagActivity.SuggestEditsDialogFragment.3(this, paramArrayList);
    arrayOfMenuOption[1] = new SelectAtTagActivity.SuggestEditsDialogFragment.PlacesFlagMenuOption(this, 2131363349, PlacesFlag.FlagType.OFFENSIVE, paramArrayList);
    arrayOfMenuOption[2] = new SelectAtTagActivity.SuggestEditsDialogFragment.PlacesFlagMenuOption(this, 2131363351, PlacesFlag.FlagType.NOT_PUBLIC, paramArrayList);
    return AlertDialogs.a(n(), 0, arrayOfMenuOption, false);
  }

  public static SuggestEditsDialogFragment a(Collection<FacebookPlace> paramCollection)
  {
    SuggestEditsDialogFragment localSuggestEditsDialogFragment = new SuggestEditsDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("suggested_places_list", Lists.a(paramCollection));
    localSuggestEditsDialogFragment.f(localBundle);
    return localSuggestEditsDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    ArrayList localArrayList = m().getParcelableArrayList("suggested_places_list");
    if (localArrayList.size() == 1);
    for (Dialog localDialog = a((FacebookPlace)localArrayList.get(0)); ; localDialog = a(localArrayList))
      return localDialog;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.SuggestEditsDialogFragment
 * JD-Core Version:    0.6.0
 */