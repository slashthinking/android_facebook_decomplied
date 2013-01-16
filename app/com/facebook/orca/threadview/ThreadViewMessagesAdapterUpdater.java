package com.facebook.orca.threadview;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.widget.animatablelistview.AnimatingListAdapter;
import com.facebook.widget.animatablelistview.AnimatingListTransactionBuilder;
import com.facebook.widget.animatablelistview.AnimationType;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import difflib.ChangeDelta;
import difflib.Chunk;
import difflib.DeleteDelta;
import difflib.Delta;
import difflib.DiffUtils;
import difflib.InsertDelta;
import difflib.Patch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadViewMessagesAdapterUpdater
{
  private static final Class<?> a = ThreadViewMessagesAdapterUpdater.class;
  private final AnimatingListAdapter<RowItem> b;

  public ThreadViewMessagesAdapterUpdater(AnimatingListAdapter<RowItem> paramAnimatingListAdapter)
  {
    this.b = paramAnimatingListAdapter;
  }

  private void a(AnimatingListTransactionBuilder<RowItem> paramAnimatingListTransactionBuilder, int paramInt1, int paramInt2, ThreadViewMessagesAdapterUpdater.ItemDeletionTracker paramItemDeletionTracker)
  {
    if (-10 + paramAnimatingListTransactionBuilder.a() < paramInt1)
    {
      paramAnimatingListTransactionBuilder.c(paramInt1);
      paramItemDeletionTracker.b(paramInt1);
    }
    while (true)
    {
      return;
      paramAnimatingListTransactionBuilder.a(paramInt1);
      paramItemDeletionTracker.a(paramInt2);
    }
  }

  private void a(AnimatingListTransactionBuilder<RowItem> paramAnimatingListTransactionBuilder, int paramInt, RowItem paramRowItem)
  {
    if (-10 + paramAnimatingListTransactionBuilder.a() < paramInt)
      paramAnimatingListTransactionBuilder.b(paramInt, paramRowItem);
    while (true)
    {
      return;
      paramAnimatingListTransactionBuilder.a(paramInt, paramRowItem);
    }
  }

  private void a(StringBuilder paramStringBuilder, List<RowItem> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      paramStringBuilder.append("    none\n");
    while (true)
    {
      return;
      for (int i = 0; (i < paramInt) && (i < paramList.size()); i++)
        paramStringBuilder.append("   ").append(((RowItem)paramList.get(i)).toString()).append("\n");
    }
  }

  private void a(List<RowItem> paramList1, List<RowItem> paramList2)
  {
    if (!BLog.b(2));
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("Current messages:\n");
      a(localStringBuilder, Lists.a(paramList1), 6);
      localStringBuilder.append("  New Message:\n");
      a(localStringBuilder, Lists.a(paramList2), 6);
      localStringBuilder.append("\n");
      BLog.a(a, localStringBuilder.toString());
    }
  }

  private void a(List<?> paramList1, List<?> paramList2, Set<RowItem> paramSet, Map<RowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction> paramMap)
  {
    HashSet localHashSet = Sets.a(paramList2);
    Iterator localIterator1 = paramList1.iterator();
    break label42;
    break label42;
    while (true)
    {
      if (!localIterator1.hasNext())
        return;
      Object localObject = localIterator1.next();
      Iterator localIterator2 = localHashSet.iterator();
      label42: if (!localIterator2.hasNext())
        continue;
      RowItem localRowItem = (RowItem)localIterator2.next();
      if (((localObject instanceof RowReceiptItem)) && ((localRowItem instanceof RowReceiptItem)))
      {
        if (!d((RowReceiptItem)localObject, (RowReceiptItem)localRowItem))
          break;
        paramSet.add((RowItem)localObject);
        paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.NONE);
        localIterator2.remove();
        continue;
      }
      if (((localObject instanceof RowMessageItem)) && ((localRowItem instanceof RowMessageItem)))
      {
        RowMessageItem localRowMessageItem1 = (RowMessageItem)localObject;
        RowMessageItem localRowMessageItem2 = (RowMessageItem)localRowItem;
        if (!a(localRowMessageItem1, localRowMessageItem2))
          break;
        paramSet.add((RowItem)localObject);
        if (c(localRowMessageItem1, localRowMessageItem2))
          paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.HIDE);
        while (true)
        {
          localIterator2.remove();
          break;
          if (b(localRowMessageItem1, localRowMessageItem2))
          {
            paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.REVEAL);
            continue;
          }
          paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.NONE);
        }
      }
      if (((localObject instanceof SimpleRowItem)) && ((localRowItem instanceof SimpleRowItem)))
      {
        if (!a((SimpleRowItem)localObject, (SimpleRowItem)localRowItem))
          break;
        paramSet.add((RowItem)localObject);
        paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.NONE);
        localIterator2.remove();
        continue;
      }
      if ((!(localObject instanceof RowTypingItem)) || (!(localRowItem instanceof RowMessageItem)))
        break;
      paramSet.add((RowItem)localObject);
      paramMap.put(localRowItem, ThreadViewMessagesAdapterUpdater.ReplaceAction.REVEAL);
      localIterator2.remove();
    }
  }

  private boolean a(RowItem paramRowItem1, RowItem paramRowItem2)
  {
    if (((paramRowItem1.a() == 2) && (paramRowItem2.a() == 3)) || ((paramRowItem1.a() == 3) && (paramRowItem2.a() == 2)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(AnimatingListTransactionBuilder<RowItem> paramAnimatingListTransactionBuilder, Patch paramPatch)
  {
    ThreadViewMessagesAdapterUpdater.ItemDeletionTracker localItemDeletionTracker = new ThreadViewMessagesAdapterUpdater.ItemDeletionTracker(this, null);
    Iterator localIterator = paramPatch.a().iterator();
    int i = 1;
    Delta localDelta;
    int j;
    label143: int k;
    if (localIterator.hasNext())
    {
      localDelta = (Delta)localIterator.next();
      if ((localDelta instanceof InsertDelta))
      {
        List localList4 = localDelta.b().b();
        int i8 = 0;
        int i9 = i;
        while (i8 < localList4.size())
        {
          RowItem localRowItem2 = (RowItem)localList4.get(i8);
          int i10 = i8 + localDelta.b().a();
          if (i9 != 0)
          {
            a(paramAnimatingListTransactionBuilder, i10 + localItemDeletionTracker.d(i10), localRowItem2);
            i8++;
            i9 = 0;
            continue;
          }
          j = 1;
          return j;
        }
        k = i9;
      }
    }
    while (true)
    {
      i = k;
      break;
      if ((localDelta instanceof DeleteDelta))
      {
        List localList3 = localDelta.a().b();
        for (int i6 = 0; i6 < localList3.size(); i6++)
        {
          int i7 = i6 + localDelta.a().a();
          a(paramAnimatingListTransactionBuilder, i7 - localItemDeletionTracker.c(i7), i7, localItemDeletionTracker);
        }
        k = i;
        continue;
      }
      if ((localDelta instanceof ChangeDelta))
      {
        List localList1 = localDelta.a().b();
        List localList2 = localDelta.b().b();
        HashSet localHashSet = Sets.a();
        HashMap localHashMap = Maps.a();
        a(localList1, localList2, localHashSet, localHashMap);
        for (int m = 0; m < localList1.size(); m++)
        {
          if (localHashSet.contains(localList1.get(m)))
            continue;
          int i5 = m + localDelta.a().a();
          a(paramAnimatingListTransactionBuilder, i5 - localItemDeletionTracker.c(i5), i5, localItemDeletionTracker);
        }
        int n = 0;
        int i1 = i;
        if (n < localList2.size())
        {
          RowItem localRowItem1 = (RowItem)localList2.get(n);
          int i2 = n + localDelta.b().a();
          int i3 = i2 + localItemDeletionTracker.d(i2);
          ThreadViewMessagesAdapterUpdater.ReplaceAction localReplaceAction;
          if (localHashMap.containsKey(localRowItem1))
          {
            localReplaceAction = (ThreadViewMessagesAdapterUpdater.ReplaceAction)localHashMap.get(localRowItem1);
            if (localReplaceAction == ThreadViewMessagesAdapterUpdater.ReplaceAction.HIDE)
            {
              paramAnimatingListTransactionBuilder.d(i3, localRowItem1);
              paramAnimatingListTransactionBuilder.a(i3, 2131297350, AnimationType.HIDE_WITH_ANIMATION_DOWN);
            }
          }
          label463: for (int i4 = i1; ; i4 = 0)
          {
            n++;
            i1 = i4;
            break;
            if (localReplaceAction == ThreadViewMessagesAdapterUpdater.ReplaceAction.REVEAL)
            {
              paramAnimatingListTransactionBuilder.c(i3, localRowItem1);
              paramAnimatingListTransactionBuilder.a(i3, 2131297350, AnimationType.REVEAL_WITH_ANIMATION_UP);
              break label463;
            }
            paramAnimatingListTransactionBuilder.c(i3, localRowItem1);
            break label463;
            if (i1 == 0)
              break label538;
            a(paramAnimatingListTransactionBuilder, i3, localRowItem1);
          }
          label538: j = 1;
          break label143;
          j = 0;
          break label143;
        }
        k = i1;
        continue;
      }
      k = i;
    }
  }

  private int[] a(Patch paramPatch)
  {
    int[] arrayOfInt = new int[2];
    Iterator localIterator = paramPatch.a().iterator();
    while (localIterator.hasNext())
    {
      Delta localDelta = (Delta)localIterator.next();
      if ((localDelta instanceof DeleteDelta))
      {
        arrayOfInt[1] += localDelta.a().c();
        continue;
      }
      if ((localDelta instanceof InsertDelta))
      {
        arrayOfInt[0] += localDelta.b().c();
        continue;
      }
      if (!(localDelta instanceof ChangeDelta))
        continue;
      if (localDelta.a().c() > localDelta.b().c())
      {
        arrayOfInt[1] += localDelta.a().c();
        continue;
      }
      if (localDelta.b().c() <= localDelta.a().c())
        continue;
      arrayOfInt[0] += localDelta.b().c() - localDelta.a().c();
      arrayOfInt[1] += localDelta.a().c();
    }
    return arrayOfInt;
  }

  private boolean b(RowMessageItem paramRowMessageItem1, RowMessageItem paramRowMessageItem2)
  {
    if ((paramRowMessageItem1.d() == null) && (paramRowMessageItem2.d() != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean c(RowMessageItem paramRowMessageItem1, RowMessageItem paramRowMessageItem2)
  {
    if ((paramRowMessageItem1.d() != null) && (paramRowMessageItem2.d() == null));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean d(RowReceiptItem paramRowReceiptItem1, RowReceiptItem paramRowReceiptItem2)
  {
    if ((a(paramRowReceiptItem1, paramRowReceiptItem2)) || (c(paramRowReceiptItem1, paramRowReceiptItem2)) || (b(paramRowReceiptItem1, paramRowReceiptItem2)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void a(List<RowItem> paramList)
  {
    ImmutableList localImmutableList = this.b.d();
    if (localImmutableList.isEmpty())
    {
      AnimatingListTransactionBuilder localAnimatingListTransactionBuilder3 = this.b.a();
      localAnimatingListTransactionBuilder3.a(paramList);
      localAnimatingListTransactionBuilder3.b();
    }
    while (true)
    {
      return;
      Patch localPatch = DiffUtils.a(localImmutableList, paramList);
      if (localPatch.a().isEmpty())
        continue;
      int[] arrayOfInt = a(localPatch);
      if ((arrayOfInt[0] > 3) || (arrayOfInt[0] + arrayOfInt[1] > 8))
      {
        this.b.b();
        AnimatingListTransactionBuilder localAnimatingListTransactionBuilder1 = this.b.a();
        localAnimatingListTransactionBuilder1.a(paramList);
        localAnimatingListTransactionBuilder1.b();
        continue;
      }
      a(localImmutableList, paramList);
      AnimatingListTransactionBuilder localAnimatingListTransactionBuilder2 = this.b.a();
      while (a(localAnimatingListTransactionBuilder2, localPatch))
      {
        localAnimatingListTransactionBuilder2.b();
        localAnimatingListTransactionBuilder2 = this.b.a();
        localPatch = DiffUtils.a(this.b.d(), paramList);
      }
      localAnimatingListTransactionBuilder2.b();
    }
  }

  public void a(boolean paramBoolean, List<RowItem> paramList, ParticipantInfo paramParticipantInfo)
  {
    ImmutableList localImmutableList = this.b.d();
    AnimatingListTransactionBuilder localAnimatingListTransactionBuilder = this.b.a();
    if (paramBoolean)
      localAnimatingListTransactionBuilder.a(new RowTypingItem(paramParticipantInfo));
    while (true)
    {
      localAnimatingListTransactionBuilder.b();
      return;
      localAnimatingListTransactionBuilder.b(-1 + localImmutableList.size());
    }
  }

  public boolean a(RowMessageItem paramRowMessageItem1, RowMessageItem paramRowMessageItem2)
  {
    Message localMessage1 = paramRowMessageItem1.b();
    Message localMessage2 = paramRowMessageItem2.b();
    boolean bool2;
    if ((!StringUtil.a(localMessage1.a())) && (!StringUtil.a(localMessage2.a())) && (Objects.equal(localMessage1.a(), localMessage2.a())))
      bool2 = true;
    while (true)
    {
      return bool2;
      boolean bool1 = StringUtil.a(localMessage1.t());
      bool2 = false;
      if (bool1)
        continue;
      boolean bool3 = StringUtil.a(localMessage2.t());
      bool2 = false;
      if (bool3)
        continue;
      bool2 = Objects.equal(localMessage1.t(), localMessage2.t());
    }
  }

  public boolean a(RowReceiptItem paramRowReceiptItem1, RowReceiptItem paramRowReceiptItem2)
  {
    if (((paramRowReceiptItem1.b() == RowReceiptItem.Type.READ) && (paramRowReceiptItem2.b() == RowReceiptItem.Type.DELIVERED)) || ((paramRowReceiptItem1.b() == RowReceiptItem.Type.DELIVERED) && (paramRowReceiptItem2.b() == RowReceiptItem.Type.READ)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean b(RowReceiptItem paramRowReceiptItem1, RowReceiptItem paramRowReceiptItem2)
  {
    if ((paramRowReceiptItem1.b().equals(RowReceiptItem.Type.READ)) && (paramRowReceiptItem2.b() == RowReceiptItem.Type.SENT));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c(RowReceiptItem paramRowReceiptItem1, RowReceiptItem paramRowReceiptItem2)
  {
    List localList1 = paramRowReceiptItem1.c();
    int i = 0;
    if (localList1 != null)
    {
      List localList2 = paramRowReceiptItem2.c();
      i = 0;
      if (localList2 != null)
      {
        RowReceiptItem.Type localType1 = paramRowReceiptItem1.b();
        RowReceiptItem.Type localType2 = RowReceiptItem.Type.READ;
        i = 0;
        if (localType1 == localType2)
        {
          RowReceiptItem.Type localType3 = paramRowReceiptItem2.b();
          RowReceiptItem.Type localType4 = RowReceiptItem.Type.READ;
          i = 0;
          if (localType3 == localType4)
          {
            boolean bool = paramRowReceiptItem1.a(paramRowReceiptItem2);
            i = 0;
            if (!bool)
              i = 1;
          }
        }
      }
    }
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMessagesAdapterUpdater
 * JD-Core Version:    0.6.0
 */