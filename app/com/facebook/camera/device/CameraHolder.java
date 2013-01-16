package com.facebook.camera.device;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Media;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.facetracking.FaceDetectionManager;
import com.facebook.camera.facetracking.FaceTracker;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.support.CameraGating;
import com.facebook.camera.utils.MediaUtil;
import com.facebook.camera.utils.MediaUtil.Orientation;
import com.facebook.camera.utils.RotateLayout;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.Log;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;

public class CameraHolder
  implements View.OnTouchListener, FocusManager.Listener
{
  private static final Class<?> b = CameraHolder.class;
  private static final String c = b.getSimpleName();
  CameraHolder.CameraListener a;
  private Camera d;
  private CameraPreview e;
  private final CameraFlash f;
  private final Context g;
  private final CameraHolder.SurfaceCreatedListener h = new CameraHolder.SurfaceCreatedListener(this, null);
  private MediaRecorder i;
  private Storage j;
  private boolean k;
  private FocusManager l;
  private FaceDetectionManager m = null;
  private FaceTracker n = null;
  private final CameraHolder.AutoFocusCallback o = new CameraHolder.AutoFocusCallback(this, null);
  private CameraHolder.LoadCameraTask p;
  private boolean q = false;
  private String r;
  private Uri s;
  private ContentResolver t;
  private int u = -1;
  private int v;
  private boolean w;
  private final CameraFlowLogger x;
  private final CameraGating y;
  private final Camera.PictureCallback z = new CameraHolder.1(this);

  public CameraHolder(CameraHolder.CameraListener paramCameraListener, Context paramContext, SharedPreferences paramSharedPreferences, CameraFlowLogger paramCameraFlowLogger, Storage paramStorage, CameraGating paramCameraGating)
  {
    this.a = paramCameraListener;
    this.x = paramCameraFlowLogger;
    this.y = paramCameraGating;
    this.f = new CameraFlash(paramSharedPreferences, this.x);
    this.g = ((Context)Preconditions.checkNotNull(paramContext));
    this.t = this.g.getContentResolver();
    this.j = paramStorage;
  }

  private void A()
  {
    if (!this.j.a());
    for (this.r = null; ; this.r = this.j.b().getPath())
      return;
  }

  private void B()
  {
    Log.d(c, "initializeRecorder");
    A();
    if (this.r == null)
      Log.a(c, "prepare failed for invalid video file name");
    while (true)
    {
      return;
      this.i = new MediaRecorder();
      this.d.stopPreview();
      this.d.unlock();
      this.i.setCamera(this.d);
      this.i.setAudioSource(5);
      this.i.setVideoSource(1);
      CamcorderProfile localCamcorderProfile = CamcorderProfile.get(this.v, 1);
      this.i.setProfile(localCamcorderProfile);
      this.i.setMaxDuration(600000);
      this.i.setPreviewDisplay(this.e.getSurface());
      this.i.setOutputFile(this.r);
      try
      {
        this.i.prepare();
        Log.d(c, "Finish preparing camera for recording");
      }
      catch (Exception localException)
      {
        while (true)
        {
          this.x.a("prepare MediaRecorder failed for " + this.r, localException);
          y();
          C();
        }
      }
    }
  }

  private void C()
  {
    Log.d(c, "Releasing media recorder.");
    if (this.i != null)
    {
      this.i.reset();
      this.i.release();
      this.i = null;
    }
    if (this.d != null);
    try
    {
      this.d.reconnect();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.x.a("camera reconnect failed", localException);
    }
  }

  private int D()
  {
    int i2;
    if (this.d == null)
    {
      i2 = 0;
      return i2;
    }
    MediaUtil.Orientation localOrientation = this.a.r();
    Camera.CameraInfo localCameraInfo;
    int i1;
    if (F())
    {
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(this.v, localCameraInfo);
      if (localCameraInfo.facing == 1)
      {
        i1 = localCameraInfo.orientation + localOrientation.mRotation;
        if (((localOrientation == MediaUtil.Orientation.PORTRAIT) || (localOrientation == MediaUtil.Orientation.REVERSE_PORTRAIT)) && (this.y.f()))
          i1 += 180;
      }
    }
    while (true)
    {
      i2 = (i1 + 360) % 360;
      break;
      i1 = localCameraInfo.orientation - localOrientation.mRotation;
      continue;
      i1 = localOrientation.mReverseRotation;
    }
  }

  private int E()
  {
    Camera.CameraInfo localCameraInfo;
    if (F())
    {
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(this.v, localCameraInfo);
    }
    for (int i1 = localCameraInfo.facing; ; i1 = -1)
      return i1;
  }

  private boolean F()
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean G()
  {
    if (Build.VERSION.SDK_INT < 9);
    for (int i1 = 0; ; i1 = 1)
      return i1;
  }

  private void H()
  {
    if (this.d != null)
      throw new IllegalStateException("Tried to load camera, even though we already have one");
    this.x.b(this.v);
    if (this.p == null)
      this.p = new CameraHolder.LoadCameraTask(this);
    if (this.p.getStatus() == AsyncTask.Status.PENDING)
      this.p.execute(new Void[0]);
    while (true)
    {
      return;
      Log.e(b, "We shouldn't be launching another task to capture camera!");
    }
  }

  private void I()
  {
    this.q = true;
    Log.e(b, "camera ready and loaded");
    this.a.c(true);
    this.a.d(this.f.a());
  }

  private void J()
  {
    this.a.c(false);
  }

  private void K()
  {
    this.q = false;
    if (this.f != null)
      this.f.a(null);
    if (this.p != null)
    {
      this.p.cancel(false);
      this.p = null;
    }
    if (this.i != null)
    {
      if (this.k)
        this.i.stop();
      this.i.reset();
      this.i.release();
      this.i = null;
    }
    if (this.a.p() != null)
      this.a.p().a();
    if (this.n != null)
    {
      this.n.b(this.a.p());
      this.n.b(this.l);
      this.n.a();
      this.n = null;
    }
    if (this.m != null)
    {
      if (this.d != null)
        this.d.setFaceDetectionListener(null);
      this.m = null;
    }
    if (this.l != null)
    {
      this.l.e();
      this.l = null;
    }
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    if (this.d != null)
    {
      this.d.stopPreview();
      this.d.release();
      this.d = null;
    }
    this.x.f();
    this.a.l();
  }

  private void L()
  {
    int i1 = 1;
    this.l.a(this.d);
    FocusManager localFocusManager = this.l;
    RotateLayout localRotateLayout = this.a.o();
    CameraPreview localCameraPreview = this.e;
    if (E() == i1);
    while (true)
    {
      localFocusManager.a(localRotateLayout, localCameraPreview, this, i1, this.a.s().mReverseRotation);
      return;
      int i2 = 0;
    }
  }

  private void M()
  {
    Camera.Parameters localParameters = this.d.getParameters();
    Camera.Size localSize1 = MediaUtil.a(localParameters.getSupportedPictureSizes());
    if (localSize1 != null)
      localParameters.setPictureSize(localSize1.width, localSize1.height);
    localParameters.setJpegQuality(85);
    Camera.Size localSize2 = MediaUtil.a(localParameters.getSupportedPreviewSizes());
    if (localSize2 != null)
      localParameters.setPreviewSize(localSize2.width, localSize2.height);
    try
    {
      this.d.setParameters(localParameters);
      this.d.setDisplayOrientation(this.a.s().mReverseRotation);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.x.a("initCameraSettings/setParameters failed", localException);
    }
  }

  private Camera a(int paramInt)
  {
    Object localObject;
    if (this.d != null)
      localObject = this.d;
    while (true)
    {
      return localObject;
      int i1;
      if (!this.g.getPackageManager().hasSystemFeature("android.hardware.camera"))
      {
        boolean bool3 = this.g.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        i1 = 0;
        if (!bool3);
      }
      else
      {
        i1 = 1;
      }
      localObject = null;
      if (i1 == 0)
        continue;
      try
      {
        boolean bool1 = b();
        localObject = null;
        if (bool1)
        {
          localObject = Camera.open(paramInt);
          continue;
        }
        boolean bool2 = G();
        localObject = null;
        if (bool2)
        {
          localObject = Camera.open(0);
          continue;
        }
        Camera localCamera = Camera.open();
        localObject = localCamera;
      }
      catch (Exception localException)
      {
        Log.e(b, "getCameraInstance() failed");
      }
    }
  }

  private void b(Camera paramCamera)
  {
    if (this.d != null)
      Log.a(b, "asked to set and initialize camera with explicitly releasing first!");
    if (paramCamera == null)
      Log.a(b, "We aren't supposed to see a null camera here!");
    this.d = paramCamera;
    this.f.a(this.d);
    this.a.c(this.f.b());
    Camera.Parameters localParameters = paramCamera.getParameters();
    List localList = localParameters.getSupportedFocusModes();
    String[] arrayOfString;
    if (localList != null)
    {
      arrayOfString = new String[localList.size()];
      if (localList != null)
        localList.toArray(arrayOfString);
      this.l = new FocusManager(arrayOfString, this.x);
      if ((!FocusManager.a(localParameters)) || (!this.y.d()))
        break label184;
      this.m = new FaceDetectionManager(this.d);
      this.n = new FaceTracker(this.m);
      this.n.a(this.l);
    }
    while (true)
    {
      return;
      arrayOfString = new String[0];
      break;
      label184: this.m = null;
    }
  }

  private static boolean c(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if ((localParameters == null) || (localParameters.getSupportedPreviewSizes() == null));
    for (int i1 = 0; ; i1 = 1)
      return i1;
  }

  public static boolean m()
  {
    if (Build.VERSION.SDK_INT >= 14);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void x()
  {
    this.k = false;
    try
    {
      this.i.stop();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.x.a("stop MediaRecorder failed", localException);
    }
  }

  private void y()
  {
    if (this.r == null);
    while (true)
    {
      return;
      if (!new File(this.r).delete())
        Log.d(c, "Could not delete " + this.r);
      this.r = null;
    }
  }

  private void z()
  {
    if (this.r == null);
    while (true)
    {
      return;
      long l1 = System.currentTimeMillis();
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("datetaken", Long.valueOf(l1));
      localContentValues.put("mime_type", "video/3gpp");
      localContentValues.put("_data", this.r);
      localContentValues.put("_size", Long.valueOf(new File(this.r).length()));
      try
      {
        this.s = this.t.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
        Log.d(c, "Current video URI: " + this.s);
        continue;
      }
      catch (Exception localException)
      {
        this.s = null;
        this.x.a("save video file failed", localException);
        Log.d(c, "Current video URI: " + this.s);
        continue;
      }
      finally
      {
        Log.d(c, "Current video URI: " + this.s);
      }
    }
    throw localObject;
  }

  public void a()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    for (int i1 = 0; ; i1++)
    {
      if (i1 < this.u)
      {
        Camera.getCameraInfo(i1, localCameraInfo);
        if (localCameraInfo.facing != this.a.q())
          continue;
        this.v = i1;
      }
      return;
    }
  }

  public void a(SharedPreferences.Editor paramEditor)
  {
    this.f.a(paramEditor);
  }

  public boolean b()
  {
    int i1 = 1;
    if (this.u > i1);
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  public int c()
  {
    if (!b())
      throw new IllegalStateException("Camera toggled without proper support from API");
    K();
    this.v = ((1 + this.v) % this.u);
    H();
    return this.v;
  }

  public boolean d()
  {
    return this.q;
  }

  public void e()
  {
    if (Build.VERSION.SDK_INT < 9)
      this.u = 1;
    if (this.u == -1)
      this.u = Camera.getNumberOfCameras();
    if (b())
      a();
    this.w = this.y.c();
  }

  public void f()
  {
    if (this.l != null)
      this.l.b();
  }

  public void g()
  {
    Log.d(c, "startVideoRecording");
    B();
    if (this.i == null)
      Log.a(c, "Fail to initialize media recorder");
    while (true)
    {
      return;
      if (this.r == null)
      {
        Log.a(c, "Invalid video output file name");
        C();
        continue;
      }
      try
      {
        this.i.start();
        this.k = true;
      }
      catch (Exception localException)
      {
        this.x.a("start MediaRecorder failed", localException);
        y();
        C();
        K();
        H();
      }
    }
  }

  public void h()
  {
    Log.d(c, "Cancel video recording here!!!");
    x();
    y();
    C();
    K();
  }

  public void i()
  {
    Log.d(c, "stopVideoRecording");
    x();
    z();
    C();
    this.a.a(this.s);
  }

  public void j()
  {
    K();
    H();
  }

  public void k()
  {
    if (this.d != null)
    {
      this.d.startPreview();
      this.q = true;
    }
  }

  public void l()
  {
    if (this.a.p() != null)
      this.a.p().a();
    if (this.k)
    {
      i();
      C();
    }
    K();
  }

  public CameraPreview n()
  {
    this.e = new CameraPreview(this.g, this.d, this.l, this.m, this.x);
    this.e.setSurfaceListener(this.h);
    this.e.setOnTouchListener(this);
    this.a.a(this.e);
    return this.e;
  }

  public View.OnTouchListener o()
  {
    return this.f;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.q;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      FocusManager localFocusManager = this.l;
      bool2 = false;
      if (localFocusManager == null)
        continue;
      bool2 = this.l.a(paramMotionEvent);
    }
  }

  public boolean p()
  {
    return this.f.a();
  }

  public void q()
  {
    AudioManager localAudioManager = (AudioManager)this.g.getSystemService("audio");
    int i1;
    if (this.w)
      i1 = 4;
    while (true)
    {
      int i2 = localAudioManager.getStreamVolume(i1);
      if (this.w)
        localAudioManager.setStreamVolume(i1, localAudioManager.getStreamMaxVolume(i1), 0);
      Resources localResources = this.g.getResources();
      Uri localUri = new Uri.Builder().scheme("android.resource").authority(localResources.getResourcePackageName(2131099649)).appendPath(localResources.getResourceTypeName(2131099649)).appendPath(localResources.getResourceEntryName(2131099649)).build();
      MediaPlayer localMediaPlayer = new MediaPlayer();
      localMediaPlayer.setAudioStreamType(i1);
      try
      {
        localMediaPlayer.setDataSource(this.g, localUri);
        localMediaPlayer.prepare();
        localMediaPlayer.setOnErrorListener(new CameraHolder.2(this, localAudioManager, i1, i2));
        localMediaPlayer.setOnCompletionListener(new CameraHolder.3(this, localAudioManager, i1, i2));
        localMediaPlayer.start();
        return;
        i1 = 1;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localAudioManager.setStreamVolume(i1, i2, 0);
          this.x.a("media player error", localException);
        }
      }
    }
  }

  public void r()
  {
    if (this.l != null)
      this.l.a();
  }

  public boolean s()
  {
    this.q = false;
    this.f.a(false);
    Camera.Parameters localParameters = this.d.getParameters();
    localParameters.setRotation(D());
    try
    {
      this.d.setParameters(localParameters);
      this.d.takePicture(null, null, this.z);
      q();
      return true;
    }
    catch (Exception localException)
    {
      while (true)
        this.x.a("capture/setParameters failed", localException);
    }
  }

  public void t()
  {
    try
    {
      this.d.autoFocus(this.o);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.x.a("autoFocus failed", localException);
        this.o.onAutoFocus(false, this.d);
      }
    }
  }

  public void u()
  {
    if (this.d != null)
      this.d.cancelAutoFocus();
  }

  public boolean v()
  {
    return this.k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder
 * JD-Core Version:    0.6.0
 */