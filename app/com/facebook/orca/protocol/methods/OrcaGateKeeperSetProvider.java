package com.facebook.orca.protocol.methods;

import com.facebook.base.GatekeeperSetProvider;
import com.google.common.collect.ImmutableSet;

public class OrcaGateKeeperSetProvider
  implements GatekeeperSetProvider
{
  public ImmutableSet<String> b()
  {
    return ImmutableSet.a("messaging", "messenger_mqtt_android", "messenger_pref_show_sms_notif_android", "messenger_pref_show_sms_enable_android", "messenger_phone_verification_android", "messenger_client_analytics_android", new String[] { "messenger_client_core_analytics_android", "messenger_contacts_download_android", "messenger_contacts_upload_android", "messenger_contacts_invite_all_android", "messenger_internal_prefs_android", "messenger_nux_android", "messenger_incall_android", "messenger_client_sms_android", "messenger_read_receipts_android", "messenger_divebar_more_last_active_android", "messenger_divebar_more_mobile_friends_android", "messenger_divebar_more_mobile_friends_2_android", "messenger_divebar_show_groups_android", "messenger_merge_threads_android", "messenger_has_contacts_list_android", "messenger_inapp_notify_android", "messenger_auth_expire_session_android", "messenger_switch_user_text_android", "messenger_logout_notify_android", "messenger_audio_player_android", "messenger_audio_recorder_android", "messenger_emoji_composer_android", "messenger_tester_logging_android", "android_persistent_push_service", "messenger_use_rolodex_for_picker_android", "messenger_zero_rating", "messenger_vvm_enable_sms_reporting", "messenger_vvm_enable_sms_detailed_reporting", "messenger_user_presence_active_android", "messenger_threadlist_user_presence_active_android", "messenger_threadlist_show_mobile_presence_android", "messenger_bug_reporter_android", "messenger_voip_android", "messenger_partial_upgrade_android" });
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.OrcaGateKeeperSetProvider
 * JD-Core Version:    0.6.0
 */