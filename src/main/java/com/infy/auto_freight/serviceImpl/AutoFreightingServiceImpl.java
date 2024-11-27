package com.infy.auto_freight.serviceImpl;

import com.infy.auto_freight.bean.AutoFreightingRules;
import com.infy.auto_freight.model.AfrTarApplied;
import com.infy.auto_freight.model.AfrTarExplain;
import com.infy.auto_freight.repoitory.AfrTarAppliedRepository;
import com.infy.auto_freight.service.AutoFreightingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AutoFreightingServiceImpl implements AutoFreightingService {

    private final AfrTarAppliedRepository afrTarAppliedRepository;

    AutoFreightingServiceImpl(AfrTarAppliedRepository afrTarAppliedRepository) {
        this.afrTarAppliedRepository = afrTarAppliedRepository;
    }

    public void insertStaticData() {
        // Use ThreadLocalRandom to avoid Sonar issues with Random
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // Generate 5 AfrTarApplied objects
        for (int i = 0; i < 5; i++) {
            // Create an AfrTarApplied object with static data
            AfrTarApplied afrTarApplied = AfrTarApplied.builder()
                    .tarAppliedUid(100000000000000L + i)  // Static tarAppliedUid
                    .appliDate(new java.sql.Date(System.currentTimeMillis()))  // Current date
                    .classCode("CL" + (i + 1))
                    .companyCode("CO" + (i + 1))
                    .creaDate(new java.sql.Date(System.currentTimeMillis()))  // Current date
                    .creaUser("US" + (i + 1))
                    .departmentCode("DE" + (i + 1))
                    .headerUid(BigDecimal.valueOf(1000000000000000L + i))
                    .jobReference("JR" + (i + 1))
                    .jobStatus("JS" + (i + 1))  // Static job status
                    .modifiedBy(null)  // Modified by can be null initially
                    .modifiedDate(null)  // Modified date can be null initially
                    .textCmt("This is a comment for TarApplied " + (i + 1))
                    .afrTarExplains(generateRandomAfrTarExplains(random, 100000000000000L + i))  // Generate random explains
                    .build();

            // Save the AfrTarApplied object to the repository
            afrTarAppliedRepository.save(afrTarApplied);
        }
    }

    private Set<AfrTarExplain> generateRandomAfrTarExplains(ThreadLocalRandom random, long tarAppliedUid) {
        Set<AfrTarExplain> afrTarExplains = new HashSet<>();

        // Generate a random number of AfrTarExplain objects (between 1 and 5)
        int numOfExplains = random.nextInt(1, 6);  // random number between 1 and 5
        for (int i = 0; i < numOfExplains; i++) {
            AfrTarExplain afrTarExplain = AfrTarExplain.builder()
                    .tarExplainUid(100000000000000L + random.nextInt(1000))  // Static tarExplainUid
                    .basedRateType("BR" + (i + 1))
                    .calcType("CT" + (i + 1))
                    .chargeCmt("Charge Comment " + (i + 1))
                    .chargeCode("CC" + (i + 1))
                    .chargeDisplOrder(BigDecimal.valueOf(random.nextDouble() * 100))  // Random charge order
                    .chgAmountFc(BigDecimal.valueOf(random.nextDouble() * 500))  // Random charge amount
                    .chgQuantity(BigDecimal.valueOf(random.nextDouble() * 10))  // Random quantity
                    .createdBy("System")
                    .createdDate(new java.sql.Date(System.currentTimeMillis()))
                    .currencyCode("USD")
                    .matchingCriteria("Matching Criteria for TarExplain " + (i + 1))
                    .levelOfCalc("1")
                    .payment("PAY84599")
                    .rate(BigDecimal.valueOf(random.nextDouble() * 112))
                    .ruleUid(BigDecimal.valueOf(random.nextDouble() * 111))
                    .seqOfCalc(BigDecimal.valueOf(random.nextDouble() * 110))
                    .tcChargeUid(BigDecimal.valueOf(random.nextDouble() * 109))
                    .ruleDateFrom(new java.sql.Date(System.currentTimeMillis()))
                    .ruleDateTo(new java.sql.Date(System.currentTimeMillis() + 1000000000L))
                    .tarAppliedUid(BigDecimal.valueOf(tarAppliedUid))  // Use the actual tarAppliedUid
                    .build();

            // Add the AfrTarExplain object to the set
            afrTarExplains.add(afrTarExplain);
        }

        return afrTarExplains;
    }

    @Override
    public AutoFreightingRules loadAutoFreightingRules(String bookingId) {
//        Inserting Random Data to Database
        insertStaticData();

//        Actual Logic Should be Written Here


        // Mock data for the sake of example
        AutoFreightingRules.Charge charge = new AutoFreightingRules.Charge(
                1,
                LocalDateTime.parse("2023-01-18T20:00:00"),
                LocalDateTime.parse("2023-01-18T20:00:00"),
                "Package Code : [40ST] like [40+]",
                "THC58"
        );

        List<AutoFreightingRules.Charge> charges = List.of(charge);

        // Create and return the AutoFreightingRule object with the mock data
        return new AutoFreightingRules(
                "0002",                           // shippingCompany
                "GA2F987260",                     // quotationReference
                "LHV2939090",                     // bookingReference
                "USC",                            // tariffType
                "115",                            // departmentCode
                LocalDateTime.parse("2023-01-18T20:00:00"), // applicationDateUsed
                "XYZ",                            // createdUser
                123,                              // amendmentNumber
                "A-2",                            // appendixCode
                "BULLET 4",                       // bulletCode
                charges                           // charges
        );
    }
}
