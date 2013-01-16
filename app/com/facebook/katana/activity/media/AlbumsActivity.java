package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.ProfileFacebookListActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.service.method.FqlGetTaggedUserAlbum;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;
import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity extends ProfileFacebookListActivity
  implements AdapterView.OnItemClickListener, AnalyticsActivity, CustomMenuActivity
{
  private FacebookAlbum A;
  private String B;
  private final String t = AlbumsActivity.class.getSimpleName();
  private AppSession u;
  private AppSessionListener v;
  private AlbumsAdapter y;
  private long z;

  public static Intent a(Context paramContext)
  {
    AppSession localAppSession = AppSession.a(paramContext, false);
    Intent localIntent;
    if (localAppSession == null)
      localIntent = null;
    while (true)
    {
      return localIntent;
      localIntent = new Intent(paramContext, AlbumsActivity.class);
      localIntent.setData(ContentUris.withAppendedId(PhotosProvider.g, localAppSession.b().userId));
      localIntent.putExtra("extra_exclude_read_only", true);
      localIntent.setAction("android.intent.action.PICK");
    }
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      return;
      findViewById(2131296644).setVisibility(0);
      findViewById(2131296645).setVisibility(8);
    }
  }

  private void i()
  {
    this.w.a(this.t);
    this.u.a(this, this.z, null);
    v();
    d(true);
  }

  private void p()
  {
    ((TextView)findViewById(2131296644)).setText(2131362821);
  }

  private void q()
  {
    if (m().getAdapter().isEmpty())
      findViewById(2131296358).setVisibility(0);
    while (true)
    {
      return;
      findViewById(2131296358).setVisibility(8);
    }
  }

  public void K()
  {
    if (!this.u.a(this.z));
    for (boolean bool = true; ; bool = false)
    {
      b(1, bool);
      return;
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.h;
  }

  public void a(Bundle paramBundle)
  {
    this.s = false;
    super.a(paramBundle);
    setContentView(2130903046);
    this.u = AppSession.a(this, true);
    Uri localUri = getIntent().getData();
    if (localUri != null)
      if (localUri.getScheme().equals("content"))
      {
        this.z = Long.parseLong(localUri.getLastPathSegment());
        if (paramBundle != null)
        {
          String str = paramBundle.getString("state_album_id");
          if (str != null)
            this.A = FacebookAlbum.a(this, str);
        }
      }
    while (true)
    {
      if (this.z == this.u.b().userId)
        a(TitleBarButtonSpec.newBuilder().b(2130837507).i());
      l();
      j();
      ListView localListView = m();
      ArrayList localArrayList = new ArrayList();
      if (getIntent().getBooleanExtra("extra_exclude_read_only", false))
        localArrayList.add(new StringBuilder().append("type").append("<>'").append("profile").append("'"));
      if (getIntent().getBooleanExtra("extra_exclude_empty", false))
        localArrayList.add(new StringBuilder().append("size").append("> 0"));
      this.y = new AlbumsAdapter(this, localUri, StringUtils.a(" AND ", new Object[] { localArrayList }), this.u);
      if (getParent() != null)
        findViewById(2131296299).setVisibility(8);
      p();
      this.v = new AlbumsActivity.AlbumsAppSessionListener(this, null);
      localListView.setOnItemClickListener(this);
      localListView.setOnCreateContextMenuListener(this);
      return;
      this.z = this.u.b().userId;
      localUri = Uri.withAppendedPath(PhotosProvider.g, String.valueOf(this.z));
    }
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    switch (paramCustomMenuItem.c())
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      i();
      continue;
      Intent localIntent = new Intent(this, CreateEditAlbumActivity.class);
      localIntent.setAction("android.intent.action.INSERT");
      startActivity(localIntent);
    }
  }

  public void d()
  {
    a(this);
    a(1, 2131363208, 2130838829);
    if (this.z == this.u.b().userId)
      a(2, 2131362815, 2130838822);
  }

  public void j()
  {
    if (getIntent().getBooleanExtra("within_tab", false))
      super.j();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    try
    {
      AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
      Cursor localCursor = (Cursor)this.y.getItem(e(localAdapterContextMenuInfo.position));
      str = this.y.a(localCursor);
      switch (paramMenuItem.getItemId())
      {
      default:
        i = 1;
        return i;
      case 4:
      case 5:
      }
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
      {
        String str;
        int i = 0;
        continue;
        Intent localIntent = new Intent(this, CreateEditAlbumActivity.class);
        localIntent.setAction("android.intent.action.EDIT");
        localIntent.setData(Uri.withAppendedPath(PhotosProvider.f, str));
        startActivity(localIntent);
        continue;
        this.A = FacebookAlbum.a(this, str);
        showDialog(2);
      }
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    try
    {
      AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      Cursor localCursor = (Cursor)this.y.getItem(e(localAdapterContextMenuInfo.position));
      if (FqlGetTaggedUserAlbum.a(this.y.a(localCursor), this.y.a()));
      while (true)
      {
        label49: return;
        paramContextMenu.setHeaderTitle(this.y.c(localCursor));
        if ((this.z != this.u.b().userId) || ("android.intent.action.PICK".equals(getIntent().getAction())))
          continue;
        paramContextMenu.add(0, 4, 0, 2131362820);
        if (this.y.d(localCursor) != 0)
          continue;
        paramContextMenu.add(0, 5, 0, 2131362816);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      break label49;
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      AlbumsActivity.1 local1 = new AlbumsActivity.1(this);
      localObject = AlertDialogs.a(this, this.A.d(), 17301543, getString(2131362817), getString(2131363280), local1, getString(2131363016), null, null, true);
      continue;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131362819));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Cursor localCursor = (Cursor)this.y.getItem(e(paramInt));
    if ("android.intent.action.PICK".equals(getIntent().getAction()))
    {
      Intent localIntent1 = new Intent();
      localIntent1.setData(Uri.withAppendedPath(PhotosProvider.f, this.y.a(localCursor)));
      setResult(-1, localIntent1);
      finish();
      return;
    }
    if (FqlGetTaggedUserAlbum.a(this.y.a(localCursor), this.y.a()));
    for (Intent localIntent2 = PhotoSetActivity.b(this, this.y.a()); ; localIntent2 = PhotoSetActivity.a(this, this.y.b(localCursor)))
    {
      startActivity(localIntent2);
      break;
    }
  }

  protected void onPause()
  {
    super.onPause();
    if (this.u != null)
      this.u.b(this.v);
  }

  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default:
      super.onPrepareDialog(paramInt, paramDialog);
    case 2:
    }
    while (true)
    {
      return;
      paramDialog.setTitle(this.A.d());
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.u = AppSession.b(this, true);
    if (this.u == null)
      LoginActivity.c(this);
    while (true)
    {
      return;
      if ((this.B != null) && (!this.u.a(this.B)))
      {
        removeDialog(3);
        this.B = null;
      }
      this.u.a(this.v);
      m().setAdapter(this.y);
      q();
      if (!this.u.a(this.z))
      {
        i();
        continue;
      }
      d(true);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.A != null)
      paramBundle.putString("state_album_id", this.A.a());
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    startActivity(CameraActivity.a(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AlbumsActivity
 * JD-Core Version:    0.6.0
 */