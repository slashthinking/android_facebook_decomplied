package com.facebook.katana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.codegenerator.CodeGeneratorActivity;
import com.facebook.katana.activity.events.EventCreationActivity;
import com.facebook.katana.activity.findfriends.FriendFinderActivity;
import com.facebook.katana.activity.media.LegacyPhotoGalleryActivity;
import com.facebook.katana.activity.media.PhotoGalleryActivity;
import com.facebook.katana.activity.media.PhotoSetActivity;
import com.facebook.katana.activity.media.PhotosLegacyAdapterActivity;
import com.facebook.katana.activity.media.UploadPhotoActivity;
import com.facebook.katana.activity.media.ViewVideoActivity;
import com.facebook.katana.activity.media.detection.barcode.QRCodeActivity;
import com.facebook.katana.activity.notifications.NotificationsActivity;
import com.facebook.katana.activity.notifications.PushNotificationsSettingsMigrationActivity;
import com.facebook.katana.activity.photos.PhotosTabActivity;
import com.facebook.katana.activity.places.FriendCheckinsActivity;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.faceweb.FacewebUriMap;
import com.facebook.katana.gifts.GiftsActivity;
import com.facebook.katana.orca.CanonicalThreadLauncherActivity;
import com.facebook.katana.orca.ForceMessenger;
import com.facebook.katana.orca.InstallMessengerActivity;
import com.facebook.katana.orca.InstallMessengerFragment.ClickThroughDestination;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.Utils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.uri.FbUriIntentHandler;
import com.facebook.uri.UriTemplateMap;
import com.facebook.uri.UriTemplateMap.InvalidUriException;
import com.facebook.uri.UriTemplateMap.InvalidUriTemplateException;
import com.facebook.uri.UriTemplateMap.UriMatch;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntentUriHandler extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  public static final Class<?> n = IntentUriHandler.class;
  private static final Map<String, Boolean> o = Collections.synchronizedMap(new HashMap());
  private static UriTemplateMap<IntentUriHandler.UriHandler> p = new UriTemplateMap();
  private static UriTemplateMap<IntentUriHandler.UriHandler> q;
  private static UriTemplateMap<IntentUriHandler.UriHandler> r;
  private static UriTemplateMap<IntentUriHandler.UriHandler> s;

  static
  {
    a(StringLocaleUtil.a("fb://faceweb/f?href={%s}", new Object[] { "mobile_page" }), FbFragmentChromeActivity.class);
    String str1 = StringLocaleUtil.a("fb://facewebmodal/f?href={%s}", new Object[] { "mobile_page" });
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = "faceweb_modal";
    arrayOfObject1[1] = Boolean.valueOf(true);
    a(str1, FbFragmentChromeActivity.class, Utils.a(arrayOfObject1));
    a("fb://feed/", FbFragmentChromeActivity.class, Utils.a(new Object[] { "mobile_page", "/home.php" }));
    a("fb://feed/top_stories", FbFragmentChromeActivity.class, Utils.a(new Object[] { "mobile_page", "/home.php?sk=h_nor" }));
    a("fb://feed/most_recent_stories", FbFragmentChromeActivity.class, Utils.a(new Object[] { "mobile_page", "/home.php?sk=h_chr" }));
    a("fb://feed/{#user_id}", null);
    a("fb://profile_qr", QRCodeActivity.class);
    a("fb://friends", UsersTabHostActivity.class);
    a("fb://friends/requests/", RequestsActivity.class);
    a(StringLocaleUtil.a("fb://findfriends?how_found={%s %s}", new Object[] { "how_found", "unknown" }), FriendFinderActivity.class);
    a("fb://pages", null);
    a("fb://messaging", ThreadListActivity.class);
    a(StringLocaleUtil.a("fb://messaging/{%s}", new Object[] { "user_id" }), CanonicalThreadLauncherActivity.class);
    a("fb://messaging/compose/new", CreateThreadActivity.class);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = CreateThreadActivity.s;
    arrayOfObject2[1] = Boolean.valueOf(true);
    a("fb://messaging/compose/new/group", CreateThreadActivity.class, Utils.a(arrayOfObject2));
    a(StringLocaleUtil.a("fb://messaging/compose/{%s}", new Object[] { "user_id" }), CanonicalThreadLauncherActivity.class);
    a(StringLocaleUtil.a("fb://messaging/thread/thread?id={%s}", new Object[] { "thread_id" }), ThreadViewActivity.class);
    a("fb://online", CreateThreadActivity.class);
    a("fb://requests", RequestsActivity.class);
    a("fb://event_creation", EventCreationActivity.class);
    a("fb://places", FriendCheckinsActivity.class);
    a("fb://notes", null);
    a("fb://notifications", NotificationsActivity.class);
    a("fb://albums", PhotosTabActivity.class);
    Object[] arrayOfObject3 = new Object[4];
    arrayOfObject3[0] = "tab_to_show";
    arrayOfObject3[1] = "sync";
    arrayOfObject3[2] = "from_fburl";
    arrayOfObject3[3] = Boolean.valueOf(true);
    a("fb://photosync", PhotosTabActivity.class, Utils.a(arrayOfObject3));
    Object[] arrayOfObject4 = new Object[4];
    arrayOfObject4[0] = "tab_to_show";
    arrayOfObject4[1] = "sync";
    arrayOfObject4[2] = "from_fburl";
    arrayOfObject4[3] = Boolean.valueOf(true);
    a("fb://syncnux", PhotosTabActivity.class, Utils.a(arrayOfObject4));
    a(StringLocaleUtil.a("fb://album/{%s}?owner={#%s}", new Object[] { "album", "owner" }), PhotosLegacyAdapterActivity.class);
    a(StringLocaleUtil.a("fb://album/{%s}/{%s}?owner={#%s}", new Object[] { "open_method", "album", "owner" }), PhotosLegacyAdapterActivity.class);
    a(StringLocaleUtil.a("fb://photo/{%1$s}/{%2$s}/{%3$s}?action={%4$s %5$s}", new Object[] { "owner", "album", "photo", "action", "android.intent.action.VIEW" }), LegacyPhotoGalleryActivity.class);
    a(StringLocaleUtil.a("fb://photo/{%1$s}/{%2$s}?action={%3$s %4$s}", new Object[] { "owner", "photo", "action", "android.intent.action.VIEW" }), LegacyPhotoGalleryActivity.class);
    a(StringLocaleUtil.a("fb://photo/{#%s}/?set={%s}", new Object[] { "photo_fbid", "photoset_token" }), PhotoGalleryActivity.class);
    a(StringLocaleUtil.a("fb://mediaset/{%s}", new Object[] { "set_token" }), PhotoSetActivity.class);
    a(StringLocaleUtil.a("fb://photo/{#%s}/", new Object[] { "photo_fbid" }), PhotoGalleryActivity.class);
    a(StringLocaleUtil.a("fb://upload/photo?uri={%s}", new Object[] { "photo_uri" }), UploadPhotoActivity.class);
    a(StringLocaleUtil.a("fb://gift/?recipient={%1$s}&entry_point={%2$s %3$s}", new Object[] { "recipient_facebook_id", "entry_point", "unknown_entry_point" }), GiftsActivity.class);
    a(StringLocaleUtil.a("fb://gift/sendinterstitial/?recipient={%1$s}&entry_point={%2$s %3$s}", new Object[] { "recipient_facebook_id", "entry_point", "unknown_entry_point" }), GiftsActivity.class);
    a("fb://video/?href={href}", ViewVideoActivity.class);
    a(StringLocaleUtil.a("fb://video/{%s}?source_url={href}", new Object[] { "video_fbid" }), ViewVideoActivity.class);
    a("fb://codegenerator", CodeGeneratorActivity.class);
    a("fb://settings", SettingsActivity.class);
    a("fb://notifications_settings_migration", PushNotificationsSettingsMigrationActivity.class);
    a(StringLocaleUtil.a("fb://appcenter/mobile_canvas/f?href={%s}", new Object[] { "mobile_page" }), AppCenterMobileCanvasActivity.class);
    p.a(StringLocaleUtil.a("fb://redirect?href={%s}", new Object[] { "destination" }), new IntentUriHandler.1());
    p.a(StringLocaleUtil.a("fb://messages/inbox/{%s}", new Object[] { "destination" }), new IntentUriHandler.2());
    s = new UriTemplateMap();
    a("facebook:/chat", "fb://online");
    a("facebook:/events", "fb://events");
    a("facebook:/friends", "fb://friends");
    a("facebook:/inbox", "fb://messaging");
    a("facebook:/newsfeed", "fb://feed");
    a("facebook:/places", "fb://places");
    a("facebook:/requests", "fb://requests");
    a("facebook:/wall?user={user}", "fb://profile/<user>/wall");
    a("facebook:/wall", "fb://profile");
    a("facebook:/info?user={user}", "fb://profile/<user>/info");
    a("facebook:/notifications", "fb://notifications");
    a("facebook:/photos?user={uid}&album={aid}&photo={pid}", "fb://photo/<uid>/<aid>/<pid>");
    a("facebook:/photos?user={uid}&photo={pid}", "fb://photo/<uid>/<pid>");
    a("facebook:/photos?user={uid}&album={aid}", "fb://album/<aid>?owner=<uid>");
    a("facebook:/photos?user={uid}", "fb://profile/<uid>/photos");
    a("facebook:/photos", "fb://albums");
    a("facebook:/feedback?user={uid}&post={post_id}", "fb://post/<post_id>?owner=<uid>");
    q = new UriTemplateMap();
    a(q, "fb://messaging", InstallMessengerActivity.class, null);
    UriTemplateMap localUriTemplateMap = q;
    String str2 = StringLocaleUtil.a("fb://messaging/compose/{%s}", new Object[] { "canonical_thread_user" });
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = "click_through";
    arrayOfObject5[1] = InstallMessengerFragment.ClickThroughDestination.CANONICAL_THREAD;
    a(localUriTemplateMap, str2, InstallMessengerActivity.class, Utils.a(arrayOfObject5));
    r = new UriTemplateMap();
    b("fb://messaging", "fb-messenger://threads");
    b("fb://messaging/compose/{user}", "fb-messenger://user/<user>");
    b("fb://messaging/thread/thread?id={thread_id}", "fb-messenger://thread/<thread_id>");
  }

  public static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent;
    try
    {
      FbInjector localFbInjector = FbInjector.a(paramContext);
      ForceMessenger localForceMessenger = (ForceMessenger)localFbInjector.a(ForceMessenger.class);
      if (localForceMessenger.b(paramContext))
      {
        if (ApplicationUtils.c(paramContext))
        {
          localObject = r.a(paramString);
          if (localObject != null)
          {
            localForceMessenger.b();
            if (localForceMessenger.a());
          }
        }
        UriTemplateMap.UriMatch localUriMatch3;
        for (localObject = null; localObject != null; localObject = localUriMatch3)
        {
          localIntent = ((IntentUriHandler.UriHandler)((UriTemplateMap.UriMatch)localObject).a).a(paramContext, ((UriTemplateMap.UriMatch)localObject).b);
          if (localIntent == null)
            localIntent = ((FbUriIntentHandler)localFbInjector.a(FbUriIntentHandler.class)).a(paramContext, paramString);
          if (localIntent == null)
          {
            UriTemplateMap.UriMatch localUriMatch2 = c(paramContext, paramString);
            if (localUriMatch2 != null)
              localIntent = ((IntentUriHandler.UriHandler)localUriMatch2.a).a(paramContext, localUriMatch2.b);
          }
          if (localIntent == null)
          {
            UriTemplateMap.UriMatch localUriMatch1 = d(paramContext, paramString);
            if (localUriMatch1 != null)
              localIntent = ((IntentUriHandler.UriHandler)localUriMatch1.a).a(paramContext, localUriMatch1.b);
          }
          if ((localIntent == null) && (paramString != null))
            localIntent = NativeThirdPartyUriHelper.a(paramContext, Uri.parse(paramString));
          if (localIntent == null)
          {
            Uri localUri = Uri.parse(paramString);
            if ((Constants.URL.b(localUri)) && (!Constants.URL.a(localUri)))
              localIntent = a(paramContext, a(localUri));
          }
          if (localIntent != null)
            localIntent.putExtra("extra_launch_uri", paramString);
          if ((localIntent == null) || (localIntent.getData() == null) || (!"market".equals(localIntent.getData().getScheme())))
            break label337;
          localIntent.setFlags(524288);
          break label337;
          if (!localForceMessenger.a(paramContext))
            break label331;
          localUriMatch3 = q.a(paramString);
        }
      }
    }
    catch (UriTemplateMap.InvalidUriException localInvalidUriException)
    {
      while (true)
      {
        BLog.e(IntentUriHandler.class, "The uri passed to getIntentForUri() was malformed");
        localIntent = null;
        break;
        localIntent = null;
        continue;
        label331: Object localObject = null;
      }
    }
    label337: return (Intent)localIntent;
  }

  public static String a(Uri paramUri)
  {
    return StringLocaleUtil.a("fb://faceweb/f?href=%s", new Object[] { Uri.encode(paramUri.toString()) });
  }

  public static String a(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    return new Uri.Builder().encodedPath(localUri.getPath()).encodedQuery(localUri.getEncodedQuery()).encodedFragment(localUri.getFragment()).toString();
  }

  private void a(Intent paramIntent)
  {
    if (!b(this, String.valueOf(paramIntent.getData())))
      b(this, "fb://feed");
  }

  private static void a(UriTemplateMap<IntentUriHandler.UriHandler> paramUriTemplateMap, String paramString, Class<? extends Activity> paramClass, Bundle paramBundle)
  {
    try
    {
      paramUriTemplateMap.a(paramString, new IntentUriHandler.NativeUriHandler(paramClass, paramBundle));
      return;
    }
    catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException)
    {
      while (true)
        Log.a(n, "Invalid uri template: " + paramString, localInvalidUriTemplateException);
    }
  }

  private static void a(String paramString, Class<? extends Activity> paramClass)
  {
    a(paramString, paramClass, null);
  }

  private static void a(String paramString, Class<? extends Activity> paramClass, Bundle paramBundle)
  {
    a(p, paramString, paramClass, paramBundle);
  }

  private static void a(String paramString1, String paramString2)
  {
    try
    {
      s.a(paramString1, new IntentUriHandler.DeepLinkIntentUriHandler(paramString2));
      return;
    }
    catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException)
    {
      while (true)
        Log.a(n, "Invalid uri template: " + paramString1, localInvalidUriTemplateException);
    }
  }

  public static boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = a(paramContext, paramString);
    if ((localIntent != null) && (paramBundle != null))
      localIntent.putExtras(paramBundle);
    if (localIntent != null)
    {
      NativeThirdPartyUriHelper.a(paramContext, localIntent);
      Context localContext = (Context)FbInjector.a(paramContext).a(Activity.class);
      if ((localContext instanceof Activity))
        localContext.startActivity(localIntent);
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      localIntent.setFlags(0x10000000 | localIntent.getFlags());
      paramContext.startActivity(localIntent);
      break;
    }
  }

  private static void b(String paramString1, String paramString2)
  {
    try
    {
      r.a(paramString1, new IntentUriHandler.MessengerRedirectIntentUriHandler(paramString2));
      return;
    }
    catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException)
    {
      while (true)
        Log.a(n, "Invalid uri template: " + paramString1, localInvalidUriTemplateException);
    }
  }

  public static boolean b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  private static UriTemplateMap.UriMatch<IntentUriHandler.UriHandler> c(Context paramContext, String paramString)
  {
    Boolean localBoolean = Gatekeeper.a(paramContext, "faceweb_android");
    UriTemplateMap.UriMatch localUriMatch = null;
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      localUriMatch = null;
      if (bool == true)
      {
        UriTemplateMap localUriTemplateMap = FacewebUriMap.a(paramContext);
        localUriMatch = null;
        if (localUriTemplateMap != null)
          localUriMatch = localUriTemplateMap.a(paramString);
      }
    }
    return localUriMatch;
  }

  private static UriTemplateMap.UriMatch<IntentUriHandler.UriHandler> d(Context paramContext, String paramString)
  {
    UriTemplateMap.UriMatch localUriMatch = p.a(paramString);
    if (localUriMatch == null)
      localUriMatch = s.a(paramString);
    return localUriMatch;
  }

  public static void j()
  {
    o.clear();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(getIntent());
    finish();
  }

  public String i()
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.IntentUriHandler
 * JD-Core Version:    0.6.0
 */