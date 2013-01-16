package com.facebook.katana.service.autoupdate;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.config.AppBuildInfo;
import com.facebook.katana.model.FacebookApp;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import java.io.IOException;
import java.util.Map;

public class AutoUpdateAppObjectFetchService extends IntentService
{
  private AppApiMethod a;
  private AppBuildInfo b;
  private AutoUpdateDownloader c;
  private FbErrorReporter d;
  private OrcaSharedPreferences e;
  private SingleMethodRunner f;

  public AutoUpdateAppObjectFetchService()
  {
    super("AutoUpdateAppObjectFetchService");
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.a = ((AppApiMethod)localFbInjector.a(AppApiMethod.class));
    this.b = ((AppBuildInfo)localFbInjector.a(AppBuildInfo.class));
    this.c = ((AutoUpdateDownloader)localFbInjector.a(AutoUpdateDownloader.class));
    this.d = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.e = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.f = ((SingleMethodRunner)localFbInjector.a(SingleMethodRunner.class));
  }

  public void onHandleIntent(Intent paramIntent)
  {
    try
    {
      str2 = paramIntent.getStringExtra("build_tag");
      try
      {
        localFacebookApp = (FacebookApp)this.f.a(this.a, null);
        if ((localFacebookApp != null) && (localFacebookApp.mClientConfig != null))
          if (localFacebookApp.mClientConfig.containsKey(str2));
      }
      catch (Exception localException)
      {
        throw new AutoUpdateServiceException("Exception running app method " + localException.getMessage());
      }
    }
    catch (AutoUpdateServiceException localAutoUpdateServiceException)
    {
      String str2;
      FacebookApp localFacebookApp;
      String str1 = "graph.facebook.com/app Exception: " + localAutoUpdateServiceException.getMessage();
      this.d.a("AutoUpdateService", str1, false);
      return;
      String str3 = (String)localFacebookApp.mClientConfig.get(str2);
      TaggedBuildInfo localTaggedBuildInfo;
      try
      {
        localTaggedBuildInfo = (TaggedBuildInfo)JMParser.a(FBJsonFactory.a.createJsonParser(str3), TaggedBuildInfo.class);
        if (localTaggedBuildInfo == null)
          throw new AutoUpdateServiceException("buildInfo cannot be null (probably malformed JSON)");
      }
      catch (IOException localIOException)
      {
        throw new AutoUpdateServiceException("Exception creating JSON parser " + localIOException.getMessage());
      }
      catch (JMException localJMException)
      {
        throw new AutoUpdateServiceException("Exception parsing JSON response " + localJMException.getMessage());
      }
      int i = localTaggedBuildInfo.mNewVersion;
      int j = localTaggedBuildInfo.mMinVersion;
      this.e.b().a(AutoUpdateConstants.c, j).a(AutoUpdateConstants.d, i).a(AutoUpdateConstants.e, localTaggedBuildInfo.mNewVersionUrl).a();
      int k = this.b.b();
      if (j > k)
        this.c.a(str2, localTaggedBuildInfo, true);
      else if (i > k)
        this.c.a(str2, localTaggedBuildInfo, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateAppObjectFetchService
 * JD-Core Version:    0.6.0
 */