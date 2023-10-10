package com.aj.mvc1.model;

import lombok.Data;

@Data
public class Holiday extends  BaseEntity{
    private  String day;
    private  String reason;
    private  Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }

}
