package com.facebook.katana.features.bugreporter;

import android.content.Context;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.bugreporter.tasklist.TagInfo;
import com.facebook.katana.UserAgent;
import com.facebook.katana.service.autoupdate.AutoUpdateConstants;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Fb4aBugReporterConfig
  implements BugReporterConfig
{
  private final ImmutableList<TagInfo> a;
  private final Context b;
  private final OrcaSharedPreferences c;

  public Fb4aBugReporterConfig(Context paramContext, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramContext;
    this.c = paramOrcaSharedPreferences;
    TagInfo localTagInfo1 = new TagInfo(a(2131362016), 44221380450L);
    TagInfo localTagInfo2 = new TagInfo(a(2131362017), 274107481035L);
    TagInfo localTagInfo3 = new TagInfo(a(2131362018), 252834681411539L);
    TagInfo localTagInfo4 = new TagInfo(a(2131362019), 13027753847L);
    TagInfo localTagInfo5 = new TagInfo(a(2131362020), 14342832615L);
    TagInfo localTagInfo6 = new TagInfo(a(2131362021), 31201912707L);
    TagInfo localTagInfo7 = new TagInfo(a(2131362022), 16328376263L);
    TagInfo localTagInfo8 = new TagInfo(a(2131362023), 280264118692782L);
    TagInfo localTagInfo9 = new TagInfo(a(2131362024), 14422129270L);
    TagInfo localTagInfo10 = new TagInfo(a(2131362025), 356657594419325L);
    TagInfo localTagInfo11 = new TagInfo(a(2131362026), 12270205501L);
    TagInfo localTagInfo12 = new TagInfo(a(2131362027), 13027753847L);
    TagInfo[] arrayOfTagInfo = new TagInfo[9];
    arrayOfTagInfo[0] = new TagInfo(a(2131362028), 12403428395L);
    arrayOfTagInfo[1] = new TagInfo(a(2131362029), 13111313300L);
    arrayOfTagInfo[2] = new TagInfo(a(2131362030), 13303636031L);
    arrayOfTagInfo[3] = new TagInfo(a(2131362031), 287298977948845L);
    arrayOfTagInfo[4] = new TagInfo(a(2131362032), 15337777201L);
    arrayOfTagInfo[5] = new TagInfo(a(2131362033), 97622897630L);
    arrayOfTagInfo[6] = new TagInfo(a(2131362034), 132783110969L);
    arrayOfTagInfo[7] = new TagInfo(a(2131362035), 195737053793914L);
    arrayOfTagInfo[8] = new TagInfo(a(2131362036), 13409161937L);
    this.a = ImmutableList.a(localTagInfo1, localTagInfo2, localTagInfo3, localTagInfo4, localTagInfo5, localTagInfo6, localTagInfo7, localTagInfo8, localTagInfo9, localTagInfo10, localTagInfo11, localTagInfo12, arrayOfTagInfo);
  }

  private String a(int paramInt)
  {
    return this.b.getString(paramInt);
  }

  public static boolean e()
  {
    return true;
  }

  public boolean a()
  {
    int i = this.c.a(AutoUpdateConstants.c, -1);
    if (UserAgent.b(this.b) < i);
    for (int j = 1; ; j = 0)
      return j;
  }

  public ImmutableSet<Long> b()
  {
    return ImmutableSet.a(Long.valueOf(430104143700853L), Long.valueOf(312873537077L));
  }

  public ImmutableList<TagInfo> c()
  {
    return this.a;
  }

  public ImmutableSet<Long> d()
  {
    return ImmutableSet.a(Long.valueOf(312873537077L), Long.valueOf(490764514271518L));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig
 * JD-Core Version:    0.6.0
 */