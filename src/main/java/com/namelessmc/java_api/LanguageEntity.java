package com.namelessmc.java_api;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface LanguageEntity {

	 String getLanguage() throws NamelessException;

	 @Nullable String getLanguagePosix() throws NamelessException;

}
