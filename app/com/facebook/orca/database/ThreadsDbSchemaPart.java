package com.facebook.orca.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threads.FolderName;

public class ThreadsDbSchemaPart extends SharedSQLiteSchemaPart
{
  private static final Class<?> a = SharedSQLiteSchemaPart.class;

  public ThreadsDbSchemaPart()
  {
    super("threads", 19);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE properties (key TEXT PRIMARY KEY, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE folder_counts (folder TEXT PRIMARY KEY, unread_count INTEGER, unseen_count INTEGER, last_seen_time INTEGER,last_action_id INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE threads (thread_id TEXT PRIMARY KEY, action_id INTEGER, refetch_action_id INTEGER, last_visible_action_id INTEGER, name TEXT, participants TEXT, former_participants TEXT, object_participants TEXT, senders TEXT, single_recipient_thread INTEGER, single_recipient_user_key TEXT, snippet TEXT, snippet_sender TEXT, admin_snippet TEXT, timestamp_ms INTEGER, last_fetch_time_ms INTEGER, unread INTEGER, pic_hash TEXT, pic TEXT, can_reply_to INTEGER, mute_until INTEGER, is_subscribed INTEGER, folder TEXT, draft TEXT )");
    paramSQLiteDatabase.execSQL("CREATE TABLE folders (folder TEXT, thread_id TEXT PRIMARY KEY, timestamp_ms INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS archived_sms_mms_threads (thread_id TEXT PRIMARY KEY )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS unread_mms_sms_threads (thread_id TEXT PRIMARY KEY )");
    paramSQLiteDatabase.execSQL("CREATE INDEX folders_timestamp_index ON folders ( folder, timestamp_ms DESC )");
    paramSQLiteDatabase.execSQL("CREATE INDEX threads_single_recipient_user_key_index ON threads ( single_recipient_user_key )");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages (msg_id TEXT PRIMARY KEY, thread_id TEXT, action_id INTEGER, subject TEXT, text TEXT, sender TEXT, timestamp_ms INTEGER, timestamp_sent_ms INTEGER, local_attachments TEXT, attachments TEXT, shares TEXT, msg_type INTEGER, affected_users TEXT, coordinates TEXT, offline_threading_id TEXT, source TEXT, is_non_authoritative INTEGER, pending_send_media_attachment STRING, handled_internally_time INTEGER )");
    paramSQLiteDatabase.execSQL("CREATE INDEX messages_timestamp_index ON messages ( thread_id, timestamp_ms DESC )");
    paramSQLiteDatabase.execSQL("CREATE INDEX messages_offline_threading_id_index ON messages ( offline_threading_id )");
    paramSQLiteDatabase.execSQL("CREATE INDEX messages_type_index ON messages ( thread_id, msg_type, timestamp_ms )");
    paramSQLiteDatabase.execSQL("CREATE TABLE thread_users (user_key TEXT PRIMARY KEY, first_name TEXT, last_name TEXT, name TEXT, pic_big TEXT, pic_square TEXT, pic_crop TEXT, last_active TEXT)");
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.d(a, "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS folder_counts");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS folders_timestamp_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS folders");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS threads_timestamp_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS threads_single_recipient_id_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS threads_single_recipient_user_key_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS threads");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS properties");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS messages_timestamp_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS messages_offline_threading_id_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS messages_type_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS messages_hashed_msg_id_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS thread_users");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS friends");
    a(paramSQLiteDatabase);
  }

  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("properties", null, null);
    paramSQLiteDatabase.delete("folder_counts", null, null);
    paramSQLiteDatabase.delete("folders", null, null);
    paramSQLiteDatabase.delete("threads", null, null);
    paramSQLiteDatabase.delete("messages", null, null);
    paramSQLiteDatabase.delete("thread_users", null, null);
    paramSQLiteDatabase.delete("archived_sms_mms_threads", null, null);
  }

  public void c(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = ((DbThreadPropertyKey)DbProperties.a.c(FolderName.d.b() + "%")).a();
    paramSQLiteDatabase.delete("properties", "key LIKE ?", arrayOfString1);
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = FolderName.d.b();
    paramSQLiteDatabase.delete("folder_counts", "folder=?", arrayOfString2);
    String[] arrayOfString3 = new String[1];
    arrayOfString3[0] = FolderName.d.b();
    paramSQLiteDatabase.delete("folders", "folder=?", arrayOfString3);
    paramSQLiteDatabase.delete("messages", "thread_id LIKE ?", new String[] { "mms-sms.%" });
    paramSQLiteDatabase.delete("threads", "thread_id LIKE ?", new String[] { "mms-sms.%" });
    paramSQLiteDatabase.delete("archived_sms_mms_threads", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbSchemaPart
 * JD-Core Version:    0.6.0
 */