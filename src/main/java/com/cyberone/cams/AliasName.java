package com.cyberone.cams;

public enum AliasName {

	ACCOUNT("a-account", "account"),
	OBJECT_GROUP("a-object_group", "object_group"),
	OBJECT("a-object", "object"),
	WORK("a-work", "work"),
	LOGGING("a-logging", "logging"),
	REPORT_SEND("a-report_send", "report_send"),
	ALARM_SEND("a-alarm_send", "alarm_send"),
	ALARM_CONFIRM("a-alarm_confirm", "alarm_confirm"),
	SYSTEM_CONFIG("a-system_config", "system_config"),
	AGENT("a-agent", "agent"),
	FIELD("a-field", "field"),
	OID("a-oid", "oid");

	String aliasName;
	String typeName;
	
	AliasName(String aliasName, String typeName) {
		this.aliasName = aliasName;
		this.typeName = typeName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public String getTypeName() {
		return typeName;
	}

}
