package com.facebook.katana;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import java.util.Arrays;

public class AlertDialogs
{
  public static AlertDialog a(Context paramContext, int paramInt, AlertDialogs.MenuOption[] paramArrayOfMenuOption, boolean paramBoolean)
  {
    AlertDialogs.AlertDialogListAdapter localAlertDialogListAdapter = new AlertDialogs.AlertDialogListAdapter(paramContext, 2130903269, Arrays.asList(paramArrayOfMenuOption));
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setAdapter(localAlertDialogListAdapter, new AlertDialogs.1(paramArrayOfMenuOption));
    if (paramInt != 0)
      localBuilder.setTitle(paramInt);
    if (paramBoolean)
      localBuilder.setNegativeButton(2131362848, null);
    return localBuilder.create();
  }

  private static AlertDialog a(Context paramContext, String paramString1, int paramInt, Object paramObject, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, String paramString3, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramString1);
    if (paramInt != 0)
      localBuilder.setIcon(paramContext.getResources().getDrawable(paramInt));
    if ((paramObject instanceof String))
      localBuilder.setMessage((String)paramObject);
    while (true)
    {
      localBuilder.setPositiveButton(paramString2, paramOnClickListener1);
      localBuilder.setNegativeButton(paramString3, paramOnClickListener2);
      localBuilder.setOnCancelListener(paramOnCancelListener);
      localBuilder.setCancelable(paramBoolean);
      return localBuilder.create();
      if (!(paramObject instanceof View))
        continue;
      localBuilder.setView((View)paramObject);
    }
  }

  public static AlertDialog a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    return a(paramContext, paramString1, paramInt, paramString2, paramString3, paramOnClickListener1, paramString4, paramOnClickListener2, paramOnCancelListener, paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.AlertDialogs
 * JD-Core Version:    0.6.0
 */