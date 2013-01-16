package com.facebook.orca.dispatch;

import android.os.Bundle;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.AddMembersParams;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMultipleThreadsParams;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.server.TerminatingHandler;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.sms.MmsSmsServiceHandler;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.inject.Provider;

public class DispatchServiceHandler extends AbstractOrcaServiceHandlerFilter
{
  private static final Class<?> a = DispatchServiceHandler.class;
  private final FilterChainLink b;
  private final FilterChainLink c;
  private final Provider<Boolean> d;

  public DispatchServiceHandler(MmsSmsServiceHandler paramMmsSmsServiceHandler, WebServiceHandler paramWebServiceHandler, Provider<Boolean> paramProvider)
  {
    super("DispatchServiceHandler");
    this.c = new FilterChainLink(paramMmsSmsServiceHandler, new TerminatingHandler());
    this.b = new FilterChainLink(paramWebServiceHandler, new TerminatingHandler());
    this.d = paramProvider;
  }

  private boolean a(ThreadCriteria paramThreadCriteria)
  {
    if (((paramThreadCriteria.b() != null) && (paramThreadCriteria.b().a() == User.Type.PHONE_NUMBER)) || ((paramThreadCriteria.a() != null) && (MessagingIdUtil.g(paramThreadCriteria.a()))));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected OperationResult A(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMultipleThreadsParams localFetchMultipleThreadsParams = (FetchMultipleThreadsParams)paramOperationParams.b().getParcelable("fetchMultipleThreadsParams");
    if (localFetchMultipleThreadsParams.a() == FolderName.b);
    for (OperationResult localOperationResult = this.b.a(paramOperationParams); ; localOperationResult = this.c.a(paramOperationParams))
    {
      return localOperationResult;
      if (localFetchMultipleThreadsParams.a() != FolderName.d)
        break;
    }
    throw new Exception("Trying to fetch multiple threads from an invalid folder");
  }

  protected OperationResult B(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult C(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult D(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult E(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult F(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FolderName localFolderName = ((FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams")).b();
    if ((FolderName.b.equals(localFolderName)) || (FolderName.c.equals(localFolderName)));
    for (OperationResult localOperationResult = this.b.a(paramOperationParams); ; localOperationResult = this.c.a(paramOperationParams))
    {
      return localOperationResult;
      if ((!((Boolean)this.d.b()).booleanValue()) || (!FolderName.d.equals(localFolderName)))
        break;
    }
    throw new Exception("Trying to fetch an unknown Folder: " + localFolderName.b());
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FolderName localFolderName = ((FetchMoreThreadsParams)paramOperationParams.b().getParcelable("fetchMoreThreadsParams")).a();
    if ((FolderName.b.equals(localFolderName)) || (FolderName.c.equals(localFolderName)));
    for (OperationResult localOperationResult = this.b.a(paramOperationParams); ; localOperationResult = this.c.a(paramOperationParams))
    {
      return localOperationResult;
      if ((!((Boolean)this.d.b()).booleanValue()) || (!FolderName.d.equals(localFolderName)))
        break;
    }
    throw new Exception("Trying to fetch an unknown Folder: " + localFolderName.b());
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (a(((FetchThreadParams)paramOperationParams.b().getParcelable("fetchThreadParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to fetch an SMS Thread when GK is off");
    }
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    CreateThreadParams localCreateThreadParams = (CreateThreadParams)paramOperationParams.b().getParcelable("createThreadParams");
    int i;
    if (((Boolean)this.d.b()).booleanValue())
    {
      Iterator localIterator = localCreateThreadParams.d().iterator();
      i = 0;
      if (localIterator.hasNext())
        if (((UserWithIdentifier)localIterator.next()).b().e() != UserIdentifier.IdentifierType.PHONE)
          break label154;
    }
    label154: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      OperationResult localOperationResult;
      if (localCreateThreadParams.d().size() == i)
        localOperationResult = this.c.a(paramOperationParams);
      while (true)
      {
        return localOperationResult;
        if (i == 0)
        {
          localOperationResult = this.b.a(paramOperationParams);
          continue;
        }
        throw new Exception("Cannot create a thread with a phone number and a Facebook user");
        localOperationResult = this.b.a(paramOperationParams);
      }
    }
  }

  protected OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((AddMembersParams)paramOperationParams.b().getParcelable("addMembersParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to add a member to an SMS Thread when GK is off");
    }
  }

  protected OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((RemoveMemberParams)paramOperationParams.b().getParcelable("removeMemberParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to remove a member from an SMS Thread when GK is off");
    }
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((MarkThreadParams)paramOperationParams.b().getParcelable("markThreadParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to mark an SMS Thread when GK is off");
    }
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((DeleteThreadParams)paramOperationParams.b().getParcelable("deleteThreadParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to delete an SMS Thread when GK is off");
    }
  }

  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((DeleteMessagesParams)paramOperationParams.b().getParcelable("deleteMessagesParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to delete the messages of an SMS Thread when GK is off");
    }
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (MessagingIdUtil.g(((ModifyThreadParams)paramOperationParams.b().getParcelable("modifyThreadParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to modify an SMS Thread when GK is off");
    }
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if ((FolderName)paramOperationParams.b().getParcelable("folderName") == FolderName.d)
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to mark the SMS Folder as seen when GK is off");
    }
  }

  protected OperationResult s(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult t(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult u(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (a(((FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams")).a()))
      if (!((Boolean)this.d.b()).booleanValue());
    for (OperationResult localOperationResult = this.c.a(paramOperationParams); ; localOperationResult = this.b.a(paramOperationParams))
    {
      return localOperationResult;
      throw new Exception("Trying to fetch more messages of an SMS Thread when GK is off");
    }
  }

  protected OperationResult w(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult x(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult y(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }

  protected OperationResult z(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return this.b.a(paramOperationParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.dispatch.DispatchServiceHandler
 * JD-Core Version:    0.6.0
 */