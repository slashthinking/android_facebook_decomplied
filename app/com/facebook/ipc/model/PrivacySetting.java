package com.facebook.ipc.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.orca.common.util.StringUtil;
import java.util.Set;
import java.util.TreeSet;

public class PrivacySetting
  implements JMStaticKeysDictDestination
{
  public static final String ALL_FRIENDS = "ALL_FRIENDS";
  public static final String CUSTOM = "CUSTOM";
  public static final String DEFAULT = "DEFAULT";
  public static final String EVERYONE = "EVERYONE";
  public static final String FACEBOOK_GROUP_ID = "114000975315193";
  public static final PrivacySetting FB_ONLY = new PrivacySetting(null, "CUSTOM", "Facebook", null, null, null, "114000975315193", null);
  public static final String FRIENDS_OF_FRIENDS = "FRIENDS_OF_FRIENDS";
  public static final String NETWORKS_FRIENDS = "NETWORKS_FRIENDS";
  public static final String ONLY_ME = "SELF";
  public static final String SOME_FRIENDS = "SOME_FRIENDS";

  @JMAutogen.InferredType(jsonFieldName="allow")
  public final String allow;

  @JMAutogen.InferredType(jsonFieldName="deny")
  public final String deny;

  @JMAutogen.InferredType(jsonFieldName="description")
  public final String description;

  @JMAutogen.InferredType(jsonFieldName="friends")
  public final String friends;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String name;

  @JMAutogen.InferredType(jsonFieldName="networks")
  public final String networks;

  @JMAutogen.InferredType(jsonFieldName="objects")
  public final String objects;

  @JMAutogen.InferredType(jsonFieldName="value")
  public final String value;

  private PrivacySetting()
  {
    this.name = null;
    this.value = null;
    this.description = null;
    this.allow = null;
    this.deny = null;
    this.networks = null;
    this.objects = null;
    this.friends = null;
  }

  public PrivacySetting(String paramString)
  {
    this.name = null;
    this.value = paramString;
    this.description = null;
    this.allow = null;
    this.deny = null;
    this.networks = null;
    this.objects = null;
    this.friends = null;
  }

  public PrivacySetting(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.description = paramString3;
    this.allow = paramString4;
    this.deny = paramString5;
    this.networks = paramString6;
    this.objects = paramString7;
    this.friends = paramString8;
  }

  private static Set<String> a(String paramString)
  {
    TreeSet localTreeSet = new TreeSet();
    if ((paramString == null) || ("".equals(paramString)));
    while (true)
    {
      return localTreeSet;
      String[] arrayOfString = paramString.split(",");
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        localTreeSet.add(arrayOfString[j]);
    }
  }

  private static boolean a(String paramString1, String paramString2)
  {
    return a(paramString1).equals(a(paramString2));
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    boolean bool1 = paramObject instanceof PrivacySetting;
    int j = 0;
    if (!bool1);
    PrivacySetting localPrivacySetting;
    while (true)
    {
      return j;
      localPrivacySetting = (PrivacySetting)paramObject;
      boolean bool2 = StringUtil.b(this.value, localPrivacySetting.value);
      j = 0;
      if (!bool2)
        continue;
      if ("CUSTOM".equals(this.value))
        break;
      j = i;
    }
    if ((StringUtil.b(this.friends, localPrivacySetting.friends)) && (a(this.allow, localPrivacySetting.allow)) && (a(this.deny, localPrivacySetting.deny)) && (a(this.networks, localPrivacySetting.networks)) && (a(this.objects, localPrivacySetting.objects)));
    while (true)
    {
      j = i;
      break;
      i = 0;
    }
  }

  public int hashCode()
  {
    return 0;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.model.PrivacySetting
 * JD-Core Version:    0.6.0
 */