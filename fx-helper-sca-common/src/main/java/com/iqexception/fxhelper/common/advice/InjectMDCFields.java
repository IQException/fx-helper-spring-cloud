package com.iqexception.fxhelper.common.advice;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;


public class InjectMDCFields{
    /**
     *  injectFields Pair <fieldName, mdcKey>
     */
   private List<Pair<String, String>> injectFields;

    public InjectMDCFields() {
    }

    public List<Pair<String, String>> getInjectFields() {
        return injectFields;
    }

    public void setInjectFields(List<Pair<String, String>> injectFields) {
        this.injectFields = injectFields;
    }

    public InjectMDCFields(List<Pair<String, String>> injectFields) {
        this.injectFields = injectFields;
    }
}
