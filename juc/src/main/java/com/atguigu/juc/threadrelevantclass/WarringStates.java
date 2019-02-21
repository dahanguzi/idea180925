package com.atguigu.juc.threadrelevantclass;


import lombok.Getter;

public enum WarringStates{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"韩"),SIX(6,"魏");

    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    WarringStates(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static WarringStates foreach_Enum(int index){
        WarringStates[] myArray = WarringStates.values();
        for (WarringStates array:myArray) {
            if(index == array.getRetCode()){
                return array;
            }
        }
        return null;
    }
}