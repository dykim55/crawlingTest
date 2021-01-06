package com.cyberone.cams;

public enum Mgr {

	_INDEX("_index"),
	_ID("_id"),
	TYPE_NAME("type_name"),
	EMAIL("email"),
	EMAIL_CHANGE_DATE("email_change_date"),
	MODIFY_DATE("modify_date"),
	AGENT_REQUEST_DATE("agent_request_date"),
	ANALY_REQUEST_DATE("analy_request_date"),
	NAME("name"),
	PASSWORD("password"),
	MOBILE("mobile"),
	STATUS("status"),
	NOT_ATTN("not_attn"),
	NOT_ATTN_TIME("not_attn_time"),
	ROLE("role"),
	KINDS("kinds"),
	ACCOUNT_ALLOW_COUNT("account_allow_count"),
	OBJECT_ALLOW_COUNT("object_allow_count"),
	PARENT_ID("parent_id"),
	CREATETIME("createtime"),
	OTP("otp"),
	OPTION("option"),
	VALUE("value"),
	OTP_OPTION("otp.option"),
	OTP_VALUE("otp.value"),
	OTP_CREATETIME("otp.createtime"),
	PWD_CHANGE_DATE("pwd_change_date"),
	PWD_EXTEND_COUNT("pwd_extend_count"),
	FAVORITE_OBJECTS("favorite_objects"),
	OBJECT_GROUPS("object_groups"),
	SERVICE_LEVEL("service_level"),
	ALARM("alarm"),
	ENABLE("enable"),
	MAIL_ENABLE("mail_enable"),
	SMS_ENABLE("sms_enable"),
	SLACK_ENABLE("slack_enable"),
	SLACK_HOOK("slack_hook"),
	ALLOW_DAYOFWEEK("allow_dayofweek"),
	ALLOW_HOUR("allow_hour"),
	ALARM_ENABLE("alarm.enable"),
	ALARM_MAIL_ENABLE("alarm.mail_enable"),
	ALARM_SMS_ENABLE("alarm.sms_enable"),
	ALARM_SLACK_ENABLE("alarm.slack_enable"),
	ALARM_SLACK_HOOK("alarm.slack_hook"),
	ALARM_ALLOW_DAYOFWEEK("alarm.allow_dayofweek"),
	ALARM_ALLOW_HOUR("alarm.allow_hour"),
	REPORT("report"),
	KIND("kind"),
	REPORT_ENABLE("report.enable"),
	REPORT_KIND("report.kind"),
	TIMEZONE("timezone"),
	DATEFORMAT("dateformat"),
	ACCOUNT_ID("account_id"),
	MODIFYTIME("modifytime"),
	MEMO("memo"),
	AGENT_ID("agent_id"),
	PREV_AGENT_ID("prev_agent_id"),
	HOST("host"),
	PORT("port"),
	CHECK_CYCLE_SEC("check_cycle_sec"),
	LAST_CHECK_TIME("last_check_time"),
	LAST_ALARM_TIME("last_alarm_time"),
	GROUP_ID("group_id"),

	POLICY("policy"),
	NORMAL("normal"),
	FROM("from"),
	TO("to"),
	ATTENTION("attention"),
	CAUTION("caution"),
	WARNING("warning"),
	SERIOUS("serious"),
	CONTINUE("continue"),
	COUNT("count"),
	NONCONTINUE("noncontinue"),
	INSTANT("instant"),
	LEVEL("level"),
	BUNDLE("bundle"),
	LATEST_COUNT("latest_count"),
	THRESHOLD_COUNT("threshold_count"),
	POLICY_ENABLE("policy.enable"),
	POLICY_NORMAL("policy.normal"),
	POLICY_ATTENTION("policy.attention"),
	POLICY_CAUTION("policy.caution"),
	POLICY_WARNING("policy.warning"),
	POLICY_SERIOUS("policy.serious"),
	POLICY_CONTINUE("policy.continue"),
	POLICY_NONCONTINUE("policy.noncontinue"),
	POLICY_INSTANT("policy.instant"),
	POLICY_BUNDLE("policy.bundle"),

	FORGERY("forgery"),
	CHANGE_RATE("change_rate"),
	CHECK_CYCLE("check_cycle"),
	DTCT_KEYWORD("dtct_keyword"),
	
