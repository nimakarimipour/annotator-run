package com.namelessmc.java_api;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class CustomProfileFieldValue {

	private final  CustomProfileField field;
	private final  String value;

	CustomProfileFieldValue( CustomProfileField field,  String value) {
		this.field = field;
		this.value = value;
	}

	public  CustomProfileField getField() {
		return this.field;
	}

	public  String getValue() {
		return value;
	}

}
