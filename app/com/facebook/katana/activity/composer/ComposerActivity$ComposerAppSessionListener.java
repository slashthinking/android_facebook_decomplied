package com.facebook.katana.activity.composer;

import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.events.AggressiveSuggestionPreferences;
import com.facebook.katana.model.FacebookProfileUtil;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.GeoRegion;
import com.facebook.katana.service.method.AudienceSettings;
import com.facebook.katana.view.composer.ComposerAudienceSelectorButton;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Iterables;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class ComposerActivity$ComposerAppSessionListener extends AppSessionListener
{
  private ComposerActivity$ComposerAppSessionListener(ComposerActivity paramComposerActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookProfile paramFacebookProfile)
  {
    if (paramInt == 200)
      ComposerActivity.i(this.a).setGroup(paramFacebookProfile);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookSessionInfo paramFacebookSessionInfo)
  {
    if (paramInt == 200)
    {
      ComposerActivity.a(this.a, System.currentTimeMillis());
      FacebookUser localFacebookUser = ComposerActivity.g(this.a).b().a();
      ComposerActivity.a(this.a, FacebookProfileUtil.a(localFacebookUser));
      ComposerActivity.h(this.a);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, AudienceSettings paramAudienceSettings)
  {
    if (paramAudienceSettings != null);
    for (PrivacySetting localPrivacySetting = paramAudienceSettings.h(); ; localPrivacySetting = null)
    {
      if (!StringUtil.a(ComposerActivity.a(this.a)))
      {
        localPrivacySetting = (PrivacySetting)JMStaticKeysDictDestination.Encoder.a(ComposerActivity.a(this.a), PrivacySetting.class);
        paramAudienceSettings.a(localPrivacySetting);
        paramInt = 200;
      }
      if ((paramInt != 200) || (ComposerActivity.b(this.a) == null) || (localPrivacySetting == null) || (localPrivacySetting.value == null))
        break;
      this.a.a(paramAudienceSettings);
      return;
    }
    FbErrorReporter localFbErrorReporter;
    StringBuilder localStringBuilder;
    String str;
    if (paramInt == 200)
    {
      localFbErrorReporter = ComposerActivity.c(this.a);
      localStringBuilder = new StringBuilder().append("We are getting bad sticky privacy settings. Result: ");
      str = null;
      if (localPrivacySetting != null)
        break label195;
    }
    while (true)
    {
      localFbErrorReporter.a("ComposerActivity_Audience_Settings_Fetch", str, true);
      if (ComposerActivity.d(this.a) <= 0)
        break;
      ComposerActivity.e(this.a);
      AudienceSettings.g();
      AudienceSettings.a(this.a.getApplicationContext(), PrivacySetting.Category.composer_sticky);
      break;
      label195: str = JMStaticKeysDictDestination.Encoder.a(localPrivacySetting);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<GeoRegion> paramList)
  {
    ListIterator localListIterator = ComposerActivity.f(this.a).listIterator(ComposerActivity.f(this.a).size());
    while (localListIterator.hasPrevious())
    {
      if (!paramString1.equals((String)localListIterator.previous()))
        continue;
      localListIterator.remove();
      while (localListIterator.hasPrevious())
      {
        localListIterator.previous();
        localListIterator.remove();
      }
      if (paramInt != 200)
        break;
      ComposerActivity.a(this.a, GeoRegion.a(paramList));
      this.a.j();
    }
  }

  public void c(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, FacebookEvent> paramMap)
  {
    if ((paramString1 == null) || (!paramString1.equals(ComposerActivity.j(this.a))))
      return;
    if ((paramInt != 200) || (paramMap == null) || (paramMap.size() != 1))
      ComposerActivity.a(this.a, null);
    while (true)
    {
      ComposerActivity.a(this.a, ComposerActivity.TipMode.NONE);
      break;
      Assert.a(paramMap.size(), 1);
      FacebookEvent localFacebookEvent = (FacebookEvent)Iterables.a(paramMap.values(), 0);
      if (ComposerActivity.k(this.a).a(localFacebookEvent))
      {
        ComposerActivity.a(this.a, localFacebookEvent);
        continue;
      }
      ComposerActivity.a(this.a, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.ComposerAppSessionListener
 * JD-Core Version:    0.6.0
 */