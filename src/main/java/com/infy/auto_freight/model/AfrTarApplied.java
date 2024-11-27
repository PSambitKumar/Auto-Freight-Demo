package com.infy.auto_freight.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @Project : auto-freight
 * @Author : sambitkumar.pradhan (1361629)
 * @Created On : 11/27/2024 10:42 AM
 */
@Entity
@Table(name = "AFR_TAR_APPLIED")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AfrTarApplied implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TAR_APPLIED_UID", unique = true, nullable = false, precision = 22)
    private long tarAppliedUid;

    @Temporal(TemporalType.DATE)
    @Column(name = "APPLI_DATE", nullable = false)
    private Date appliDate;

    @Column(name = "CLASS_CODE", nullable = false, length = 4)
    private String classCode;

    @Column(name = "COMPANY_CODE", nullable = false, length = 3)
    private String companyCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREA_DATE", nullable = false)
    private Date creaDate;

    @Column(name = "CREA_USER", nullable = false, length = 12)
    private String creaUser;

    @Column(name = "DEPARTMENT_CODE", nullable = false, length = 4)
    private String departmentCode;

    @Column(name = "HEADER_UID", nullable = false, precision = 16)
    private BigDecimal headerUid;

    @Column(name = "JOB_REFERENCE", nullable = false, length = 20)
    private String jobReference;

    @Column(name = "JOB_STATUS", nullable = false, length = 3)
    private String jobStatus;

    @Column(name = "MODIFIED_BY", length = 12)
    private String modifiedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "TEXT_CMT", length = 4000)
    private String textCmt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "TAR_APPLIED_UID", referencedColumnName = "TAR_APPLIED_UID", nullable = true, updatable = false, insertable = true)
    private     Set<AfrTarExplain> afrTarExplains;

}