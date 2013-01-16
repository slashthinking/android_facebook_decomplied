package com.facebook.orca.contacts.invite;

import com.facebook.contacts.data.DbContactsProperties;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.contacts.server.UsersInviteParams;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.UsersInviteMethod;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.users.PhoneUserIterator;
import com.facebook.orca.users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

public class ContactsInviteServiceHandler
  implements OrcaServiceHandler
{
  private static final String a = ContactsInviteServiceHandler.class.getName();
  private final Provider<PhoneUserIterator> b;
  private final Provider<SingleMethodRunner> c;
  private final Provider<String> d;
  private final DbContactsPropertyUtil e;
  private final UsersInviteMethod f;

  @Inject
  public ContactsInviteServiceHandler(Provider<PhoneUserIterator> paramProvider, Provider<SingleMethodRunner> paramProvider1, Provider<String> paramProvider2, DbContactsPropertyUtil paramDbContactsPropertyUtil, UsersInviteMethod paramUsersInviteMethod)
  {
    this.b = paramProvider;
    this.c = paramProvider1;
    this.d = paramProvider2;
    this.e = paramDbContactsPropertyUtil;
    this.f = paramUsersInviteMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    BLog.b(a, "Starting Invite All");
    ObjectMapper localObjectMapper = new ObjectMapper();
    String str = this.e.a(DbContactsProperties.e);
    if ((str == null) || (str.length() == 0))
      BLog.b(a, "No one to invite");
    for (OperationResult localOperationResult = OperationResult.b(); ; localOperationResult = OperationResult.b())
    {
      return localOperationResult;
      HashSet localHashSet = (HashSet)localObjectMapper.readValue(str, HashSet.class);
      PhoneUserIterator localPhoneUserIterator = (PhoneUserIterator)this.b.b();
      localPhoneUserIterator.a();
      ImmutableList.Builder localBuilder = ImmutableList.e();
      while (true)
      {
        User localUser = localPhoneUserIterator.e();
        if (localUser == null)
          break;
        if (!localHashSet.contains(localUser.b()))
          continue;
        localBuilder.b(localUser);
      }
      ImmutableList localImmutableList = localBuilder.b();
      if (localImmutableList.size() > 0)
      {
        UsersInviteParams localUsersInviteParams = new UsersInviteParams(localImmutableList, (String)this.d.b());
        ((SingleMethodRunner)this.c.b()).a(this.f, localUsersInviteParams);
      }
      BLog.b(a, "Done Invite All");
    }
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("contacts_invite_all".equals(str))
      return b(paramOperationParams);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.invite.ContactsInviteServiceHandler
 * JD-Core Version:    0.6.0
 */