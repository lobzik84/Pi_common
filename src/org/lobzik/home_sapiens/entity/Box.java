/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.entity;

import java.util.HashMap;
import org.json.JSONObject;
import org.lobzik.tools.Tools;

/**
 *
 * @author lobzik
 */
public class Box {

    public Box(JSONObject json) {
        if (json.has("id")) {
            this.id = json.getInt("id");
        }
        if (json.has("ssid")) {
            this.ssid = json.getString("ssid");
        }
        if (json.has("public_key")) {
            this.publicKey = json.getString("public_key");
        }
        if (json.has("version")) {
            this.version = json.getString("version");
        }
        if (json.has("status")) {
            this.status = Status.values()[json.getInt("status")];
        }
        if (json.has("phone_num")) {
            this.phoneNum = json.getString("phone_num");
        }
        if (json.has("wpa_psk")) {
            this.wpaPSK = json.getString("wpa_psk");
        }
        
        if (json.has("name")) {
            this.wpaPSK = json.getString("name");
        }

    }

    public Box(HashMap map) {
        this.id = Tools.parseInt(map.get("id"), 0);
        this.ssid = (String) map.get("ssid");
        this.publicKey = (String) map.get("public_key");
        this.version = (String) map.get("version");
        this.status = Status.values()[Tools.parseInt(map.get("status"), 0)];
        this.phoneNum = (String) map.get("phone_num");
        this.wpaPSK = (String) map.get("wpa_psk");
        this.name = (String) map.get("name");
    }

    public HashMap<String, Object> getMap() {
        HashMap<String, Object> map = new HashMap();
        map.put("id", id);
        map.put("ssid", ssid);
        map.put("public_key", publicKey);
        map.put("version", version);
        map.put("status", status.ordinal());
        map.put("phone_num", phoneNum);
        map.put("wpa_psk", wpaPSK);
        map.put("name", name);
        return map;
    }

    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        HashMap<String, Object> map = getMap();
        for (String key : map.keySet()) {
            json.put(key, map.get(key));
        }
        return json;
    }

    public int id = 0;
    public String ssid = null;
    public String publicKey = null;
    public String version = null;
    public Status status = Status.BANNED;
    public String phoneNum = null;
    public String wpaPSK = null;
    public String name = null;
    
    
    public enum Status
    {   
        BANNED,
        REGISTERED,
        ACTIVATED
    }
}
