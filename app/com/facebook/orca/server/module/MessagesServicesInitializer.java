package com.facebook.orca.server.module;

import com.facebook.contacts.service.ContactsQueue;
import com.facebook.contacts.service.ContactsSyncQueue;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.MessagesService;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.facebook.zero.annotations.ZeroTokenQueue;
import java.lang.annotation.Annotation;

public class MessagesServicesInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public MessagesServicesInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  private void a(String paramString, Class<? extends Annotation> paramClass)
  {
    this.a.a(paramString, paramClass);
  }

  public void i_()
  {
    this.a.a(ThreadsQueue.class, MessagesService.class);
    this.a.a(SendQueue.class, MessagesService.class);
    this.a.a(PushQueue.class, MessagesService.class);
    this.a.a(ContactsQueue.class, MessagesService.class);
    this.a.a(ContactsSyncQueue.class, MessagesService.class);
    this.a.a(LocationQueue.class, MessagesService.class);
    this.a.a(AnalyticsQueue.class, MessagesService.class);
    this.a.a(ImageSearchQueue.class, MessagesService.class);
    this.a.a(AddressBookQueue.class, MessagesService.class);
    this.a.a(ContactsUploadQueue.class, MessagesService.class);
    this.a.a(ContactsInviteQueue.class, MessagesService.class);
    this.a.a(PhoneNumberIdentificationQueue.class, MessagesService.class);
    this.a.a(ZeroTokenQueue.class, MessagesService.class);
    a("get_wildfire_reg_gk", ThreadsQueue.class);
    a("verify_reg_data", ThreadsQueue.class);
    a("register_partial_acct", ThreadsQueue.class);
    a("user_lookup", ThreadsQueue.class);
    a("login", ThreadsQueue.class);
    a("create_thread", ThreadsQueue.class);
    a("delete_thread", ThreadsQueue.class);
    a("delete_messages", ThreadsQueue.class);
    a("fetch_thread_list", ThreadsQueue.class);
    a("fetch_more_threads", ThreadsQueue.class);
    a("fetch_thread", ThreadsQueue.class);
    a("add_members", ThreadsQueue.class);
    a("remove_member", ThreadsQueue.class);
    a("mark_thread", ThreadsQueue.class);
    a("read_receipt", ThreadsQueue.class);
    a("delivered_receipt", ThreadsQueue.class);
    a("mark_folder_seen", ThreadsQueue.class);
    a("fetch_more_messages", ThreadsQueue.class);
    a("modify_thread", ThreadsQueue.class);
    a("request_sms_confirmation_code", ThreadsQueue.class);
    a("confirm_phone", ThreadsQueue.class);
    a("get_app_info", ThreadsQueue.class);
    a("update_user_settings", ThreadsQueue.class);
    a("chat_set_visiblity", ThreadsQueue.class);
    a("chat_get_visibility", ThreadsQueue.class);
    a("send", SendQueue.class);
    a("queue_message", PushQueue.class);
    a("save_draft", PushQueue.class);
    a("pushed_message", PushQueue.class);
    a("push_trace_confirmation", PushQueue.class);
    a("fetch_contact", ContactsQueue.class);
    a("create_contact_claim", ContactsQueue.class);
    a("delete_contact_claim", ContactsQueue.class);
    a("block_contact", ContactsQueue.class);
    a("bulk_contacts_delete", ContactsQueue.class);
    a("sync_contacts_complete", ContactsSyncQueue.class);
    a("sync_contacts_partial", ContactsSyncQueue.class);
    a("contacts_upload", ContactsUploadQueue.class);
    a("contacts_invite_all", ContactsInviteQueue.class);
    a("verify_phone_number", PhoneNumberIdentificationQueue.class);
    a("verify_phone_number_manual", PhoneNumberIdentificationQueue.class);
    a("sync_address_book", AddressBookQueue.class);
    a("sync_top_last_active", AddressBookQueue.class);
    a("update_favorite_contacts", AddressBookQueue.class);
    a("get_device_location", LocationQueue.class);
    a("analytics_upload", AnalyticsQueue.class);
    a("image_search", ImageSearchQueue.class);
    a("validate_zero_token", ZeroTokenQueue.class);
    a("fetch_zero_token", ZeroTokenQueue.class);
    a("sync_mobile_app_data", AddressBookQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServicesInitializer
 * JD-Core Version:    0.6.0
 */