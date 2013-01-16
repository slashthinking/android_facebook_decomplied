package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.Toaster;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.MediaUploadService;
import com.facebook.katana.service.method.FqlGetProfile;
import com.facebook.katana.ui.TagUsersAutoCompleteTextView;
import com.facebook.katana.ui.TaggableView;
import com.facebook.katana.ui.TaggableView.TaggableViewListener;
import java.io.File;
import java.util.List;

public class UploadPhotoActivity extends BaseFacebookActivity
  implements View.OnClickListener
{
  private float A;
  private float B;
  private boolean C;
  private Bitmap D;
  private AppSession n;
  private String o;
  private FacebookAlbum p;
  private boolean q;
  private boolean r = true;
  private long s;
  private long t;
  private FacebookProfile u;
  private AppSessionListener v;
  private boolean x;
  private DropdownTagUsersAdapter y;
  private TaggableView.TaggableViewListener z;

  private void a(Bitmap paramBitmap, String paramString)
  {
    this.o = paramString;
    if (this.D != null)
    {
      this.D.recycle();
      this.D = null;
    }
    this.D = paramBitmap;
    TaggableView localTaggableView = (TaggableView)findViewById(2131297931);
    localTaggableView.setImage(paramBitmap);
    if (!this.C)
    {
      new UploadPhotoActivity.FaceDetectTask(this, new Handler(), paramBitmap).start();
      this.C = true;
    }
    localTaggableView.setListener(this.z);
    findViewById(2131297928).setVisibility(8);
    findViewById(2131297931).setVisibility(0);
    ((ImageView)findViewById(2131297397)).setImageBitmap(paramBitmap);
    findViewById(2131297397).setVisibility(0);
    findViewById(2131297932).setVisibility(8);
    t().a(false);
    findViewById(2131297934).setEnabled(true);
  }

  private void a(FaceDetector.Face[] paramArrayOfFace, int paramInt1, int paramInt2)
  {
    TaggableView localTaggableView = (TaggableView)findViewById(2131297931);
    int i = paramArrayOfFace.length;
    int j = 0;
    if (j < i)
    {
      FaceDetector.Face localFace = paramArrayOfFace[j];
      if (localFace == null);
      while (true)
      {
        j++;
        break;
        if (localFace.confidence() < 0.5F)
          continue;
        PointF localPointF = new PointF();
        localFace.getMidPoint(localPointF);
        localTaggableView.a(localPointF.x / paramInt1, localPointF.y / paramInt2, localFace.eyesDistance() / paramInt1);
      }
    }
  }

  private void c(boolean paramBoolean)
  {
    TagUsersAutoCompleteTextView localTagUsersAutoCompleteTextView = (TagUsersAutoCompleteTextView)findViewById(2131297929);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView1 = findViewById(2131296666);
    View localView2 = findViewById(2131297928);
    if (paramBoolean)
    {
      localView1.setVisibility(8);
      localView2.setVisibility(0);
      localTagUsersAutoCompleteTextView.requestFocus();
      localInputMethodManager.showSoftInput(localTagUsersAutoCompleteTextView, 1);
    }
    while (true)
    {
      return;
      localView1.setVisibility(0);
      localView2.setVisibility(8);
      localTagUsersAutoCompleteTextView.clearFocus();
      localInputMethodManager.hideSoftInputFromWindow(localTagUsersAutoCompleteTextView.getWindowToken(), 1);
    }
  }

  private void i()
  {
    m();
    this.q = true;
    if (this.o != null)
    {
      t().a(true);
      new UploadPhotoActivity.LoadImageTask(this, new Handler(), this.o).start();
    }
    while (true)
    {
      this.n.a(this.v);
      return;
      String str1 = getIntent().getStringExtra("photo_uri");
      if (str1 != null);
      for (Uri localUri = Uri.parse(str1); ; localUri = (Uri)getIntent().getExtras().getParcelable("android.intent.extra.STREAM"))
      {
        if (localUri != null)
          break label107;
        finish();
        break;
      }
      label107: String str2 = localUri.getScheme();
      if ((str2 != null) && (str2.equals("content")))
      {
        t().a(true);
        new UploadPhotoActivity.ScaleImageTask(this, new Handler(), localUri, false).start();
        continue;
      }
      if (getIntent().getBooleanExtra("extra_photo_is_scaled", false))
      {
        t().a(true);
        new UploadPhotoActivity.LoadImageTask(this, new Handler(), localUri.toString()).start();
        continue;
      }
      new UploadPhotoActivity.ScaleImageTask(this, new Handler(), localUri, true).start();
    }
  }

  private void j()
  {
    this.z = new UploadPhotoActivity.2(this);
    TagUsersAutoCompleteTextView localTagUsersAutoCompleteTextView = (TagUsersAutoCompleteTextView)findViewById(2131297929);
    this.y = new DropdownTagUsersAdapter(this, this.n.j());
    localTagUsersAutoCompleteTextView.setAdapter(this.y);
    localTagUsersAutoCompleteTextView.setThreshold(0);
    localTagUsersAutoCompleteTextView.setOnItemClickListener(new UploadPhotoActivity.3(this, localTagUsersAutoCompleteTextView));
    ((ImageView)findViewById(2131297930)).setOnClickListener(new UploadPhotoActivity.4(this, localTagUsersAutoCompleteTextView));
    Toaster.a(this, 2131363033);
  }

  private void k()
  {
    List localList = ((TaggableView)findViewById(2131297931)).getTags();
    String str1 = ((EditText)findViewById(2131297933)).getText().toString().trim();
    if (str1.length() == 0)
      str1 = null;
    FacebookAlbum localFacebookAlbum = this.p;
    String str2 = null;
    if (localFacebookAlbum != null)
      str2 = this.p.a();
    MediaUploadService.a(this, this.o, str2, str1, this.t, this.s, this.x, localList, -1L, null, -1L, null);
    this.r = false;
    Toaster.a(this, 2131363257);
    finish();
  }

  private void l()
  {
    if (this.t == -1L)
    {
      ImageButton localImageButton = (ImageButton)findViewById(2131296665);
      localImageButton.setVisibility(0);
      localImageButton.setImageResource(2130838321);
      localImageButton.setOnClickListener(this);
    }
  }

  private void m()
  {
    ((TextView)findViewById(2131296663)).setText(2131363251);
    String str;
    if ((this.t != -1L) && (this.s == -1L))
      if (this.u == null)
      {
        FqlGetProfile.a(this, this.t);
        str = getString(2131363254);
      }
    while (true)
    {
      ((TextView)findViewById(2131296664)).setText(str);
      return;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.u.mDisplayName;
      str = getString(2131363255, arrayOfObject3);
      continue;
      if (this.p == null)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = getString(2131363245);
        str = getString(2131363253, arrayOfObject2);
        continue;
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.p.d();
      str = getString(2131363253, arrayOfObject1);
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = AppSession.a(this, true);
    boolean bool = getIntent().getBooleanExtra("places_suggestion", false);
    String str1 = getIntent().getAction();
    if (str1 != null)
    {
      if (str1.startsWith("com.facebook.katana.upload.notification.error"))
        this.n.a(this, "" + getIntent().getExtras().getInt("android.intent.extra.SUBJECT"));
    }
    else
    {
      setContentView(2130903616);
      String str2 = getIntent().getStringExtra("extra_album_id");
      if (str2 == null)
        break label328;
      this.p = FacebookAlbum.a(this, str2);
      if (this.p != null)
        break label328;
      finish();
    }
    while (true)
    {
      return;
      if (str1.startsWith("com.facebook.katana.upload.notification.ok"))
      {
        this.n.a(this, "" + getIntent().getExtras().getInt("android.intent.extra.SUBJECT"));
        new File(((Uri)getIntent().getParcelableExtra("android.intent.extra.STREAM")).getPath()).delete();
        if (!bool)
        {
          String str5 = getIntent().getStringExtra("extra_photo_id");
          String str6 = getIntent().getStringExtra("extra_album_id");
          startActivity(LegacyPhotoGalleryActivity.a(this, this.n.b().userId, str6, str5, "android.intent.action.VIEW"));
        }
        finish();
        continue;
      }
      if (str1.startsWith("com.facebook.katana.upload_notification_canceled"))
      {
        this.n.a(this, String.valueOf(getIntent().getExtras().getInt("android.intent.extra.SUBJECT")));
        finish();
        continue;
      }
      if (!str1.startsWith("com.facebook.katana.upload.notification.pending"))
        break;
      finish();
    }
    label328: this.s = getIntent().getLongExtra("extra_checkin_id", -1L);
    this.t = getIntent().getLongExtra("extra_profile_id", -1L);
    this.x = getIntent().getBooleanExtra("extra_photo_publish", true);
    Button localButton = (Button)findViewById(2131297934);
    localButton.setEnabled(false);
    localButton.setOnClickListener(this);
    ((Button)findViewById(2131297935)).setOnClickListener(this);
    l();
    String str3 = getIntent().getStringExtra("android.intent.extra.TITLE");
    if (TextUtils.isEmpty(str3));
    for (String str4 = getIntent().getStringExtra("android.intent.extra.TEXT"); ; str4 = str3)
    {
      if (str4 != null)
        ((TextView)findViewById(2131297933)).setText(str4);
      this.v = new UploadPhotoActivity.1(this);
      j();
      break;
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        break;
      case 2210:
        i();
        break;
      case 21177:
        this.p = FacebookAlbum.a(this, paramIntent.getData());
        m();
      }
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297934)
    {
      TextView localTextView = (TextView)findViewById(2131297933);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(localTextView.getWindowToken(), 0);
      k();
    }
    while (true)
    {
      return;
      if (i == 2131297935)
      {
        finish();
        continue;
      }
      if (i != 2131296665)
        continue;
      startActivityForResult(AlbumsActivity.a(this), 21177);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      localObject = AlertDialogs.a(this, getString(2131363256), 17301543, getString(2131361989), getString(2131361888), new UploadPhotoActivity.5(this), null, null, new UploadPhotoActivity.6(this), true);
      continue;
      localObject = AlertDialogs.a(this, getString(2131363256), 17301543, getString(2131363252), getString(2131361888), new UploadPhotoActivity.7(this), null, null, new UploadPhotoActivity.8(this), true);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.o != null) && (this.r))
      new File(this.o).delete();
    if (this.y != null)
      this.y.a();
  }

  protected void onPause()
  {
    this.q = false;
    if ((this.n != null) && (this.v != null))
      this.n.b(this.v);
    ((TaggableView)findViewById(2131297931)).setImage(null);
    if (this.D != null)
    {
      this.D.recycle();
      this.D = null;
    }
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    if (this.n == null)
      LoginActivity.c(this);
    while (true)
    {
      return;
      i();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity
 * JD-Core Version:    0.6.0
 */