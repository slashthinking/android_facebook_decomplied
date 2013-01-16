package com.facebook.contacts.data;

import android.content.Context;
import com.facebook.contacts.annotations.IsContactsListEnabled;
import com.facebook.contacts.annotations.IsRolodexPickerEnabled;
import com.facebook.contacts.annotations.WithContacts;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.contactslist.ContactsListAdapter;
import com.facebook.contacts.contactslist.ContactsListLoader;
import com.facebook.contacts.contactslist.IsContactsListEnabledProvider;
import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactUtils;
import com.facebook.contacts.picker.IsRolodexPickerEnabledProvider;
import com.facebook.contacts.protocol.BulkContactsDeleteMethod;
import com.facebook.contacts.protocol.ContactClaimFormatHelper;
import com.facebook.contacts.protocol.FetchAllContactsMethod;
import com.facebook.contacts.protocol.FetchContactMethod;
import com.facebook.contacts.protocol.FetchContactsMethod;
import com.facebook.contacts.protocol.FetchDeltaContactsMethod;
import com.facebook.contacts.protocol.UploadBulkContactsMethod;
import com.facebook.contacts.service.AddressBookContactFetcher;
import com.facebook.contacts.service.ContactsQueue;
import com.facebook.contacts.service.ContactsServiceHandler;
import com.facebook.contacts.service.ContactsSyncQueue;
import com.facebook.orca.annotations.ShowOtherContactsDivebar;
import com.facebook.orca.contacts.divebar.ShowOtherContactsDivebarProvider;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.users.FacebookUserIterator;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class ContactsModule extends AbstractModule
{
  private final Context a;

  public ContactsModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(ContactsDbSchemaPart.class).a(new ContactsModule.ContactsDbSchemaPartProvider(this, null)).a();
    a(ContactsDatabaseSupplier.class).a(new ContactsModule.ContactsDatabaseSupplierProvider(this, null)).a();
    a(ContactSerialization.class).a(new ContactsModule.ContactSerializationProvider(this, null)).a();
    a(ContactClaimFormatHelper.class).a(new ContactsModule.ContactClaimFormatHelperProvider(this, null)).a();
    a(DbContactsPropertyUtil.class).a(new ContactsModule.DbContactsPropertyUtilProvider(this, null));
    a(DbFetchContactHandler.class).a(new ContactsModule.DbFetchContactHandlerProvider(this, null)).a();
    a(DbInsertContactHandler.class).a(new ContactsModule.DbInsertContactHandlerProvider(this, null)).a();
    a(DbInsertContactHandler.ContactNameLookupBuilder.class).a(new ContactsModule.DbInsertContactHandlerContactNameLookupBuilderProvider(this, null));
    a(AddressBookContactFetcher.class).a(new ContactsModule.AddressBookContactFetcherProvider(this, null)).a();
    a(FetchContactMethod.class).a(new ContactsModule.FetchContactMethodProvider(this, null));
    a(FetchContactsMethod.class).a(new ContactsModule.FetchContactsMethodProvider(this, null));
    a(FetchAllContactsMethod.class).a(new ContactsModule.FetchAllContactsMethodProvider(this, null));
    a(FetchDeltaContactsMethod.class).a(new ContactsModule.FetchDeltaContactsMethodProvider(this, null));
    a(UploadBulkContactsMethod.class).a(new ContactsModule.UploadBulkContactsMethodProvider(this, null));
    a(ContactGraphQL.class).a(new ContactsModule.ContactGraphQLProvider(this, null));
    a(BulkContactsDeleteMethod.class).a(new ContactsModule.BulkDeleteContactsMethodProvider(this, null));
    a(ContactsListAdapter.class).a(new ContactsModule.ContactsListAdapterProvider(this, null));
    a(Boolean.class).a(IsContactsListEnabled.class).c(IsContactsListEnabledProvider.class);
    a(Boolean.class).a(IsRolodexPickerEnabled.class).c(IsRolodexPickerEnabledProvider.class);
    a(Boolean.class).a(ShowOtherContactsDivebar.class).c(ShowOtherContactsDivebarProvider.class);
    a(ContactsServiceHandler.class).a(new ContactsModule.ContactsServiceHandlerProvider(this, null));
    a(ContactsCache.class).a(new ContactsModule.ContactsCacheProvider(this, null)).a();
    a(ContactUtils.class).a(new ContactsModule.ContactUtilsProvider(this, null)).a();
    a(ContactPicCropInfoGenerator.class).a(new ContactsModule.ContactPicCropInfoProvider(this, null));
    a(FacebookUserIterator.class).a(WithContacts.class).a(new ContactsModule.ContactsUserIteratorProvider(this, null));
    a(DbContactIterator.class).a(new ContactsModule.DbContactIteratorProvider(this, null));
    a(DbContactIteratorFactory.class).a(new ContactsModule.DbContactIteratorFactoryProvider(this, null));
    a(ContactsListLoader.class).a(new ContactsModule.ContactsListLoaderProvider(this, null));
    a(ContactsQueue.class, new ContactsModule.OrcaServiceHandlerForContactsQueueProvider(this, null));
    a(ContactsSyncQueue.class, new ContactsModule.OrcaServiceHandlerForContactsQueueProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule
 * JD-Core Version:    0.6.0
 */