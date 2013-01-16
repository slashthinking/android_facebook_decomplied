package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.Toaster;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerPublishService.Publisher;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.Shareable;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.media.PhotoGalleryActivity;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImplicitShareIntentHandler extends BaseFacebookActivity
  implements AnalyticsSubModuleActivity, NotNewNavEnabled
{
  private String a(String paramString)
  {
    String str = null;
    if (paramString == null);
    while (true)
    {
      return str;
      Matcher localMatcher = Patterns.WEB_URL.matcher(paramString);
      boolean bool = localMatcher.find();
      str = null;
      if (!bool)
        continue;
      str = localMatcher.group();
    }
  }

  private boolean a(long paramLong, Intent paramIntent)
  {
    boolean bool = paramLong < 0L;
    int i = 0;
    if (bool);
    while (true)
    {
      return i;
      FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this, paramLong);
      i = 0;
      if (localFacebookPhoto == null)
        continue;
      paramIntent.putExtra("extra_is_share", true);
      paramIntent.putExtra("extra_share_preview_on_click", PhotoGalleryActivity.a(getApplicationContext(), paramLong));
      paramIntent.putExtra("extra_shareable", new Shareable(String.valueOf(paramLong), GraphQLObjectType.ObjectType.Photo));
      i = 1;
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.k;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Intent localIntent1 = getIntent();
    String str1 = localIntent1.getType();
    if ((str1 == null) || ("*/*".equals(str1)))
    {
      Toaster.a(getApplicationContext(), 2131361977, 17);
      finish();
      return;
    }
    String str2 = localIntent1.getAction();
    FbInjector localFbInjector = C();
    Storage localStorage = (Storage)localFbInjector.a(Storage.class);
    SecureContextHelper localSecureContextHelper = (SecureContextHelper)localFbInjector.a(SecureContextHelper.class);
    Intent localIntent2 = new Intent(getApplicationContext(), ComposerActivity.class);
    localIntent2.putExtra(ComposerConstants.c, true);
    if (("android.intent.action.SEND".equals(str2)) && ("text/plain".equals(str1)))
    {
      String str4 = a(localIntent1.getStringExtra("android.intent.extra.TEXT"));
      if (!StringUtils.c(str4))
      {
        localIntent2.putExtra("extra_is_share", true);
        localIntent2.putExtra("extra_link_for_share", str4);
      }
    }
    label419: label423: 
    while (true)
    {
      localSecureContextHelper.a(localIntent2, 1756, this);
      break;
      if (("android.intent.action.SEND".equals(str2)) && (str1.startsWith("video/")))
      {
        localIntent2.putExtra("extra_video_request_code", 2544);
        Uri localUri = (Uri)localIntent1.getExtras().getParcelable("android.intent.extra.STREAM");
        if (localUri == null)
          continue;
        String str3 = localStorage.b(localUri, getContentResolver());
        if (str3 == null)
          continue;
        localIntent2.setData(Uri.parse("file://" + str3));
        continue;
      }
      if (!str1.startsWith("image/"))
        continue;
      if ("android.intent.action.SEND".equals(str2))
        if (!localIntent1.hasExtra("photo_fbid"))
          break label419;
      for (boolean bool = a(localIntent1.getLongExtra("photo_fbid", -1L), localIntent2); ; bool = false)
      {
        if (bool)
          break label423;
        localIntent2.putExtra("extra_photo_request_code", 2542);
        localIntent2.putExtra("android.intent.extra.STREAM", localIntent1.getParcelableExtra("android.intent.extra.STREAM"));
        break;
        if ("android.intent.action.SEND_MULTIPLE".equals(str2))
        {
          localIntent2.putExtra("extra_photo_request_code", 2543);
          localIntent2.putExtra("android.intent.extra.STREAM", localIntent1.getParcelableArrayListExtra("android.intent.extra.STREAM"));
          break;
        }
        Preconditions.checkState(false, "Unexpected action: " + str2);
        break;
      }
    }
  }

  public String i()
  {
    return null;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 == -1)
        switch (paramInt1)
        {
        default:
          BLog.e(x(), "Unexpected request code received " + paramInt1);
        case 1756:
        }
      while (true)
      {
        return;
        if (paramIntent.getBooleanExtra("is_uploading_media", false))
          continue;
        ((ComposerPublishService)C().a(ComposerPublishService.class)).a(paramIntent, ComposerPublishService.Publisher.IMPLICIT_INTENT);
      }
    }
    finally
    {
      finish();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ImplicitShareIntentHandler
 * JD-Core Version:    0.6.0
 */