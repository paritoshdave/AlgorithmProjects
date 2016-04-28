package com.learn.json.domain;

import java.util.Calendar;

/**
 * Created by Paritosh Dave on 4/28/2016.
 */
public class Principal {

    private int principalId;
    private String principalName;
    private Calendar dob;
    private PrincipalType type;

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public PrincipalType getType() {
        return type;
    }

    public void setType(PrincipalType type) {
        this.type = type;
    }

    public Principal(Integer id, String name, PrincipalType type)
    {
        this.principalId = id;
        this.principalName = name;
        this.type = type;
    }

    public String toString()
    {
        return "\tprincipalId="+principalId+","+" principalName="+principalName+","+" principalDOB="+(dob!=null?dob.toString():"");
    }
}
