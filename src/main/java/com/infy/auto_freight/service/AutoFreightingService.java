package com.infy.auto_freight.service;

import com.infy.auto_freight.bean.AutoFreightingRules;

public interface AutoFreightingService {
    AutoFreightingRules loadAutoFreightingRules(String bookingId);
}
