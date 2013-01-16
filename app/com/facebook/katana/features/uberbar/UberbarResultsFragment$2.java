package com.facebook.katana.features.uberbar;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.common.util.ErrorReporting;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.facebook.ipc.data.uberbar.UberbarResult;
import java.util.List;

class UberbarResultsFragment$2
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    UberbarResultsFragment.a(this.a).hideSoftInputFromWindow(this.a.A().getWindowToken(), 0);
    Object localObject = UberbarResultsFragment.b(this.a).getItem(paramInt);
    UberbarResult localUberbarResult;
    if ((localObject instanceof UberbarResult))
    {
      localUberbarResult = (UberbarResult)localObject;
      List localList = UberbarResultsFragment.b(this.a).a();
      UberbarResultsFragment.d(this.a).a(localUberbarResult, UberbarResultsFragment.c(this.a), paramInt, localList);
      UberbarResultsFragment.d(this.a).a(UberbarResultsFragment.c(this.a));
    }
    Bundle localBundle1;
    String str1;
    switch (UberbarResultsFragment.6.a[localUberbarResult.h.ordinal()])
    {
    default:
      ErrorReporting.a(UberbarResultsFragment.b(), "Unrecognized result type: " + localUberbarResult.h);
      return;
    case 1:
      String str2 = "fb://profile/" + localUberbarResult.i;
      Bundle localBundle2 = new Bundle();
      GraphQLProfile.Builder localBuilder = new GraphQLProfile.Builder();
      localBuilder.c(localUberbarResult.g);
      localBundle2.putParcelable("gql_profile", localBuilder.b());
      localBundle1 = localBundle2;
      str1 = str2;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      UberbarResultsFragment.b(this.a.n(), str1, localBundle1);
      break;
      str1 = "fb://group/" + localUberbarResult.i;
      localBundle1 = null;
      continue;
      if (localUberbarResult.c != null)
      {
        str1 = localUberbarResult.c.toString();
        localBundle1 = null;
        continue;
      }
      str1 = localUberbarResult.d.toString();
      localBundle1 = null;
      continue;
      str1 = "fb://page/" + localUberbarResult.i;
      localBundle1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsFragment.2
 * JD-Core Version:    0.6.0
 */