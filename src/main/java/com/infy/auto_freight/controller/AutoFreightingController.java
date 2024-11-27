package com.infy.auto_freight.controller;

import com.infy.auto_freight.bean.AutoFreightingRules;
import com.infy.auto_freight.exception.InternalServerErrorException;
import com.infy.auto_freight.exception.NotFoundException;
import com.infy.auto_freight.service.AutoFreightingService;
import com.infy.auto_freight.util.AutoFreightingConstants;
import com.infy.auto_freight.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @Project : auto-freight
 * @Author : sambitkumar.pradhan (1361629)
 * @Created On : 26/11/2024 12:31 PM
 */


@RestController
@RequestMapping(value = "/autoFreighting/v1")
public class AutoFreightingController {

    private final Logger logger = LoggerFactory.getLogger(AutoFreightingController.class);
    private final AutoFreightingService autoFreightingService;

    AutoFreightingController(AutoFreightingService autoFreightingService) {
        this.autoFreightingService = autoFreightingService;
    }

    /**
     * Retrieves the AutoFreightingRules for the given booking ID.
     * <p>
     * This API endpoint fetches the freighting rules for a specific booking. It returns:
     * - 400 Bad Request if the booking ID is invalid (null or empty),
     * - 404 Not Found if the freighting rules cannot be found for the given booking ID,
     * - 500 Internal Server Error if an internal error occurs during processing.
     *
     * @param bookingId The booking ID passed as a path variable.
     * @return A {@link ResponseEntity} containing the AutoFreightingRules and HTTP status 200 if successful.
     *
     * @throws NotFoundException If the booking ID is invalid or rules cannot be found (400 or 404 status).
     * @throws InternalServerErrorException If an error occurs during processing (500 status).
     * @auther Sambit Kumar Pradhan(1361629)
     */
    @GetMapping("/shipments/{bookingId}/loadAutoFreightingRules")
    public ResponseEntity<AutoFreightingRules> loadAutoFreightingRules(@PathVariable String bookingId) {
        // Ensure bookingId is valid, throw exception if not
        if (StringUtils.isEmpty(bookingId)) {
            throw new NotFoundException("400 Bad Request", AutoFreightingConstants.AFR_RULE_ERR,
                    AutoFreightingConstants.UNKNOWN_BOOKING_REFERENCE, HttpStatus.BAD_REQUEST);
        }

        logger.info("Booking Id: {}", bookingId);

        // Load AutoFreightingRules with exception handling
        AutoFreightingRules autoFreightingRules;
        try {
            autoFreightingRules = autoFreightingService.loadAutoFreightingRules(bookingId);
        } catch (Exception e) {
            logger.error("Exception occurred in loadAutoFreightingRules method of AutoFreightingController: {}", e.getMessage(), e);
            throw new InternalServerErrorException("500 Internal server error", AutoFreightingConstants.AFR_RULE_ERR,
                    AutoFreightingConstants.CALCULATION_DETAILS_UNAVAILABLE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Check if autoFreightingRules is null and throw appropriate exception
        if (autoFreightingRules == null) {
            throw new NotFoundException("404 Not Found", AutoFreightingConstants.AFR_RULE_ERR,
                    AutoFreightingConstants.INVALID_BOOKING_ID, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(autoFreightingRules, HttpStatus.OK);
    }
}
