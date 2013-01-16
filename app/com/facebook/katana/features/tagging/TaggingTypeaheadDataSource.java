package com.facebook.katana.features.tagging;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.TaggingGraphGetSearchResponse;
import com.facebook.katana.service.method.TaggingGraphGetTaggeeResponse;
import com.facebook.widget.tagging.TaggingProfile;
import com.facebook.widget.tagging.TaggingProfile.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TaggingTypeaheadDataSource
{
  private static int a = 3;
  private static int b = 5;
  private Context c;
  private ArrayList<TaggingProfile> d;

  public TaggingTypeaheadDataSource(Context paramContext)
  {
    this.c = paramContext;
  }

  private TaggingProfile a(TaggingGraphGetTaggeeResponse paramTaggingGraphGetTaggeeResponse)
  {
    String str1 = paramTaggingGraphGetTaggeeResponse.c();
    long l = paramTaggingGraphGetTaggeeResponse.a().longValue();
    String str2 = paramTaggingGraphGetTaggeeResponse.e();
    if ("user".equals(paramTaggingGraphGetTaggeeResponse.b()));
    for (TaggingProfile.Type localType = TaggingProfile.Type.USER; ; localType = TaggingProfile.Type.UNKNOWN)
      return new TaggingProfile(str1, l, str2, localType, paramTaggingGraphGetTaggeeResponse.d());
  }

  private ArrayList<TaggingProfile> a()
  {
    TaggingProfile localTaggingProfile = b();
    ArrayList localArrayList1 = c();
    ArrayList localArrayList2 = d();
    ArrayList localArrayList3 = new ArrayList();
    if (localTaggingProfile != null)
      localArrayList3.add(localTaggingProfile);
    if (localArrayList1 != null)
      localArrayList3.addAll(localArrayList1);
    if (localArrayList2 != null)
      localArrayList3.addAll(localArrayList2);
    return localArrayList3;
  }

  private ArrayList<TaggingProfile> a(Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3, TaggingProfile.Type paramType)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramCursor == null);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      paramCursor.moveToFirst();
      while (!paramCursor.isAfterLast())
      {
        localArrayList1.add(new TaggingProfile(paramCursor.getString(paramInt1), paramCursor.getLong(paramInt2), paramCursor.getString(paramInt3), paramType));
        paramCursor.moveToNext();
      }
    }
  }

  private ArrayList<TaggingProfile> a(CharSequence paramCharSequence)
  {
    boolean bool = Gatekeeper.a(this.c, "tagging_enable_fof_android").booleanValue();
    Object localObject = null;
    if (!bool);
    while (true)
    {
      return localObject;
      TaggingTypeaheadDataSource.1 local1 = new TaggingTypeaheadDataSource.1(this, paramCharSequence);
      AppSession.a(this.c, true).a(new TaggingTypeaheadDataSource.2(this, local1));
      local1.a();
      TaggingGraphGetSearchResponse localTaggingGraphGetSearchResponse = local1.b();
      localObject = null;
      if (localTaggingGraphGetSearchResponse == null)
        continue;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localTaggingGraphGetSearchResponse.a().iterator();
      while (localIterator.hasNext())
      {
        TaggingGraphGetTaggeeResponse localTaggingGraphGetTaggeeResponse = (TaggingGraphGetTaggeeResponse)localIterator.next();
        if ((localTaggingGraphGetTaggeeResponse == null) || (localTaggingGraphGetTaggeeResponse.c() == null))
          continue;
        localArrayList.add(a(localTaggingGraphGetTaggeeResponse));
      }
      localObject = localArrayList;
    }
  }

  private ArrayList<TaggingProfile> a(ArrayList<TaggingProfile> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      TaggingProfile localTaggingProfile = (TaggingProfile)localIterator.next();
      if (((!paramBoolean1) && (localTaggingProfile.d() == TaggingProfile.Type.SELF)) || ((!paramBoolean2) && (localTaggingProfile.d() == TaggingProfile.Type.USER)) || ((!paramBoolean3) && (localTaggingProfile.d() == TaggingProfile.Type.PAGE)) || ((!paramBoolean4) && (localTaggingProfile.d() == TaggingProfile.Type.TEXT)))
        continue;
      localArrayList.add(localTaggingProfile);
    }
    return localArrayList;
  }

  private TaggingProfile b()
  {
    AppSession localAppSession = AppSession.b(this.c, false);
    FacebookUser localFacebookUser;
    if (localAppSession != null)
      localFacebookUser = localAppSession.b().a();
    for (TaggingProfile localTaggingProfile = new TaggingProfile(localFacebookUser.mDisplayName, localAppSession.b().userId, localFacebookUser.mImageUrl, TaggingProfile.Type.SELF); ; localTaggingProfile = null)
      return localTaggingProfile;
  }

  private TaggingProfile b(CharSequence paramCharSequence)
  {
    return new TaggingProfile(paramCharSequence.toString(), -1L, null, TaggingProfile.Type.TEXT);
  }

  private ArrayList<TaggingProfile> c()
  {
    Cursor localCursor = this.c.getContentResolver().query(ConnectionsContract.d, TaggingTypeaheadDataSource.FriendsQuery.a, null, null, null);
    ArrayList localArrayList = a(localCursor, localCursor.getColumnIndex("display_name"), localCursor.getColumnIndex("user_id"), localCursor.getColumnIndex("user_image_url"), TaggingProfile.Type.USER);
    localCursor.close();
    return localArrayList;
  }

  private ArrayList<TaggingProfile> d()
  {
    Cursor localCursor = this.c.getContentResolver().query(ConnectionsContract.i, TaggingTypeaheadDataSource.FannedPagesQuery.a, null, null, "connection_type, display_name");
    ArrayList localArrayList = a(localCursor, localCursor.getColumnIndex("display_name"), localCursor.getColumnIndex("user_id"), localCursor.getColumnIndex("user_image_url"), TaggingProfile.Type.PAGE);
    localCursor.close();
    return localArrayList;
  }

  public List<TaggingProfile> a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.d == null)
      a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0));
    ArrayList localArrayList3;
    for (ArrayList localArrayList1 = this.d; ; localArrayList1 = a(localArrayList3, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4))
    {
      return localArrayList1;
      ArrayList localArrayList2 = new ArrayList();
      String str = paramCharSequence.toString().toLowerCase();
      Iterator localIterator1 = this.d.iterator();
      while (localIterator1.hasNext())
      {
        TaggingProfile localTaggingProfile2 = (TaggingProfile)localIterator1.next();
        if (!localTaggingProfile2.a(str))
          continue;
        localArrayList2.add(localTaggingProfile2);
      }
      localArrayList3 = a(localArrayList2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      if ((localArrayList3.size() < b) && (paramCharSequence.length() >= a) && (paramBoolean5))
      {
        ArrayList localArrayList4 = a(paramCharSequence);
        if (localArrayList4 != null)
        {
          HashSet localHashSet = new HashSet();
          Iterator localIterator2 = localArrayList3.iterator();
          while (localIterator2.hasNext())
            localHashSet.add(Long.valueOf(((TaggingProfile)localIterator2.next()).b()));
          Iterator localIterator3 = localArrayList4.iterator();
          while (localIterator3.hasNext())
          {
            TaggingProfile localTaggingProfile1 = (TaggingProfile)localIterator3.next();
            if (localHashSet.contains(Long.valueOf(localTaggingProfile1.b())))
              continue;
            localArrayList3.add(localTaggingProfile1);
          }
        }
      }
      if (!paramBoolean4)
        continue;
      localArrayList3.add(b(paramCharSequence));
    }
  }

  public List<TaggingProfile> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.d == null)
      this.d = a();
    return a(this.d, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingTypeaheadDataSource
 * JD-Core Version:    0.6.0
 */