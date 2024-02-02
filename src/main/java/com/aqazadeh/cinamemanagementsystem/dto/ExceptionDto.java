package com.aqazadeh.cinamemanagementsystem.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:21:12
 */

public record ExceptionDto(
        List<String> message,
        LocalDateTime time
) {
}
