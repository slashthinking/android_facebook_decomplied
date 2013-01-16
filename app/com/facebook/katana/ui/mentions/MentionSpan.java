package com.facebook.katana.ui.mentions;

import android.text.Editable;
import com.facebook.widget.tagging.TaggingProfile;
import com.facebook.widget.tagging.TaggingProfile.Type;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MentionSpan
{
  public static final Class<?> a = MentionSpan.class;
  private final TaggingProfile b;
  private ArrayList<MentionSpan.PartialMentionSpan> c;

  public MentionSpan(TaggingProfile paramTaggingProfile)
  {
    this.b = paramTaggingProfile;
  }

  private static int a(int paramInt)
  {
    if (paramInt == 0);
    for (int i = 33; ; i = 17)
      return i;
  }

  public int a(Editable paramEditable)
  {
    return paramEditable.getSpanStart(this.c.get(0));
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append(((MentionSpan.PartialMentionSpan)localIterator.next()).a());
    return localStringBuilder.toString().trim();
  }

  public void a(Editable paramEditable, int paramInt)
  {
    int i = 0;
    this.c = new ArrayList();
    String[] arrayOfString = b().split(" ");
    int j = arrayOfString.length;
    int k = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      MentionSpan.PartialMentionSpan localPartialMentionSpan = new MentionSpan.PartialMentionSpan(this, str);
      paramEditable.setSpan(localPartialMentionSpan, paramInt + k, paramInt + k + str.length(), a(this.c.size()));
      this.c.add(localPartialMentionSpan);
      k += 1 + str.length();
      i++;
    }
  }

  public int b(Editable paramEditable)
  {
    return paramEditable.getSpanEnd(this.c.get(-1 + this.c.size()));
  }

  protected String b()
  {
    return this.b.a();
  }

  public long c()
  {
    return this.b.b();
  }

  public boolean c(Editable paramEditable)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    MentionSpan.PartialMentionSpan localPartialMentionSpan1 = (MentionSpan.PartialMentionSpan)this.c.get(-1 + this.c.size());
    Object localObject;
    if ((this.b.d() == TaggingProfile.Type.USER) || (this.b.d() == TaggingProfile.Type.SELF))
      if (localPartialMentionSpan1.a(paramEditable))
        localObject = Lists.a(this.c);
    int j;
    while (true)
    {
      Iterator localIterator1 = ((List)localObject).iterator();
      while (true)
        if (localIterator1.hasNext())
        {
          MentionSpan.PartialMentionSpan localPartialMentionSpan3 = (MentionSpan.PartialMentionSpan)localIterator1.next();
          if ((localPartialMentionSpan3.a(paramEditable)) && (localArrayList.isEmpty()))
            continue;
          localArrayList.add(localPartialMentionSpan3);
          continue;
          localObject = this.c;
          break;
          Iterator localIterator3 = this.c.iterator();
          j = 0;
          if (localIterator3.hasNext())
            if (((MentionSpan.PartialMentionSpan)localIterator3.next()).a(paramEditable))
              break label322;
        }
    }
    label322: for (int k = 1; ; k = j)
    {
      j = k;
      break;
      if (j != 0)
        localArrayList.addAll(this.c);
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
        paramEditable.removeSpan((MentionSpan.PartialMentionSpan)localIterator2.next());
      this.c.removeAll(localArrayList);
      while (i < this.c.size())
      {
        MentionSpan.PartialMentionSpan localPartialMentionSpan2 = (MentionSpan.PartialMentionSpan)this.c.get(i);
        paramEditable.setSpan(localPartialMentionSpan2, paramEditable.getSpanStart(localPartialMentionSpan2), paramEditable.getSpanEnd(localPartialMentionSpan2), a(i));
        i++;
      }
      return this.c.isEmpty();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionSpan
 * JD-Core Version:    0.6.0
 */