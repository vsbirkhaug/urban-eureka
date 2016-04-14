/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

/**
 *
 * @author Vilde
 */
public enum ChargeType {
    MEMBERSHIP_FEE("MEMBERSHIP_FEE"), ANNUAL_CLAIM_FEE("ANNUAL_CLAIM_FEE");

    private final String name;

    private ChargeType(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
