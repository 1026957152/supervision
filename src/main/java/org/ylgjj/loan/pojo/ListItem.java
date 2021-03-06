/*
 * Copyright (c) 2005-2011 Grameen Foundation USA
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */
package org.ylgjj.loan.pojo;

import java.io.Serializable;

/**
 * I am a DTO for items within a list e.g. a dropdown list.
 */
@SuppressWarnings("PMD")
//@edu.umd.cs.findbugs.annotations.SuppressWarnings(value={"SE_NO_SERIALVERSIONID", "NP_EQUALS_SHOULD_HANDLE_NULL_ARGUMENT", "BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS"}, justification="should disable at filter level and also for pmd - not important for us")
public class ListItem<T> implements Serializable {

    private final T id;
    private final String displayValue;
    private final String tipsMessage;

    private final Integer count  =9999;

    private  boolean selected;
    private  boolean completed;
    private String url;

    public ListItem(T id, String displayValue, String 名称1, String userUrl) {

        this.id = id;
        this.displayValue = displayValue;

        this.selected = false;
        this.url = userUrl;
        this.tipsMessage  = "";
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ListItem(T id, String displayValue, String tipsMessage) {
        this.id = id;
        this.displayValue = displayValue;

            this.selected = false;
        this.tipsMessage = tipsMessage;


    }

    public ListItem(T id, String displayValue, String tipsMessage,boolean completed) {
        this.id = id;
        this.displayValue = displayValue;

        this.tipsMessage = tipsMessage;
        this.completed = completed;

    }

    public ListItem(T id, String displayValue) {
        this.id = id;
        this.displayValue = displayValue;
        this.selected = false;
        this.tipsMessage = "";
    }

    public ListItem(T id, String displayValue, boolean selected) {
        this.id = id;
        this.displayValue = displayValue;
        this.selected = selected;
        this.tipsMessage = "";

    }
    public T getId() {
        return this.id;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        ListItem<T> item = (ListItem<T>) obj;

        return (item.id.equals(this.id) && item.displayValue.equals(this.displayValue));
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return id.hashCode() * displayValue.hashCode();
    }

    @Override
    public String toString() {
        return "Item: id: " + this.id + " displayValue: " + this.displayValue;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