	PWD_CHANGE_TERM("pwd_change_term"),
	KAFKA("kafka"),
	KAFKA_IP("kafka.ip"),
	KAFKA_PORT("kafka.port"),
//	AGENT_PORT("agent_port"),
	SMTP("smtp"),
	IP("ip"),
	USER("user"),
	PASS("pass"),
	API_KEY("api_key"),
	SENT_MAIL("sent_mail"),
	SENT_NAME("sent_name"),
	SMTP_IP("smtp.ip"),
	SMTP_PORT("smtp.port"),
	SMTP_USER("smtp.user"),
	SMTP_PASS("smtp.pass"),
	SMTP_API_KEY("smtp.api_key"),
	SMTP_SENT_MAIL("smtp.sent_mail"),
	SMTP_SENT_NAME("smtp.sent_name"),
	SMS("sms"),
	API_SECRET("api_secret"),
	SENT_NUMBER("sent_number"),
	SMS_IP("sms.ip"),
	SMS_PORT("sms.port"),
	SMS_USER("sms.user"),
	SMS_PASS("sms.pass"),
	SMS_API_KEY("sms.api_key"),
	SMS_API_SECRET("sms.api_secret"),
	SMS_SENT_NUMBER("sms.sent_number"),
	SNMP("snmp"),
	COMMUNITY("community"),
	SECURITY_LEVEL("security_level"),
	USERNAME("username"),
	AUTH_PASS("auth_pass"),
	PRIV_PASS("priv_pass"),
	AUTH_PROTOCOL("auth_protocol"),
	PRIV_PROTOCOL("priv_protocol"),
	SNMP_VERSION("snmp.version"),
	SNMP_COMMUNITY("snmp.community"),
	SNMP_SECURITY_LEVEL("snmp.security_level"),
	SNMP_USERNAME("snmp.username"),
	SNMP_AUTH_PASS("snmp.auth_pass"),
	SNMP_PRIV_PASS("snmp.priv_pass"),
	SNMP_AUTH_PROTOCOL("snmp.auth_protocol"),
	SNMP_PRIV_PROTOCOL("snmp.priv_protocol"),
	OIDINFO("oidinfo"),
	ATTNINFO("attninfo"),
	CYCLE("cycle"),
	SNMP_OIDINFO("snmp.oidinfo"),
	SNMP_OIDINFO_ID("snmp.oidinfo.id"),
	SNMP_OIDINFO_NAME("snmp.oidinfo.name"),
	SNMP_OIDINFO_KIND("snmp.oidinfo.kind"),
	SNMP_OIDINFO_OID("snmp.oidinfo.oid"),
	SNMP_OIDINFO_OID2("snmp.oidinfo.oid2"),
	SNMP_OIDINFO_CYCLE("snmp.oidinfo.cycle"),
	SNMP_OIDINFO_CAUTION("snmp.oidinfo.caution"),
	SNMP_OIDINFO_WARNING("snmp.oidinfo.warning"),
	SNMP_OIDINFO_ALARM("snmp.oidinfo.alarm"),
	SNMP_OIDINFO_LATEST_COUNT("snmp.oidinfo.latest_count"),
	SNMP_OIDINFO_THRESHOLD_COUNT("snmp.oidinfo.threshold_count"),
	SNMP_OIDINFO_STATUS("snmp.oidinfo.status"),
	SNMP_ALARM_EMAIL("snmp.alarm.email"),
	SNMP_ALARM_SMS("snmp.alarm.sms"),
	STORAGE("storage"),
	PERIOD("period"),
	BACKUP_PATH("backup_path"),
	STORAGE_PERIOD("storage.period"),
	STORAGE_BACKUP_PATH("storage.backup_path"),
	DATALIFE("datalife"),
	LOG("log"),
	ACCESS("access"),
	WORK("work"),
	DATALIFE_LOG("datalife.log"),
	DATALIFE_ACCESS("datalife.access"),
	DATALIFE_WORK("datalife.work"),
	AGENT("agent"),
	KAFKA__IP("kafka_ip"),
	KAFKA__PORT("kafka_port"),
	AGENT_API_KEY("agent.api_key"),
	AGENT_API_SECRET("agent.api_secret"),
	AGENT_KAFKA_IP("agent.kafka_ip"),
	AGENT_KAFKA_PORT("agent.kafka_port"),
	VERSION("version"),
	COUNTRY("country"),
	LAST_HEARTBEAT_TIME("last_heartbeat_time"),
	OBJECT_COUNT("object_count"),
	RESOURCE("resource"),
	OS("os"),
	MEM_USED("mem_used"),
	DISK_USED("disk_used"),
	RESOURCE_OS("resource.os"),
	RESOURCE_MEM_USED("resource.mem_used"),
	RESOURCE_DISK_USED("resource.disk_used"),
	FIELD_KEY("field_key"),
	FIELD_NAME("field_name"),
	CSCO_CD("cscoCd"),
	CSCO_EQPM_CD("cscoEqpmCd"),
	OID("oid"),
	OID2("oid2"),
	CALC_TYPE("calc_type");
	
	String fieldName;
	
	Mgr(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getName() {
		return fieldName;
	}

}