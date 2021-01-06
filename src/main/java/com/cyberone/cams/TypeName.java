package com.cyberone.cams;

public enum TypeName {

	MGR_TYPE("mgr_type"),
	HISTORY_TYPE("history_type"),
	LOG_TYPE("log_type"),
	EVENT_TYPE("event_type"),
	ACCOUNT("account"),
	OBJECT_GROUP("object_group"),
	OBJECT("object"),
	WORK("work"),
	LOGGING("logging"),
	REPORT_SEND("report_send"),
	ALARM_SEND("alarm_send"),
	ALARM_CONFIRM("alarm_confirm"),
	SYSTEM_CONFIG("system_config"),
	AGENT("agent"),
	FIELD("field"),
	OID("oid"),
	EVENT("event"),
	URL("url"),
	ICMP("icmp"),
	PORT("port");

	String fieldName;
	
	TypeName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getName() {
		return fieldName;
	}

}
