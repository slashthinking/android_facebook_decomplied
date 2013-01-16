package com.facebook.orca.camera;

import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.facebook.orca.camera.gallery.IImage;
import com.facebook.orca.camera.gallery.IImageList;
import com.facebook.orca.debug.BLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class CropImage extends MonitoredActivity
{
  private static final Class<?> e = CropImage.class;
  boolean a;
  boolean b;
  HighlightView c;
  Runnable d = new CropImage.6(this);
  private Bitmap.CompressFormat f = Bitmap.CompressFormat.JPEG;
  private Uri g = null;
  private boolean h = false;
  private int i;
  private int j;
  private boolean k = true;
  private boolean l = false;
  private final Handler m = new Handler();
  private int n;
  private int o;
  private boolean p;
  private boolean q = true;
  private CropImageView r;
  private ContentResolver s;
  private Bitmap t;
  private IImageList u;
  private IImage v;

  private void a()
  {
    if (isFinishing());
    while (true)
    {
      return;
      this.r.a(this.t, true);
      Util.a(this, null, getResources().getString(2131362638), new CropImage.3(this), this.m);
    }
  }

  private void a(Bitmap paramBitmap)
  {
    OutputStream localOutputStream = null;
    int i1 = 0;
    if (this.g != null);
    while (true)
    {
      try
      {
        localOutputStream = this.s.openOutputStream(this.g);
        if (localOutputStream == null)
          continue;
        paramBitmap.compress(this.f, 75, localOutputStream);
        Util.a(localOutputStream);
        Bundle localBundle2 = new Bundle();
        setResult(-1, new Intent(this.g.toString()).putExtras(localBundle2));
        this.m.post(new CropImage.5(this, paramBitmap));
        finish();
        return;
      }
      catch (IOException localIOException2)
      {
        BLog.e(e, "Cannot open file: " + this.g, localIOException2);
        Util.a(localOutputStream);
        continue;
      }
      finally
      {
        Util.a(localOutputStream);
      }
      if (!this.h)
        break;
      try
      {
        WallpaperManager.getInstance(this).setBitmap(paramBitmap);
        setResult(-1);
      }
      catch (IOException localIOException1)
      {
        BLog.e(e, "Failed to set wallpaper.", localIOException1);
        setResult(0);
      }
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("rect", this.c.b().toString());
    File localFile1 = new File(this.v.a());
    File localFile2 = new File(localFile1.getParent());
    String str1 = localFile1.getName();
    String str2 = str1.substring(0, str1.lastIndexOf("."));
    while (true)
    {
      int i2;
      while (true)
      {
        i2 = i1 + 1;
        if (new File(localFile2.toString() + "/" + str2 + "-" + i2 + ".jpg").exists())
          break label446;
        try
        {
          int[] arrayOfInt = new int[1];
          Uri localUri = ImageManager.a(this.s, this.v.d(), this.v.b(), null, localFile2.toString(), str2 + "-" + i2 + ".jpg", paramBitmap, null, arrayOfInt);
          setResult(-1, new Intent().setAction(localUri.toString()).putExtras(localBundle1));
        }
        catch (Exception localException)
        {
          BLog.e(e, "store image fail, continue anyway", localException);
        }
      }
      break;
      label446: i1 = i2;
    }
  }

  private void b()
  {
    if (this.c == null);
    Bitmap localBitmap;
    while (true)
    {
      return;
      if (this.b)
        break label561;
      this.b = true;
      if ((this.n != 0) && (this.o != 0) && (!this.p))
      {
        localBitmap = Bitmap.createBitmap(this.n, this.o, Bitmap.Config.RGB_565);
        Canvas localCanvas3 = new Canvas(localBitmap);
        Rect localRect3 = this.c.b();
        Rect localRect4 = new Rect(0, 0, this.n, this.o);
        int i4 = (localRect3.width() - localRect4.width()) / 2;
        int i5 = (localRect3.height() - localRect4.height()) / 2;
        localRect3.inset(Math.max(0, i4), Math.max(0, i5));
        localRect4.inset(Math.max(0, -i4), Math.max(0, -i5));
        localCanvas3.drawBitmap(this.t, localRect3, localRect4, null);
        this.r.a();
        this.t.recycle();
        this.r.a(localBitmap, true);
        this.r.a(true, true);
        this.r.a.clear();
        Bundle localBundle1 = getIntent().getExtras();
        if ((localBundle1 == null) || ((localBundle1.getParcelable("data") == null) && (!localBundle1.getBoolean("return-data"))))
          break;
        Bundle localBundle2 = new Bundle();
        localBundle2.putParcelable("data", localBitmap);
        setResult(-1, new Intent().setAction("inline-data").putExtras(localBundle2));
        finish();
        continue;
      }
      else
      {
        Rect localRect1 = this.c.b();
        int i1 = localRect1.width();
        int i2 = localRect1.height();
        if (this.l);
        for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888; ; localConfig = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i1, i2, localConfig);
          Canvas localCanvas1 = new Canvas(localBitmap);
          Rect localRect2 = new Rect(0, 0, i1, i2);
          localCanvas1.drawBitmap(this.t, localRect1, localRect2, null);
          this.r.a();
          this.t.recycle();
          if (this.l)
          {
            Canvas localCanvas2 = new Canvas(localBitmap);
            Path localPath = new Path();
            localPath.addCircle(i1 / 2.0F, i2 / 2.0F, i1 / 2.0F, Path.Direction.CW);
            localCanvas2.clipPath(localPath, Region.Op.DIFFERENCE);
            localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
          }
          if ((this.n == 0) || (this.o == 0) || (!this.p))
            break;
          localBitmap = Util.a(new Matrix(), localBitmap, this.n, this.o, this.q, true);
          break;
        }
      }
    }
    if (this.h);
    for (int i3 = 2131362641; ; i3 = 2131362642)
    {
      Util.a(this, null, getResources().getString(i3), new CropImage.4(this, localBitmap), this.m);
      break;
      label561: break;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.s = getContentResolver();
    requestWindowFeature(1);
    setContentView(2130903335);
    this.r = ((CropImageView)findViewById(2131296625));
    MenuHelper.a(this);
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    boolean bool;
    if (localBundle != null)
    {
      if (localBundle.getString("circleCrop") != null)
      {
        this.l = true;
        this.i = 1;
        this.j = 1;
      }
      this.g = ((Uri)localBundle.getParcelable("output"));
      if (this.g != null)
      {
        String str = localBundle.getString("outputFormat");
        if (str != null)
          this.f = Bitmap.CompressFormat.valueOf(str);
        this.t = ((Bitmap)localBundle.getParcelable("data"));
        this.i = localBundle.getInt("aspectX");
        this.j = localBundle.getInt("aspectY");
        this.n = localBundle.getInt("outputX");
        this.o = localBundle.getInt("outputY");
        this.p = localBundle.getBoolean("scale", true);
        this.q = localBundle.getBoolean("scaleUpIfNeeded", true);
        if (!localBundle.containsKey("noFaceDetection"))
          break label348;
        if (localBundle.getBoolean("noFaceDetection"))
          break label342;
        bool = true;
        label246: this.k = bool;
      }
    }
    else
    {
      if (this.t == null)
      {
        Uri localUri = localIntent.getData();
        this.u = ImageManager.a(this.s, localUri, 1);
        this.v = this.u.a(localUri);
        if (this.v != null)
          this.t = this.v.a(true);
      }
      if (this.t != null)
        break label354;
      finish();
    }
    while (true)
    {
      return;
      this.h = localBundle.getBoolean("setWallpaper");
      break;
      label342: bool = false;
      break label246;
      label348: bool = true;
      break label246;
      label354: getWindow().addFlags(1024);
      findViewById(2131297254).setOnClickListener(new CropImage.1(this));
      findViewById(2131297253).setOnClickListener(new CropImage.2(this));
      a();
    }
  }

  protected void onDestroy()
  {
    if (this.u != null)
      this.u.a();
    super.onDestroy();
  }

  protected void onPause()
  {
    super.onPause();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.CropImage
 * JD-Core Version:    0.6.0
 */