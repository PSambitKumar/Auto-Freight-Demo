package com.infy.auto_freight.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  @Project : auto-freight
 * @Author : sambitkumar.pradhan (1361629)
 * @Created On : 26/11/2024 12:38 PM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoFreightingRules {

    private String shippingCompany;
    private String quotationReference;
    private String bookingReference;
    private String tariffType;
    private String departmentCode;
    private LocalDateTime applicationDateUsed; // Use LocalDateTime for date fields
    private String createdUser;
    private int amendmentNumber;
    private String appendixCode;
    private String bulletCode;
    private List<Charge> charges;

    // Inner class for Charge
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Charge {
        private int ruleSequence;
        private LocalDateTime ruleDateFrom; // Use LocalDateTime instead of String
        private LocalDateTime ruleDateTo;   // Use LocalDateTime instead of String
        private String matchingCriteria;
        private String chargeCode;
    }
}