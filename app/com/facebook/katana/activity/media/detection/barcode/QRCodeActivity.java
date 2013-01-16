package com.facebook.katana.activity.media.detection.barcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.device.CameraHolder.CameraListener;
import com.facebook.camera.device.CameraPreview;
import com.facebook.camera.device.CameraPreview.PreviewListener;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.support.CameraGating;
import com.facebook.camera.utils.MediaUtil.Orientation;
import com.facebook.camera.utils.RotateLayout;
import com.facebook.camera.utils.Storage;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.Timer;

public class QRCodeActivity extends BaseFacebookActivity
  implements CameraHolder.CameraListener, CameraPreview.PreviewListener
{
  private Button A;
  private CameraFlowLogger B;
  private CameraGating C;
  private Storage D;
  private QRCodeActivity.SuccessfulScanTimerTask E;
  private QRCodeActivity.Mode n;
  private MediaUtil.Orientation o = MediaUtil.Orientation.PORTRAIT;
  private RelativeLayout p;
  private ImageView q;
  private Bitmap r;
  private CameraHolder s;
  private CameraPreview t;
  private RelativeLayout u;
  private SurfaceView v;
  private RotateLayout x;
  private View y;
  private Button z;

  private Bitmap A()
  {
    long l = AppSession.a(this, true).b().a().mUserId;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(l);
    String str = StringLocaleUtil.a("http://www.facebook.com/qr?id=%d", arrayOfObject);
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    QRCodeWriter localQRCodeWriter = new QRCodeWriter();
    int i = this.q.getLayoutParams().width;
    BitMatrix localBitMatrix = localQRCodeWriter.a(str, BarcodeFormat.QR_CODE, i, i, localEnumMap);
    int j = localBitMatrix.c();
    int k = localBitMatrix.d();
    int[] arrayOfInt = new int[j * k];
    for (int m = 0; m < k; m++)
    {
      int i1 = m * j;
      int i2 = 0;
      if (i2 >= j)
        continue;
      int i3 = i1 + i2;
      if (localBitMatrix.a(i2, m));
      for (int i4 = -16777216; ; i4 = -1)
      {
        arrayOfInt[i3] = i4;
        i2++;
        break;
      }
    }
    Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
    localBitmap.setPixels(arrayOfInt, 0, j, 0, 0, j, k);
    return localBitmap;
  }

  private void a(QRCodeActivity.Mode paramMode)
  {
    QRCodeActivity.Mode localMode = this.n;
    if (localMode == paramMode);
    while (true)
    {
      return;
      this.n = paramMode;
      if (localMode == QRCodeActivity.Mode.SCAN)
        this.s.l();
      if (paramMode == QRCodeActivity.Mode.SHOW)
      {
        this.z.setEnabled(false);
        this.A.setEnabled(true);
        if (this.r != null);
      }
      try
      {
        this.r = A();
        label68: BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), this.r);
        this.q.setBackgroundDrawable(localBitmapDrawable);
        this.p.setVisibility(0);
        this.u.setVisibility(8);
        continue;
        if (paramMode != QRCodeActivity.Mode.SCAN)
          continue;
        this.z.setEnabled(true);
        this.A.setEnabled(false);
        this.p.setVisibility(8);
        this.u.setVisibility(0);
        z();
      }
      catch (WriterException localWriterException)
      {
        break label68;
      }
    }
  }

  private void a(Result paramResult)
  {
    try
    {
      URL localURL = new URL(paramResult.a());
      if ((!localURL.getProtocol().equals("http")) && (!localURL.getProtocol().equals("https")));
      while (true)
      {
        label38: return;
        if ((localURL.getHost().equals("www.facebook.com")) && ((localURL.getPath().equals("/qr")) || (localURL.getPath().equals("/qr/"))))
        {
          Uri localUri = Uri.parse(paramResult.a());
          try
          {
            long l = Long.parseLong(localUri.getQueryParameter("id"));
            this.y.setVisibility(0);
            Timer localTimer = new Timer();
            this.E = new QRCodeActivity.SuccessfulScanTimerTask(this, this, l);
            localTimer.schedule(this.E, 100L);
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          continue;
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label38;
    }
  }

  private void j()
  {
    this.p = ((RelativeLayout)findViewById(2131297787));
    this.q = ((ImageView)findViewById(2131297790));
    this.u = ((RelativeLayout)findViewById(2131296442));
    this.v = ((SurfaceView)findViewById(2131297791));
    this.x = ((RotateLayout)findViewById(2131296869));
    this.y = findViewById(2131297792);
    this.z = ((Button)findViewById(2131297794));
    this.A = ((Button)findViewById(2131297795));
  }

  private void k()
  {
    this.z.setOnClickListener(new QRCodeActivity.1(this));
    this.A.setOnClickListener(new QRCodeActivity.2(this));
  }

  private void z()
  {
    if (this.s == null)
    {
      this.s = new CameraHolder(this, this, getPreferences(0), this.B, this.D, this.C);
      this.s.e();
    }
    this.s.j();
  }

  public void a(Uri paramUri)
  {
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.B = ((CameraFlowLogger)C().a(CameraFlowLogger.class));
    Preconditions.checkNotNull(this.B);
    this.C = ((CameraGating)C().a(CameraGating.class));
    Preconditions.checkNotNull(this.C);
    this.C.a(this);
    this.D = ((Storage)C().a(Storage.class));
    Preconditions.checkNotNull(this.D);
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.o = i();
      switch (QRCodeActivity.3.a[this.o.ordinal()])
      {
      default:
        setRequestedOrientation(1);
        i = 2130903532;
      case 2:
      case 3:
      }
    }
    while (true)
    {
      requestWindowFeature(1);
      getWindow().addFlags(128);
      getWindow().addFlags(1024);
      getWindow().clearFlags(2048);
      setContentView(i);
      j();
      k();
      this.v.getHolder().setFormat(-2);
      a(QRCodeActivity.Mode.SHOW);
      return;
      this.o = MediaUtil.Orientation.PORTRAIT;
      break;
      setRequestedOrientation(0);
      i = 2130903531;
      continue;
      setRequestedOrientation(8);
      i = 2130903533;
    }
  }

  public void a(CameraPreview paramCameraPreview)
  {
    this.u.addView(paramCameraPreview, 0);
    this.t = paramCameraPreview;
  }

  public void a(byte[] paramArrayOfByte, Camera.Parameters paramParameters)
  {
    if (this.E != null);
    while (true)
    {
      return;
      Camera.Size localSize = paramParameters.getPreviewSize();
      BinaryBitmap localBinaryBitmap = new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(paramArrayOfByte, localSize.width, localSize.height, 0, 0, localSize.width, localSize.height, false)));
      QRCodeReader localQRCodeReader = new QRCodeReader();
      try
      {
        a(localQRCodeReader.a(localBinaryBitmap));
      }
      catch (NotFoundException localNotFoundException)
      {
        if (this.y.getVisibility() != 0)
          continue;
        this.y.setVisibility(4);
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    this.s.j();
  }

  public boolean b(Uri paramUri)
  {
    return false;
  }

  public void c(int paramInt)
  {
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean);
    this.x.setVisibility(0);
    this.s.t();
    this.t.setPreviewListener(this);
  }

  public void d(boolean paramBoolean)
  {
  }

  public MediaUtil.Orientation i()
  {
    MediaUtil.Orientation localOrientation;
    if (this.C.e())
      localOrientation = MediaUtil.Orientation.LANDSCAPE;
    while (true)
    {
      return localOrientation;
      int i = getRequestedOrientation();
      if (i == 1)
      {
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        continue;
      }
      if (i == 0)
      {
        localOrientation = MediaUtil.Orientation.LANDSCAPE;
        continue;
      }
      if (i == 9)
      {
        localOrientation = MediaUtil.Orientation.REVERSE_PORTRAIT;
        continue;
      }
      int j = getWindowManager().getDefaultDisplay().getRotation();
      if (j == 0)
      {
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        continue;
      }
      if (j == 1)
      {
        localOrientation = MediaUtil.Orientation.LANDSCAPE;
        continue;
      }
      if (j == 3)
      {
        localOrientation = MediaUtil.Orientation.REVERSE_LANDSCAPE;
        continue;
      }
      if (j == 2)
      {
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        continue;
      }
      localOrientation = MediaUtil.Orientation.PORTRAIT;
    }
  }

  public void l()
  {
    this.x.setVisibility(8);
    if (this.t != null)
    {
      this.u.removeView(this.t);
      this.t = null;
    }
  }

  public void m()
  {
  }

  public void n()
  {
  }

  public RotateLayout o()
  {
    return this.x;
  }

  protected void onPause()
  {
    if (this.n == QRCodeActivity.Mode.SCAN)
      this.s.l();
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.n == QRCodeActivity.Mode.SCAN)
      z();
  }

  public FaceDetectionIndicatorView p()
  {
    return null;
  }

  public int q()
  {
    return 0;
  }

  public MediaUtil.Orientation r()
  {
    return s();
  }

  public MediaUtil.Orientation s()
  {
    return this.o;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.barcode.QRCodeActivity
 * JD-Core Version:    0.6.0
 */