package com.karmascience.gifts.views;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

class ProductsView$RecipientCantReceiveAlcoholDialogFragment extends DialogFragment
{
  private final String Z;

  private ProductsView$RecipientCantReceiveAlcoholDialogFragment(ProductsView paramProductsView, String paramString)
  {
    this.Z = CommonViewUtils.d(paramString);
  }

  public Dialog c(Bundle paramBundle)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(n());
    localBuilder.setTitle(2131362249);
    Resources localResources = n().getResources();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.Z;
    localBuilder.setMessage(localResources.getString(2131362250, arrayOfObject));
    localBuilder.setPositiveButton(2131362252, new ProductsView.RecipientCantReceiveAlcoholDialogFragment.1(this));
    localBuilder.setNegativeButton(2131362251, new ProductsView.RecipientCantReceiveAlcoholDialogFragment.2(this));
    return localBuilder.create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.RecipientCantReceiveAlcoholDialogFragment
 * JD-Core Version:    0.6.0
 */