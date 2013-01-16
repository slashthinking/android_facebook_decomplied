package com.facebook.katana.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.photos.util.PhotoUtils;
import javax.inject.Provider;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationHelper
{
  private static final Class<?> a = NotificationHelper.class;
  private final Context b;
  private final Provider<Boolean> c;

  public NotificationHelper(Context paramContext, Provider<Boolean> paramProvider)
  {
    this.b = paramContext;
    this.c = paramProvider;
  }

  private static long a(String paramString1, long paramLong, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString1);
      paramLong = l;
      return paramLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        ErrorReporting.a(paramString2, "failed to parse '" + paramString1 + "' as a long.", localNumberFormatException, true);
    }
  }

  public static String a(String paramString)
  {
    return b(paramString).optString("logging_data");
  }

  private String a(String paramString1, String paramString2)
  {
    if (Boolean.TRUE.equals(this.c.b()))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Uri.encode(paramString2);
      paramString2 = StringLocaleUtil.a("fb://native_post/%s?fallback_url=%s", arrayOfObject);
    }
    return paramString2;
  }

  private String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = b(paramString4);
    String str1 = localJSONObject.optString("action_type");
    String str2 = localJSONObject.optString("subobject_id");
    String str3 = localJSONObject.optString("owner_id");
    NotificationHelper.Type localType = NotificationHelper.Type.access$000(paramString1);
    Object localObject;
    if (str1.equals("timeline_review"))
      localObject = "fb://pending_posts";
    while (true)
    {
      return localObject;
      localObject = null;
      switch (NotificationHelper.1.a[localType.ordinal()])
      {
      default:
        localObject = null;
        break;
      case 1:
        localObject = a(paramString2, StringLocaleUtil.a("fb://post/%s", new Object[] { paramString2 }));
        break;
      case 2:
        try
        {
          String str5 = localJSONObject.optString("collection_id");
          String str6 = localJSONObject.optString("target_ent_id");
          boolean bool4 = str1.equals("tag_approval");
          localObject = null;
          if (!bool4)
          {
            boolean bool5 = str1.equals("comment");
            localObject = null;
            if (bool5)
            {
              boolean bool8 = Boolean.TRUE.equals(this.c.b());
              localObject = null;
              if (bool8);
            }
          }
          else
          {
            Object[] arrayOfObject3 = new Object[2];
            arrayOfObject3[0] = PhotoUtils.b(paramString2);
            arrayOfObject3[1] = PhotoUtils.a(paramString2);
            localObject = StringLocaleUtil.a("fb://photofeedback/%s/%s", arrayOfObject3);
            continue;
          }
          boolean bool6 = StringUtils.c(str6);
          localObject = null;
          if (bool6)
          {
            Object[] arrayOfObject4 = new Object[2];
            arrayOfObject4[0] = PhotoUtils.b(paramString2);
            arrayOfObject4[1] = paramString2;
            localObject = StringLocaleUtil.a("fb://photo/%s/%s", arrayOfObject4);
            continue;
          }
          boolean bool7 = StringUtils.c(str5);
          localObject = null;
          if (bool7)
          {
            localObject = StringLocaleUtil.a("fb://photo/%s", new Object[] { str6 });
            continue;
          }
          String str7 = StringLocaleUtil.a("fb://photo/%s/?set=%s", new Object[] { str6, str5 });
          localObject = str7;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          ErrorReporting.a("PhotoNotificationObjectIdParsing", "could not parse '" + paramString2 + "' as a long.", localNumberFormatException2, true);
        }
        break;
      case 3:
      case 4:
        if (str1.equals("android_ci_retarget"))
        {
          localObject = HowFound.a("notification");
          continue;
        }
        localObject = StringLocaleUtil.a("fb://profile/%s", new Object[] { paramString2 });
        break;
      case 5:
        localObject = StringLocaleUtil.a("fb://event/%s", new Object[] { paramString2 });
        break;
      case 6:
        localObject = "fb://pokes";
        break;
      case 7:
        localObject = StringLocaleUtil.a("fb://page/%s", new Object[] { paramString2 });
        break;
      case 8:
        if (!StringUtils.c(str2))
        {
          long l = a(str2, -1L, "GroupNotificationSubObjectIdParsing");
          boolean bool3 = l < 0L;
          localObject = null;
          if (bool3)
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = paramString2;
            arrayOfObject2[1] = Long.valueOf(l);
            localObject = a(paramString2, str2, StringLocaleUtil.a("fb://group/%s/%d", arrayOfObject2));
          }
        }
        while (localObject == null)
        {
          localObject = StringLocaleUtil.a("fb://group/%s/wall/inner", new Object[] { paramString2 });
          break;
          boolean bool2 = str1.equals("member_review");
          localObject = null;
          if (!bool2)
            continue;
          localObject = StringLocaleUtil.a("fb://group/%s/members", new Object[] { paramString2 });
        }
      case 9:
        try
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = paramString2;
          arrayOfObject1[1] = PhotoUtils.b(paramString2);
          String str4 = StringLocaleUtil.a("fb://album/faceweb/%s?owner=%s", arrayOfObject1);
          localObject = str4;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          ErrorReporting.a("AlbumNotificationObjectIdParsing", "could not parse '" + paramString2 + "' as an album platform_id.", true);
          localObject = null;
        }
        break;
      case 10:
        localObject = paramString3;
        break;
      case 11:
        localObject = StringLocaleUtil.a("fb://note/%s", new Object[] { paramString2 });
        break;
      case 12:
      case 13:
        boolean bool1 = StringUtils.c(str3);
        localObject = null;
        if (bool1)
          continue;
        localObject = a(str3, paramString2, StringLocaleUtil.a("fb://story/%s/%s", new Object[] { paramString2, str3 }));
      }
    }
  }

  private static JSONObject b(String paramString)
  {
    if (!StringUtils.c(paramString));
    while (true)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        Log.a(a, "Exception parsing join data", localJSONException);
        ErrorReporting.a(a.toString(), "Error in parsing join data: " + paramString, localJSONException, true);
      }
      JSONObject localJSONObject = new JSONObject();
    }
  }

  public Intent a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = null;
    if (StringUtils.c(paramString1))
      Log.c(a, "Empty object type for: " + paramString3);
    while (true)
    {
      return localIntent;
      if (StringUtils.c(paramString2))
      {
        Log.c(a, "Empty object id for: " + paramString3);
        localIntent = null;
        continue;
      }
      String str = b(paramString1, paramString2, paramString3, paramString4);
      localIntent = null;
      if (str == null)
        continue;
      localIntent = IntentUriHandler.a(this.b, str);
    }
  }

  public String a(String paramString1, String paramString2, String paramString3)
  {
    return a(StringUtil.a("%s_%s", new Object[] { paramString1, paramString2 }), paramString3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.NotificationHelper
 * JD-Core Version:    0.6.0
 */