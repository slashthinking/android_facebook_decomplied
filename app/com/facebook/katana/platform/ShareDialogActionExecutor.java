package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerPublishService.Publisher;
import com.facebook.content.SecureContextHelper;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.activity.composer.ComposerIntent.Builder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;

public class ShareDialogActionExecutor extends AbstractPlatformActionExecutor
{
  private static final Class<?> b = ShareDialogActionExecutor.class;
  private final String Y;
  private final String Z;
  protected boolean a;
  private final String aa;
  private final String ab;
  private final String ac;
  private AbstractPlatformActionExecutor.CompletionCallback c;
  private final Activity d;
  private final ComposerPublishService e;
  private final boolean f;
  private final FacebookPlace g;
  private final Location h;
  private final long[] i;

  public ShareDialogActionExecutor(ComposerPublishService paramComposerPublishService, Activity paramActivity, PlatformActivityShareDialogRequest paramPlatformActivityShareDialogRequest)
  {
    this.d = paramActivity;
    this.e = paramComposerPublishService;
    this.f = paramPlatformActivityShareDialogRequest.b();
    this.g = a(paramPlatformActivityShareDialogRequest.c(), paramPlatformActivityShareDialogRequest.f(), paramPlatformActivityShareDialogRequest.g(), paramPlatformActivityShareDialogRequest.h());
    this.h = a(paramPlatformActivityShareDialogRequest.g(), paramPlatformActivityShareDialogRequest.h());
    this.i = a(paramPlatformActivityShareDialogRequest.i());
    this.Y = paramPlatformActivityShareDialogRequest.j();
    this.Z = paramPlatformActivityShareDialogRequest.k();
    this.aa = paramPlatformActivityShareDialogRequest.l();
    this.ab = paramPlatformActivityShareDialogRequest.m();
    this.ac = paramPlatformActivityShareDialogRequest.n();
  }

  private Location a(Double paramDouble1, Double paramDouble2)
  {
    double d1 = 0.0D;
    double d2;
    if (paramDouble1 == null)
    {
      d2 = d1;
      if (paramDouble2 != null)
        break label49;
    }
    while (true)
    {
      Location localLocation = new Location("");
      localLocation.setLatitude(d2);
      localLocation.setLongitude(d1);
      return localLocation;
      d2 = paramDouble1.doubleValue();
      break;
      label49: d1 = paramDouble2.doubleValue();
    }
  }

  private FacebookPlace a(String paramString1, String paramString2, Double paramDouble1, Double paramDouble2)
  {
    String str;
    FacebookPlace localFacebookPlace;
    label40: double d1;
    label49: double d3;
    try
    {
      long l = Long.parseLong(paramString1);
      if (paramString2 == null)
      {
        str = "";
        break label71;
        while (true)
        {
          Object localObject1;
          Object localObject2;
          localFacebookPlace = new FacebookPlace(l, str, null, localObject1, localObject2, 0, null);
          break label89;
          d1 = paramDouble1.doubleValue();
          break;
          double d2 = paramDouble2.doubleValue();
          d3 = d2;
        }
      }
    }
    catch (Exception localException)
    {
      localFacebookPlace = null;
    }
    while (true)
    {
      label71: if (paramDouble1 != null)
        break label40;
      d1 = 0.0D;
      if (paramDouble2 != null)
        break label49;
      d3 = 0.0D;
      break;
      label89: return localFacebookPlace;
      str = paramString2;
    }
  }

  private long[] a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0));
    while (true)
    {
      try
      {
        long[] arrayOfLong2 = new long[paramArrayList.size()];
        int j = 0;
        if (j >= arrayOfLong2.length)
          continue;
        arrayOfLong2[j] = Long.parseLong((String)paramArrayList.get(j));
        j++;
        continue;
        arrayOfLong1 = arrayOfLong2;
        return arrayOfLong1;
      }
      catch (Exception localException)
      {
        arrayOfLong1 = new long[0];
        continue;
      }
      long[] arrayOfLong1 = new long[0];
    }
  }

  private Intent b(Context paramContext)
  {
    ComposerIntent.Builder localBuilder = new ComposerIntent.Builder(paramContext).c(true).b(true).a("platform_composer");
    if ((this.g != null) && (this.h != null))
      localBuilder = localBuilder.a(this.h).a(this.g);
    if (this.i.length > 0)
      localBuilder = localBuilder.a(this.i);
    if ((this.Y != null) && (!this.Y.isEmpty()))
      localBuilder = localBuilder.a(true).b(this.Y);
    return localBuilder.a();
  }

  private boolean c(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("is_ui_showing")));
    for (int j = 1; ; j = 0)
      return j;
  }

  private void g(Bundle paramBundle)
  {
    if (this.c != null)
      this.c.c(paramBundle);
  }

  public void D()
  {
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 51)
    {
      if (paramInt2 != 0)
        break label20;
      g(AuthorizeAppResults.a("User canceled message"));
    }
    while (true)
    {
      return;
      label20: this.a = false;
      ListenableFuture localListenableFuture = this.e.a(paramIntent, ComposerPublishService.Publisher.NEWSFEED);
      DialogBasedProgressIndicator localDialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.d, "Sending...");
      localDialogBasedProgressIndicator.a();
      Futures.a(localListenableFuture, new ShareDialogActionExecutor.1(this, localDialogBasedProgressIndicator));
    }
  }

  public void a(Bundle paramBundle)
  {
    this.a = c(paramBundle);
    if (!this.a)
    {
      this.a = true;
      Intent localIntent = b(this.d.getApplicationContext());
      SecureContextHelper localSecureContextHelper = (SecureContextHelper)FbInjector.a(this.d.getApplicationContext()).a(SecureContextHelper.class);
      if (!localIntent.getBooleanExtra(ComposerConstants.c, false))
        break label76;
      localSecureContextHelper.a(localIntent, 51, this.d);
    }
    while (true)
    {
      return;
      label76: BLog.e(b, "cannot handle intent without Extra " + ComposerConstants.c + "=true");
    }
  }

  public void a(AbstractPlatformActionExecutor.CompletionCallback paramCompletionCallback)
  {
    this.c = paramCompletionCallback;
  }

  public void e(Bundle paramBundle)
  {
    paramBundle.putBoolean("is_ui_showing", this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.ShareDialogActionExecutor
 * JD-Core Version:    0.6.0
 */