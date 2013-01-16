package com.facebook.katana.features.composer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FriendList;
import com.facebook.katana.service.method.AudienceSettings;
import com.facebook.katana.ui.SectionedListAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AudienceAdapter extends SectionedListAdapter
{
  public boolean a = false;
  public boolean b = false;
  private Map<AudienceOption.Type, List<AudienceOption>> c;
  private int[] d;
  private Context e;
  private LayoutInflater f;
  private PrivacySetting g;
  private AudienceSettings h;
  private boolean i;
  private AudienceOption.Type[] j;

  public AudienceAdapter()
  {
    AudienceOption.Type[] arrayOfType = new AudienceOption.Type[2];
    arrayOfType[0] = AudienceOption.Type.PRIVACY_SETTING;
    arrayOfType[1] = AudienceOption.Type.FRIEND_LIST;
    this.j = arrayOfType;
  }

  private void b(PrivacySetting paramPrivacySetting)
  {
    int k;
    int m;
    if ((this.d == null) || (!this.b))
    {
      k = Arrays.asList(this.j).indexOf(AudienceOption.Type.PRIVACY_SETTING);
      Iterator localIterator = ((List)this.c.get(AudienceOption.Type.PRIVACY_SETTING)).iterator();
      m = -1;
      AudienceOption localAudienceOption;
      do
      {
        if (!localIterator.hasNext())
          break;
        localAudienceOption = (AudienceOption)localIterator.next();
        m++;
      }
      while (!((AudienceAdapter.PrivacySettingAudienceOption)localAudienceOption).d().equals(paramPrivacySetting));
    }
    while (true)
    {
      if ((k >= 0) && (m >= 0))
      {
        this.d = new int[] { k, m };
        j();
      }
      return;
      m = -1;
    }
  }

  public int a(int paramInt)
  {
    return 0;
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView1 = this.f.inflate(2130903092, null); ; localView1 = paramView)
    {
      LinearLayout localLinearLayout = (LinearLayout)localView1;
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131296489);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131296488);
      View localView2 = localLinearLayout.findViewById(2131296490);
      AudienceOption localAudienceOption = (AudienceOption)((List)this.c.get(this.j[paramInt1])).get(paramInt2);
      localTextView.setText(localAudienceOption.b());
      localImageView.setImageResource(localAudienceOption.a());
      int k;
      if (this.d != null)
        if ((this.d[0] == paramInt1) && (this.d[1] == paramInt2))
          k = 1;
      while (true)
      {
        int m = 0;
        if (k != 0);
        while (true)
        {
          localView2.setVisibility(m);
          return localLinearLayout;
          k = 0;
          break;
          m = 8;
        }
        k = 0;
      }
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = this.f.inflate(2130903239, null); ; localView = paramView)
    {
      TextView localTextView = (TextView)localView;
      String str = new String();
      switch (AudienceAdapter.1.a[this.j[paramInt].ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        localTextView.setText(str);
        return localView;
        str = this.e.getString(2131362856);
        continue;
        str = this.e.getString(2131362858);
      }
    }
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    this.e = paramContext;
    this.i = paramBoolean;
    this.f = LayoutInflater.from(paramContext);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
      localArrayList.add(new AudienceAdapter.PrivacySettingAudienceOption(this, new PrivacySetting("FRIENDS_OF_FRIENDS")));
    while (true)
    {
      localArrayList.add(new AudienceAdapter.PrivacySettingAudienceOption(this, new PrivacySetting("ALL_FRIENDS")));
      localArrayList.add(new AudienceAdapter.PrivacySettingAudienceOption(this, new PrivacySetting("SELF")));
      if (FacebookAffiliation.b())
        localArrayList.add(new AudienceAdapter.PrivacySettingAudienceOption(this, PrivacySetting.FB_ONLY));
      this.c = new HashMap();
      this.c.put(AudienceOption.Type.PRIVACY_SETTING, localArrayList);
      return;
      localArrayList.add(new AudienceAdapter.PrivacySettingAudienceOption(this, new PrivacySetting("EVERYONE")));
    }
  }

  public void a(PrivacySetting paramPrivacySetting)
  {
    this.g = paramPrivacySetting;
    if (paramPrivacySetting == null)
      return;
    if ((this.i) && (paramPrivacySetting.value.equals("EVERYONE")))
      paramPrivacySetting = new PrivacySetting("FRIENDS_OF_FRIENDS");
    List localList2;
    int m;
    if (("CUSTOM".equals(paramPrivacySetting.value)) && ("SOME_FRIENDS".equals(paramPrivacySetting.friends)))
    {
      localList2 = (List)this.c.get(AudienceOption.Type.FRIEND_LIST);
      m = Arrays.asList(this.j).indexOf(AudienceOption.Type.FRIEND_LIST);
    }
    while (true)
    {
      try
      {
        long l2 = Long.valueOf(paramPrivacySetting.allow).longValue();
        l1 = l2;
        if (l1 != -1L)
        {
          Iterator localIterator2 = localList2.iterator();
          n = -1;
          if (!localIterator2.hasNext())
            break label312;
          AudienceOption localAudienceOption = (AudienceOption)localIterator2.next();
          n++;
          if (((AudienceAdapter.FriendListAudienceOption)localAudienceOption).d().flid != l1)
            continue;
          if ((m >= 0) && (n >= 0))
          {
            this.d = new int[] { m, n };
            j();
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = -1L;
        continue;
      }
      List localList1 = (List)this.c.get(AudienceOption.Type.PRIVACY_SETTING);
      Iterator localIterator1 = localList1.iterator();
      do
        if (!localIterator1.hasNext())
          break;
      while (!((AudienceAdapter.PrivacySettingAudienceOption)(AudienceOption)localIterator1.next()).d().equals(paramPrivacySetting));
      for (int k = 1; ; k = 0)
      {
        if (k == 0)
          localList1.add(new AudienceAdapter.PrivacySettingAudienceOption(this, paramPrivacySetting));
        b(paramPrivacySetting);
        break;
      }
      label312: int n = -1;
    }
  }

  public void a(AudienceSettings paramAudienceSettings)
  {
    this.h = paramAudienceSettings;
  }

  public void a(List<FriendList> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0));
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FriendList localFriendList = (FriendList)localIterator.next();
        if ((FacebookAffiliation.b()) && ("Facebook".equals(localFriendList.name)) && ("work".equals(localFriendList.type)))
          continue;
        localArrayList.add(new AudienceAdapter.FriendListAudienceOption(this, localFriendList));
      }
      this.c.put(AudienceOption.Type.FRIEND_LIST, localArrayList);
    }
  }

  public void a(int[] paramArrayOfInt)
  {
    this.d = paramArrayOfInt;
  }

  public boolean a(long paramLong)
  {
    List localList = (List)this.c.get(AudienceOption.Type.FRIEND_LIST);
    int k;
    if (localList == null)
      k = 0;
    while (true)
    {
      return k;
      Iterator localIterator = localList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          FriendList localFriendList = ((AudienceAdapter.FriendListAudienceOption)(AudienceOption)localIterator.next()).d();
          if (localFriendList.flid != paramLong)
            continue;
          a(localFriendList.a());
          k = 1;
          break;
        }
      k = 0;
    }
  }

  public int b(int paramInt)
  {
    List localList = (List)this.c.get(this.j[paramInt]);
    if (localList != null);
    for (int k = localList.size(); ; k = 0)
      return k;
  }

  public int b(int paramInt1, int paramInt2)
  {
    return 1;
  }

  public int c()
  {
    return 2;
  }

  public Object c(int paramInt)
  {
    return this.c.get(this.j[paramInt]);
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public AudienceOption d(int paramInt1, int paramInt2)
  {
    return (AudienceOption)((List)this.c.get(this.j[paramInt1])).get(paramInt2);
  }

  public boolean d()
  {
    return false;
  }

  public int d_()
  {
    return this.c.size();
  }

  public AudienceSettings e()
  {
    return this.h;
  }

  public void f()
  {
    b(new PrivacySetting("EVERYONE"));
  }

  public AudienceOption g()
  {
    if (this.d == null);
    for (AudienceOption localAudienceOption = null; ; localAudienceOption = d(this.d[0], this.d[1]))
      return localAudienceOption;
  }

  public int h()
  {
    AudienceOption localAudienceOption = g();
    if (localAudienceOption == null);
    for (int k = -1; ; k = localAudienceOption.a())
      return k;
  }

  public int[] i()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.AudienceAdapter
 * JD-Core Version:    0.6.0
 */