package com.facebook.katana.platform;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permissions
  implements INeedInit
{
  private static final Class<?> a = Permissions.class;
  private static String[] b = { "basic_info", "email", "read_friendslists", "read_insights", "read_mailbox", "read_requests", "read_stream" };
  private static String[] c = { "about_me", "activities", "birthday", "checkins", "education_history", "events", "groups", "hometown", "interests", "likes", "location", "notes", "online_presence", "photos", "questions", "relationships", "relationship_details", "religion_politics", "status", "subscriptions", "videos", "website", "work_history" };
  private static String[] d = { "publish_actions", "anonymous_publish_actions", "publish_checkins", "publish_stream" };
  private static String[] e = { "ads_management", "create_event", "manage_friendlists", "manage_notifications", "manage_pages", "rsvp_event", "xmpp_login" };
  private final Context f;
  private final Map<String, Permission> g = Maps.a();
  private int h = 0;

  public Permissions(Context paramContext)
  {
    this.f = paramContext;
  }

  private String a(String paramString)
  {
    boolean bool1;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Invalid write privacy.");
      if (!"SELF".equalsIgnoreCase(paramString))
        break label52;
      i = 2131363555;
      label28: if (i == 0)
        break label89;
    }
    label52: label89: for (String str = this.f.getString(i); ; str = "")
    {
      return str;
      bool1 = false;
      break;
      if ("ALL_FRIENDS".equalsIgnoreCase(paramString))
      {
        i = 2131363554;
        break label28;
      }
      boolean bool2 = "EVERYONE".equalsIgnoreCase(paramString);
      i = 0;
      if (!bool2)
        break label28;
      i = 2131363553;
      break label28;
    }
  }

  private String a(Collection<String> paramCollection)
  {
    String str;
    if (paramCollection.size() == 0)
      str = "";
    while (true)
    {
      return str;
      Iterator localIterator = paramCollection.iterator();
      if (paramCollection.size() == 1)
      {
        str = (String)localIterator.next();
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < -2 + paramCollection.size(); i++)
      {
        localStringBuilder.append((String)localIterator.next());
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localIterator.next());
      Context localContext = this.f;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localStringBuilder.toString();
      arrayOfObject[1] = localIterator.next();
      str = localContext.getString(2131363495, arrayOfObject);
    }
  }

  private List<String> a(List<String> paramList)
  {
    Collections.sort(paramList, new Permissions.1(this));
    HashSet localHashSet = Sets.a();
    LinkedList localLinkedList = Lists.b();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!this.g.containsKey(str1))
        continue;
      String str2 = ((Permission)this.g.get(str1)).a(this.f);
      if (localHashSet.contains(str2))
        continue;
      localHashSet.add(str2);
      localLinkedList.add(str2);
    }
    return localLinkedList;
  }

  private void a(String[] paramArrayOfString, Permission.Bucket paramBucket, String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    for (int i = 1; ; i = 0)
    {
      int j = paramArrayOfString.length;
      for (int k = 0; k < j; k++)
      {
        String str = paramArrayOfString[k];
        if (i != 0)
          str = paramString + str;
        Map localMap = this.g;
        int m = this.h;
        this.h = (m + 1);
        localMap.put(str, new Permission(m, str, paramBucket, b(str)));
      }
    }
  }

  private int b(String paramString)
  {
    String str = c(paramString);
    int i = this.f.getResources().getIdentifier(str, "string", this.f.getPackageName());
    if (i == 0)
      BLog.e(a, "Unable to find the resource identifier for permission " + str);
    return i;
  }

  private String c(String paramString)
  {
    if (paramString.startsWith("friends_"))
      paramString = paramString.replaceFirst("friends_", "friend_");
    while (true)
    {
      return "perm_" + paramString;
      if (!paramString.equals("read_friendlists"))
        continue;
      paramString = "read_friendslists";
    }
  }

  public String a(Collection<String> paramCollection, String paramString, List<String> paramList)
  {
    Preconditions.checkNotNull(paramCollection, "No permissions specified.");
    if (!paramCollection.isEmpty());
    HashMap localHashMap;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "No permissions specified");
      localHashMap = Maps.a();
      Iterator localIterator1 = EnumSet.allOf(Permission.Bucket.class).iterator();
      while (localIterator1.hasNext())
        localHashMap.put((Permission.Bucket)localIterator1.next(), Lists.a());
    }
    Iterator localIterator2 = paramCollection.iterator();
    if (localIterator2.hasNext())
    {
      String str6 = (String)localIterator2.next();
      Permission localPermission = (Permission)this.g.get(str6);
      if (localPermission != null);
      for (Permission.Bucket localBucket = localPermission.b(); ; localBucket = Permission.Bucket.UNKNOWN)
      {
        ((List)localHashMap.get(localBucket)).add(str6);
        break;
      }
    }
    ArrayList localArrayList = Lists.a();
    String str1 = a(a((List)localHashMap.get(Permission.Bucket.USER_READ_OBJECT)));
    String str2 = a(a((List)localHashMap.get(Permission.Bucket.FRIEND_READ_OBJECT)));
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      localArrayList.add(this.f.getString(2131363492, new Object[] { str1, str2 }));
      if (((List)localHashMap.get(Permission.Bucket.WRITE)).size() > 0)
      {
        String str5 = a(paramString);
        if (TextUtils.isEmpty(str5))
          break label506;
        localArrayList.add(this.f.getString(2131363493, new Object[] { str5 }));
      }
    }
    while (true)
    {
      String str3 = a(a((List)localHashMap.get(Permission.Bucket.MANAGE)));
      if (!TextUtils.isEmpty(str3))
        localArrayList.add(this.f.getString(2131363494, new Object[] { str3 }));
      String str4 = a(localArrayList);
      paramList.clear();
      paramList.addAll((Collection)localHashMap.get(Permission.Bucket.UNKNOWN));
      return str4;
      if (!TextUtils.isEmpty(str1))
      {
        localArrayList.add(this.f.getString(2131363490, new Object[] { str1 }));
        break;
      }
      if (TextUtils.isEmpty(str2))
        break;
      localArrayList.add(this.f.getString(2131363491, new Object[] { str2 }));
      break;
      label506: ((List)localHashMap.get(Permission.Bucket.UNKNOWN)).addAll((Collection)localHashMap.get(Permission.Bucket.WRITE));
    }
  }

  public void i_()
  {
    a(b, Permission.Bucket.USER_READ_OBJECT, "");
    a(c, Permission.Bucket.USER_READ_OBJECT, "user_");
    a(c, Permission.Bucket.FRIEND_READ_OBJECT, "friends_");
    a(d, Permission.Bucket.WRITE, "");
    a(e, Permission.Bucket.MANAGE, "");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.Permissions
 * JD-Core Version:    0.6.0
 */