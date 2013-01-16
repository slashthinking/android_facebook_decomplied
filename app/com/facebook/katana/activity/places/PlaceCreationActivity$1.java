package com.facebook.katana.activity.places;

import android.app.AlertDialog.Builder;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.debug.Assert;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookGeolocation;
import com.facebook.katana.service.method.PlacesCreateException;
import com.facebook.katana.service.method.PlacesCreateException.SimilarPlace;
import com.facebook.katana.util.StringUtils;
import java.util.List;

class PlaceCreationActivity$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookGeolocation paramFacebookGeolocation)
  {
    if ((paramFacebookGeolocation == null) || (paramInt != 200) || (paramString1 == null) || (!paramString1.equals(PlaceCreationActivity.a(this.a))));
    while (true)
    {
      return;
      if ((PlaceCreationActivity.c(this.a).equals(PlaceCreationActivity.b(this.a))) && (PlaceCreationActivity.e(this.a).equals(PlaceCreationActivity.d(this.a))))
      {
        if (paramFacebookGeolocation.city != null)
        {
          PlaceCreationActivity.a(this.a, StringUtils.e(paramFacebookGeolocation.city.toLowerCase()));
          PlaceCreationActivity.f(this.a).setText(PlaceCreationActivity.c(this.a));
        }
        if (paramFacebookGeolocation.streetName == null)
          continue;
        PlaceCreationActivity.b(this.a, StringUtils.e(paramFacebookGeolocation.streetName.toLowerCase()));
        PlaceCreationActivity.g(this.a).setText(PlaceCreationActivity.e(this.a));
        continue;
      }
    }
  }

  public void c(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, long paramLong)
  {
    if ((paramString1 == null) || (!paramString1.equals(PlaceCreationActivity.h(this.a))));
    label658: 
    while (true)
    {
      return;
      Assert.a(PlaceCreationActivity.State.PROCESSING, PlaceCreationActivity.i(this.a));
      PlaceCreationActivity.a(this.a, PlaceCreationActivity.State.NONE);
      PlaceCreationActivity.j(this.a).a();
      String str1 = PlaceCreationActivity.k(this.a);
      if (paramInt == 200)
      {
        PlaceCreationActivity.a(this.a, paramLong, str1);
        continue;
      }
      PlacesCreateException localPlacesCreateException;
      PlacesCreateException.SimilarPlace localSimilarPlace;
      AlertDialog.Builder localBuilder2;
      label225: int i;
      if ((paramException instanceof PlacesCreateException))
      {
        localPlacesCreateException = (PlacesCreateException)paramException;
        if ((localPlacesCreateException.a() == 2406) && (localPlacesCreateException.d().size() > 0))
        {
          localSimilarPlace = (PlacesCreateException.SimilarPlace)localPlacesCreateException.d().get(0);
          localBuilder2 = new AlertDialog.Builder(this.a);
          localBuilder2.setCancelable(false);
          localBuilder2.setPositiveButton(2131363336, new PlaceCreationActivity.1.1(this, localSimilarPlace));
          if (str1.compareToIgnoreCase(localSimilarPlace.mName) == 0)
          {
            PlaceCreationActivity localPlaceCreationActivity2 = this.a;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = localSimilarPlace.mName;
            localBuilder2.setMessage(localPlaceCreationActivity2.getString(2131363310, arrayOfObject2));
            localBuilder2.show();
            i = 1;
          }
        }
      }
      while (true)
      {
        if (i != 0)
          break label658;
        Log.a(PlaceCreationActivity.j(), "Exception when adding place", paramException);
        Toaster.a(this.a, 2131363306);
        break;
        PlaceCreationActivity localPlaceCreationActivity1 = this.a;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = localSimilarPlace.mName;
        arrayOfObject1[1] = str1;
        localBuilder2.setMessage(localPlaceCreationActivity1.getString(2131363311, arrayOfObject1));
        localBuilder2.setNeutralButton(2131363337, new PlaceCreationActivity.1.2(this, localSimilarPlace));
        break label225;
        if (localPlacesCreateException.a() == 2409)
        {
          String str2 = localPlacesCreateException.e();
          String str3 = localPlacesCreateException.f();
          AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this.a);
          String str4;
          if (str2 == null)
          {
            if ("invalid_chars".equals(str3))
              str4 = this.a.getString(2131363314);
            while (true)
            {
              localBuilder1.setPositiveButton(2131361888, null);
              localBuilder1.setMessage(str4);
              localBuilder1.show();
              i = 1;
              break;
              if ("blacklist".equals(str3))
              {
                str4 = this.a.getString(2131363316);
                continue;
              }
              if ("caps".equals(str3))
              {
                str4 = this.a.getString(2131363318);
                continue;
              }
              str4 = this.a.getString(2131363312);
            }
          }
          if ("invalid_chars".equals(str3))
            str4 = this.a.getString(2131363315, new Object[] { str2 });
          while (true)
          {
            localBuilder1.setPositiveButton(2131361888, new PlaceCreationActivity.1.3(this, str2));
            localBuilder1.setNegativeButton(2131362848, null);
            break;
            if ("blacklist".equals(str3))
            {
              str4 = this.a.getString(2131363317, new Object[] { str2 });
              continue;
            }
            if ("caps".equals(str3))
            {
              str4 = this.a.getString(2131363319, new Object[] { str2 });
              continue;
            }
            str4 = this.a.getString(2131363313, new Object[] { str2 });
          }
        }
        if (localPlacesCreateException.a() == 2408)
        {
          Toaster.a(this.a, 2131363307);
          i = 1;
          continue;
        }
        i = 0;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity.1
 * JD-Core Version:    0.6.0
 */