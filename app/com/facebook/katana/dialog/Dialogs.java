package com.facebook.katana.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.katana.binding.AppSession;

public class Dialogs
{
  public static Dialog a(Context paramContext, long paramLong, Dialogs.AddFriendListener paramAddFriendListener)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130903280, null);
    localBuilder.setView(localView);
    localBuilder.setTitle(2131363064);
    TextView localTextView = (TextView)localView.findViewById(2131297098);
    Dialogs.1 local1 = new Dialogs.1(localTextView, AppSession.a(paramContext, false), paramContext, paramLong, paramAddFriendListener);
    localTextView.setOnEditorActionListener(new Dialogs.2(local1));
    localBuilder.setPositiveButton(paramContext.getString(2131362073), new Dialogs.3(local1));
    return localBuilder.create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.Dialogs
 * JD-Core Version:    0.6.0
 */