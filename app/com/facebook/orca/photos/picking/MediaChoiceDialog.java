package com.facebook.orca.photos.picking;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

public class MediaChoiceDialog extends DialogFragment
{
  private String Y;
  private EnumSet<MediaChoiceDialog.ButtonOption> Z;
  private EnumMap<MediaChoiceDialog.ButtonOption, Button> aa;
  private MediaChoiceDialog.Listener ab;
  private MediaChoiceDialog.Result ac = MediaChoiceDialog.Result.CANCEL;

  public static MediaChoiceDialog a(String paramString, EnumSet<MediaChoiceDialog.ButtonOption> paramEnumSet)
  {
    MediaChoiceDialog localMediaChoiceDialog = new MediaChoiceDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString);
    localBundle.putSerializable("visibleButtons", paramEnumSet);
    localMediaChoiceDialog.f(localBundle);
    return localMediaChoiceDialog;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Dialog localDialog = c();
    Window localWindow = localDialog.getWindow();
    localWindow.setSoftInputMode(1);
    localWindow.addFlags(131072);
    localDialog.requestWindowFeature(1);
    localDialog.setCanceledOnTouchOutside(true);
    if (this.Y != null)
      localDialog.setTitle(this.Y);
    View localView = paramLayoutInflater.inflate(2130903363, paramViewGroup, false);
    MediaChoiceDialog.1 local1 = new MediaChoiceDialog.1(this);
    for (MediaChoiceDialog.ButtonOption localButtonOption2 : MediaChoiceDialog.ButtonOption.values())
    {
      Button localButton = (Button)localView.findViewById(MediaChoiceDialog.ButtonOption.access$300(localButtonOption2));
      localButton.setOnClickListener(local1);
      this.aa.put(localButtonOption2, localButton);
    }
    Iterator localIterator = this.Z.iterator();
    while (localIterator.hasNext())
    {
      MediaChoiceDialog.ButtonOption localButtonOption1 = (MediaChoiceDialog.ButtonOption)localIterator.next();
      ((Button)this.aa.get(localButtonOption1)).setVisibility(8);
    }
    return localView;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Bundle localBundle = m();
    this.Y = localBundle.getString("title");
    this.aa = new EnumMap(MediaChoiceDialog.ButtonOption.class);
    this.Z = EnumSet.complementOf((EnumSet)localBundle.getSerializable("visibleButtons"));
  }

  public void a(MediaChoiceDialog.Listener paramListener)
  {
    this.ab = paramListener;
  }

  public void g()
  {
    super.g();
    if (this.ab != null)
      this.ab.a(this.ac);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.MediaChoiceDialog
 * JD-Core Version:    0.6.0
 */