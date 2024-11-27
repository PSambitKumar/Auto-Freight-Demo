package com.infy.auto_freight.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Project : auto-freight
 * @Author : sambitkumar.pradhan (1361629)
 * @Created On : 11/27/2024 10:41 AM
 */
@Entity
@Table(name = "AFR_TAR_EXPLAIN")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AfrTarExplain implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TAR_EXPLAIN_UID", unique = true, nullable = false, precision = 16)
    private long tarExplainUid;

    @Column(name = "BASED_RATE_TYPE", length = 3)
    private String basedRateType;

    @Column(name = "CALC_TYPE", nullable = false, length = 10)
    private String calcType;

    @Column(name = "CHARGE_CMT", length = 750)
    private String chargeCmt;

    @Column(name = "CHARGE_CODE", length = 5)
    private String chargeCode;

    @Column(name = "CHARGE_DISPL_ORDER")
    private BigDecimal chargeDisplOrder;

    @Column(name = "CHG_AMOUNT_FC", nullable = false, precision = 10, scale = 2)
    private BigDecimal chgAmountFc;

    @Column(name = "CHG_QUANTITY", nullable = false, precision = 11, scale = 3)
    private BigDecimal chgQuantity;

    @Column(name = "CREATED_BY", length = 12)
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CURRENCY_CODE", length = 3)
    private String currencyCode;

    @Column(name = "DETAIL_UID", precision = 16)
    private Long detailUid;

    @Column(name = "DTL_SEQUENCE", precision = 3, scale = 1)
    private BigDecimal dtlSequence;

    @Column(name = "JC_CHARGE_UID", precision = 16)
    private Long jcChargeUid;

    @Column(name = "LEVEL_OF_CALC", nullable = false, length = 1)
    private String levelOfCalc;

    @Column(name = "MATCHING_CRITERIA", length = 4000)
    private String matchingCriteria;

    @Column(name = "MODIFIED_BY", length = 12)
    private String modifiedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "PACKAGE_CODE", length = 5)
    private String packageCode;

    @Column(nullable = false, length = 10)
    private String payment;

    @Column(nullable = false, precision = 12, scale = 4)
    private BigDecimal rate;

    @Column(name = "ROUTE_SEQ")
    private BigDecimal routeSeq;

    @Temporal(TemporalType.DATE)
    @Column(name = "RULE_DATE_FROM", nullable = false)
    private Date ruleDateFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "RULE_DATE_TO")
    private Date ruleDateTo;

    @Column(name = "RULE_SEQ", precision = 16)
    private BigDecimal ruleSeq;

    @Column(name = "RULE_UID", nullable = false, precision = 16)
    private BigDecimal ruleUid;

    @Column(name = "SEQ_OF_CALC", nullable = false, precision = 5)
    private BigDecimal seqOfCalc;

    @Column(name = "TAR_APPLIED_UID", nullable = false, precision = 22)
    private BigDecimal tarAppliedUid;

    @Column(name = "TAR_HEADER_UID", precision = 16)
    private BigDecimal tarHeaderUid;

    @Column(name = "TAR_IMPORT_EXPORT_FLAG", length = 10)
    private String tarImportExportFlag;

    @Column(name = "TC_CHARGE_UID", nullable = false, precision = 16)
    private BigDecimal tcChargeUid;

    @Column(name = "TEXT_CMT", length = 4000)
    private String textCmt;
}