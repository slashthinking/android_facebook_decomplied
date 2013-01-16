package com.facebook.orca.prefs;

import android.net.Uri;
import android.provider.BaseColumns;

final class OrcaSharedPreferencesContract$PrefColumns
  implements BaseColumns
{
  final Uri a;

  OrcaSharedPreferencesContract$PrefColumns(Uri paramUri)
  {
    this.a = Uri.withAppendedPath(paramUri, "prefs");
  }

  public Uri a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesContract.PrefColumns
 * JD-Core Version:    0.6.0
 */