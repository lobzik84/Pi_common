/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.entity;

import java.util.Date;
import org.lobzik.tools.Tools;

/**
 *
 * @author lobzik
 */
public class Measurement {

    private final Double doubleValue;
    private final String stringValue;
    private final Integer integerValue;
    private final Boolean booleanValue;
    private final long time;
    private final Parameter parameter;

    public Measurement(Parameter p, Double value) {
        this.time = System.currentTimeMillis();
        this.stringValue = null;
        this.integerValue = null;
        this.doubleValue = value;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, String value) {
        this.time = System.currentTimeMillis();
        this.stringValue = value;
        this.integerValue = null;
        this.doubleValue = null;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, Integer value) {
        this.time = System.currentTimeMillis();
        this.stringValue = null;
        this.integerValue = value;
        this.doubleValue = null;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, Boolean value) {
        this.time = System.currentTimeMillis();
        this.stringValue = null;
        this.integerValue = null;
        this.doubleValue = null;
        this.booleanValue = value;
        this.parameter = p;
    }

    public Measurement(Parameter p, Double value, long time) {
        this.time = time;
        this.stringValue = null;
        this.integerValue = null;
        this.doubleValue = value;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, String value, long time) {
        this.time = time;
        this.stringValue = value;
        this.integerValue = null;
        this.doubleValue = null;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, Integer value, long time) {
        this.time = time;
        this.stringValue = null;
        this.integerValue = value;
        this.doubleValue = null;
        this.booleanValue = null;
        this.parameter = p;
    }

    public Measurement(Parameter p, Boolean value, long time) {
        this.time = time;
        this.stringValue = null;
        this.integerValue = null;
        this.doubleValue = null;
        this.booleanValue = value;
        this.parameter = p;
    }

    public long getTime() {
        return time;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public String toStringValue() {
        String value = null;
        switch (parameter.getType()) {
            case BOOLEAN:
                value = booleanValue + "";
                break;

            case INTEGER:
                value = integerValue + "";
                break;

            case DOUBLE:
                if (doubleValue != null) {
                    /*if (parameter.getCalibration() != null) {
                        if (parameter.getPattern() != null) {
                            value = String.format(parameter.getPattern(), parameter.getCalibration() * doubleValue);
                        } else {
                            value = parameter.getCalibration() * doubleValue + "";
                        }
                    } else*/ if (parameter.getPattern() != null) {
                        value = String.format(parameter.getPattern(), doubleValue);
                    } else {
                        value = doubleValue + "";
                    }
                } else {
                    value = "";
                }
                break;

            case STRING:
                value = stringValue;
                break;

        }

        return value;
    }

    @Override
    public String toString() {
        String dateStr = Tools.getFormatedDate(new Date(time), "yyyy.MM.dd HH:mm:ss");
        return dateStr + " : " + toStringValue();
    }

}
