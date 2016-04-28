package com.learn.json.domain;

import java.util.Calendar;

/**
 * Created by Paritosh Dave on 4/28/2016.
 */
public class Entty {

    private int entityId;
    private String entityName;
    private Calendar dob;
    private EntityType type;

    private Principal[] principals;

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public Principal[] getPrincipals() {
        return principals;
    }

    public void setPrincipals(Principal[] principals) {
        this.principals = principals;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public Entty(Integer id, String name, EntityType type)
    {
        this.entityId = id;
        this.entityName = name;
        this.type = type;
    }


    public String toString()
    {
        return "entityId="+entityId+","+"entityName="+entityName+","+" entityDOB="+(dob!=null?dob.getTime():"")+"\n"+getPrincipalData();
    }

    private String getPrincipalData()
    {
        String str = "";
        for(int i = 0; i< this.getPrincipals().length; ++i)
        {
            str = str+this.getPrincipals()[i].toString()+"\n";
        }

        return str;
    }

}
